/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataHandle.Data;
import DataHandle.constants.CommonConstants;
import java.sql.*;
import java.util.*;
/**
 *
 * @author DELL
 */
public class Flights {

    public static String chuanHoa(String s){
        StringBuilder sb = new StringBuilder();
        String[] line = s.split("\\s+");
        for(String x : line){
            sb.append(Character.toUpperCase(x.charAt(0)));
            sb.append(x.substring(1).toLowerCase() + " ");
        }
        return sb.toString().trim();
    }

    //Ma tran de uoc luong thoi gian chuyen bay
    public static int[][] travelTimes = {
            {0, 60, 120, -1, 75, 90, 100, -1, -1, -1, 95, 140, -1, 85, 115, -1, -1, 130, 100, 110, 105}, //VCL
            {60, 0, 90, 150, -1, 80, 110, -1, -1, -1, 120, 160, -1, 95, 125, -1, -1, 140, 90, 115, 100}, // THD
            {120, 90, 0, 180, -1, 70, 105, -1, -1, -1, 130, 150, -1, 100, 140, -1, -1, 135, 95, 120, 110}, // VDH
            {-1, 150, 180, 0, 200, 95, 115, -1, -1, -1, 160, 180, -1, 110, 150, -1, -1, 155, 125, 135, 120}, // DIN
            {75, -1, -1, 200, 0, 65, 80, -1, -1, -1, 115, 135, -1, 95, 105, -1, -1, 145, 105, 115, 100}, // TBB
            {90, 80, 70, 95, 65, 0, 50, -1, -1, -1, 100, 120, -1, 85, 95, -1, -1, 125, 85, 100, 90}, // PXU
            {100, 110, 105, 115, 80, 50, 0, 95, 120, 140, 130, 150, 180, 110, 140, 125, 135, 160, 90, 115, 110}, // BMV
            {-1, -1, -1, -1, -1, -1, 95, 0, 50, 75, -1, 115, 90, -1, 100, -1, -1, 120, -1, 95, -1}, // VKG
            {-1, -1, -1, -1, -1, -1, 120, 50, 0, 90, -1, 130, 100, -1, 115, -1, -1, 140, -1, 110, -1}, // CAH
            {-1, -1, -1, -1, -1, -1, 140, 75, 90, 0, -1, 150, 120, -1, 130, -1, -1, 160, -1, 120, -1}, // VCS
            {95, 120, 130, 160, 115, 100, 130, -1, -1, -1, 0, 60, 180, 75, 85, 50, 90, 100, 115, 120, 105}, // HAN
            {140, 160, 150, 180, 135, 120, 150, 115, 130, 150, 60, 0, 210, 110, 125, 85, 120, 130, 140, 145, 130}, // SGN
            {-1, -1, -1, -1, -1, -1, 180, 90, 100, 120, 180, 210, 0, 150, 160, 140, 170, 50, 190, 170, 155}, // PQC
            {85, 95, 100, 110, 95, 85, 110, -1, -1, -1, 75, 110, 150, 0, 90, 60, 100, 115, 105, 110, 95}, // DAD
            {115, 125, 140, 150, 105, 95, 140, 100, 115, 130, 85, 125, 160, 90, 0, 85, 105, 135, 110, 120, 110}, // CXR
            {-1, -1, -1, -1, -1, -1, 125, -1, -1, -1, 50, 85, 140, 60, 85, 0, 90, 120, 100, 115, 95}, // HUI
            {-1, -1, -1, -1, -1, -1, 135, -1, -1, -1, 90, 120, 170, 100, 105, 90, 0, 150, 120, 125, 110}, // VDO
            {130, 140, 135, 155, 145, 125, 160, 120, 140, 160, 100, 130, 50, 115, 135, 120, 150, 0, 180, 160, 145}, // VCA
            {100, 90, 95, 125, 105, 85, 90, -1, -1, -1, 115, 140, 190, 105, 110, 100, 120, 180, 0, 95, 100}, // VII
            {110, 115, 120, 135, 115, 100, 115, 95, 110, 120, 120, 145, 170, 110, 120, 115, 125, 160, 95, 0, 105}, // UIH
            {105, 100, 110, 120, 100, 90, 110, -1, -1, -1, 105, 130, 155, 95, 110, 95, 110, 145, 100, 105, 0} // HPH
    };

    static String[] cities = {"VCL", "THD", "VDH", "DIN", "TBB", "PXU", "BMV", "VKG", "CAH", "VCS",
            "HAN", "SGN", "PQC", "DAD", "CXR", "HUI", "VDO", "VCA", "VII", "UIH", "HPH"};

