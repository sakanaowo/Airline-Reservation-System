// DataHandle/Data/Airports.java
package DataHandle.Data;

import DataHandle.constants.CommonConstants;
import Models.Airport;

import java.sql.*;
import java.util.*;

/**
 * Data Access Object for handling Airport-related database operations.
 */
public class Airports {

    /**
     * Custom exception for airport-related database operations
     */
    public static class AirportOperationException extends Exception {
        public AirportOperationException(String message) {
            super(message);
        }

        public AirportOperationException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    /**
     * Inserts a new airport into the database
     *
     * @param airport Airport object containing the data to insert
     * @return true if insertion was successful
     */
    public static boolean insertAirport(Airport airport) {
        String sql = "INSERT INTO " + CommonConstants.DB_AIRPORTS_TABLE +
                " (AirportName, City, Country) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, airport.getAirportName());
            stmt.setString(2, airport.getCity());
            stmt.setString(3, airport.getAirportCode());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        airport.setAirportID(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Updates an existing airport in the database
     *
     * @param airport Airport object containing the updated data
     * @return true if update was successful
     */
    public static boolean updateAirport(Airport airport) {
        String sql = "UPDATE " + CommonConstants.DB_AIRPORTS_TABLE +
                " SET AirportName = ?, City = ?, Country = ? WHERE AirportID = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, airport.getAirportName());
            stmt.setString(2, airport.getCity());
            stmt.setString(3, airport.getAirportCode());
            stmt.setInt(4, airport.getAirportID());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deletes an airport from the database
     *
     * @param airportID ID of the airport to delete
     * @return true if deletion was successful
     */
    public static boolean deleteAirport(int airportID) {
        // First check if the airport is used in any flights
        String checkFlightsSql = "SELECT COUNT(*) FROM " + CommonConstants.DB_FLIGHTS_TABLE +
                " WHERE DepartureAirportID = ? OR ArrivalAirportID = ?";

        String deleteAirportSql = "DELETE FROM " + CommonConstants.DB_AIRPORTS_TABLE +
                " WHERE AirportID = ?";

        try (Connection conn = getConnection()) {
            // Check for existing flights
            try (PreparedStatement checkStmt = conn.prepareStatement(checkFlightsSql)) {
                checkStmt.setInt(1, airportID);
                checkStmt.setInt(2, airportID);

                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    System.err.println("Cannot delete airport: It is associated with existing flights");
                    return false;
                }
            }

            // If no flights found, proceed with deletion
            try (PreparedStatement deleteStmt = conn.prepareStatement(deleteAirportSql)) {
                deleteStmt.setInt(1, airportID);
                return deleteStmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves all airports from the database
     *
     * @return List of Airport objects
     */
    public static ArrayList<Airport> getAllAirports() {
        String sql = "SELECT * FROM " + CommonConstants.DB_AIRPORTS_TABLE + " ORDER BY AirportName";
        ArrayList<Airport> airports = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Airport airport = new Airport();
                airport.setAirportID(rs.getInt("AirportID"));
                airport.setAirportName(rs.getString("AirportName"));
                airport.setCity(rs.getString("City"));
                airport.setAirportCode(rs.getString("Country"));
                airports.add(airport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airports;
    }

    /**
     * Retrieves a specific airport by ID
     *
     * @param airportID ID of the airport to retrieve
     * @return Airport object if found, null otherwise
     */
    public static Airport getAirportById(int airportID) {
        String sql = "SELECT * FROM " + CommonConstants.DB_AIRPORTS_TABLE + " WHERE AirportID = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, airportID);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Airport airport = new Airport();
                    airport.setAirportID(rs.getInt("AirportID"));
                    airport.setAirportName(rs.getString("AirportName"));
                    airport.setCity(rs.getString("City"));
                    airport.setAirportCode(rs.getString("Country"));
                    return airport;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Searches airports based on name, city, or country
     *
     * @param searchTerm The search term to look for
     * @return List of matching Airport objects
     */
    public static ArrayList<Airport> searchAirports(String searchTerm) {
        String sql = "SELECT * FROM " + CommonConstants.DB_AIRPORTS_TABLE +
                " WHERE AirportName LIKE ? OR City LIKE ? OR Country LIKE ? ORDER BY AirportName";
        ArrayList<Airport> airports = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String searchPattern = "%" + searchTerm + "%";
            stmt.setString(1, searchPattern);
            stmt.setString(2, searchPattern);
            stmt.setString(3, searchPattern);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Airport airport = new Airport();
                    airport.setAirportID(rs.getInt("AirportID"));
                    airport.setAirportName(rs.getString("AirportName"));
                    airport.setCity(rs.getString("City"));
                    airport.setAirportCode(rs.getString("Country"));
                    airports.add(airport);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airports;
    }

    /**
     * Retrieves airports by country
     *
     * @param country The country to filter by
     * @return List of Airport objects in the specified country
     */
    public static ArrayList<Airport> getAirportsByCountry(String country) {
        String sql = "SELECT * FROM " + CommonConstants.DB_AIRPORTS_TABLE +
                " WHERE Country = ? ORDER BY City, AirportName";
        ArrayList<Airport> airports = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, country);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Airport airport = new Airport();
                    airport.setAirportID(rs.getInt("AirportID"));
                    airport.setAirportName(rs.getString("AirportName"));
                    airport.setCity(rs.getString("City"));
                    airport.setAirportCode(rs.getString("Country"));
                    airports.add(airport);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airports;
    }

    /**
     * Checks if an airport exists in the database
     *
     * @param airportID ID to check
     * @return true if airport exists
     */
    public static boolean airportExists(int airportID) {
        String sql = "SELECT 1 FROM " + CommonConstants.DB_AIRPORTS_TABLE + " WHERE AirportID = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, airportID);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Airport getAirportByCity(String city) {
        String sql = "SELECT * FROM " + CommonConstants.DB_AIRPORTS_TABLE + " WHERE City = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, city);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Airport airport = new Airport();
                    airport.setAirportID(rs.getInt("AirportID"));
                    airport.setAirportName(rs.getString("AirportName"));
                    airport.setCity(rs.getString("City"));
                    airport.setAirportCode(rs.getString("Country"));
                    return airport;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Helper method for database connection
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                CommonConstants.DB_URL,
                CommonConstants.DB_USERNAME,
                CommonConstants.DB_PASSWORD
        );
    }
}