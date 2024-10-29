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
    JPanel mainPanel = new JPanel();

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

        JPanel navigator = createNavigator();

        mainPanel.setBounds(70, 0, 1050, 700);
        mainPanel.setOpaque(false);

        backgroundPanel.add(navigator);
        backgroundPanel.add(mainPanel);
        add(backgroundPanel);
    }

    private JPanel createNavigator() {
        JPanel navigator = new JPanel();
        navigator.setLayout(new BoxLayout(navigator, BoxLayout.Y_AXIS));
        navigator.setBounds(0, -3, 70, 670);
        navigator.setOpaque(false);
        navigator.setBackground(Color.WHITE);

        ImageIcon home = loadIcon("src/Icon/home.png");
        ImageIcon magnify = loadIcon("src/Icon/magnifying-glass.png");
        ImageIcon ticket = loadIcon("src/Icon/ticket-flight.png");
        ImageIcon calendar = loadIcon("src/Icon/calendar.png");
        ImageIcon notification = loadIcon("src/Icon/notification-bell.png");
        ImageIcon setting = loadIcon("src/Icon/setting.png");
        ImageIcon user = loadIcon("src/Icon/user.png");

        // Create buttons with icons
        JButton button1 = new JButton(home);
        JButton button2 = new JButton(magnify);
        JButton button3 = new JButton(ticket);
        JButton button4 = new JButton(calendar);
        JButton button5 = new JButton(notification);
        JButton button6 = new JButton(setting);
        JButton button7 = new JButton(user);

        // Optionally, add ActionListener to buttons
//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Define action for button1
//            }
//        });

        // Add buttons to navigator panel
        navigator.add(button1);
        navigator.add(button2);
        navigator.add(button3);
        navigator.add(button4);

        // Adding empty labels for spacing
        navigator.add(Box.createRigidArea(new Dimension(0, 90)));
        navigator.add(Box.createRigidArea(new Dimension(0, 90)));

        navigator.add(button5);
        navigator.add(button6);
        navigator.add(button7);

        return navigator;
    }

    // Method to load and scale icons to 65x65
    private ImageIcon loadIcon(String url) {
        if (url.startsWith("http")) {
            try {
                Image img = ImageIO.read(new URL(url));
                if (img != null) {
                    // Scale image to 65x65
                    return new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
                } else {
                    System.out.println("Error: Image could not be loaded.");
                    return null;
                }
            } catch (IOException e) {
                System.out.println("Error loading icon: " + e.getMessage());
                return null;
            }
        } else {
            ImageIcon icon = new ImageIcon(url);
            Image img = icon.getImage();
            return new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        }
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
