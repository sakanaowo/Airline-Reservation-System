package admininterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PlaneManagementPanel {
    private static List<Object[]> tempPlanesList = new ArrayList<>();

    public static JPanel createPlanesManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255)); // Alice Blue color

        String[] columnNames = {"Plane ID", "Model", "Capacity", "Airline", "Created By", "Created Date", "Updated By", "Updated Date"};
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

        JButton addPlaneButton = new JButton("Add Plane");
        JButton editPlaneButton = new JButton("Edit Plane");
        JButton removePlaneButton = new JButton("Remove Plane");
        JButton searchPlaneButton = new JButton("Search Plane");
        JButton refreshButton = new JButton("Refresh List");

        AdminInterface.styleButton(addPlaneButton);
        AdminInterface.styleButton(editPlaneButton);
        AdminInterface.styleButton(removePlaneButton);
        AdminInterface.styleButton(searchPlaneButton);
        AdminInterface.styleButton(refreshButton);

        buttonPanel.add(addPlaneButton);
        buttonPanel.add(editPlaneButton);
        buttonPanel.add(removePlaneButton);
        buttonPanel.add(searchPlaneButton);
        buttonPanel.add(refreshButton);

        // Text Area for plane details
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
        addPlaneButton.addActionListener(e -> handleAddPlane());
        editPlaneButton.addActionListener(e -> handleEditPlane());
        removePlaneButton.addActionListener(e -> handleRemovePlane());
        searchPlaneButton.addActionListener(e -> handleSearchPlane());
        refreshButton.addActionListener(e -> handleRefreshList(table));

        return panel;
    }

    private static void handleAddPlane() {
        JDialog dialog = new JDialog((Frame) null, "Add Plane", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(9, 2, 10, 10));

        JTextField planeIDField = new JTextField();
        JTextField modelField = new JTextField();
        JTextField capacityField = new JTextField();
        JTextField airlineField = new JTextField();
        JTextField createdByField = new JTextField();
        JTextField createdDateField = new JTextField();
        JTextField updatedByField = new JTextField();
        JTextField updatedDateField = new JTextField();

        dialog.add(new JLabel("Plane ID:"));
        dialog.add(planeIDField);
        dialog.add(new JLabel("Model:"));
        dialog.add(modelField);
        dialog.add(new JLabel("Capacity:"));
        dialog.add(capacityField);
        dialog.add(new JLabel("Airline:"));
        dialog.add(airlineField);
        dialog.add(new JLabel("Created By:"));
        dialog.add(createdByField);
        dialog.add(new JLabel("Created Date:"));
        dialog.add(createdDateField);
        dialog.add(new JLabel("Updated By:"));
        dialog.add(updatedByField);
        dialog.add(new JLabel("Updated Date:"));
        dialog.add(updatedDateField);

        JButton addButton = new JButton("Add");
        AdminInterface.styleButton(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String planeID = planeIDField.getText();
                String model = modelField.getText();
                String capacity = capacityField.getText();
                String airline = airlineField.getText();
                String createdBy = createdByField.getText();
                String createdDate = createdDateField.getText();
                String updatedBy = updatedByField.getText();
                String updatedDate = updatedDateField.getText();

                // Thêm vào danh sách tạm thời
                tempPlanesList.add(new Object[]{planeID, model, capacity, airline, createdBy, createdDate, updatedBy, updatedDate});

                dialog.dispose();
            }
        });

        dialog.add(new JLabel(""));
        dialog.add(addButton);

        dialog.setVisible(true);
    }

    private static void handleEditPlane() {
        System.out.println("Edit Plane button clicked");
        // Implement edit plane functionality
    }

    private static void handleRemovePlane() {
        System.out.println("Remove Plane button clicked");
        // Implement remove plane functionality
    }

    private static void handleSearchPlane() {
        System.out.println("Search Plane button clicked");
        // Implement search plane functionality
    }

    private static void handleRefreshList(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        // Thêm các máy bay từ danh sách tạm thời vào bảng
        for (Object[] plane : tempPlanesList) {
            model.addRow(plane);
        }
        // Xóa danh sách tạm thời sau khi cập nhật bảng
        tempPlanesList.clear();
    }
}
