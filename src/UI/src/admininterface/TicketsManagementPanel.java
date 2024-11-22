package admininterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketsManagementPanel {
    public static JPanel createTicketManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255)); // Alice Blue color

        String[] columnNames = {"Ticket ID", "Flight ID", "Passenger Name", "Seat Number", "Booking Date", "Price", "Status"};
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

        JButton addTicketButton = new JButton("Add Ticket");
        JButton editTicketButton = new JButton("Edit Ticket");
        JButton removeTicketButton = new JButton("Remove Ticket");
        JButton searchTicketButton = new JButton("Search Ticket");
        JButton refreshButton = new JButton("Refresh List");

        AdminInterface.styleButton(addTicketButton);
        AdminInterface.styleButton(editTicketButton);
        AdminInterface.styleButton(removeTicketButton);
        AdminInterface.styleButton(searchTicketButton);
        AdminInterface.styleButton(refreshButton);

        buttonPanel.add(addTicketButton);
        buttonPanel.add(editTicketButton);
        buttonPanel.add(removeTicketButton);
        buttonPanel.add(searchTicketButton);
        buttonPanel.add(refreshButton);

        // Text Area for ticket details
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
        addTicketButton.addActionListener(e -> handleAddTicket(panel, table));
        editTicketButton.addActionListener(e -> handleEditTicket());
        removeTicketButton.addActionListener(e -> handleRemoveTicket());
        searchTicketButton.addActionListener(e -> handleSearchTicket());
        refreshButton.addActionListener(e -> handleRefreshList());

        return panel;
    }

    private static void handleAddTicket(JPanel panel, JTable table) {
        JDialog dialog = new JDialog((Frame) null, "Add Ticket", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(8, 2, 10, 10));

        JTextField ticketIDField = new JTextField();
        JTextField flightIDField = new JTextField();
        JTextField passengerNameField = new JTextField();
        JTextField seatNumberField = new JTextField();
        JTextField bookingDateField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField statusField = new JTextField();

        dialog.add(new JLabel("Ticket ID:"));
        dialog.add(ticketIDField);
        dialog.add(new JLabel("Flight ID:"));
        dialog.add(flightIDField);
        dialog.add(new JLabel("Passenger Name:"));
        dialog.add(passengerNameField);
        dialog.add(new JLabel("Seat Number:"));
        dialog.add(seatNumberField);
        dialog.add(new JLabel("Booking Date:"));
        dialog.add(bookingDateField);
        dialog.add(new JLabel("Price:"));
        dialog.add(priceField);
        dialog.add(new JLabel("Status:"));
        dialog.add(statusField);

        JButton addButton = new JButton("Add");
        AdminInterface.styleButton(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ticketID = ticketIDField.getText();
                String flightID = flightIDField.getText();
                String passengerName = passengerNameField.getText();
                String seatNumber = seatNumberField.getText();
                String bookingDate = bookingDateField.getText();
                String price = priceField.getText();
                String status = statusField.getText();

                // Thêm dòng mới vào bảng
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{ticketID, flightID, passengerName, seatNumber, bookingDate, price, status});

                dialog.dispose();
            }
        });

        dialog.add(new JLabel(""));
        dialog.add(addButton);

        dialog.setVisible(true);
    }

    private static void handleEditTicket() {
        System.out.println("Edit Ticket button clicked");
        // Implement edit ticket functionality
    }

    private static void handleRemoveTicket() {
        System.out.println("Remove Ticket button clicked");
        // Implement remove ticket functionality
    }

    private static void handleSearchTicket() {
        System.out.println("Search Ticket button clicked");
        // Implement search ticket functionality
    }

    private static void handleRefreshList() {
        System.out.println("Refresh List button clicked");
        // Implement refresh list functionality
    }
}
