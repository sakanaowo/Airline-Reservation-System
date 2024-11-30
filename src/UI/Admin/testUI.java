package UI.Admin;

import javax.swing.*;
import java.awt.*;

public class testUI {

    public static void main(String[] args) {
        // Tạo cửa sổ chính
        JFrame mainFrame = new JFrame("Flight Management System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);

        // Tạo tab chính
        JTabbedPane tabbedPane = new JTabbedPane();

        // Thêm tab Flight Management
        tabbedPane.addTab("Flight Management", createFlightManagementPanel());

        // Cài đặt tabbedPane vào cửa sổ chính
        mainFrame.add(tabbedPane, BorderLayout.CENTER);

        // Hiển thị cửa sổ
        mainFrame.setVisible(true);
    }

    private static JPanel createFlightManagementPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Tạo bảng dữ liệu ví dụ
        String[] columnNames = {"Flight ID", "Departure", "Destination", "Time"};
        Object[][] data = {
            {"F001", "Hanoi", "Ho Chi Minh", "08:00"},
            {"F002", "Da Nang", "Hanoi", "10:00"},
            {"F003", "Ho Chi Minh", "Da Nang", "14:00"}
        };

        JTable flightTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(flightTable);

        // Bảng chiếm toàn bộ trung tâm
        panel.add(scrollPane, BorderLayout.CENTER);

        // Khu vực điều khiển ở phía dưới
        JPanel controlPanel = new JPanel();
        JButton addButton = new JButton("Add Flight");
        JButton editButton = new JButton("Edit Flight");
        JButton deleteButton = new JButton("Delete Flight");
        controlPanel.add(addButton);
        controlPanel.add(editButton);
        controlPanel.add(deleteButton);

        panel.add(controlPanel, BorderLayout.SOUTH);

        return panel;
    }
}