    public static boolean insertFlight(Timestamp departureTime, int planeID,
                                       String arrivalCity, String updatedName) {
        String insertFlightSQL = "INSERT INTO " + CommonConstants.DB_FLIGHTS_TABLE +
                " (DepartureTime, ArrivalTime, PlaneID, DepartureAirportID, ArrivalAirportID, UpdatedBy, UpdatedDate) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        String checkQuery = """
            SELECT 1
            FROM airline.flights
            WHERE PlaneID = ?
              AND DATE(DepartureTime) = DATE(?);
        """;


        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

             PreparedStatement checkStmt = connection.prepareStatement(checkQuery);

             PreparedStatement adminIDStmt = connection.prepareStatement(
                     "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?");

             PreparedStatement departureAirportStmt = connection.prepareStatement(
                     "SELECT a.AirportID, a.AirportCode FROM " + CommonConstants.DB_AIRPORTS_TABLE + " a " +
                             "JOIN " + CommonConstants.DB_PLANES_TABLE + " p ON p.LocationID = a.AirportID ");

             PreparedStatement arrivalAirportStmt = connection.prepareStatement(
                     "SELECT AirportID, AirportCode FROM " + CommonConstants.DB_AIRPORTS_TABLE + " WHERE City = ?");
             PreparedStatement insertFlightStmt = connection.prepareStatement(insertFlightSQL)) {

            checkStmt.setInt(1, planeID);
            checkStmt.setTimestamp(2, departureTime);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                return false;
            }

            adminIDStmt.setString(1, updatedName);
            ResultSet adminResultSet = adminIDStmt.executeQuery();
            Integer adminID = null;
            if (adminResultSet.next()) {
                adminID = adminResultSet.getInt("AdminID");
            } else {
                System.err.println("Admin not found");
                return false;
            }

            ResultSet departureResultSet = departureAirportStmt.executeQuery();
            int departureAirportID = -1;
            String departureAirportCode = "";
            if (departureResultSet.next()) {
                departureAirportID = departureResultSet.getInt("AirportID");
                departureAirportCode = departureResultSet.getString("AirportCode");
            } else {
                System.err.println("Departure airport not found");
                return false;
            }

            arrivalAirportStmt.setString(1, arrivalCity);
            ResultSet arrivalResultSet = arrivalAirportStmt.executeQuery();
            int arrivalAirportID = -1;
            String arrivalAirportCode = "";
            if (arrivalResultSet.next()) {
                arrivalAirportID = arrivalResultSet.getInt("AirportID");
                arrivalAirportCode = arrivalResultSet.getString("AirportCode");
            } else {
                System.err.println("Arrival airport not found");
                return false;
            }
            int x = -1, y = -1;
            for (int i=0; i<cities.length; i++) {
                if (departureAirportCode.equals(cities[i])) x = i;
            }
            for (int i=0; i<cities.length; i++) {
                if (arrivalAirportCode.equals(cities[i])) y = i;
            }

            if (x == -1 ||  y == -1) {
                System.err.println("City not found in travelTimes");
                return false;
            }

            int travelTime = travelTimes[x][y];
            if (travelTime == -1 || travelTime == 0) {
                System.err.println("No direct route available between ");
                return false;
            }

            Timestamp arrivalTime = new Timestamp(departureTime.getTime() + travelTime * 60 * 1000);

            insertFlightStmt.setTimestamp(1, departureTime);
            insertFlightStmt.setTimestamp(2, arrivalTime);
            insertFlightStmt.setInt(3, planeID);
            insertFlightStmt.setInt(4, departureAirportID);
            insertFlightStmt.setInt(5, arrivalAirportID);

            if (adminID != null) {
                insertFlightStmt.setInt(6, adminID);
            } else {
                insertFlightStmt.setNull(6, java.sql.Types.INTEGER);
            }

            insertFlightStmt.setDate(7, new java.sql.Date(System.currentTimeMillis()));
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
            System.out.print(viewFlightSQL + " okokokoko ");
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
        String modifyFlightSQL = "UPDATE " + CommonConstants.DB_FLIGHTS_TABLE
                + " SET DepartureTime = ?, ArrivalTime = ?, PlaneID = ?, DepartureAirportID = ?, ArrivalAirportID = ?, "
                + "UpdatedBy = ?, UpdatedDate = ? WHERE FlightID = ?";

        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD); PreparedStatement modifyFlightStmt = connection.prepareStatement(modifyFlightSQL); PreparedStatement adminIDStmt = connection.prepareStatement(
                "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?"); PreparedStatement departureAirportStmt = connection.prepareStatement(
                "SELECT AirportID FROM " + CommonConstants.DB_AIRPORTS_TABLE + " WHERE City = ?"); PreparedStatement arrivalAirportStmt = connection.prepareStatement(
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

    public static List<Object> getFlightById(int flightID) {
        String query = "SELECT FlightID, DepartureTime, ArrivalTime, PlaneID, DepartureAirportID, ArrivalAirportID, UpdatedBy, UpdatedDate FROM flights WHERE FlightID = ?";
        List<Object> flightData = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Gán giá trị cho tham số flightID
            preparedStatement.setInt(1, flightID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Thêm các giá trị vào danh sách
                    flightData.add(resultSet.getInt("FlightID"));              // FlightID
                    flightData.add(resultSet.getTimestamp("DepartureTime"));  // DepartureTime
                    flightData.add(resultSet.getTimestamp("ArrivalTime"));    // ArrivalTime
                    flightData.add(resultSet.getInt("PlaneID"));              // PlaneID
                    flightData.add(resultSet.getInt("DepartureAirportID"));   // DepartureAirportID
                    flightData.add(resultSet.getInt("ArrivalAirportID"));     // ArrivalAirportID
                    flightData.add(resultSet.getInt("UpdatedBy"));            // UpdatedBy
                    flightData.add(resultSet.getDate("UpdatedDate"));         // UpdatedDate
                } else {
                    System.out.println("No flight found with FlightID: " + flightID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flightData; // Trả về danh sách (có thể rỗng nếu không tìm thấy chuyến bay)
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                CommonConstants.DB_URL,
                CommonConstants.DB_USERNAME,
                CommonConstants.DB_PASSWORD
        );
    }

}