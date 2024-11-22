package admininterface;

import javax.swing.*;
import java.awt.*;

public class AdminInterface {
    // Method to switch panels based on button click
    public static void showPanel(JPanel mainPanel, String panelName) {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, panelName);
    }

    // Method to handle log out confirmation
    public static void handleLogout(JFrame frame) {
        int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0); // Exit the application
        }
    }

    // Method to style buttons
    public static void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(70, 130, 180)); // Steel Blue color
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(200, 50));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

    // Method to create Dashboard Panel
    public static JPanel createDashboardPanel() {
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
}
