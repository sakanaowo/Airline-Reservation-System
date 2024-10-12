package UI;
import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        // Khởi tạo JFrame (cửa sổ chính)
        JFrame frame = new JFrame("Frame with Image and Dock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Kích thước cửa sổ

        // Sử dụng GridLayout với 2 hàng và 1 cột
        frame.setLayout(new GridLayout(2, 1));

        // 1. Phần ảnh chiếm 2/3 khung hình
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());
        JLabel imageLabel = new JLabel();

        // Đặt ảnh vào JLabel (ở đây sử dụng ảnh từ file)
        ImageIcon imageIcon = new ImageIcon("path_to_your_image.jpg"); // Thay bằng đường dẫn đến ảnh của bạn
        Image image = imageIcon.getImage(); // Lấy đối tượng ảnh
        Image scaledImage = image.getScaledInstance(800, 400, Image.SCALE_SMOOTH); // Điều chỉnh kích thước ảnh
        imageLabel.setIcon(new ImageIcon(scaledImage));

        // Thêm JLabel chứa ảnh vào JPanel
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        // 2. Phần dock chiếm 1/3 khung hình
        JPanel dockPanel = new JPanel();
        dockPanel.setLayout(new BorderLayout());

        // Tạo JTabbedPane (dock) với các tab
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Flight", createFlightPanel());
        tabbedPane.addTab("Hotel", createHotelPanel());
        tabbedPane.addTab("Rent a Car", createCarPanel());

        // Thêm dock vào JPanel dưới
        dockPanel.add(tabbedPane, BorderLayout.CENTER);

        // Thêm các phần panel vào frame với GridLayout
        frame.add(imagePanel);  // 2/3 frame
        frame.add(dockPanel);   // 1/3 frame

        // Hiển thị JFrame
        frame.setVisible(true);
    }

    // Tạo JPanel cho tab "Flight"
    private static JPanel createFlightPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10)); // Lưới với 3 hàng và 2 cột
        panel.add(new JLabel("From:"));
        panel.add(new JTextField(10)); // TextField cho nơi đi
        panel.add(new JLabel("To:"));
        panel.add(new JTextField(10)); // TextField cho nơi đến
        panel.add(new JLabel("Departure Date:"));
        panel.add(new JTextField(10)); // TextField cho ngày khởi hành

        return panel;
    }

    // Tạo JPanel cho tab "Hotel"
    private static JPanel createHotelPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10)); // Lưới với 2 hàng và 2 cột
        panel.add(new JLabel("Location:"));
        panel.add(new JTextField(10)); // TextField cho địa điểm khách sạn
        panel.add(new JLabel("Check-in Date:"));
        panel.add(new JTextField(10)); // TextField cho ngày check-in

        return panel;
    }

    // Tạo JPanel cho tab "Rent a Car"
    private static JPanel createCarPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10)); // Lưới với 2 hàng và 2 cột
        panel.add(new JLabel("Pick-up Location:"));
        panel.add(new JTextField(10)); // TextField cho nơi lấy xe
        panel.add(new JLabel("Pick-up Date:"));
        panel.add(new JTextField(10)); // TextField cho ngày lấy xe

        return panel;
    }
}
