package noiadmin.API;

import constants.CommonConstants;
import java.sql.*;
import java.util.*;

public class Airports {

    public static boolean insertAirport(String airportName, String city, String airportCode) {
        String query = "INSERT INTO airports (AirportName, City, AirportCode) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, airportName);
            pstmt.setString(2, city);
            pstmt.setString(3, airportCode);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteAirport(int airportID) {
        String query = "DELETE FROM airports WHERE AirportID = ?";
        try (Connection conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, airportID);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Airport deleted successfully!");
                return true;
            } else {
                System.out.println("No airport found with the given ID.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateAirport(int airportID, String airportName, String city, String airportCode) {
        String query = "UPDATE airports SET AirportName = ?, City = ?, AirportCode = ? WHERE AirportID = ?";
        try (Connection conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, airportName);
            pstmt.setString(2, city);
            pstmt.setString(3, airportCode);
            pstmt.setInt(4, airportID);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Airport updated successfully!");
                return true;
            } else {
                System.out.println("No airport found with the given ID.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void modifyAirportCity(int airportID, String newCity) {
        String query = "UPDATE airports SET City = ? WHERE AirportID = ?";
        try (Connection conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newCity);
            pstmt.setInt(2, airportID);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Airport city updated successfully!");
            } else {
                System.out.println("No airport found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ArrayList<Object>> viewAirportCity(String AirportName, String City) {
        String viewAirportSQL
                = "SELECT a.AirportID, a.AirportName, a.City, a.AirportCode, COUNT(p.PlaneID) AS NumberPlanes "
                + "FROM " + CommonConstants.DB_PLANES_TABLE + " p "
                + "JOIN " + CommonConstants.DB_AIRPORTS_TABLE + " a ON p.LocationID = a.AirportID "
                + "WHERE 1=1";

        ArrayList<ArrayList<Object>> airportlist = new ArrayList<>();

        if (!AirportName.isEmpty()) {
            viewAirportSQL += " AND a.AirportName = ? ";
        }
        if (!City.isEmpty()) {
            viewAirportSQL += " AND a.City = ? ";
        }

        viewAirportSQL += " GROUP BY a.AirportID";

        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD); PreparedStatement viewAirportsStmt = connection.prepareStatement(viewAirportSQL)) {

            int index = 1;
            if (!AirportName.isEmpty()) {
                viewAirportsStmt.setString(index++, AirportName);
            }
            if (!City.isEmpty()) {
                viewAirportsStmt.setString(index++, City);
            }

            try (ResultSet resultSet = viewAirportsStmt.executeQuery()) {
                while (resultSet.next()) {
                    ArrayList<Object> AirportData = new ArrayList<>();
                    AirportData.add(resultSet.getInt("AirportID"));
                    AirportData.add(resultSet.getString("AirportName"));
                    AirportData.add(resultSet.getString("City"));
                    AirportData.add(resultSet.getString("AirportCode")); // Added missing AirportCode
                    AirportData.add(resultSet.getInt("NumberPlanes"));
                    airportlist.add(AirportData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airportlist;
    }
}

