package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainWindow extends JFrame {
    private JLabel mainLabel;
    private ImageIcon imageIcon;
    private Image originalImage; // Keep the original image

    public MainWindow() {
        setTitle("Main Window");
        setSize(640, 426);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupMainWindow();
        setVisible(true);
    }

    private void setupMainWindow() {
        // Load the image
        imageIcon = new ImageIcon("images/background.png");
        originalImage = imageIcon.getImage(); // Save original image for resizing

        // Create label with the image
        mainLabel = new JLabel(imageIcon);
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setVerticalAlignment(JLabel.CENTER);

        // Add the label to the frame
        add(mainLabel);

        // Add listener for window resize
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeImage();
            }
        });
    }

    private void resizeImage() {
        // lấy kích thước
        int newWidth = getWidth();
        int newHeight = getHeight();

        // căn chỉnh ảnh theo size cửa sổ
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        imageIcon.setImage(scaledImage);

        // Refresh
        mainLabel.repaint();
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}