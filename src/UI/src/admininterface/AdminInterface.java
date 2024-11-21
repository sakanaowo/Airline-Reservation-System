package admininterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class AdminInterface {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin Interface - Airline System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 750);

        // Main panel with CardLayout
        JPanel mainPanel = new JPanel(new CardLayout());

        // Vertical Navigation Menu
        JPanel menuPanel = new JPanel(new GridLayout(6, 1));

        // Load the logo image for the button
        ImageIcon logoIcon = new ImageIcon(AdminInterface.class.getResource("/airport.jpg"));

        // Resize the image to fit the button (optional)
        Image scaledImage = logoIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Adjust size as needed
        ImageIcon scaledLogoIcon = new ImageIcon(scaledImage);

        // Create the button with the logo icon
        JButton dashboardButton = new JButton(scaledLogoIcon);

        // Set background color to light blue
        dashboardButton.setBackground(new Color(173, 216, 230)); // Light Blue (RGB values)
        dashboardButton.setOpaque(true);
        dashboardButton.setContentAreaFilled(true);
        dashboardButton.setBorderPainted(false);
        dashboardButton.setFocusPainted(false);
        dashboardButton.setToolTipText("Dashboard");

        // Other buttons
        JButton flightsButton = new JButton("Flight Management");
        JButton usersButton = new JButton("User Management");
        JButton ticketsButton = new JButton("Ticket Management");
        JButton airportsButton = new JButton("Airport Management");
        JButton logoutButton = new JButton("Log Out");

        // Style buttons
        styleButton(dashboardButton);
        styleButton(flightsButton);
        styleButton(usersButton);
        styleButton(ticketsButton);
        styleButton(airportsButton);
        styleButton(logoutButton);

        menuPanel.add(dashboardButton);
        menuPanel.add(flightsButton);
        menuPanel.add(usersButton);
        menuPanel.add(ticketsButton);
        menuPanel.add(airportsButton);
        menuPanel.add(logoutButton);

        // Panels for different sections
        JPanel dashboardPanel = createDashboardPanel();
        JPanel flightsPanel = createFlightsManagementPanel();
        JPanel usersPanel = createUserManagementPanel();
        JPanel ticketsPanel = createTicketManagementPanel();
        JPanel airportsPanel = createAirportManagementPanel();

        mainPanel.add(dashboardPanel, "Dashboard");
        mainPanel.add(flightsPanel, "FlightsManagement");
        mainPanel.add(usersPanel, "UsersManagement");
        mainPanel.add(ticketsPanel, "TicketsManagement");
        mainPanel.add(airportsPanel, "AirportsManagement");

        // Action Listeners for navigation
        dashboardButton.addActionListener(e -> showPanel(mainPanel, "Dashboard"));
        flightsButton.addActionListener(e -> showPanel(mainPanel, "FlightsManagement"));
        usersButton.addActionListener(e -> showPanel(mainPanel, "UsersManagement"));
        ticketsButton.addActionListener(e -> showPanel(mainPanel, "TicketsManagement"));
        airportsButton.addActionListener(e -> showPanel(mainPanel, "AirportsManagement"));
        logoutButton.addActionListener(e -> handleLogout(frame));

        // Frame Layout
        frame.setLayout(new BorderLayout());
        frame.add(menuPanel, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Method to switch panels based on button click
    private static void showPanel(JPanel mainPanel, String panelName) {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, panelName);
    }

    // Method to handle log out confirmation
    private static void handleLogout(JFrame frame) {
        int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0); // Exit the application
        }
    }

    // Method to style buttons
    private static void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(70, 130, 180)); // Steel Blue color
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(200, 50));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

    // Method to create Dashboard Panel
    private static JPanel createDashboardPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(240, 248, 255)); // Alice Blue color

        JLabel welcomeLabel = new JLabel("Welcome to our website!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        welcomeLabel.setForeground(new Color(70, 130, 180)); // Steel Blue color
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(welcomeLabel);

        return panel;
    }

    public static JPanel createFlightsManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255)); // Alice Blue color

        String[] columnNames = {"Flight ID", "Flight Name", "Departure", "Arrival", "Date", "Seats Available"};
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

        styleButton(addFlightButton);
        styleButton(editFlightButton);
        styleButton(removeFlightButton);
        styleButton(searchFlightButton);
        styleButton(refreshButton);

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
        addFlightButton.addActionListener(e -> handleAddFlight(panel, table));
        editFlightButton.addActionListener(e -> handleEditFlight());
        removeFlightButton.addActionListener(e -> handleRemoveFlight());
        searchFlightButton.addActionListener(e -> handleSearchFlight());
        refreshButton.addActionListener(e -> handleRefreshList());

        return panel;
    }

    private static void handleAddFlight(JPanel panel, JTable table) {
        JDialog dialog = new JDialog((Frame) null, "Add Flight", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(7, 2, 10, 10));

        JTextField flightIDField = new JTextField();
        JTextField flightNameField = new JTextField();
        JTextField departureField = new JTextField();
        JTextField arrivalField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField seatsAvailableField = new JTextField();

        dialog.add(new JLabel("Flight ID:"));
        dialog.add(flightIDField);
        dialog.add(new JLabel("Flight Name:"));
        dialog.add(flightNameField);
        dialog.add(new JLabel("Departure:"));
        dialog.add(departureField);
        dialog.add(new JLabel("Arrival:"));
        dialog.add(arrivalField);
        dialog.add(new JLabel("Date:"));
        dialog.add(dateField);
        dialog.add(new JLabel("Seats Available:"));
        dialog.add(seatsAvailableField);

        JButton addButton = new JButton("Add");
        styleButton(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flightID = flightIDField.getText();
                String flightName = flightNameField.getText();
                String departure = departureField.getText();
                String arrival = arrivalField.getText();
                String date = dateField.getText();
                String seatsAvailable = seatsAvailableField.getText();

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{flightID, flightName, departure, arrival, date, seatsAvailable});

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

    private static void handleRefreshList() {
        System.out.println("Refresh List button clicked");
        // Implement refresh list functionality
    }

    // Method to create User Management Panel
    private static JPanel createUserManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255)); // Alice Blue color

        // Create a table to display user information
        String[] columnNames = {"User ID", "Username", "Email", "Role", "Status"};
        Object[][] data = {}; // Replace with actual user data

        JTable table = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        panel.add(tableScrollPane, BorderLayout.CENTER);

        // Button panel for user management
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton addUserButton = new JButton("Add User");
        JButton editUserButton = new JButton("Edit User");
        JButton removeUserButton = new JButton("Remove User");
        JButton searchUserButton = new JButton("Search User");
        JButton refreshUserButton = new JButton("Refresh List");

        styleButton(addUserButton);
        styleButton(editUserButton);
        styleButton(removeUserButton);
        styleButton(searchUserButton);
        styleButton(refreshUserButton);

        buttonPanel.add(addUserButton);
        buttonPanel.add(editUserButton);
        buttonPanel.add(removeUserButton);
        buttonPanel.add(searchUserButton);
        buttonPanel.add(refreshUserButton);

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

        // Action listeners for user buttons
        addUserButton.addActionListener(e -> handleAddUser());
        editUserButton.addActionListener(e -> handleEditUser());
        removeUserButton.addActionListener(e -> handleRemoveUser());
        searchUserButton.addActionListener(e -> handleSearchUser());
        refreshUserButton.addActionListener(e -> handleRefreshUserList());

        return panel;
    }

    // Event handling methods
    private static void handleAddUser() {
        System.out.println("Add Flight button clicked");
        // Implement add flight functionality
    }

    private static void handleEditUser() {
        System.out.println("Edit Flight button clicked");
        // Implement edit flight functionality
    }

    private static void handleRemoveUser() {
        System.out.println("Remove Flight button clicked");
        // Implement remove flight functionality
    }

    private static void handleSearchUser() {
        System.out.println("Search Flight button clicked");
        // Implement search flight functionality
    }

    private static void handleRefreshUserList() {
        System.out.println("Refresh List button clicked");
        // Implement refresh list functionality
    }

    // Method to create Ticket Management Panel
    private static JPanel createTicketManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255)); // Alice Blue color

        // Create a table to display ticket information
        String[] columnNames = {"Ticket ID", "Passenger Name", "Flight", "Date", "Price"};
        Object[][] data = {}; // Replace with actual ticket data

        JTable table = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        panel.add(tableScrollPane, BorderLayout.CENTER);

        // Button panel for ticket management
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton addTicketButton = new JButton("Add Ticket");
        JButton editTicketButton = new JButton("Edit Ticket");
        JButton removeTicketButton = new JButton("Remove Ticket");
        JButton searchTicketButton = new JButton("Search Ticket");
        JButton refreshTicketButton = new JButton("Refresh List");

        styleButton(addTicketButton);
        styleButton(editTicketButton);
        styleButton(removeTicketButton);
        styleButton(searchTicketButton);
        styleButton(refreshTicketButton);

        buttonPanel.add(addTicketButton);
        buttonPanel.add(editTicketButton);
        buttonPanel.add(removeTicketButton);
        buttonPanel.add(searchTicketButton);
        buttonPanel.add(refreshTicketButton);

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

        // Action listeners for ticket buttons
        addTicketButton.addActionListener(e -> handleAddTicket());
        editTicketButton.addActionListener(e -> handleEditTicket());
        removeTicketButton.addActionListener(e -> handleRemoveTicket());
        searchTicketButton.addActionListener(e -> handleSearchTicket());
        refreshTicketButton.addActionListener(e -> handleRefreshTicketList());

        return panel;
    }

    // Event handling methods
    private static void handleAddTicket() {
        System.out.println("Add Flight button clicked");
        // Implement add flight functionality
    }

    private static void handleEditTicket() {
        System.out.println("Edit Flight button clicked");
        // Implement edit flight functionality
    }

    private static void handleRemoveTicket() {
        System.out.println("Remove Flight button clicked");
        // Implement remove flight functionality
    }

    private static void handleSearchTicket() {
        System.out.println("Search Flight button clicked");
        // Implement search flight functionality
    }

    private static void handleRefreshTicketList() {
        System.out.println("Refresh List button clicked");
        // Implement refresh list functionality
    }

    // Method to create Airport Management Panel
    private static JPanel createAirportManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255)); // Alice Blue color

        // Create a table to display airport information
        String[] columnNames = {"Airport ID", "Airport Name", "Location", "Capacity"};
        Object[][] data = {}; // Replace with actual airport data

        JTable table = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        panel.add(tableScrollPane, BorderLayout.CENTER);

        // Button panel for airport management
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton addAirportButton = new JButton("Add Airport");
        JButton editAirportButton = new JButton("Edit Airport");
        JButton removeAirportButton = new JButton("Remove Airport");
        JButton searchAirportButton = new JButton("Search Airport");
        JButton refreshAirportButton = new JButton("Refresh List");

        styleButton(addAirportButton);
        styleButton(editAirportButton);
        styleButton(removeAirportButton);
        styleButton(searchAirportButton);
        styleButton(refreshAirportButton);

        buttonPanel.add(addAirportButton);
        buttonPanel.add(editAirportButton);
        buttonPanel.add(removeAirportButton);
        buttonPanel.add(searchAirportButton);
        buttonPanel.add(refreshAirportButton);

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

        // Action listeners for airport buttons
        addAirportButton.addActionListener(e -> handleAddAirport());
        editAirportButton.addActionListener(e -> handleEditAirport());
        removeAirportButton.addActionListener(e -> handleRemoveAirport());
        searchAirportButton.addActionListener(e -> handleSearchAirport());
        refreshAirportButton.addActionListener(e -> handleRefreshAirportList());

        return panel;
    }

    // Event handling methods
    private static void handleAddAirport() {
        System.out.println("Add Flight button clicked");
        // Implement add flight functionality
    }

    private static void handleEditAirport() {
        System.out.println("Edit Flight button clicked");
        // Implement edit flight functionality
    }

    private static void handleRemoveAirport() {
        System.out.println("Remove Flight button clicked");
        // Implement remove flight functionality
    }

    private static void handleSearchAirport() {
        System.out.println("Search Flight button clicked");
        // Implement search flight functionality
    }

    private static void handleRefreshAirportList() {
        System.out.println("Refresh List button clicked");
        // Implement refresh list functionality
    }

}
