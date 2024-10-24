/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login_test.guis;

import constants.CommandConstants;
import db.MyJDBC;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

/**
 *
 * @author DELL
 */
public class RegisterFormGUI extends Form {
    public RegisterFormGUI() {
        super("Register");
        addGUIComponents();
    }
    private void addGUIComponents() {
        JLabel registerLabel = new JLabel("Register");
        registerLabel.setBounds(0, 25, 520, 100);
        registerLabel.setForeground(CommandConstants.TEXT_COLOR);
        
        registerLabel.setFont(new Font("DiaLog", Font.BOLD, 40));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(registerLabel);
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 150, 400, 25);
        usernameLabel.setForeground(CommandConstants.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(usernameLabel);
        
        JTextField usernameField = new JTextField();
        usernameField.setBounds(30, 185, 450, 55);
        usernameField.setBackground(CommandConstants.SECONDARY_COLOR);
        usernameField.setForeground(CommandConstants.TEXT_COLOR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 24));
        usernameField.setCaretColor(CommandConstants.TEXT_COLOR); 
        usernameField.getCaret().setBlinkRate(500);
        add(usernameField);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 255, 400, 25);
        passwordLabel.setForeground(CommandConstants.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(passwordLabel);
        
        JTextField passwordField = new JPasswordField();
        passwordField.setBounds(30, 290, 450, 55);
        passwordField.setBackground(CommandConstants.SECONDARY_COLOR);
        passwordField.setForeground(CommandConstants.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));
        passwordField.setCaretColor(CommandConstants.TEXT_COLOR);  
        passwordField.getCaret().setBlinkRate(500);
        add(passwordField);
        
        JLabel rePasswordLabel = new JLabel("Re-enter Password:");
        rePasswordLabel.setBounds(30, 360, 400, 25);
        rePasswordLabel.setForeground(CommandConstants.TEXT_COLOR);
        rePasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(rePasswordLabel);
        
        JTextField rePasswordField = new JPasswordField();
        rePasswordField.setBounds(30, 395, 450, 55);
        rePasswordField.setBackground(CommandConstants.SECONDARY_COLOR);
        rePasswordField.setForeground(CommandConstants.TEXT_COLOR);
        rePasswordField.setFont(new Font("Dialog", Font.PLAIN, 24));
        rePasswordField.setCaretColor(CommandConstants.TEXT_COLOR); 
        rePasswordField.getCaret().setBlinkRate(500);
        add(rePasswordField);
        
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Dialog", Font.BOLD, 18));
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBackground(CommandConstants.TEXT_COLOR);
        registerButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                String rePassword = rePasswordField.getText();
                
                if (validateUserInput(username, password, rePassword)) {
                    if (MyJDBC.register(username, password)) {
                        RegisterFormGUI.this.dispose();
                        LoginFormGUI loginFormGUI = new LoginFormGUI();
                        loginFormGUI.setVisible(true);
                        
                        JOptionPane.showMessageDialog(loginFormGUI, 
                                "Registered Account Successfully!");
                    } else {
                        JOptionPane.showMessageDialog(RegisterFormGUI.this, 
                                "Error: Username already taken");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(RegisterFormGUI.this, 
                                "Error: Username must be at least 6 characters \n" +
                                    "and/or Passwords must match");
                }
            }
        });
        registerButton.setBounds(125, 520, 250, 50);
        add(registerButton);
        
        JLabel loginLabel = new JLabel("Have an account? Login Here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.setForeground(CommandConstants.TEXT_COLOR);
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterFormGUI.this.dispose();
                new LoginFormGUI().setVisible(true);
            }
        });
        loginLabel.setBounds(125, 600, 250, 30);
        add(loginLabel);
        
    }
    
    private boolean validateUserInput(String username, String password, String rePassword){
        if(username.length() == 0 || password.length() == 0 || rePassword.length() == 0) return false;

        if(username.length() < 6) return false;

        if(!password.equals(rePassword)) return false;

        return true;
    }
}
