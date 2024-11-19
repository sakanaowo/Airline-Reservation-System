package System;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import DataHandle.Data.Users;

import Models.*;

public class UserManager {
    public UserManager(){}
    //     Kiểm tra người dùng hợp lệ
    public boolean isValidUser(String username, String password) throws SQLException {
        boolean b = Users.validateUser(username, password);
        return b;
    }

    // kiểm tra nếu người dùng tồn tại
    public boolean IfExists(String username) throws SQLException {
        return Users.isUserNameExist(username);
    }

    // thêm tài khoản vào DB
    public boolean addUser(String username, String password, String email) throws SQLException {
        boolean b = Users.insertUser(username, password, email);
        return b;
    }

}
//    private Map<String, String> users;
//    private Connection connection;
//
//    // Constructor kết nối với database và load dữ liệu người dùng
//    public UserManager() {
//        users = new HashMap<>();
//        connectToDatabase();
//        loadUsers();
//    }
//
//    // Kết nối tới cơ sở dữ liệu MySQL
//    private void connectToDatabase() {
//        try {
//            // Kết nối tới MySQL, cần sửa lại URL, username, password theo cấu hình của bạn
//            String url = "jdbc:mysql://127.0.0.1:3306/airlinereservationoop";
//            String user = "root";
//            String password = "khongbiet";
//            connection = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to database.");
//        } catch (SQLException e) {
//            System.out.println("Error connecting to database: " + e.getMessage());
//        }
//    }
//
//
//
//    // Thêm người dùng mới vào cơ sở dữ liệu và bản đồ (map) nội bộ
//    public void addUser(String username, String password) {
//        if (username == null || password == null || username.contains(" ") || password.contains(" ")) {
//            System.out.println("Invalid username or password.");
//            return;
//        }
////        String hashedPassword = hashPassword(password);
//        String hashedPassword = password;
//
//        // Thêm vào cơ sở dữ liệu MySQL
//        try (PreparedStatement stmt = connection.prepareStatement(
//                "INSERT INTO User (account, password) VALUES (?, ?)")) {
//            stmt.setString(1, username);
//            stmt.setString(2, hashedPassword);
//            stmt.executeUpdate();
//
//            // Cập nhật vào map nội bộ
//            users.put(username, hashedPassword);
//            System.out.println("User added successfully.");
//        } catch (SQLException e) {
//            System.out.println("Error adding user: " + e.getMessage());
//        }
//    }
//
//    // Load thông tin người dùng từ database MySQL
//    private void loadUsers() {
//        try (Statement stmt = connection.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT account, password FROM User")) {
//            while (rs.next()) {
//                String username = rs.getString("account");
//                String hashedPassword = rs.getString("password");
//                users.put(username, hashedPassword);
//            }
//            System.out.println("Users loaded successfully.");
//        } catch (SQLException e) {
//            System.out.println("Could not load users: " + e.getMessage());
//        }
//    }
//
//    // Hàm hash mật khẩu (SHA-256) + salt để tăng cường bảo mật
//    private String hashPassword(String password) {
//        try {
//            String salt = "a_random_salt";  // Có thể thay bằng một giá trị ngẫu nhiên cho mỗi người dùng
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            byte[] hashedBytes = md.digest((password + salt).getBytes());
//            StringBuilder sb = new StringBuilder();
//            for (byte b : hashedBytes) {
//                sb.append(String.format("%02x", b));
//            }
//            return sb.toString();
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException("Error hashing password: " + e.getMessage());
//        }
//    }
//
//    // Đóng kết nối với cơ sở dữ liệu khi không sử dụng nữa
//    public void closeConnection() {
//        try {
//            if (connection != null && !connection.isClosed()) {
//                connection.close();
//                System.out.println("Database connection closed.");
//            }
//        } catch (SQLException e) {
//            System.out.println("Error closing connection: " + e.getMessage());
//        }
//    }
//}
