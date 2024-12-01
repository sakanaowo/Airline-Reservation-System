package UI.Admin;

import UI.Admin.Plugin.*;
import javax.swing.*;
import java.awt.*;

public class mainFrame {

    public static JPanel mainAdmin(JFrame parentFrame) {
        // Main panel with CardLayout
        JPanel mainPanel = new JPanel(new CardLayout());

        // Vertical Navigation Menu
        JPanel menuPanel = new JPanel(new GridLayout(6, 1));

        // Load the logo image for the button
        ImageIcon logoIcon = new ImageIcon(backupMain.class.getResource("/UI/Icon/airport.jpg"));
        // Resize the image to fit the button (optional)
        Image scaledImage = logoIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Adjust size as needed
        ImageIcon scaledLogoIcon = new ImageIcon(scaledImage);

        // Create the button with the logo icon
        JButton dashboardButton = new JButton(scaledLogoIcon);

        // Set background color to light blue
        dashboardButton.setBackground(new Color(100, 149, 237)); // Light Blue (RGB values)
        dashboardButton.setOpaque(true);
        dashboardButton.setContentAreaFilled(true);
        dashboardButton.setBorderPainted(false);
        dashboardButton.setFocusPainted(false);
        dashboardButton.setToolTipText("Dashboard");

        // Other buttons
        JButton flightsButton = new JButton("Flight Management");
        JButton planesButton = new JButton("Plane Management");
        JButton logoutButton = new JButton("Log Out");
        JButton airportsButton = new JButton("Airport Management");
        // Style buttons
        styleButton(dashboardButton);
        styleButton(flightsButton);
        styleButton(planesButton);
        styleButton(airportsButton);
        styleButton(logoutButton);

        menuPanel.add(dashboardButton);
        menuPanel.add(flightsButton);
        menuPanel.add(planesButton);
        menuPanel.add(airportsButton);
        menuPanel.add(logoutButton);

        // Panels for different sections
        JPanel dashboardPanel = createDashboardPanel();
        JPanel flightsPanel = createFlightsManagementPanel();
        JPanel planesPanel = createPlaneManagementPanel();
        //JPanel ticketsPanel = createTicketManagementPanel();
        JPanel airportsPanel = createAirportManagementPanel();

        mainPanel.add(dashboardPanel, "Dashboard");
        mainPanel.add(flightsPanel, "FlightsManagement");
        mainPanel.add(airportsPanel, "AirportsManagement");
        mainPanel.add(planesPanel, "PlanesManagement");

        // Action Listeners for navigation
        dashboardButton.addActionListener(e -> showPanel(mainPanel, "Dashboard"));
        flightsButton.addActionListener(e -> showPanel(mainPanel, "FlightsManagement"));
        planesButton.addActionListener(e -> showPanel(mainPanel, "PlanesManagement"));
        airportsButton.addActionListener(e -> showPanel(mainPanel, "AirportsManagement"));
        logoutButton.addActionListener(e -> handleLogout(parentFrame));

        // Frame Layout
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(menuPanel, BorderLayout.WEST);
        wrapperPanel.add(mainPanel, BorderLayout.CENTER);

        return wrapperPanel;
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
            System.exit(0);
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

    // Method to create Flights Management Panel
    private static JPanel createFlightsManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        view.viewFlights(panel);
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(240, 248, 255));
        view.viewFlights(centerPanel); // Hiển thị bảng ban đầu

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setPreferredSize(new Dimension(200, 0)); // Set fixed width for button panel

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

        panel.add(buttonPanel, BorderLayout.EAST);

        // Action listeners for buttons
        addFlightButton.addActionListener(e -> handleAddFlight());
        editFlightButton.addActionListener(e -> handleEditFlight());
        removeFlightButton.addActionListener(e -> handleRemoveFlight());
        searchFlightButton.addActionListener(e -> handleSearchFlight());
        refreshButton.addActionListener(e -> refresh.handleRefreshList(panel));

