/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataHandle.Data;
import DataHandle.Data.*;
import DataHandle.constants.CommonConstants;

import java.sql.*;
import java.util.*;
import java.time.*;
/**
 *
 * @author DELL
 */
public class Planes {
        public static boolean insertPlane(String model, int seats, String updatedBy) {
        String insertPlaneSQL = "INSERT INTO " + CommonConstants.DB_PLANES_TABLE +
        " (Model, Seats, UpdatedBy, UpdatedDate) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
             PreparedStatement adminIDStmt = connection.prepareStatement(
             "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?");
             PreparedStatement insertPlaneStmt = connection.prepareStatement(insertPlaneSQL)) {

            adminIDStmt.setString(1, updatedBy);
            ResultSet resultSet = adminIDStmt.executeQuery();
            Integer adminID = null; 

            if (resultSet.next()) {
                adminID = resultSet.getInt("AdminID");
            } else {
                System.err.println("Admin not found");
                return false;
            }

            insertPlaneStmt.setString(1, model);
            insertPlaneStmt.setInt(2, seats);
            if (adminID != null) {
                insertPlaneStmt.setInt(3, adminID);
            } else {
                insertPlaneStmt.setNull(3, java.sql.Types.INTEGER);
            }
            insertPlaneStmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));

            insertPlaneStmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean modifyPlane(int planeID, String model, int seats, String updatedBy) {
        String modifyPlaneSQL = "UPDATE " + CommonConstants.DB_PLANES_TABLE +
        " SET Model = ?, Seats = ?, UpdatedBy = ?, UpdatedDate = ? WHERE PlaneID = ?";

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement modifyPlaneStmt = connection.prepareStatement(modifyPlaneSQL);
            PreparedStatement adminIDStmt = connection.prepareStatement(
             "SELECT AdminID FROM " + CommonConstants.DB_ADMIN_TABLE + " WHERE AdminName = ?")) {

            adminIDStmt.setString(1, updatedBy);
            ResultSet resultSet = adminIDStmt.executeQuery();
            Integer adminID = null;

            if (resultSet.next()) {
                adminID = resultSet.getInt("AdminID");
            } else {
                System.err.println("Admin not found");
                return false;
            }

            modifyPlaneStmt.setString(1, model);
            modifyPlaneStmt.setInt(2, seats);
            if (adminID != null) {
                modifyPlaneStmt.setInt(3, adminID);
            } else {
                modifyPlaneStmt.setNull(3, java.sql.Types.INTEGER);
            }
            modifyPlaneStmt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
            modifyPlaneStmt.setInt(5, planeID);

            int rowsAffected = modifyPlaneStmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deletePlane(int planeID) {
        String deletePlaneSQL = "DELETE FROM " + CommonConstants.DB_PLANES_TABLE + " WHERE PlaneID = ?";

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement deletePlaneStmt = connection.prepareStatement(deletePlaneSQL)) {

            deletePlaneStmt.setInt(1, planeID);
            int rowsAffected = deletePlaneStmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<ArrayList<Object>> viewPlane() {
        String viewPlaneSQL = "SELECT * FROM " + CommonConstants.DB_PLANES_TABLE;
        ArrayList<ArrayList<Object>> planesList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(
            CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement viewPlanesStmt = connection.prepareStatement(viewPlaneSQL)) {

            ResultSet resultSet = viewPlanesStmt.executeQuery();
            while (resultSet.next()) {
                ArrayList<Object> planeData = new ArrayList<>();
                planeData.add(resultSet.getInt("PlaneID"));
                planeData.add(resultSet.getString("Model"));
                planeData.add(resultSet.getInt("Seats"));
                planeData.add(resultSet.getObject("UpdatedBy")); // Nullable foreign key
                planeData.add(resultSet.getDate("UpdatedDate"));
                planesList.add(planeData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planesList;
    }
}
