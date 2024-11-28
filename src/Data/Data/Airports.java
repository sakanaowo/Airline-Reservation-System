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
    public ArrayList<ArrayList<Object>> viewAirportCity(String AirportName, String City) {
        String viewAirportSQL =
                "SELECT a.AirportID, a.AirportName, a.City, a.AirportCode, COUNT(p.PlaneID) AS NumberPlanes " +
                        "FROM " + CommonConstants.DB_PLANES_TABLE + " p " +
                        "JOIN " + CommonConstants.DB_AIRPORTS_TABLE + " a ON p.LocationID = a.AirportID " +
                        "WHERE 1=1";

        ArrayList<ArrayList<Object>> airportlist = new ArrayList<>();

        if (!AirportName.isEmpty()) {
            viewAirportSQL += " AND a.AirportName = ? ";
        }
        if (!City.isEmpty()) {
            viewAirportSQL += " AND a.City = ? ";
        }

        viewAirportSQL += " GROUP BY a.AirportID";

        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement viewAirportsStmt = connection.prepareStatement(viewAirportSQL)) {

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
