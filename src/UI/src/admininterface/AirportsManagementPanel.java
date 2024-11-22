package admininterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AirportsManagementPanel {
    public static JPanel createAirportManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255)); // Alice Blue color

        String[] columnNames = {"Airport ID", "Airport Name", "Location", "Number of Terminals", "Created By", "Created Date", "Updated By", "Updated Date"};
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

        JButton addAirportButton = new JButton("Add Airport");
        JButton editAirportButton = new JButton("Edit Airport");
        JButton removeAirportButton = new JButton("Remove Airport");
        JButton searchAirportButton = new JButton("Search Airport");
        JButton refreshButton = new JButton("Refresh List");

        AdminInterface.styleButton(addAirportButton);
        AdminInterface.styleButton(editAirportButton);
        AdminInterface.styleButton(removeAirportButton);
        AdminInterface.styleButton(searchAirportButton);
        AdminInterface.styleButton(refreshButton);

        buttonPanel.add(addAirportButton);
        buttonPanel.add(editAirportButton);
        buttonPanel.add(removeAirportButton);
        buttonPanel.add(searchAirportButton);
        buttonPanel.add(refreshButton);

        // Text Area for airport details
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
        addAirportButton.addActionListener(e -> handleAddAirport(panel, table));
        editAirportButton.addActionListener(e -> handleEditAirport());
        removeAirportButton.addActionListener(e -> handleRemoveAirport());
        searchAirportButton.addActionListener(e -> handleSearchAirport());
        refreshButton.addActionListener(e -> handleRefreshList());

        return panel;
    }

    private static void handleAddAirport(JPanel panel, JTable table) {
        JDialog dialog = new JDialog((Frame) null, "Add Airport", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(9, 2, 10, 10));

        JTextField airportIDField = new JTextField();
        JTextField airportNameField = new JTextField();
        JTextField locationField = new JTextField();
        JTextField numberOfTerminalsField = new JTextField();
        JTextField createdByField = new JTextField();
        JTextField createdDateField = new JTextField();
        JTextField updatedByField = new JTextField();
        JTextField updatedDateField = new JTextField();

        dialog.add(new JLabel("Airport ID:"));
        dialog.add(airportIDField);
        dialog.add(new JLabel("Airport Name:"));
        dialog.add(airportNameField);
        dialog.add(new JLabel("Location:"));
        dialog.add(locationField);
        dialog.add(new JLabel("Number of Terminals:"));
        dialog.add(numberOfTerminalsField);
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
                String airportID = airportIDField.getText();
                String airportName = airportNameField.getText();
                String location = locationField.getText();
                String numberOfTerminals = numberOfTerminalsField.getText();
                String createdBy = createdByField.getText();
                String createdDate = createdDateField.getText();
                String updatedBy = updatedByField.getText();
                String updatedDate = updatedDateField.getText();

                // Thêm dòng mới vào bảng
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{airportID, airportName, location, numberOfTerminals, createdBy, createdDate, updatedBy, updatedDate});

                dialog.dispose();
            }
        });

        dialog.add(new JLabel(""));
        dialog.add(addButton);

        dialog.setVisible(true);
    }

    private static void handleEditAirport() {
        System.out.println("Edit Airport button clicked");
        // Implement edit airport functionality
    }

    private static void handleRemoveAirport() {
        System.out.println("Remove Airport button clicked");
        // Implement remove airport functionality
    }

    private static void handleSearchAirport() {
        System.out.println("Search Airport button clicked");
        // Implement search airport functionality
    }

    private static void handleRefreshList() {
        System.out.println("Refresh List button clicked");
        // Implement refresh list functionality
    }
}
