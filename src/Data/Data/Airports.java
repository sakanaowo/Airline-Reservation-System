package Data.Data;

public class Airports {
    public void insertAirport(String airportName, String city, String airportCode) {
        String query = "INSERT INTO airports (AirportName, City, AirportCode) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, airportName);
            pstmt.setString(2, city);
            pstmt.setString(3, airportCode);
            pstmt.executeUpdate();
            System.out.println("Airport inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAirport(int airportID) {
        String query = "DELETE FROM airports WHERE AirportID = ?";
        try (Connection conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, airportID);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Airport deleted successfully!");
            } else {
                System.out.println("No airport found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAirport(int airportID, String airportName, String city, String airportCode) {
        String query = "UPDATE airports SET AirportName = ?, City = ?, AirportCode = ? WHERE AirportID = ?";
        try (Connection conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, airportName);
            pstmt.setString(2, city);
            pstmt.setString(3, airportCode);
            pstmt.setInt(4, airportID);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Airport updated successfully!");
            } else {
                System.out.println("No airport found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifyAirportCity(int airportID, String newCity) {
        String query = "UPDATE airports SET City = ? WHERE AirportID = ?";
        try (Connection conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
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

}
