
package UI.Admin;

import UI.Admin.Plugin.*;
import DataHandle.Data.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class view {
    public static void viewFlights(JPanel panel) {
        // Xóa tất cả các thành phần hiện có trong panel để tránh chồng lặp
        panel.removeAll();

        // Định nghĩa tên cột cho bảng
        String[] columnNames = {"Flight ID", "Departure time", "Arrival time", "Plane ID", "Departure airport", "Arrival airport", "Departure city", "Arrival city"};

        // Lấy dữ liệu chuyến bay từ phương thức viewFlight của lớp Flights
        ArrayList<ArrayList<Object>> flightData = Flights.viewFlight("", "", "", "", "");

        // Tạo DefaultTableModel để quản lý dữ liệu bảng
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Thêm dữ liệu vào model
        for (ArrayList<Object> flight : flightData) {
            model.addRow(flight.toArray());
        }

        // Tạo JTable từ model
        JTable table = new JTable(model);

        // Thêm JTable vào JScrollPane
        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Thêm JScrollPane chứa bảng vào panel
        panel.setLayout(new BorderLayout());
        panel.add(tableScrollPane, BorderLayout.CENTER);

        // Làm mới giao diện sau khi thêm bảng mới vào panel
        panel.revalidate();
        panel.repaint();
    }
    
    public static void viewPlanes(JPanel panel){
        panel.removeAll();
        // Định nghĩa tên cột cho bảng
        String[] columnNames = {"Plane ID", "Model", "Seats", "Location", "UpdatedBy", "UpdatedDate"};
        
        ArrayList<ArrayList<Object>> planeData = Planes.viewPlane("", "", "");

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (ArrayList<Object> plane : planeData) {
            model.addRow(plane.toArray());
        }

        JTable table = new JTable(model);

        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        panel.setLayout(new BorderLayout());
        panel.add(tableScrollPane, BorderLayout.CENTER);

        panel.revalidate();
        panel.repaint();
    }
    
    public static void viewAirports(JPanel panel){
        panel.removeAll();
        // modiify
        String[] columnNames = {"Airport ID", "Airport Name", "Location", "Airport Code", "Number Planes"};
        
        ArrayList<ArrayList<Object>> airportData = Airports.viewAirportCity("", "");

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (ArrayList<Object> airport : airportData) {
            model.addRow(airport.toArray());
        }

        JTable table = new JTable(model);

        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        panel.setLayout(new BorderLayout());
        panel.add(tableScrollPane, BorderLayout.CENTER);

        panel.revalidate();
        panel.repaint();
    }
}
