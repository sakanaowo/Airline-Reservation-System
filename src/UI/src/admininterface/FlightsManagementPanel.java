package admininterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FlightsManagementPanel {
    private static List<Object[]> tempFlightsList = new ArrayList<>();

    public static JPanel createFlightsManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255)); // Alice Blue color

        String[] columnNames = {"Departure Time", "Arrival Time", "Plane ID", "Departure Airport ID", "Arrival Airport ID", "Updated By", "Updated Date"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        panel.add(tableScrollPane, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton addFlightButton = new JButton("Add Flight");
        JButton editFlightButton = new JButton("Edit Flight");
        JButton removeFlightButton = new JButton("Remove Flight");
        JButton searchFlightButton = new JButton("Search Flight");
        JButton refreshButton = new JButton("Refresh List");

        AdminInterface.styleButton(addFlightButton);
        AdminInterface.styleButton(editFlightButton);
        AdminInterface.styleButton(removeFlightButton);
        AdminInterface.styleButton(searchFlightButton);
        AdminInterface.styleButton(refreshButton);

        buttonPanel.add(addFlightButton);
        buttonPanel.add(editFlightButton);
        buttonPanel.add(removeFlightButton);
        buttonPanel.add(searchFlightButton);
        buttonPanel.add(refreshButton);

        // Text Area for flight details
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane textAreaScrollPane = new JScrollPane(textArea);
        textAreaScrollPane.setBorder(BorderFactory.createTitledBorder("Details"));

        panel.add(textAreaScrollPane, BorderLayout.SOUTH);
        textAreaScrollPane.setPreferredSize(new Dimension(600, 200));
        panel.add(buttonPanel, BorderLayout.EAST);

        // Action listeners for buttons
        addFlightButton.addActionListener(e -> handleAddFlight());
        editFlightButton.addActionListener(e -> handleEditFlight());
        removeFlightButton.addActionListener(e -> handleRemoveFlight());
        searchFlightButton.addActionListener(e -> handleSearchFlight());
        refreshButton.addActionListener(e -> handleRefreshList(table));

        return panel;
    }

    private static void handleAddFlight() {
        JDialog dialog = new JDialog((Frame) null, "Add Flight", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(8, 2, 10, 10));

        JTextField departureTimeField = new JTextField();
        JTextField arrivalTimeField = new JTextField();
        JTextField planeIDField = new JTextField();
        JTextField departureAirportIDField = new JTextField();
        JTextField arrivalAirportIDField = new JTextField();
        JTextField updatedByField = new JTextField();
        JTextField updatedDateField = new JTextField();

        dialog.add(new JLabel("Departure Time:"));
        dialog.add(departureTimeField);
        dialog.add(new JLabel("Arrival Time:"));
        dialog.add(arrivalTimeField);
        dialog.add(new JLabel("Plane ID:"));
        dialog.add(planeIDField);
        dialog.add(new JLabel("Departure Airport ID:"));
        dialog.add(departureAirportIDField);
        dialog.add(new JLabel("Arrival Airport ID:"));
        dialog.add(arrivalAirportIDField);
        dialog.add(new JLabel("Updated By:"));
        dialog.add(updatedByField);
        dialog.add(new JLabel("Updated Date:"));
        dialog.add(updatedDateField);

        JButton addButton = new JButton("Add");
        AdminInterface.styleButton(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String departureTime = departureTimeField.getText();
                String arrivalTime = arrivalTimeField.getText();
                String planeID = planeIDField.getText();
                String departureAirportID = departureAirportIDField.getText();
                String arrivalAirportID = arrivalAirportIDField.getText();
                String updatedBy = updatedByField.getText();
                String updatedDate = updatedDateField.getText();

                // Thêm vào danh sách tạm thời
                tempFlightsList.add(new Object[]{departureTime, arrivalTime, planeID, departureAirportID, arrivalAirportID, updatedBy, updatedDate});

                dialog.dispose();
            }
        });

        dialog.add(new JLabel(""));
        dialog.add(addButton);

        dialog.setVisible(true);
    }

    private static void handleEditFlight() {
        System.out.println("Edit Flight button clicked");
        // Implement edit flight functionality
    }

    private static void handleRemoveFlight() {
        System.out.println("Remove Flight button clicked");
        // Implement remove flight functionality
    }

    private static void handleSearchFlight() {
        System.out.println("Search Flight button clicked");
        // Implement search flight functionality
    }

    private static void handleRefreshList(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        // Thêm các chuyến bay từ danh sách tạm thời vào bảng
        for (Object[] flight : tempFlightsList) {
            model.addRow(flight);
        }
        // Xóa danh sách tạm thời sau khi cập nhật bảng
        tempFlightsList.clear();
    }
}
