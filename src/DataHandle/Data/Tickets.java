package DataHandle.Data;
import DataHandle.constants.CommonConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Tickets {
    public static boolean insertTicket(int passengerId, int seatId, String ticketCode) {
        String insertTicketSQL = "INSERT INTO airline.tickets (PassengerID, SeatID, TicketCode, ReservationDate) " +
                "VALUES (?, ?, ?, ?)";

        String updateSeatSQL = "UPDATE airline.seats SET Available = 0 WHERE SeatID = ?";

        try (Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                CommonConstants.DB_USERNAME,
                CommonConstants.DB_PASSWORD)) {

            connection.setAutoCommit(false);

            try (PreparedStatement insertTicketStmt = connection.prepareStatement(insertTicketSQL);
                 PreparedStatement updateSeatStmt = connection.prepareStatement(updateSeatSQL)) {

                insertTicketStmt.setInt(1, passengerId);
                insertTicketStmt.setInt(2, seatId);
                insertTicketStmt.setString(3, ticketCode);
                insertTicketStmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

                updateSeatStmt.setInt(1, seatId);

                int rowsAffectedTicket = insertTicketStmt.executeUpdate();
                int rowsAffectedSeat = updateSeatStmt.executeUpdate();

                if (rowsAffectedTicket > 0 && rowsAffectedSeat > 0) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }

            } catch (SQLException e) {
                connection.rollback();
                System.err.println("Error inserting ticket or updating seat: " + e.getMessage());
                e.printStackTrace();
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteTicket(int passengerId) {
        String deleteTicketSQL = "DELETE FROM airline.tickets WHERE PassengerID = ?";
        String updateSeatSQL = "UPDATE airline.seats " +
                "SET Available = 1 " +
                "WHERE SeatID = (SELECT SeatID FROM airline.tickets WHERE PassengerID = ?)";
        String deletePassengerSQL = "DELETE FROM airline.passengers WHERE PassengerID = ?";

        try (Connection connection = DriverManager.getConnection(
                CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD)) {

            connection.setAutoCommit(false);

            try (PreparedStatement updateSeatStatement = connection.prepareStatement(updateSeatSQL);
                 PreparedStatement deleteTicketStatement = connection.prepareStatement(deleteTicketSQL);
                 PreparedStatement deletePassengerStatement = connection.prepareStatement(deletePassengerSQL)) {

                updateSeatStatement.setInt(1, passengerId);
                updateSeatStatement.executeUpdate();

                deleteTicketStatement.setInt(1, passengerId);
                int rowsAffected = deleteTicketStatement.executeUpdate();

                if (rowsAffected > 0) {
                    deletePassengerStatement.setInt(1, passengerId);
                    deletePassengerStatement.executeUpdate();

                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }
            } catch (SQLException e) {
                connection.rollback();
                System.err.println("Error deleting tickets: " + e.getMessage());
                e.printStackTrace();
                return false;
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            System.err.println("Error establishing database connection: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Object> viewTicket(int passengerId) {
        String viewTicketSQL = "SELECT TicketID, SeatID, TicketCode, ReservationDate FROM airline.tickets WHERE PassengerID = ?";
        ArrayList<Object> tickets = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(viewTicketSQL)) {

            preparedStatement.setInt(1, passengerId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    tickets.add(resultSet.getInt("TicketID"));
                    tickets.add(resultSet.getInt("SeatID"));
                    tickets.add(resultSet.getString("TicketCode"));
                    tickets.add(resultSet.getTimestamp("ReservationDate"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error viewing tickets: " + e.getMessage());
            e.printStackTrace();
        }

        return tickets;
    }
}