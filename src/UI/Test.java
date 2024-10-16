package UI;
import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Multi Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Sử dụng BorderLayout cho JFrame chính
        frame.setLayout(new BorderLayout());

        // Tạo JPanel trên cùng với FlowLayout
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Welcome to the Multi Layout Example"));

        // Tạo JPanel giữa với GridLayout
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        centerPanel.add(new JButton("Button 1"));
        centerPanel.add(new JButton("Button 2"));
        centerPanel.add(new JButton("Button 3"));
        centerPanel.add(new JButton("Button 4"));

        // Tạo JPanel dưới cùng với BoxLayout
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(new JLabel("Footer Section"));
        bottomPanel.add(Box.createVerticalStrut(10)); // Tạo khoảng cách giữa các thành phần
        bottomPanel.add(new JButton("Submit"));

        // Thêm các JPanel vào JFrame chính
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
