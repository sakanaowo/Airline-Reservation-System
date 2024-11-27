package UI.main.CustomPlugin;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image img;

    public ImagePanel(String imagePath) {
        setImage(imagePath);
    }

    public ImagePanel(Image img) {
        this.img = img;
    }

    public void setImage(Image img) {
        this.img = img;
        repaint();
    }

    public void setImage(String imagePath) {
        if (imagePath == null) {
            System.err.println("Image path cannot be null.");
            return;
        }
        try {
            this.img = new ImageIcon(getClass().getResource(imagePath)).getImage();
        } catch (Exception e) {
            System.err.println("Error loading image: " + imagePath);
            e.printStackTrace();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            Graphics2D g2d = (Graphics2D) g;

            // Rendering hints for better quality
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw the image resized to panel dimensions
            g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
