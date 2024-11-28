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

    public static ArrayList<ArrayList<Object>> viewAirports(String airportName, String cityName, String airportCode) {
        String viewAirportsSQL = "SELECT AirportID, AirportName, City, AirportCode "
                + "FROM " + CommonConstants.DB_AIRPORTS_TABLE + " WHERE 1=1 ";

        ArrayList<ArrayList<Object>> airportsList = new ArrayList<>();

        if (!airportName.isEmpty()) {
            viewAirportsSQL += " AND AirportName LIKE ? ";
        }
        if (!cityName.isEmpty()) {
            viewAirportsSQL += " AND City LIKE ? ";
        }
        if (!airportCode.isEmpty()) {
            viewAirportsSQL += " AND AirportCode LIKE ? ";
        }

        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD); PreparedStatement viewAirportsStmt = connection.prepareStatement(viewAirportsSQL)) {

            int index = 1;

            if (!airportName.isEmpty()) {
                viewAirportsStmt.setString(index++, "%" + airportName + "%");
            }
            if (!cityName.isEmpty()) {
                viewAirportsStmt.setString(index++, "%" + cityName + "%");
            }
            if (!airportCode.isEmpty()) {
                viewAirportsStmt.setString(index++, "%" + airportCode + "%");
            }

            ResultSet resultSet = viewAirportsStmt.executeQuery();
            while (resultSet.next()) {
                ArrayList<Object> airportData = new ArrayList<>();
                airportData.add(resultSet.getInt("AirportID"));       
                airportData.add(resultSet.getString("AirportName")); 
                airportData.add(resultSet.getString("City"));     
                airportData.add(resultSet.getString("AirportCode"));
                airportsList.add(airportData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return airportsList;
    }

}
