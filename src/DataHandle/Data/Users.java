package DataHandle.Data;

import java.sql.*;
import DataHandle.constants.CommonConstants;


public class Users {

    public static Connection conn;

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
        }
        else {
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

    public static boolean viewTickets() throws SQLException {
        conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
        String viewTicketsQuery = """
                SELECT
                    t.TicketID,
                    t.TicketCode,
                    t.ReservationDate,
                    p.FirstName,
                    p.LastName,
                    s.Class,
                    s.Position,
                    s.Price,
                    s.Available,
                    s.FlightID
                FROM """ + CommonConstants.DB_TICKETS_TABLE + " t"
                + " JOIN " + CommonConstants.DB_PASSENGERS_TABLE + " p ON t.PassengerID = p.PassengerID"
                + " JOIN " + CommonConstants.DB_SEATS_TABLE + " s ON t.SeatID = s.SeatID";

        PreparedStatement viewTicket = conn.prepareStatement(viewTicketsQuery);
        ResultSet rs = viewTicket.executeQuery();
        //Kiem tra xem co ticket khong
        boolean check = false;// Cai nay de kiem tra
        if (rs.isBeforeFirst()) {
            check = true;
            System.out.printf("%-10s %-15s %-20s %-20s %-30s %-10s %-10s%n",
                    "TicketID", "TicketCode", "ReservationDate",
                    "PassengerName", "PassengerEmail", "SeatNumber", "FlightID");

            while (rs.next()) {
                int ticketID = rs.getInt("TicketID");
                String ticketCode = rs.getString("TicketCode");
                String reservationDate = rs.getString("ReservationDate");
                String passengerName = rs.getString("PassengerName");
                String passengerEmail = rs.getString("PassengerEmail");
                String seatNumber = rs.getString("SeatNumber");
                int flightID = rs.getInt("FlightID");

                System.out.printf("%-10d %-15s %-20s %-20s %-30s %-10s %-10d%n",
                        ticketID, ticketCode, reservationDate,
                        passengerName, passengerEmail, seatNumber, flightID);
            }
        }
        return check;
    }

    public static boolean insertTicket() {
        //Con xem UI nhu nao roi phat trien sau
        return true;
    }

//    public static void main(String[] args) throws SQLException {
//        conn = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
//        //insertUser("meobinh", "123", "meobinh123");
//        //insertUser("binhmeo", "321", "dcmeo");
//        //System.out.println(getIDViaName("meobinh"));
//        //updateUserEmail(6, "okokokok");
//        //updateUserPassword(6, "123213");
//        //deleteUser(6);
//    }
}