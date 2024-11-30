package DataHandle.Data;


import DataHandle.constants.CommonConstants;
import Models.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Passengers {

    public static int insertPassenger(String firstName, String lastName,
                               String phoneNumber, String cccd, int userId) {
        String insertSQL = "INSERT INTO airline.passengers (FirstName, LastName, PhoneNumber, CCCD, UserID) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME,
                CommonConstants.DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, cccd);
            preparedStatement.setInt(5, userId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error inserting passenger: " + e.getMessage());
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<ArrayList<Object>> viewPassenger(int userId) {
        String query = "SELECT PassengerID, FirstName, LastName, PhoneNumber, CCCD, UserID " +
                "FROM airline.passengers WHERE UserID = ?";
        ArrayList<ArrayList<Object>> passengerList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ArrayList<Object> passenger = new ArrayList<>();
                passenger.add(resultSet.getInt("PassengerID"));
                passenger.add(resultSet.getString("FirstName"));
                passenger.add(resultSet.getString("LastName"));
                passenger.add(resultSet.getString("PhoneNumber"));
                passenger.add(resultSet.getString("CCCD"));
                passenger.add(resultSet.getInt("UserID"));
                passengerList.add(passenger);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving passengers: " + e.getMessage());
            e.printStackTrace();
        }

        return passengerList;
    }

    public static boolean deletePassenger(int passengerId) {
        String deleteSQL = "DELETE FROM airline.passengers WHERE PassengerID = ?";

        try (Connection connection = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            preparedStatement.setInt(1, passengerId);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting passenger: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyPassenger(int passengerId, String firstName, String lastName, String phoneNumber, String cccd) {
        String updateSQL = "UPDATE airline.passengers " +
                "SET FirstName = ?, LastName = ?, PhoneNumber = ?, CCCD = ? " +
                "WHERE PassengerID = ?";

        try (Connection connection = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, cccd);
            preparedStatement.setInt(5, passengerId);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error modifying passenger: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static Passenger getPassengerByID(int passengerID){
        String query = "SELECT PassengerID, FirstName, LastName, PhoneNumber, CCCD, UserID FROM passengers WHERE PassengerID = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Gán giá trị cho tham số passengerID
            preparedStatement.setInt(1, passengerID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Nếu tìm thấy hành khách, trả về đối tượng Passenger
                if (resultSet.next()) {
                    return new Passenger(
                            resultSet.getInt("PassengerID"),
                            resultSet.getString("FirstName"),
                            resultSet.getString("LastName"),
                            resultSet.getString("PhoneNumber"),
                            resultSet.getString("CCCD"),
                            resultSet.getInt("UserID")
                    );
                } else {
                    System.out.println("No passenger found with PassengerID: " + passengerID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // Nếu không tìm thấy hành khách
    }

    public static ArrayList<Integer> getPassengerIdsByUserId(int userID) {
        String query = "SELECT PassengerID FROM passengers WHERE UserID = ?";
        ArrayList<Integer> passengerIDs = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Gán giá trị cho tham số userID
            preparedStatement.setInt(1, userID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Thêm PassengerID vào danh sách
                    passengerIDs.add(resultSet.getInt("PassengerID"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return passengerIDs; // Trả về danh sách PassengerID
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                CommonConstants.DB_URL,
                CommonConstants.DB_USERNAME,
                CommonConstants.DB_PASSWORD
        );
    }
}