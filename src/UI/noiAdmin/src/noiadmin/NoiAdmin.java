package noiadmin;

import noiadmin.Plugin.insertFlight;
import noiadmin.Plugin.editFlight;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import noiadmin.API.Flights;
import noiadmin.Plugin.*;

public class NoiAdmin {

    public static void viewFlights(JPanel panel) {
        // Xóa tất cả các thành phần hiện có trong panel để tránh chồng lặp
        panel.removeAll();

        // Định nghĩa tên cột cho bảng
        String[] columnNames = {"Flight ID", "Departure time", "Arrival time", "Plane ID", "Departure airport", "Arrival airport", "Departure city", "Arrival city"};

        // Lấy dữ liệu chuyến bay từ phương thức viewFlight của lớp Flights
        ArrayList<ArrayList<Object>> flightData = Flights.viewFlight("", "", "", "", "");

        // Tạo DefaultTableModel để quản lý dữ liệu bảng
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Thêm dữ liệu vào model
        for (ArrayList<Object> flight : flightData) {
            model.addRow(flight.toArray());
        }

        // Tạo JTable từ model
        JTable table = new JTable(model);

        // Thêm JTable vào JScrollPane
        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Thêm JScrollPane chứa bảng vào panel
        panel.setLayout(new BorderLayout());
        panel.add(tableScrollPane, BorderLayout.CENTER);

        // Làm mới giao diện sau khi thêm bảng mới vào panel
        panel.revalidate();
        panel.repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin Interface - Airline System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 750);

        // Main panel with CardLayout
        JPanel mainPanel = new JPanel(new CardLayout());

        // Vertical Navigation Menu
        JPanel menuPanel = new JPanel(new GridLayout(6, 1));

        // Load the logo image for the button
        ImageIcon logoIcon = new ImageIcon(NoiAdmin.class.getResource("Icon\\airport.jpg"));
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
        JButton logoutButton = new JButton("Log Out");
        JButton airportsButton = new JButton("Airport Management");
        // Style buttons
        styleButton(dashboardButton);
        styleButton(flightsButton);
        //styleButton(usersButton);
        styleButton(airportsButton);
        styleButton(logoutButton);

        menuPanel.add(dashboardButton);
        menuPanel.add(flightsButton);
        //menuPanel.add(usersButton);
        menuPanel.add(airportsButton);
        menuPanel.add(logoutButton);

        // Panels for different sections
        JPanel dashboardPanel = createDashboardPanel();
        JPanel flightsPanel = createFlightsManagementPanel();
        //JPanel usersPanel = createUserManagementPanel();
        //JPanel ticketsPanel = createTicketManagementPanel();
        JPanel airportsPanel = createAirportManagementPanel();

        mainPanel.add(dashboardPanel, "Dashboard");
        mainPanel.add(flightsPanel, "FlightsManagement");
        mainPanel.add(airportsPanel, "AirportsManagement");

        // Action Listeners for navigation
        dashboardButton.addActionListener(e -> showPanel(mainPanel, "Dashboard"));
        flightsButton.addActionListener(e -> showPanel(mainPanel, "FlightsManagement"));
        //usersButton.addActionListener(e -> showPanel(mainPanel, "UsersManagement"));
        airportsButton.addActionListener(e -> showPanel(mainPanel, "AirportsManagement"));
        logoutButton.addActionListener(e -> handleLogout(frame));

        // Frame Layout
        frame.setLayout(new BorderLayout());
        frame.add(menuPanel, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
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

    // Method to create Flights Management Panel
    private static JPanel createFlightsManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255)); // Alice Blue color

        viewFlights(panel);
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(240, 248, 255));
        viewFlights(centerPanel); // Hiển thị bảng ban đầu

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

        // Text Area for flight details
        /*JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane textAreaScrollPane = new JScrollPane(textArea);
        textAreaScrollPane.setBorder(BorderFactory.createTitledBorder("Details"));

        panel.add(textAreaScrollPane, BorderLayout.SOUTH);
        textAreaScrollPane.setPreferredSize(new Dimension(600, 200));
         */
        panel.add(buttonPanel, BorderLayout.EAST);

        // Action listeners for buttons
        addFlightButton.addActionListener(e -> handleAddFlight());
        editFlightButton.addActionListener(e -> handleEditFlight());
        removeFlightButton.addActionListener(e -> handleRemoveFlight());
        searchFlightButton.addActionListener(e -> handleSearchFlight());
        refreshButton.addActionListener(e -> handleRefreshList(panel));

        return panel;
    }

    // Event handling methods
    private static void handleAddFlight() {
        SwingUtilities.invokeLater(() -> {
            insertFlight frame = new insertFlight();
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

    private static void handleRefreshList(JPanel flightsPanel) {
        try {
            // Lấy JScrollPane chứa bảng từ panel
            JScrollPane scrollPane = (JScrollPane) flightsPanel.getComponent(0); // Giả định JScrollPane nằm ở vị trí đầu tiên
            JTable table = (JTable) scrollPane.getViewport().getView();

            // Lấy DefaultTableModel của bảng
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Xóa tất cả dữ liệu cũ trong model
            model.setRowCount(0);

            // Lấy dữ liệu chuyến bay mới từ lớp Flights
            ArrayList<ArrayList<Object>> flightData = Flights.viewFlight("", "", "", "", "");

            // Thêm dữ liệu mới vào model
            for (ArrayList<Object> flight : flightData) {
                model.addRow(flight.toArray());
            }

            // Làm mới bảng
            flightsPanel.revalidate();
            flightsPanel.repaint();
        } catch (Exception e) {
            // Xử lý trường hợp không tìm thấy bảng hoặc lỗi bất ngờ
            System.err.println("Cannot refresh list: " + e.getMessage());
        }
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
