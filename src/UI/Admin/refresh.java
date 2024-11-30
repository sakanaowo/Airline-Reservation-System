package UI.Admin;


import DataHandle.Data.Flights;
import DataHandle.Data.Planes;
import UI.Admin.Plugin.*;
import DataHandle.Data.Airports;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class refresh {

    public static void handleRefreshPlaneList(JPanel planesPanel) {
        try {
            // Lấy JScrollPane chứa bảng từ panel
            JScrollPane scrollPane = (JScrollPane) planesPanel.getComponent(0); 
            JTable table = (JTable) scrollPane.getViewport().getView();

            // Lấy DefaultTableModel của bảng
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Xóa tất cả dữ liệu cũ trong model
            model.setRowCount(0);

            ArrayList<ArrayList<Object>> planeData = Planes.viewPlane("", "", "");

            // Thêm dữ liệu mới vào model
            for (ArrayList<Object> plane : planeData) {
                model.addRow(plane.toArray());
            }

            // Làm mới bảng
            planesPanel.revalidate();
            planesPanel.repaint();
        } catch (Exception e) {
            System.err.println("Cannot refresh list: " + e.getMessage());
        }
    }
    
    //Flight
    public static void handleRefreshList(JPanel flightsPanel) {
        try {
            // Lấy JScrollPane chứa bảng từ panel
            JScrollPane scrollPane = (JScrollPane) flightsPanel.getComponent(0); // Giả định JScrollPane nằm ở vị trí đầu tiên
            JTable table = (JTable) scrollPane.getViewport().getView();

            // Lấy DefaultTableModel của bảng
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Xóa tất cả dữ liệu cũ trong model
            model.setRowCount(0);

            // Lấy dữ liệu chuyến bay mới từ lớp Flights
            ArrayList<ArrayList<Object>> flightData = Flights.viewFlight("", "", "", "", "");

            // Thêm dữ liệu mới vào model
            for (ArrayList<Object> flight : flightData) {
                model.addRow(flight.toArray());
            }

            // Làm mới bảng
            flightsPanel.revalidate();
            flightsPanel.repaint();
        } catch (Exception e) {
            // Xử lý trường hợp không tìm thấy bảng hoặc lỗi bất ngờ
            System.err.println("Cannot refresh list: " + e.getMessage());
        }
    }
    
    public static void handleRefreshAirportsList(JPanel airportsPanel) {
        try {
            // Lấy JScrollPane chứa bảng từ panel
            JScrollPane scrollPane = (JScrollPane) airportsPanel.getComponent(0); // Giả định JScrollPane nằm ở vị trí đầu tiên
            JTable table = (JTable) scrollPane.getViewport().getView();

            // Lấy DefaultTableModel của bảng
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Xóa tất cả dữ liệu cũ trong model
            model.setRowCount(0);

            ArrayList<ArrayList<Object>> airportData = Airports.viewAirportCity("", "");
                    
            // Thêm dữ liệu mới vào model
            for (ArrayList<Object> airport : airportData) {
                model.addRow(airport.toArray());
            }

            airportsPanel.revalidate();
            airportsPanel.repaint();
        } catch (Exception e) {
            System.err.println("Cannot refresh list: " + e.getMessage());
        }
    }
}
