package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class MainWindow extends JFrame {
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

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null); // Use null layout for positioning
        mainPanel.setBounds(100, 300, 900, 260); // Set position and size of the tabbed pane panel

        // JTabbedPane setup
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0, 0, 900, 260); // Set size and position for the tabbed pane

        // Flight panel
        JPanel FlightPanel = new JPanel();
        FlightPanel.add(new JLabel("Flight panel"));
        FlightPanel.add(new JButton("Flight"));

        // Test panel
        JPanel testPanel = new JPanel();
        testPanel.add(new JLabel("Test panel"));
        testPanel.add(new JButton("Test"));

        // Add tabs to JTabbedPane
        tabbedPane.add("Flight", FlightPanel);
        tabbedPane.add("Test", testPanel);

        // Add JTabbedPane directly to mainPanel
        mainPanel.add(tabbedPane);

        // Add mainPanel to backgroundPanel
        backgroundPanel.add(mainPanel);

        // Add backgroundPanel to JFrame
        add(backgroundPanel);
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
