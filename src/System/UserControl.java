package System;

import java.sql.*;
import java.util.ArrayList;

import DataHandle.Data.Users;

public class UserControl {
    public UserControl() {
    }

    //     Kiểm tra người dùng hợp lệ
    public boolean isValidUser(String username, String password) throws SQLException {
        boolean b = Users.validateUser(username, password);
        return b;
    }

    public int getIDByUserName(String username) throws SQLException {
        return Users.getIDViaName(username);
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

    public static boolean changeEmail(int userID, String newEmail) throws SQLException {
        return Users.updateUserEmail(userID, newEmail);
    }

    public static boolean deleteUser(int userID, String confirm) throws SQLException {
        String pwd = Users.getPasswordByID(userID);
        if (confirm.equals(pwd)) {
            ArrayList<Integer> passIDs = ReservationControl.getPassIDs(userID);
            for (int i : passIDs) {
                ReservationControl.CancelTicket(i);
            }
            return Users.deleteUser(userID);
        } else return false;
    }

    public boolean resetPassword(String username, String email) throws SQLException {
        return Users.resetPWD(username, email);
    }
}

