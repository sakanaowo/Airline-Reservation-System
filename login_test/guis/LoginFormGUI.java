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
public class LoginFormGUI extends Form {
    
    public LoginFormGUI() {
        super("Login");
        addGUIComponents();
    }
    private void addGUIComponents() {
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(0, 25, 520, 100);
        loginLabel.setForeground(CommandConstants.TEXT_COLOR);
        
        loginLabel.setFont(new Font("DiaLog", Font.BOLD, 40));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);
        
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
        passwordLabel.setBounds(30, 335, 400, 25);
        passwordLabel.setForeground(CommandConstants.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(passwordLabel);
        
        JTextField passwordField = new JPasswordField();
        passwordField.setBounds(30, 365, 450, 55);
        passwordField.setBackground(CommandConstants.SECONDARY_COLOR);
        passwordField.setForeground(CommandConstants.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));
        passwordField.setCaretColor(CommandConstants.TEXT_COLOR);  
        passwordField.getCaret().setBlinkRate(500);
        add(passwordField);
        
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Dialog", Font.BOLD, 18));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBackground(CommandConstants.TEXT_COLOR);
        loginButton.setBounds(125, 520, 250, 50);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                String username = usernameField.getText();

        
                String password = passwordField.getText();

   
                if(MyJDBC.validateLogin(username, password)){
              
                    JOptionPane.showMessageDialog(LoginFormGUI.this,
                            "Login Successful!");
                }else{
            
                    JOptionPane.showMessageDialog(LoginFormGUI.this,
                            "Login Failed...");
                }
            }
        });
        add(loginButton);
        
        JLabel registerLabel = new JLabel("Not a user? Register Here");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setForeground(CommandConstants.TEXT_COLOR);
        
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginFormGUI.this.dispose();
                new RegisterFormGUI().setVisible(true);
            }
        });
        registerLabel.setBounds(125, 600, 250, 30);
        add(registerLabel);
        
    }
    
}