        return panel;
    }

    // Event handling methods
    private static void handleAddFlight() {
        SwingUtilities.invokeLater(() -> {
            addFlight frame = new addFlight();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });

    }

    private static void handleEditFlight() {
        SwingUtilities.invokeLater(() -> {
            editFlight frame = new editFlight();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
    }

    private static void handleRemoveFlight() {
        SwingUtilities.invokeLater(() -> {
            deleteFlight frame = new deleteFlight();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
    }

    private static void handleSearchFlight() {
        SwingUtilities.invokeLater(() -> {
            searchFlight frame = new searchFlight();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
    }

    // Method to create Airport Management Panel
    private static JPanel createAirportManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255)); // Alice Blue color

        view.viewAirports(panel);
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

        panel.add(buttonPanel, BorderLayout.EAST);

        // Action listeners for airport buttons
        addAirportButton.addActionListener(e -> handleAddAirport());
        editAirportButton.addActionListener(e -> handleEditAirport());
        removeAirportButton.addActionListener(e -> handleRemoveAirport());
        searchAirportButton.addActionListener(e -> handleSearchAirport());
        refreshAirportButton.addActionListener(e -> refresh.handleRefreshAirportsList(panel));

        return panel;
    }

    // Event handling methods
    private static void handleAddAirport() {
        SwingUtilities.invokeLater(() -> {
            addAirport frame = new addAirport();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
    }

    private static void handleEditAirport() {
        SwingUtilities.invokeLater(() -> {
            editAirport frame = new editAirport();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
    }

    private static void handleRemoveAirport() {
        SwingUtilities.invokeLater(() -> {
            deleteAirport frame = new deleteAirport();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
    }

    private static void handleSearchAirport() {
        SwingUtilities.invokeLater(() -> {
            searchAirport frame = new searchAirport();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
    }

    private static JPanel createPlaneManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255)); // Alice Blue color

        view.viewPlanes(panel);

        // Button panel for plane management
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton addPlaneButton = new JButton("Add Plane");
        JButton editPlaneButton = new JButton("Edit Plane");
        JButton removePlaneButton = new JButton("Remove Plane");
        JButton searchPlaneButton = new JButton("Search Plane");
        JButton refreshPlaneButton = new JButton("Refresh List");

        styleButton(addPlaneButton);
        styleButton(editPlaneButton);
        styleButton(removePlaneButton);
        styleButton(searchPlaneButton);
        styleButton(refreshPlaneButton);

        buttonPanel.add(addPlaneButton);
        buttonPanel.add(editPlaneButton);
        buttonPanel.add(removePlaneButton);
        buttonPanel.add(searchPlaneButton);
        buttonPanel.add(refreshPlaneButton);

        panel.add(buttonPanel, BorderLayout.EAST);

        // Action listeners for plane buttons
        addPlaneButton.addActionListener(e -> handleAddPlane());
        editPlaneButton.addActionListener(e -> handleEditPlane());
        removePlaneButton.addActionListener(e -> handleRemovePlane());
        searchPlaneButton.addActionListener(e -> handleSearchPlane());
        refreshPlaneButton.addActionListener(e -> refresh.handleRefreshPlaneList(panel));

        return panel;
    }

    private static void handleAddPlane() {
        SwingUtilities.invokeLater(() -> {
            addPlane frame = new addPlane();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
    }

    private static void handleEditPlane() {
        SwingUtilities.invokeLater(() -> {
            editPlane frame = new editPlane();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
    }

    private static void handleRemovePlane() {
        SwingUtilities.invokeLater(() -> {
            deletePlane frame = new deletePlane();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
    }

    private static void handleSearchPlane() {
        SwingUtilities.invokeLater(() -> {
            searchPlane frame = new searchPlane();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        });
    }
    // Khoi tao de goi sau khi login thanh cong de view lai cap nhat
    private static JPanel planesPanel;
    private static JPanel flightsPanel;
    private static JPanel airportsPanel;
    
    public static JPanel getPlanesPanel() {
        if(planesPanel == null){
            planesPanel = createPlaneManagementPanel();
        }
        return planesPanel;
    }

    public static JPanel getFlightsPanel() {
        if(flightsPanel == null){
            flightsPanel = createFlightsManagementPanel();
        }
        return flightsPanel;
    }

    public static JPanel getAirportsPanel() {
        if(airportsPanel == null){
            airportsPanel = createAirportManagementPanel();
        }
        return airportsPanel;
    }
}
