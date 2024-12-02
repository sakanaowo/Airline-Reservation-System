/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataHandle.Data;

import DataHandle.constants.CommonConstants;
import Models.Plane;

import java.sql.*;
import java.util.*;

import static java.sql.DriverManager.getConnection;

/**
 * @author DELL
 */
public class Planes {
    public static boolean insertPlane(String model, int seats, String locationAirport, String updatedBy) {
        String insertPlaneSQL = "INSERT INTO " + CommonConstants.DB_PLANES_TABLE +
                " (Model, Seats, LocationID, UpdatedBy, UpdatedDate) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement adminIDStmt = connection.prepareStatement(
                     "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?");
             PreparedStatement locationIDStmt = connection.prepareStatement(
                     "SELECT AirportID FROM " + CommonConstants.DB_AIRPORTS_TABLE + " WHERE AirportName = ?");
             PreparedStatement insertPlaneStmt = connection.prepareStatement(insertPlaneSQL)) {

            adminIDStmt.setString(1, updatedBy);
            ResultSet adminResultSet = adminIDStmt.executeQuery();
            Integer adminID = null;
            if (adminResultSet.next()) {
                adminID = adminResultSet.getInt("AdminID");
            } else {
                System.err.println("Admin not found: " + updatedBy);
                return false;
            }

            locationIDStmt.setString(1, locationAirport);
            ResultSet locationResultSet = locationIDStmt.executeQuery();
            Integer locationID = null;
            if (locationResultSet.next()) {
                locationID = locationResultSet.getInt("AirportID");
            } else {
                System.err.println("Airport not found: " + locationAirport);
                return false;
            }

            insertPlaneStmt.setString(1, model);
            insertPlaneStmt.setInt(2, seats);
            insertPlaneStmt.setInt(3, locationID);
            if (adminID != null) {
                insertPlaneStmt.setInt(4, adminID);
            } else {
                insertPlaneStmt.setNull(4, java.sql.Types.INTEGER);
            }
            insertPlaneStmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));

            insertPlaneStmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean modifyPlane(int planeID, String model, int seats, String locationAirport, String updatedBy, java.util.Date updatedDate) {
        String modifyPlaneSQL = "UPDATE " + CommonConstants.DB_PLANES_TABLE
                + " SET Model = ?, Seats = ?, LocationID = ?, UpdatedBy = ?, UpdatedDate = ? WHERE PlaneID = ?";

        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD); PreparedStatement adminIDStmt = connection.prepareStatement(
                "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?"); PreparedStatement locationIDStmt = connection.prepareStatement(
                "SELECT AirportID FROM " + CommonConstants.DB_AIRPORTS_TABLE + " WHERE AirportName = ?"); PreparedStatement modifyPlaneStmt = connection.prepareStatement(modifyPlaneSQL)) {

            adminIDStmt.setString(1, updatedBy);
            ResultSet adminResultSet = adminIDStmt.executeQuery();
            Integer adminID = null;

            if (adminResultSet.next()) {
                adminID = adminResultSet.getInt("AdminID");
            } else {
                System.err.println("Admin not found: " + updatedBy);
                return false;
            }

            locationIDStmt.setString(1, locationAirport);
            ResultSet locationResultSet = locationIDStmt.executeQuery();
            Integer locationID = null;

            if (locationResultSet.next()) {
                locationID = locationResultSet.getInt("AirportID");
            } else {
                System.err.println("Airport not found: " + locationAirport);
                return false;
            }

            modifyPlaneStmt.setString(1, model);
            modifyPlaneStmt.setInt(2, seats);
            modifyPlaneStmt.setInt(3, locationID);
            modifyPlaneStmt.setInt(4, adminID);
            modifyPlaneStmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));
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

    public static ArrayList<ArrayList<Object>> viewPlane(String model, String locationAirport, String updatedBy) {
        StringBuilder viewPlaneSQL = new StringBuilder(
                "SELECT p.PlaneID, p.Model, p.Seats, a.AirportName AS LocationAirport, " +
                        "p.UpdatedBy, p.UpdatedDate " +
                        "FROM " + CommonConstants.DB_PLANES_TABLE + " p " +
                        "JOIN " + CommonConstants.DB_AIRPORTS_TABLE + " a ON p.LocationID = a.AirportID WHERE 1=1"
        );

        ArrayList<ArrayList<Object>> planesList = new ArrayList<>();
        ArrayList<Object> parameters = new ArrayList<>();

        if (model != null && !model.isEmpty()) {
            viewPlaneSQL.append(" AND p.Model LIKE ?");
            parameters.add("%" + model + "%");
        }
        if (locationAirport != null && !locationAirport.isEmpty()) {
            viewPlaneSQL.append(" AND a.AirportName LIKE ?");
            parameters.add("%" + locationAirport + "%");
        }
        if (updatedBy != null && !updatedBy.isEmpty()) {
            viewPlaneSQL.append(" AND p.UpdatedBy = ?");
            parameters.add(updatedBy);
        }

        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement viewPlanesStmt = connection.prepareStatement(viewPlaneSQL.toString())) {

            for (int i = 0; i < parameters.size(); i++) {
                viewPlanesStmt.setObject(i + 1, parameters.get(i));
            }

            ResultSet resultSet = viewPlanesStmt.executeQuery();
            while (resultSet.next()) {
                ArrayList<Object> planeData = new ArrayList<>();
                planeData.add(resultSet.getInt("PlaneID"));
                planeData.add(resultSet.getString("Model"));
                planeData.add(resultSet.getInt("Seats"));
                planeData.add(resultSet.getString("LocationAirport"));
                planeData.add(resultSet.getObject("UpdatedBy"));
                planeData.add(resultSet.getDate("UpdatedDate"));
                planesList.add(planeData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return planesList;
    }

    public static void updatePlaneBaseOnFlight() {
        String updatePlanesSQL = """
            UPDATE airline.planes p
            JOIN airline.flights f ON p.planeID = f.planeID
            SET p.LocationID = f.ArrivalAirportID
            WHERE CURRENT_TIME() >= f.ArrivalTime
            """;

        String deleteTicketsSQL = """
            DELETE t
            FROM airline.tickets t
            JOIN airline.seats s ON t.SeatID = s.SeatID
            JOIN airline.flights f ON s.FlightID = f.FlightID
            WHERE CURRENT_TIME() >= f.ArrivalTime
            """;

        String deletePassengersSQL = """
            DELETE p
            FROM airline.passengers p
            WHERE NOT EXISTS (
                SELECT 1
                FROM airline.tickets t
                WHERE t.PassengerID = p.PassengerID
            )
            """;

        String deleteFlightsSQL = """
            DELETE FROM airline.flights
            WHERE CURRENT_TIME() >= ArrivalTime
        """;

        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD); PreparedStatement updatePlanesStmt = connection.prepareStatement(updatePlanesSQL); PreparedStatement deleteTicketsStmt = connection.prepareStatement(deleteTicketsSQL); PreparedStatement deletePassengersStmt = connection.prepareStatement(deletePassengersSQL); PreparedStatement deleteFlightsStmt = connection.prepareStatement(deleteFlightsSQL)) {

            int planesUpdated = updatePlanesStmt.executeUpdate();
            System.out.println(planesUpdated + " planes updated in the 'planes' table.");

            int ticketsDeleted = deleteTicketsStmt.executeUpdate();
            System.out.println(ticketsDeleted + " tickets deleted from the 'tickets' table.");

            int passengersDeleted = deletePassengersStmt.executeUpdate();
            System.out.println(passengersDeleted + " passengers deleted from the 'passengers' table.");

            int flightsDeleted = deleteFlightsStmt.executeUpdate();
            System.out.println(flightsDeleted + " flights deleted from the 'flights' table.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // get plane by ID
    public static Plane getPlaneById(int planeID) {
        String sql = "SELECT p.*, a.AdminName FROM " + CommonConstants.DB_PLANES_TABLE + " p " +
                "LEFT JOIN " + CommonConstants.DB_ADMIN_TABLE + " a ON p.UpdatedBy = a.AdminID " +
                "WHERE p.PlaneID = ?";

        try (Connection conn = getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, planeID);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Plane plane = new Plane(
                            rs.getString("Model"),
                            rs.getInt("Seats"),
                            rs.getInt("UpdatedBy"),
                            rs.getTimestamp("UpdatedDate")
                    );
                    return plane;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
