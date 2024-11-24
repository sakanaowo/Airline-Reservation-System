package admininterface;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin Interface - Airline System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 750);

        // Main panel with CardLayout
        JPanel mainPanel = new JPanel(new CardLayout());

        // Vertical Navigation Menu
        JPanel menuPanel = new JPanel(new GridLayout(8, 1)); // Increased to 8 rows

        // Load the logo image for the button
        ImageIcon logoIcon = new ImageIcon(MainFrame.class.getResource("/airport.jpg"));

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
        JButton planesButton = new JButton("Plane Management"); // New button for planes
        JButton seatsButton = new JButton("Seat Management"); // New button for seats
        JButton usersButton = new JButton("User Management");
        JButton ticketsButton = new JButton("Ticket Management");
        JButton airportsButton = new JButton("Airport Management");
        JButton logoutButton = new JButton("Log Out");

        // Style buttons
        AdminInterface.styleButton(dashboardButton);
        AdminInterface.styleButton(flightsButton);
        AdminInterface.styleButton(planesButton);
        AdminInterface.styleButton(seatsButton);
        AdminInterface.styleButton(usersButton);
        AdminInterface.styleButton(ticketsButton);
        AdminInterface.styleButton(airportsButton);
        AdminInterface.styleButton(logoutButton);

        menuPanel.add(dashboardButton);
        menuPanel.add(flightsButton);
        menuPanel.add(planesButton); // Add to menu
        menuPanel.add(seatsButton); // Add to menu
        menuPanel.add(usersButton);
        menuPanel.add(ticketsButton);
        menuPanel.add(airportsButton);
        menuPanel.add(logoutButton);

        // Panels for different sections
        JPanel dashboardPanel = AdminInterface.createDashboardPanel();
        JPanel flightsPanel = FlightsManagementPanel.createFlightsManagementPanel();
        JPanel planesPanel = PlaneManagementPanel.createPlanesManagementPanel(); // New panel for planes
        JPanel seatsPanel = SeatsManagementPanel.createSeatsManagementPanel(); // New panel for seats
        JPanel usersPanel = UsersManagementPanel.createUserManagementPanel();
        JPanel ticketsPanel = TicketsManagementPanel.createTicketManagementPanel();
        JPanel airportsPanel = AirportsManagementPanel.createAirportManagementPanel();

        mainPanel.add(dashboardPanel, "Dashboard");
        mainPanel.add(flightsPanel, "FlightsManagement");
        mainPanel.add(planesPanel, "PlanesManagement"); // Add to main panel
        mainPanel.add(seatsPanel, "SeatsManagement"); // Add to main panel
        mainPanel.add(usersPanel, "UsersManagement");
        mainPanel.add(ticketsPanel, "TicketsManagement");
        mainPanel.add(airportsPanel, "AirportsManagement");

        // Action Listeners for navigation
        dashboardButton.addActionListener(e -> AdminInterface.showPanel(mainPanel, "Dashboard"));
        flightsButton.addActionListener(e -> AdminInterface.showPanel(mainPanel, "FlightsManagement"));
        planesButton.addActionListener(e -> AdminInterface.showPanel(mainPanel, "PlanesManagement")); // Action for planes
        seatsButton.addActionListener(e -> AdminInterface.showPanel(mainPanel, "SeatsManagement")); // Action for seats
        usersButton.addActionListener(e -> AdminInterface.showPanel(mainPanel, "UsersManagement"));
        ticketsButton.addActionListener(e -> AdminInterface.showPanel(mainPanel, "TicketsManagement"));
        airportsButton.addActionListener(e -> AdminInterface.showPanel(mainPanel, "AirportsManagement"));
        logoutButton.addActionListener(e -> AdminInterface.handleLogout(frame));

        // Frame Layout
        frame.setLayout(new BorderLayout());
        frame.add(menuPanel, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
