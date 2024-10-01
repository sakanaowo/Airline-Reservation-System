package UI;

import javax.swing.*;
import java.awt.*;

public class NewUserDialog extends JDialog {
    private JTextField nameField;
    private JTextField fullNameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private UserManager userManager;

    public NewUserDialog(Frame parent, UserManager userManager) {
        super(parent, "Registration", true);
        this.userManager = userManager;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(null);  // Sử dụng layout tuyệt đối (null layout)
        setSize(360, 400);  // Chỉnh lại kích thước cửa sổ
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel titleLabel = new JLabel("Create New Account");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(90, 20, 200, 30);  // Đặt vị trí phù hợp
        add(titleLabel);

        // Hình ảnh đại diện người dùng
        JLabel userImageLabel = new JLabel();
        userImageLabel.setBounds(150, 60, 60, 60);  // Kích thước phù hợp cho hình ảnh
        ImageIcon userIcon = new ImageIcon("images/new_user_icon.png");
        userImageLabel.setIcon(userIcon);
        add(userImageLabel);

        // Thêm các thành phần giao diện
        JLabel nameLabel = new JLabel("Username:");
        nameLabel.setBounds(20, 144, 80, 24);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 144, 200, 24);
        add(nameField);

        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameLabel.setBounds(20, 174, 80, 24);
        add(fullNameLabel);

        fullNameField = new JTextField();
        fullNameField.setBounds(120, 174, 200, 24);
        add(fullNameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 204, 80, 24);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 204, 200, 24);
        add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm:");
        confirmPasswordLabel.setBounds(20, 234, 80, 24);
        add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(120, 234, 200, 24);
        add(confirmPasswordField);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(20, 280, 300, 32);
        signUpButton.addActionListener(e -> confirmSignUp());
        add(signUpButton);
    }

    private void confirmSignUp() {
        String username = nameField.getText();
        String fullName = fullNameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            userManager.addUser(username, password);
            JOptionPane.showMessageDialog(this, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }
}
