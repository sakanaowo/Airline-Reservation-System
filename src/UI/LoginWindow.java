package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class LoginWindow extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCB;
    private boolean loginIsSuccessful = false;
    private UserManager userManager;

    public LoginWindow() {
        userManager = new UserManager(); // Sử dụng UserManager để quản lý tài khoản
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Login GUI");
        setSize(370, 260);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupWindow();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setupWindow() {
        // Tạo các thành phần giao diện
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(160, 10, 80, 30);
        add(loginLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 54, 80, 24);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(90, 50, 250, 24);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 86, 80, 24);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(90, 82, 250, 24);
        add(passwordField);

        showPasswordCB = new JCheckBox("Show Password");
        showPasswordCB.setBounds(90, 110, 150, 24);
        showPasswordCB.addActionListener(e -> displayPasswordIfChecked(showPasswordCB.isSelected()));
        add(showPasswordCB);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(20, 140, 320, 34);
        loginButton.addActionListener(e -> clickLoginButton());
        add(loginButton);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(120, 180, 100, 24);
        signUpButton.addActionListener(e -> openNewUserDialog());
        add(signUpButton);
    }

    private void clickLoginButton() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (userManager.isValidUser(username, password)) {
            JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loginIsSuccessful = true;
            dispose();
            openMainWindow();
        } else {
            JOptionPane.showMessageDialog(this, "The username or password is incorrect.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void displayPasswordIfChecked(boolean isChecked) {
        passwordField.setEchoChar(isChecked ? (char) 0 : '*');
    }

    private void openMainWindow() {
        new MainWindow();
    }

    private void openNewUserDialog() {
        setVisible(false);
        NewUserDialog newUserDialog = new NewUserDialog(this, userManager);
        newUserDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                setVisible(true);
            }
        });
        newUserDialog.setVisible(true);
    }
}
