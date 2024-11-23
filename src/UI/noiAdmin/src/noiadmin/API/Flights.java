
package noiadmin.API;

import constants.CommonConstants;
import java.sql.*;
import java.util.*;
import java.time.*;

public class Flights {
    
    public static boolean insertFlight(Timestamp departureTime, Timestamp arrivalTime, int planeID,
                                       String departureCity, String arrivalCity, String updatedName) {
        String insertFlightSQL = "INSERT INTO " + CommonConstants.DB_FLIGHTS_TABLE +
                " (DepartureTime, ArrivalTime, PlaneID, DepartureAirportID, ArrivalAirportID, UpdatedBy, UpdatedDate) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement adminIDStmt = connection.prepareStatement(
                     "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?");
             PreparedStatement departureAirportStmt = connection.prepareStatement(
                     "SELECT AirportID FROM " + CommonConstants.DB_AIRPORTS_TABLE + " a " +
                             "JOIN " + CommonConstants.DB_PLANES_TABLE + " p ON p.LocationID = a.AirportID " +
                             "WHERE a.City = ?");
             PreparedStatement arrivalAirportStmt = connection.prepareStatement(
                     "SELECT AirportID FROM " + CommonConstants.DB_AIRPORTS_TABLE + " WHERE City = ?");
             PreparedStatement insertFlightStmt = connection.prepareStatement(insertFlightSQL)) {

            adminIDStmt.setString(1, updatedName);
            ResultSet adminResultSet = adminIDStmt.executeQuery();
            Integer adminID = null;
            if (adminResultSet.next()) {
                adminID = adminResultSet.getInt("AdminID");
            } else {
                System.err.println("Admin not found");
                return false;
            }

            departureAirportStmt.setString(1, departureCity);
            ResultSet departureResultSet = departureAirportStmt.executeQuery();
            int departureAirportID = -1;
            if (departureResultSet.next()) {
                departureAirportID = departureResultSet.getInt("AirportID");
            } else {
                System.err.println("Departure airport not found");
                return false;
            }

            arrivalAirportStmt.setString(1, arrivalCity);
            ResultSet arrivalResultSet = arrivalAirportStmt.executeQuery();
            int arrivalAirportID = -1;
            if (arrivalResultSet.next()) {
                arrivalAirportID = arrivalResultSet.getInt("AirportID");
            } else {
                System.err.println("Arrival airport not found");
                return false;
            }

            insertFlightStmt.setTimestamp(1, departureTime);
            insertFlightStmt.setTimestamp(2, arrivalTime);
            insertFlightStmt.setInt(3, planeID);
            insertFlightStmt.setInt(4, departureAirportID);
            insertFlightStmt.setInt(5, arrivalAirportID);

            if (adminID != null) {
                insertFlightStmt.setInt(6, adminID); // Admin ID
            } else {
                insertFlightStmt.setNull(6, java.sql.Types.INTEGER); // Null Admin ID if not found
            }

            insertFlightStmt.setDate(7, new java.sql.Date(System.currentTimeMillis())); // Current date for UpdatedDate

            insertFlightStmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<ArrayList<Object>> viewFlight(String departureTime, String arrivalTime, 
                                                      String planeID, String departureCityName, String arrivalCityName) {
        String viewFlightSQL = "SELECT f.FlightID, f.DepartureTime, f.ArrivalTime, f.PlaneID, " +
            "da.AirportName AS DepartureAirportName, aa.AirportName AS ArrivalAirportName, " +
            "da.City AS DepartureCity, aa.City AS ArrivalCity " +  
            "FROM " + CommonConstants.DB_FLIGHTS_TABLE + " f " +
            "JOIN " + CommonConstants.DB_AIRPORTS_TABLE + " da ON f.DepartureAirportID = da.AirportID " +
            "JOIN " + CommonConstants.DB_AIRPORTS_TABLE + " aa ON f.ArrivalAirportID = aa.AirportID WHERE 1=1 ";

        ArrayList<ArrayList<Object>> flightsList = new ArrayList<>();

        if (!departureTime.isEmpty()) {
            viewFlightSQL += " AND f.DepartureTime >= ? ";
        }
        if (!arrivalTime.isEmpty()) {
            viewFlightSQL += " AND f.ArrivalTime <= ? ";
        }
        if (!planeID.isEmpty()) {
            viewFlightSQL += " AND f.PlaneID = ? ";
        }
        if (!departureCityName.isEmpty()) {
            viewFlightSQL += " AND da.City LIKE ? "; 
        }
        if (!arrivalCityName.isEmpty()) {
            viewFlightSQL += " AND aa.City LIKE ? "; 
        }

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement viewFlightsStmt = connection.prepareStatement(viewFlightSQL)) {

            int index = 1;
            if (!departureTime.isEmpty()) {
                viewFlightsStmt.setString(index++, departureTime);
            }
            if (!arrivalTime.isEmpty()) {
                viewFlightsStmt.setString(index++, arrivalTime);
            }
            if (!planeID.isEmpty()) {
                viewFlightsStmt.setString(index++, planeID);
            }
            if (!departureCityName.isEmpty()) {
                viewFlightsStmt.setString(index++, "%" + departureCityName + "%");
            }
            if (!arrivalCityName.isEmpty()) {
                viewFlightsStmt.setString(index++, "%" + arrivalCityName + "%");
            }

            ResultSet resultSet = viewFlightsStmt.executeQuery();
            while (resultSet.next()) {
                ArrayList<Object> flightData = new ArrayList<>();
                flightData.add(resultSet.getInt("FlightID"));
                flightData.add(resultSet.getTimestamp("DepartureTime"));
                flightData.add(resultSet.getTimestamp("ArrivalTime"));
                flightData.add(resultSet.getInt("PlaneID"));
                flightData.add(resultSet.getString("DepartureAirportName"));
                flightData.add(resultSet.getString("ArrivalAirportName"));
                flightData.add(resultSet.getString("DepartureCity"));  
                flightData.add(resultSet.getString("ArrivalCity"));    
                flightsList.add(flightData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flightsList;
    }

    public static boolean deleteFlight(int flightID) {
        String deleteFlightSQL = "DELETE FROM " + CommonConstants.DB_FLIGHTS_TABLE + " WHERE FlightID = ?";

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement deleteFlightStmt = connection.prepareStatement(deleteFlightSQL)) {

            deleteFlightStmt.setInt(1, flightID);
            int rowsAffected = deleteFlightStmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean modifyFlight(int flightID, Timestamp newDepartureTime, Timestamp newArrivalTime,
                                   int newPlaneID, String newDepartureCity, String newArrivalCity, String updatedBy) {
        String modifyFlightSQL = "UPDATE " + CommonConstants.DB_FLIGHTS_TABLE +
            " SET DepartureTime = ?, ArrivalTime = ?, PlaneID = ?, DepartureAirportID = ?, ArrivalAirportID = ?, " +
            "UpdatedBy = ?, UpdatedDate = ? WHERE FlightID = ?";

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement modifyFlightStmt = connection.prepareStatement(modifyFlightSQL);
            PreparedStatement adminIDStmt = connection.prepareStatement(
                 "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?");
            PreparedStatement departureAirportStmt = connection.prepareStatement(
                 "SELECT AirportID FROM " + CommonConstants.DB_AIRPORTS_TABLE + " WHERE City = ?");
            PreparedStatement arrivalAirportStmt = connection.prepareStatement(
                 "SELECT AirportID FROM " + CommonConstants.DB_AIRPORTS_TABLE + " WHERE City = ?")) {

            adminIDStmt.setString(1, updatedBy);
            ResultSet resultSet = adminIDStmt.executeQuery();
            Integer adminID = null;
            if (resultSet.next()) {
                adminID = resultSet.getInt("AdminID");
            }

            departureAirportStmt.setString(1, newDepartureCity);
            ResultSet departureResultSet = departureAirportStmt.executeQuery();
            int departureAirportID = -1;
            if (departureResultSet.next()) {
                departureAirportID = departureResultSet.getInt("AirportID");
            } else {
                System.err.println("Departure airport not found");
                return false;
            }

            arrivalAirportStmt.setString(1, newArrivalCity);
            ResultSet arrivalResultSet = arrivalAirportStmt.executeQuery();
            int arrivalAirportID = -1;
            if (arrivalResultSet.next()) {
                arrivalAirportID = arrivalResultSet.getInt("AirportID");
            } else {
                System.err.println("Arrival airport not found");
                return false;
            }

            modifyFlightStmt.setTimestamp(1, newDepartureTime);
            modifyFlightStmt.setTimestamp(2, newArrivalTime);
            modifyFlightStmt.setInt(3, newPlaneID);
            modifyFlightStmt.setInt(4, departureAirportID);
            modifyFlightStmt.setInt(5, arrivalAirportID);
            if (adminID != null) {
                modifyFlightStmt.setInt(6, adminID);
            } else {
                modifyFlightStmt.setNull(6, java.sql.Types.INTEGER);
            }
            modifyFlightStmt.setDate(7, new java.sql.Date(System.currentTimeMillis()));
            modifyFlightStmt.setInt(8, flightID);

            int rowsAffected = modifyFlightStmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
