/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import constants.CommonConstants;
import java.sql.*;
import java.util.*;
import java.time.*;
/**
 *
 * @author DELL
 */
public class Seats {
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
    public static ArrayList<ArrayList<Object>> viewSeatAvailablePassenger(String departureTime,
                                                                          String departureCityName, String arrivalCityName, int seatNumber) {
        String viewSeatSQL = "SELECT f.FlightID, f.DepartureTime, f.ArrivalTime, f.PlaneID, " +
                "da.City AS DepartureCity, aa.City AS ArrivalCity, " +
                "SUM(CASE WHEN s.Class = 'Business' AND s.Available = 1 THEN 1 ELSE 0 END) AS BusinessAvailableSeats, " +
                "SUM(CASE WHEN s.Class = 'Economy' AND s.Available = 1 THEN 1 ELSE 0 END) AS EconomyAvailableSeats, " +
                "MAX(CASE WHEN s.Class = 'Business' THEN s.Price ELSE 0 END) AS BusinessPrice, " +
                "MAX(CASE WHEN s.Class = 'Economy' THEN s.Price ELSE 0 END) AS EconomyPrice " +
                "FROM airline.flights f " +
                "JOIN airline.airports da ON f.DepartureAirportID = da.AirportID " +
                "JOIN airline.airports aa ON f.ArrivalAirportID = aa.AirportID " +
                "JOIN airline.seats s ON f.FlightID = s.FlightID " +
                "WHERE 1=1 ";

        ArrayList<ArrayList<Object>> seatsList = new ArrayList<>();

        if (!departureTime.isEmpty()) {
            viewSeatSQL += " AND f.DepartureTime >= ? ";
        }
        if (!departureCityName.isEmpty()) {
            viewSeatSQL += " AND da.City LIKE ? ";
        }
        if (!arrivalCityName.isEmpty()) {
            viewSeatSQL += " AND aa.City LIKE ? ";
        }

        viewSeatSQL += " GROUP BY f.FlightID, f.DepartureTime, f.ArrivalTime, f.PlaneID, " +
                "da.City, aa.City " +
                "HAVING SUM(CASE WHEN s.Class = 'Business' AND s.Available = 1 THEN 1 ELSE 0 END) + " +
                "SUM(CASE WHEN s.Class = 'Economy' AND s.Available = 1 THEN 1 ELSE 0 END) >= ?";

        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement viewSeatsStmt = connection.prepareStatement(viewSeatSQL)) {

            int index = 1;
            if (!departureTime.isEmpty()) {
                viewSeatsStmt.setString(index++, departureTime);
            }
            if (!departureCityName.isEmpty()) {
                viewSeatsStmt.setString(index++, "%" + departureCityName + "%");
            }
            if (!arrivalCityName.isEmpty()) {
                viewSeatsStmt.setString(index++, "%" + arrivalCityName + "%");
            }
            viewSeatsStmt.setInt(index++, seatNumber);

            ResultSet resultSet = viewSeatsStmt.executeQuery();
            while (resultSet.next()) {
                ArrayList<Object> seatData = new ArrayList<>();
                seatData.add(resultSet.getString("FlightID"));
                seatData.add(resultSet.getTimestamp("DepartureTime"));
                seatData.add(resultSet.getTimestamp("ArrivalTime"));
                seatData.add(resultSet.getInt("PlaneID"));
                seatData.add(resultSet.getString("DepartureCity"));
                seatData.add(resultSet.getString("ArrivalCity"));
                seatData.add(resultSet.getInt("BusinessAvailableSeats"));
                seatData.add(resultSet.getInt("EconomyAvailableSeats"));
                seatData.add(resultSet.getDouble("BusinessPrice"));
                seatData.add(resultSet.getDouble("EconomyPrice"));
                seatsList.add(seatData);
            }

        } catch (SQLException e) {
            System.err.println("Error executing viewSeatAvailablePassenger query: " + e.getMessage());
            e.printStackTrace();
        }

