/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline_project;
import constants.CommonConstants;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class MyJDBC {
    public static boolean insertFlight(Timestamp departureTime, Timestamp arrivalTime, int planeID, 
                                       int departureAirportID, int arrivalAirportID, String updatedName) {
        String insertFlightSQL = "INSERT INTO " + CommonConstants.DB_FLIGHTS_TABLE +
                " (DepartureTime, ArrivalTime, PlaneID, DepartureAirportID, ArrivalAirportID, UpdatedBy, UpdatedDate) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement adminIDStmt = connection.prepareStatement(
                     "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?");
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
                     "SELECT ADMINID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?");
             PreparedStatement insertSeatStmt = connection.prepareStatement(insertSeatSQL)) {

            adminIDStmt.setString(1, updatedName);
            ResultSet resultSet = adminIDStmt.executeQuery();
            int adminID = -1;
            if (resultSet.next()) {
                adminID = resultSet.getInt("AdminID");
            } else {
                System.err.println("Admin not found");
                return false;
            }

            for (int i = 1; i <= numEconomySeats; i++) {
                insertSeatStmt.setInt(1, flightID);
                insertSeatStmt.setString(2, "Economy");
                insertSeatStmt.setInt(3, 1);
                insertSeatStmt.setDouble(4, economyPrice);
                insertSeatStmt.setInt(5, adminID);
                insertSeatStmt.setDate(6, Date.valueOf(java.time.LocalDate.now()));
                insertSeatStmt.addBatch();
            }

            for (int i = 1; i <= numBusinessSeats; i++) {
                insertSeatStmt.setInt(1, flightID);
                insertSeatStmt.setString(2, "Business");
                insertSeatStmt.setInt(3, 1);
                insertSeatStmt.setDouble(4, businessPrice);
                insertSeatStmt.setInt(5, adminID);
                insertSeatStmt.setDate(6, Date.valueOf(java.time.LocalDate.now()));
                insertSeatStmt.addBatch();
            }

            insertSeatStmt.executeBatch();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

