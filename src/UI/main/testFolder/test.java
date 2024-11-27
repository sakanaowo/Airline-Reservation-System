package UI.main.testFolder;

import javax.swing.*;
import java.awt.*;

public class test extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Chuyển Graphics thành Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // Thiết lập nét đứt
        float[] dashPattern = {10, 10}; // Mẫu nét đứt: 10 pixel vẽ, 10 pixel trống
        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, dashPattern, 0));

        // Vẽ đường nét đứt
        g2d.drawLine(50, 50, 250, 50); // Đường từ tọa độ (50, 50) đến (250, 50)
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Nét Đứt trong Swing");
        test panel = new test();
        frame.add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
