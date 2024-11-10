/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline_project;
import constants.CommonConstants;
import java.sql.*;
import java.util.*;
import java.time.*;
/**
 *
 * @author DELL
 */
public class MyJDBC {
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
            int adminID = -1;
            if (resultSet.next()) {
                adminID = resultSet.getInt("AdminID");
            } else {
                System.err.println("Admin not found");
                return false;
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
            modifyFlightStmt.setInt(6, adminID);
            modifyFlightStmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            modifyFlightStmt.setInt(8, flightID);

            int rowsAffected = modifyFlightStmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean deleteSeats(int flightID) {
        String deleteSeatsSQL = "DELETE FROM " + CommonConstants.DB_SEATS_TABLE + " WHERE FlightID = ?";

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement deleteSeatsStmt = connection.prepareStatement(deleteSeatsSQL)) {

            deleteSeatsStmt.setInt(1, flightID);
            int rowsAffected = deleteSeatsStmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean modifySeat(int seatID, String seatClass, boolean available, double newPrice, String updatedBy) {
        String modifySeatSQL = "UPDATE " + CommonConstants.DB_SEATS_TABLE +
            " SET Class = ?, Available = ?, Price = ?, UpdatedBy = ?, UpdatedDate = ? WHERE SeatID = ?";

        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement modifySeatStmt = connection.prepareStatement(modifySeatSQL);
            PreparedStatement adminIDStmt = connection.prepareStatement(
                 "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?")) {

            adminIDStmt.setString(1, updatedBy);
            ResultSet resultSet = adminIDStmt.executeQuery();
            int adminID = -1;
            if (resultSet.next()) {
                adminID = resultSet.getInt("AdminID");
            } else {
                System.err.println("Admin not found");
                return false;
            }

            modifySeatStmt.setString(1, seatClass);
            modifySeatStmt.setInt(2, available ? 1 : 0);
            modifySeatStmt.setDouble(3, newPrice);
            modifySeatStmt.setInt(4, adminID);
            modifySeatStmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            modifySeatStmt.setInt(6, seatID);

            int rowsAffected = modifySeatStmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean insertFlight(Timestamp departureTime, Timestamp arrivalTime, int planeID, 
                                   String departureCity, String arrivalCity, String updatedName) {
        String insertFlightSQL = "INSERT INTO " + CommonConstants.DB_FLIGHTS_TABLE +
            " (DepartureTime, ArrivalTime, PlaneID, DepartureAirportID, ArrivalAirportID, UpdatedBy, UpdatedDate) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement adminIDStmt = connection.prepareStatement(
                 "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?");
            PreparedStatement departureAirportStmt = connection.prepareStatement(
                 "SELECT AirportID FROM " + CommonConstants.DB_AIRPORTS_TABLE + " WHERE City = ?");
            PreparedStatement arrivalAirportStmt = connection.prepareStatement(
                 "SELECT AirportID FROM " + CommonConstants.DB_AIRPORTS_TABLE + " WHERE City = ?");
            PreparedStatement insertFlightStmt = connection.prepareStatement(insertFlightSQL)) {

            adminIDStmt.setString(1, updatedName);
            ResultSet resultSet = adminIDStmt.executeQuery();
            int adminID = -1;
            if (resultSet.next()) {
                adminID = resultSet.getInt("AdminID");
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
            insertFlightStmt.setInt(6, adminID);
            insertFlightStmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

            insertFlightStmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean insertSeats(int flightID, int numEconomySeats, double economyPrice,
                                  int numBusinessSeats, double businessPrice, String updatedName) {

    String insertSeatSQL = "INSERT INTO " + CommonConstants.DB_SEATS_TABLE +
            " (FlightID, Class, Available, Price, UpdatedBy, UpdatedDate) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
         PreparedStatement adminIDStmt = connection.prepareStatement(
                 "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?");
         PreparedStatement insertSeatStmt = connection.prepareStatement(insertSeatSQL)) {

        connection.setAutoCommit(false);

        adminIDStmt.setString(1, updatedName);
        try (ResultSet resultSet = adminIDStmt.executeQuery()) {
            if (resultSet.next()) {
                int adminID = resultSet.getInt("AdminID");

                for (int i = 0; i < numEconomySeats; i++) {
                    insertSeatStmt.setInt(1, flightID);
                    insertSeatStmt.setString(2, "Economy");
                    insertSeatStmt.setInt(3, 1); 
                    insertSeatStmt.setDouble(4, economyPrice);
                    insertSeatStmt.setInt(5, adminID);
                    insertSeatStmt.setDate(6, Date.valueOf(java.time.LocalDate.now()));
                    insertSeatStmt.addBatch();
                }

                for (int i = 0; i < numBusinessSeats; i++) {
                    insertSeatStmt.setInt(1, flightID);
                    insertSeatStmt.setString(2, "Business");
                    insertSeatStmt.setInt(3, 1); // Available
                    insertSeatStmt.setDouble(4, businessPrice);
                    insertSeatStmt.setInt(5, adminID);
                    insertSeatStmt.setDate(6, Date.valueOf(java.time.LocalDate.now()));
                    insertSeatStmt.addBatch();
                }

                    insertSeatStmt.executeBatch();
                    connection.commit();
                    return true;
                } else {
                    System.err.println("Admin not found");
                    return false;
                }
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean insertPlane(String planeName, String planeModel, int capacity, String updatedBy) {
        String insertPlaneSQL = "INSERT INTO " + CommonConstants.DB_PLANES_TABLE +
            " (PlaneName, PlaneModel, Capacity, UpdatedBy, UpdatedDate) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement adminIDStmt = connection.prepareStatement(
                 "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?");
            PreparedStatement insertPlaneStmt = connection.prepareStatement(insertPlaneSQL)) {

            adminIDStmt.setString(1, updatedBy);
            ResultSet resultSet = adminIDStmt.executeQuery();
            int adminID = -1;
            if (resultSet.next()) {
                adminID = resultSet.getInt("AdminID");
            } else {
                System.err.println("Admin not found");
                return false;
            }

            insertPlaneStmt.setString(1, planeName);
            insertPlaneStmt.setString(2, planeModel);
            insertPlaneStmt.setInt(3, capacity);
            insertPlaneStmt.setInt(4, adminID);
            insertPlaneStmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

            insertPlaneStmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean modifyPlane(int planeID, String planeName, String planeModel, int capacity, String updatedBy) {
        String modifyPlaneSQL = "UPDATE " + CommonConstants.DB_PLANES_TABLE +
            " SET PlaneName = ?, PlaneModel = ?, Capacity = ?, UpdatedBy = ?, UpdatedDate = ? WHERE PlaneID = ?";

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement modifyPlaneStmt = connection.prepareStatement(modifyPlaneSQL);
            PreparedStatement adminIDStmt = connection.prepareStatement(
                 "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?")) {

            adminIDStmt.setString(1, updatedBy);
            ResultSet resultSet = adminIDStmt.executeQuery();
            int adminID = -1;
            if (resultSet.next()) {
                adminID = resultSet.getInt("AdminID");
            } else {
                System.err.println("Admin not found");
                return false;
            }

            modifyPlaneStmt.setString(1, planeName);
            modifyPlaneStmt.setString(2, planeModel);
            modifyPlaneStmt.setInt(3, capacity);
            modifyPlaneStmt.setInt(4, adminID);
            modifyPlaneStmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            modifyPlaneStmt.setInt(6, planeID);

            int rowsAffected = modifyPlaneStmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deletePlane(int planeID) {
        String deletePlaneSQL = "DELETE FROM " + CommonConstants.DB_PLANES_TABLE + " WHERE PlaneID = ?";

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement deletePlaneStmt = connection.prepareStatement(deletePlaneSQL)) {

            deletePlaneStmt.setInt(1, planeID);
            int rowsAffected = deletePlaneStmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static ArrayList<ArrayList<Object>> viewPlane() {
        String viewPlaneSQL = "SELECT * FROM " + CommonConstants.DB_PLANES_TABLE;
        ArrayList<ArrayList<Object>> planesList = new ArrayList<>();
    
        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement viewPlanesStmt = connection.prepareStatement(viewPlaneSQL)) {

            ResultSet resultSet = viewPlanesStmt.executeQuery();
            while (resultSet.next()) {
                ArrayList<Object> planeData = new ArrayList<>();
                planeData.add(resultSet.getInt("PlaneID"));  
                planeData.add(resultSet.getString("Model")); 
                planeData.add(resultSet.getInt("Seats"));     
                planesList.add(planeData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planesList;
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
            }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        return flightsList;

    }
    public static ArrayList<ArrayList<Object>> viewSeatAvailable(String departureTime, String arrivalTime, 
        String flightID, String departureCityName, String arrivalCityName) {

        String viewSeatSQL = "SELECT f.FlightID, f.DepartureTime, f.ArrivalTime, f.PlaneID, " +
        "da.AirportName AS DepartureAirportName, aa.AirportName AS ArrivalAirportName, " +
        "da.City AS DepartureCity, aa.City AS ArrivalCity, " +
        "s.AvailableSeats " +
        "FROM " + CommonConstants.DB_FLIGHTS_TABLE + " f " +
        "JOIN " + CommonConstants.DB_AIRPORTS_TABLE + " da ON f.DepartureAirportID = da.AirportID " +
        "JOIN " + CommonConstants.DB_AIRPORTS_TABLE + " aa ON f.ArrivalAirportID = aa.AirportID " +
        "JOIN " + CommonConstants.DB_SEATS_TABLE + " s ON f.FlightID = s.FlightID " +
        "WHERE s.Available = 1 ";

        ArrayList<ArrayList<Object>> seatsList = new ArrayList<>();

        if (!departureTime.isEmpty()) {
            viewSeatSQL += " AND f.DepartureTime >= ? ";
        }
        if (!arrivalTime.isEmpty()) {
            viewSeatSQL += " AND f.ArrivalTime <= ? ";
        }
        if (!flightID.isEmpty()) {
            viewSeatSQL += " AND f.FlightID = ? ";
        }
        if (!departureCityName.isEmpty()) {
            viewSeatSQL += " AND da.City LIKE ? ";
        }
        if (!arrivalCityName.isEmpty()) {
            viewSeatSQL += " AND aa.City LIKE ? ";
        }

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement viewSeatsStmt = connection.prepareStatement(viewSeatSQL)) {

            int index = 1;
            if (!departureTime.isEmpty()) {
                viewSeatsStmt.setString(index++, departureTime);
            }
            if (!arrivalTime.isEmpty()) {
                viewSeatsStmt.setString(index++, arrivalTime);
            }
            if (!flightID.isEmpty()) {
                viewSeatsStmt.setString(index++, flightID);
            }
            if (!departureCityName.isEmpty()) {
                viewSeatsStmt.setString(index++, "%" + departureCityName + "%");
            }
            if (!arrivalCityName.isEmpty()) {
                viewSeatsStmt.setString(index++, "%" + arrivalCityName + "%");
            }

            ResultSet resultSet = viewSeatsStmt.executeQuery();
            while (resultSet.next()) {
                ArrayList<Object> seatData = new ArrayList<>();
                seatData.add(resultSet.getInt("FlightID"));
                seatData.add(resultSet.getTimestamp("DepartureTime"));
                seatData.add(resultSet.getTimestamp("ArrivalTime"));
                seatData.add(resultSet.getInt("PlaneID"));
                seatData.add(resultSet.getString("DepartureAirportName"));
                seatData.add(resultSet.getString("ArrivalAirportName"));
                seatData.add(resultSet.getString("DepartureCity"));
                seatData.add(resultSet.getString("ArrivalCity"));
                seatData.add(resultSet.getInt("AvailableSeats"));
                seatsList.add(seatData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seatsList;
    }


 
}