        return seatsList;
    }

    public static ArrayList<ArrayList<Object>> viewSeatAvailable(String departureTime, String arrivalTime,
                                                                 String flightID, String departureCityName, String arrivalCityName) {

        String viewSeatSQL = "SELECT f.FlightID, f.DepartureTime, f.ArrivalTime, f.PlaneID, " +
                "da.AirportName AS DepartureAirportName, aa.AirportName AS ArrivalAirportName, " +
                "da.City AS DepartureCity, aa.City AS ArrivalCity, " +
                "SUM(CASE WHEN s.Class = 'Business' AND s.Available = 1 THEN 1 ELSE 0 END) AS BusinessAvailableSeats, " +
                "SUM(CASE WHEN s.Class = 'Economy' AND s.Available = 1 THEN 1 ELSE 0 END) AS EconomyAvailableSeats " +
                "FROM airline.flights f " +
                "JOIN airline.airports da ON f.DepartureAirportID = da.AirportID " +
                "JOIN airline.airports aa ON f.ArrivalAirportID = aa.AirportID " +
                "JOIN airline.seats s ON f.FlightID = s.FlightID " +
                "WHERE 1=1 ";

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

        viewSeatSQL += " GROUP BY f.FlightID, f.DepartureTime, f.ArrivalTime, f.PlaneID, " +
                "da.AirportName, aa.AirportName, da.City, aa.City";

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
                seatData.add(resultSet.getString("FlightID"));
                seatData.add(resultSet.getTimestamp("DepartureTime"));
                seatData.add(resultSet.getTimestamp("ArrivalTime"));
                seatData.add(resultSet.getInt("PlaneID"));
                seatData.add(resultSet.getString("DepartureAirportName"));
                seatData.add(resultSet.getString("ArrivalAirportName"));
                seatData.add(resultSet.getString("DepartureCity"));
                seatData.add(resultSet.getString("ArrivalCity"));
                seatData.add(resultSet.getInt("BusinessAvailableSeats"));
                seatData.add(resultSet.getInt("EconomyAvailableSeats"));
                seatsList.add(seatData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seatsList;
    }
    
    public static boolean modifySeat(int seatID, String seatClass, boolean available, double newPrice, String updatedBy) {
        String modifySeatSQL = "UPDATE airline.seats SET Class = ?, Available = ?, Price = ?, UpdatedBy = ?, UpdatedDate = ? WHERE SeatID = ?";

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement modifySeatStmt = connection.prepareStatement(modifySeatSQL);
            PreparedStatement adminIDStmt = connection.prepareStatement(
            "SELECT AdminID FROM airline.admins WHERE AdminName = ?")) {

                adminIDStmt.setString(1, updatedBy);
                ResultSet resultSet = adminIDStmt.executeQuery();
                int adminID;
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
                modifySeatStmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));
                modifySeatStmt.setInt(6, seatID);

                int rowsAffected = modifySeatStmt.executeUpdate();
                return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean insertSeats(int flightID, double economyPrice,
                                   double businessPrice, String updatedName) {

        String insertSeatSQL = "INSERT INTO " + CommonConstants.DB_SEATS_TABLE +
            " (FlightID, Class, Position, Available, Price, UpdatedBy, UpdatedDate) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement adminIDStmt = connection.prepareStatement(
                "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?");
            PreparedStatement insertSeatStmt = connection.prepareStatement(insertSeatSQL)) {

            connection.setAutoCommit(false);

            adminIDStmt.setString(1, updatedName);
            ResultSet resultSet = adminIDStmt.executeQuery();
            int adminID;

            if (resultSet.next()) {
                adminID = resultSet.getInt("AdminID");
            } else {
                System.err.println("Admin not found");
                return false;
            }

            char seatLetter;
            int seatNumber;

            for (int i = 0; i < 30; i++) {
                seatLetter = (char) ('A' + (i % 6)); 
                seatNumber = (i / 6) + 1;             
                String position = seatLetter + Integer.toString(seatNumber);

                insertSeatStmt.setInt(1, flightID);
                insertSeatStmt.setString(2, "Business");
                insertSeatStmt.setString(3, position);
                insertSeatStmt.setInt(4, 1); 
                insertSeatStmt.setDouble(5, businessPrice);
                insertSeatStmt.setInt(6, adminID);
                insertSeatStmt.setDate(7, new java.sql.Date(System.currentTimeMillis()));
                insertSeatStmt.addBatch();
            }

            for (int i = 0; i < 150; i++) {
                seatLetter = (char) ('A' + (i % 6));  
                seatNumber = (i / 6) + 1;             
                String position = seatLetter + Integer.toString(seatNumber);

                insertSeatStmt.setInt(1, flightID);
                insertSeatStmt.setString(2, "Economy");
                insertSeatStmt.setString(3, position);
                insertSeatStmt.setInt(4, 1); 
                insertSeatStmt.setDouble(5, economyPrice);
                insertSeatStmt.setInt(6, adminID);
                insertSeatStmt.setDate(7, new java.sql.Date(System.currentTimeMillis()));
                insertSeatStmt.addBatch();
            }
            
            insertSeatStmt.executeBatch();
            connection.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getMinAvailableSeatIDByClass(String seatClass, int FlightID) {
        String query = "SELECT MIN(s.SeatID) AS MinAvailableSeatID " +
                "FROM airline.seats s " +
                "WHERE Available = 1 AND Class = ? AND FlightID = ?";

        try (Connection connection = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, seatClass);
            preparedStatement.setInt(2, FlightID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() && resultSet.getInt("MinAvailableSeatID") != 0) {
                return resultSet.getInt("MinAvailableSeatID");
            } else {
                System.out.println("No available seats found for class: " + seatClass);
                return -1;
            }

        } catch (SQLException e) {
            System.err.println("Error fetching minimum available SeatID for class '" + seatClass + "': " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
}
