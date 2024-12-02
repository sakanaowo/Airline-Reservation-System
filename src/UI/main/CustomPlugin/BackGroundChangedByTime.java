package UI.main.CustomPlugin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BackGroundChangedByTime extends JPanel {
    private Image[] images;
    private int currentIndex = 0;

    public BackGroundChangedByTime() {
        images = new Image[]{
                new ImageIcon(getClass().getResource("/UI/Icon/phu-quoc.jpg")).getImage(),
                new ImageIcon(getClass().getResource("/UI/Icon/hcml-1.jpg")).getImage(),
                new ImageIcon(getClass().getResource("/UI/Icon/jp.png")).getImage(),
                new ImageIcon(getClass().getResource("/UI/Icon/russia.jpg")).getImage(),
                new ImageIcon(getClass().getResource("/UI/Icon/paris.jpg")).getImage()
        };
        currentIndex = new Random().nextInt(5);
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex = (currentIndex + 1) % images.length;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);  // Làm mịn ảnh khi phóng to

        g2d.drawImage(images[currentIndex], 0, 0, getWidth(), getHeight(), this);
    }
}
