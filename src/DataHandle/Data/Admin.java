package DataHandle.Data;

import DataHandle.constants.CommonConstants;

import java.sql.*;

public class Admin {
    public static boolean checkAdminLogin(String AdminName, String password) {
        String sql = "SELECT Password FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?";
        boolean isAuthenticated = false;

        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, AdminName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String storedPassword = resultSet.getString("Password");

                    isAuthenticated = storedPassword.equals(password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isAuthenticated;
    }
}
