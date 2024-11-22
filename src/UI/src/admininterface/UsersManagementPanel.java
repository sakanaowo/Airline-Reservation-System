package admininterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsersManagementPanel {
    public static JPanel createUserManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255)); // Alice Blue color

        String[] columnNames = {"User ID", "Username", "Role", "Email", "Created By", "Created Date", "Updated By", "Updated Date"};
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

        JButton addUserButton = new JButton("Add User");
        JButton editUserButton = new JButton("Edit User");
        JButton removeUserButton = new JButton("Remove User");
        JButton searchUserButton = new JButton("Search User");
        JButton refreshButton = new JButton("Refresh List");

        AdminInterface.styleButton(addUserButton);
        AdminInterface.styleButton(editUserButton);
        AdminInterface.styleButton(removeUserButton);
        AdminInterface.styleButton(searchUserButton);
        AdminInterface.styleButton(refreshButton);

        buttonPanel.add(addUserButton);
        buttonPanel.add(editUserButton);
        buttonPanel.add(removeUserButton);
        buttonPanel.add(searchUserButton);
        buttonPanel.add(refreshButton);

        // Text Area for user details
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
        addUserButton.addActionListener(e -> handleAddUser(panel, table));
        editUserButton.addActionListener(e -> handleEditUser());
        removeUserButton.addActionListener(e -> handleRemoveUser());
        searchUserButton.addActionListener(e -> handleSearchUser());
        refreshButton.addActionListener(e -> handleRefreshList());

        return panel;
    }

    private static void handleAddUser(JPanel panel, JTable table) {
        JDialog dialog = new JDialog((Frame) null, "Add User", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(9, 2, 10, 10));

        JTextField userIDField = new JTextField();
        JTextField usernameField = new JTextField();
        JTextField roleField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField createdByField = new JTextField();
        JTextField createdDateField = new JTextField();
        JTextField updatedByField = new JTextField();
        JTextField updatedDateField = new JTextField();

        dialog.add(new JLabel("User ID:"));
        dialog.add(userIDField);
        dialog.add(new JLabel("Username:"));
        dialog.add(usernameField);
        dialog.add(new JLabel("Role:"));
        dialog.add(roleField);
        dialog.add(new JLabel("Email:"));
        dialog.add(emailField);
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
                String userID = userIDField.getText();
                String username = usernameField.getText();
                String role = roleField.getText();
                String email = emailField.getText();
                String createdBy = createdByField.getText();
                String createdDate = createdDateField.getText();
                String updatedBy = updatedByField.getText();
                String updatedDate = updatedDateField.getText();

                // Thêm dòng mới vào bảng
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{userID, username, role, email, createdBy, createdDate, updatedBy, updatedDate});

                dialog.dispose();
            }
        });

        dialog.add(new JLabel(""));
        dialog.add(addButton);

        dialog.setVisible(true);
    }

    private static void handleEditUser() {
        System.out.println("Edit User button clicked");
        // Implement edit user functionality
    }

    private static void handleRemoveUser() {
        System.out.println("Remove User button clicked");
        // Implement remove user functionality
    }

    private static void handleSearchUser() {
        System.out.println("Search User button clicked");
        // Implement search user functionality
    }

    private static void handleRefreshList() {
        System.out.println("Refresh List button clicked");
        // Implement refresh list functionality
    }
}
