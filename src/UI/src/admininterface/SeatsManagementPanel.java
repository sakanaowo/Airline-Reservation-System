package admininterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SeatsManagementPanel {
    private static List<Object[]> tempSeatsList = new ArrayList<>();

    public static JPanel createSeatsManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255)); // Alice Blue color

        String[] columnNames = {"Seat ID", "Plane ID", "Class", "Row", "Number", "Available", "Created By", "Created Date", "Updated By", "Updated Date"};
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

        JButton addSeatButton = new JButton("Add Seat");
        JButton editSeatButton = new JButton("Edit Seat");
        JButton removeSeatButton = new JButton("Remove Seat");
        JButton searchSeatButton = new JButton("Search Seat");
        JButton refreshButton = new JButton("Refresh List");

        AdminInterface.styleButton(addSeatButton);
        AdminInterface.styleButton(editSeatButton);
        AdminInterface.styleButton(removeSeatButton);
        AdminInterface.styleButton(searchSeatButton);
        AdminInterface.styleButton(refreshButton);

        buttonPanel.add(addSeatButton);
        buttonPanel.add(editSeatButton);
        buttonPanel.add(removeSeatButton);
        buttonPanel.add(searchSeatButton);
        buttonPanel.add(refreshButton);

        // Text Area for seat details
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
        addSeatButton.addActionListener(e -> handleAddSeat());
        editSeatButton.addActionListener(e -> handleEditSeat());
        removeSeatButton.addActionListener(e -> handleRemoveSeat());
        searchSeatButton.addActionListener(e -> handleSearchSeat());
        refreshButton.addActionListener(e -> handleRefreshList(table));

        return panel;
    }

        private static void handleAddSeat() {
        JDialog dialog = new JDialog((Frame) null, "Add Seat", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(11, 2, 10, 10));

        JTextField seatIDField = new JTextField();
        JTextField planeIDField = new JTextField();
        JTextField classField = new JTextField();
        JTextField rowField = new JTextField();
        JTextField numberField = new JTextField();
        JTextField availableField = new JTextField();
        JTextField createdByField = new JTextField();
        JTextField createdDateField = new JTextField();
        JTextField updatedByField = new JTextField();
        JTextField updatedDateField = new JTextField();

        dialog.add(new JLabel("Seat ID:"));
        dialog.add(seatIDField);
        dialog.add(new JLabel("Plane ID:"));
        dialog.add(planeIDField);
        dialog.add(new JLabel("Class:"));
        dialog.add(classField);
        dialog.add(new JLabel("Row:"));
        dialog.add(rowField);
        dialog.add(new JLabel("Number:"));
        dialog.add(numberField);
        dialog.add(new JLabel("Available:"));
        dialog.add(availableField);
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
                String seatID = seatIDField.getText();
                String planeID = planeIDField.getText();
                String seatClass = classField.getText();
                String row = rowField.getText();
                String number = numberField.getText();
                String available = availableField.getText();
                String createdBy = createdByField.getText();
                String createdDate = createdDateField.getText();
                String updatedBy = updatedByField.getText();
                String updatedDate = updatedDateField.getText();

                // Thêm vào danh sách tạm thời
                tempSeatsList.add(new Object[]{seatID, planeID, seatClass, row, number, available, createdBy, createdDate, updatedBy, updatedDate});

                dialog.dispose();
            }
        });

        dialog.add(new JLabel(""));
        dialog.add(addButton);

        dialog.setVisible(true);
    }

    private static void handleEditSeat() {
        System.out.println("Edit Seat button clicked");
        // Implement edit seat functionality
    }

    private static void handleRemoveSeat() {
        System.out.println("Remove Seat button clicked");
        // Implement remove seat functionality
    }

    private static void handleSearchSeat() {
        System.out.println("Search Seat button clicked");
        // Implement search seat functionality
    }

    private static void handleRefreshList(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        // Thêm các chỗ ngồi từ danh sách tạm thời vào bảng
        for (Object[] seat : tempSeatsList) {
            model.addRow(seat);
        }
        // Xóa danh sách tạm thời sau khi cập nhật bảng
        tempSeatsList.clear();
    }
}
