package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class MainWindow extends JFrame {
    private JPanel altPanel;
    private CardLayout cardLayout;

    public MainWindow() {
        setTitle("Main Window");
        setSize(1120, 700);
        setResizable(false); // Fixed size
        setLocationRelativeTo(null); // Center window on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupMainWindow();
        setVisible(true);
    }

    private void setupMainWindow() {
        // Background panel
        String imageURL = "https://i.imgur.com/6ShCP5E.png";
        BackgroundPanel backgroundPanel = new BackgroundPanel(imageURL);
        backgroundPanel.setLayout(null); // Use null layout to set fixed positions

        // Option panel for buttons
        JPanel optionPanel = createOptionPanel();

        // Alternate panel to display different contents
        altPanel = createAltPanel();

        backgroundPanel.add(optionPanel);
        backgroundPanel.add(altPanel);
        add(backgroundPanel);
    }

    // Method to create the altPanel with CardLayout
    private JPanel createAltPanel() {
        cardLayout = new CardLayout();
        JPanel altPanel = new JPanel(cardLayout);  // Use CardLayout for altPanel
        altPanel.setBounds(110, 150, 900, 450);
        altPanel.setBackground(Color.WHITE);

        // Add different panels to the CardLayout
        JPanel bookingPanel = createContentPanel("Đặt vé content", Color.LIGHT_GRAY);
        JPanel manageReservationPanel = createContentPanel("Quản lý đặt chỗ content", Color.PINK);
        JPanel userInfoPanel = createContentPanel("Thông tin cá nhân content", Color.CYAN);

        altPanel.add(bookingPanel, "booking");
        altPanel.add(manageReservationPanel, "manage_reservation");
        altPanel.add(userInfoPanel, "user_info");

        return altPanel;
    }

    // Helper method to create content panels
    private JPanel createContentPanel(String text, Color bgColor) {
        JPanel panel = new JPanel();
        panel.setBackground(bgColor);
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label);
        return panel;
    }

    private JPanel createOptionPanel() {
        JPanel optionPanel = new JPanel();
        optionPanel.setOpaque(false);
        optionPanel.setLayout(new GridLayout(1, 3, 10, 0));
        optionPanel.setBounds(110, 70, 900, 50);

        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        // Create buttons
        JButton booking = new JButton("Đặt vé");
        JButton manage_reservation = new JButton("Quản lý đặt chỗ");
        JButton user_info = new JButton("Thông tin cá nhân");

        booking.setFont(buttonFont);
        manage_reservation.setFont(buttonFont);
        user_info.setFont(buttonFont);

        // Add ActionListeners to change altPanel content
        booking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(altPanel, "booking");
            }
        });

        manage_reservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(altPanel, "manage_reservation");
            }
        });

        user_info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(altPanel, "user_info");
            }
        });

        // Add buttons to the panel
        optionPanel.add(booking);
        optionPanel.add(manage_reservation);
        optionPanel.add(user_info);

        return optionPanel;
    }

    public static void main(String[] args) {
        new MainWindow();
    }

    // Class to paint background image from URL
    private class BackgroundPanel extends JPanel {
        private BufferedImage image;

        public BackgroundPanel(String imageURL) {
            try {
                URL url = new URL(imageURL);
                image = ImageIO.read(url);
            } catch (IOException e) {
                System.out.println("Error loading image: " + e.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
