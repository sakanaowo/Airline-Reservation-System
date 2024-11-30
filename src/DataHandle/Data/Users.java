package DataHandle.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

import DataHandle.constants.CommonConstants;
import Models.User;


public class Users {

    public static Connection conn;

    // kiem tra nguoi dung hop le
    public static boolean validateUser(String userName, String password) throws SQLException {
        String validateQuery = "SELECT COUNT(*) FROM " + CommonConstants.DB_USER_TABLE +
                " WHERE UserName = ? AND Password = ?";
        conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

        try (PreparedStatement validateStmt = conn.prepareStatement(validateQuery)) {
            validateStmt.setString(1, userName);
            validateStmt.setString(2, password);

            ResultSet rs = validateStmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    System.out.println("Dang nhap thanh cong!");
                    return true;
                }
            }
            System.out.println("Ten dang nhap hoac mat khau khong dung!");
            return false;
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }

    public static boolean insertUser(String userName, String password, String email) throws SQLException {
        String insertUserQuery = "INSERT INTO " + CommonConstants.DB_USER_TABLE
                + "(UserName, Password, Email) VALUES(?,?,?)";
        conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
        boolean check = true;
        //Kiem tra username da co chua
        if (!isUserNameExist(userName)) {
            PreparedStatement insertUser = conn.prepareStatement(insertUserQuery);
            insertUser.setString(1, userName);
            insertUser.setString(2, password);
            insertUser.setString(3, email);
            int rowsAffected = insertUser.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Them nguoi dung thanh cong!");
            }
        } else {
            System.out.println("Them nguoi dung that bai!");
            check = false;
        }
        return check;
    }

    //check ten tk xem da ton tai chua
    public static boolean isUserNameExist(String userName) throws SQLException {
        String checkQuery = "SELECT COUNT(*) FROM " + CommonConstants.DB_USER_TABLE + " WHERE UserName = ?";
        conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
        PreparedStatement checkName = conn.prepareStatement(checkQuery);
        checkName.setString(1, userName);
        ResultSet rs = checkName.executeQuery();
        if (rs.next()) {
            int exist = rs.getInt(1);
            if (exist > 0) {
                System.out.println("Ten tai khoan da ton tai");
                return true;
            }
        }
        return false;
    }

    //Lay id cua user thong qua userName trong luc dang dang nhap
    public static int getIDViaName(String userName) throws SQLException {
        String getIDQuery = "SELECT UserID FROM " + CommonConstants.DB_USER_TABLE + " WHERE UserName = ?";
        conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
        PreparedStatement getID = conn.prepareStatement(getIDQuery);
        getID.setString(1, userName);
        int ID = -1;//neu 0 co thi la -1
        ResultSet rs = getID.executeQuery();
        if (rs.next()) {
            ID = rs.getInt("UserID");
        }
        return ID;
    }

    public static boolean updateUserEmail(int ID, String email) throws SQLException {
        conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
        String updateEmailQuery = "UPDATE " + CommonConstants.DB_USER_TABLE + " SET Email = ? WHERE UserID = ?";

        PreparedStatement updateEmail = conn.prepareStatement(updateEmailQuery);
        updateEmail.setString(1, email);
        updateEmail.setInt(2, ID);

        int rowsAffected = updateEmail.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Update Email thanh cong!");
            return true;
        } else {
            System.out.println("Update Email that bai!");
            return false;
        }
    }

    public static boolean updateUserPassword(int ID, String password) throws SQLException {
        conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
        String updateEmailQuery = "UPDATE " + CommonConstants.DB_USER_TABLE + " SET Password = ? WHERE UserID = ?";

        PreparedStatement updatePassword = conn.prepareStatement(updateEmailQuery);
        updatePassword.setString(1, password);
        updatePassword.setInt(2, ID);

        int rowsAffected = updatePassword.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Update Password thanh cong!");
            return true;
        } else {
            System.out.println("Update Password that bai!");
            return false;
        }
    }

    //xoa tai khoan ng dung thong qua ID
    public static boolean deleteUser(int ID) throws SQLException {
        conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
        String deleteUserQuery = "DELETE FROM " + CommonConstants.DB_USER_TABLE + " WHERE UserID = ?";

        PreparedStatement deleteUser = conn.prepareStatement(deleteUserQuery);
        deleteUser.setInt(1, ID);
        int rowsAffected = deleteUser.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Xoa thanh cong!");
            return true;
        } else {
            System.out.println("Xoa that bai!");
            return false;
        }
    }

    public static User getUserByID(int userID) throws SQLException {
        String getUserQuery = "SELECT UserName, Password, Email FROM " + CommonConstants.DB_USER_TABLE + " WHERE UserID = ?";
        conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

        try (PreparedStatement getUserStmt = conn.prepareStatement(getUserQuery)) {
            getUserStmt.setInt(1, userID);
            ResultSet rs = getUserStmt.executeQuery();

            if (rs.next()) {
                // Lấy thông tin từ kết quả truy vấn
                String userName = rs.getString("UserName");
                String password = rs.getString("Password");
                String email = rs.getString("Email");

                // Tạo đối tượng User và trả về
                User user = new User(userName, password, email); // Điều chỉnh constructor User nếu cần
                user.setUserID(userID);
                return user;
            } else {
                System.out.println("Không tìm thấy User với ID: " + userID);
                return null;
            }
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }



    public static String getPasswordByID(int userID) throws SQLException {
        conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
        String getPasswordQuery = "SELECT Password FROM " + CommonConstants.DB_USER_TABLE + " WHERE UserID = ?";
        PreparedStatement getPassword = conn.prepareStatement(getPasswordQuery);
        getPassword.setInt(1, userID);
        ResultSet rs = getPassword.executeQuery();
        return rs.next() ? rs.getString("Password") : null;
    }

    public static boolean resetPWD(String username, String email) throws SQLException {
        conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
        String resetQ = "SELECT UserID,email FROM " + CommonConstants.DB_USER_TABLE + " WHERE UserName = ?";
        PreparedStatement resetPwd = conn.prepareStatement(resetQ);
        resetPwd.setString(1, username);
        ResultSet rs = resetPwd.executeQuery();
        if (rs.next()) {
            int tmp1 = rs.getInt("UserID");
            String tmp2 = rs.getString("email");
            if (tmp2.equals(email)) {
                updateUserPassword(tmp1, "1");
                return true;
            } else return false;
        }
        return false;
    }
}