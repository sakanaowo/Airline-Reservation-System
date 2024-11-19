/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import System.AirlineSystem;
import java.sql.SQLException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * @author ADMIN
 */


public class Login extends javax.swing.JFrame {
    private AirlineSystem manager = new AirlineSystem();

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        Login = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        BrandName = new javax.swing.JLabel();
        CopyRight = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        LoginLabel = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        EmailField = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        SignUpButtons = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        ForgotButton = new javax.swing.JButton();
        ShowPWD = new javax.swing.JCheckBox();
        SignUp = new javax.swing.JPanel();
        Left2 = new javax.swing.JPanel();
        BrandName2 = new javax.swing.JLabel();
        CopyRight2 = new javax.swing.JLabel();
        logo1 = new javax.swing.JLabel();
        Right1 = new javax.swing.JPanel();
        SignUpLabel = new javax.swing.JLabel();
        Fullname = new javax.swing.JLabel();
        signupUsername = new javax.swing.JTextField();
        signupEmail = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        signupPassword = new javax.swing.JPasswordField();
        SignUpButton = new javax.swing.JButton();
        quitSignUp = new javax.swing.JButton();
        confirmLabel = new javax.swing.JLabel();
        confirmPasswordField = new javax.swing.JPasswordField();
        ForgotPassword = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("I've an account");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        Login.setBackground(new java.awt.Color(255, 255, 255));
        Login.setPreferredSize(new java.awt.Dimension(900, 500));
        Login.setLayout(null);

        Left.setBackground(new java.awt.Color(204, 0, 0));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        BrandName.setFont(new java.awt.Font("Showcard Gothic", 3, 36)); // NOI18N
        BrandName.setForeground(new java.awt.Color(255, 255, 255));
        BrandName.setText("CLC04 Airlines");

        CopyRight.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        CopyRight.setForeground(new java.awt.Color(255, 255, 255));
        CopyRight.setText("copyright (c) CLC04 AIRLINES All rights reversed");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icon/logo.png"))); // NOI18N

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CopyRight)
                    .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(93, 93, 93))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                            .addComponent(BrandName, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(69, 69, 69)))))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(BrandName)
                .addGap(91, 91, 91)
                .addComponent(CopyRight)
                .addGap(106, 106, 106))
        );

        Login.add(Left);
        Left.setBounds(0, 0, 450, 500);

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        LoginLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LoginLabel.setForeground(new java.awt.Color(204, 0, 0));
        LoginLabel.setText("LOGIN");

        UsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        UsernameLabel.setText("Username");

        EmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailFieldActionPerformed(evt);
            }
        });

        PasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PasswordLabel.setText("Password");

        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });

        SignUpButtons.setBackground(new java.awt.Color(204, 204, 204));
        SignUpButtons.setText("Sign Up");
        SignUpButtons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonsActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("I don't have a acccount");

        LoginButton.setBackground(new java.awt.Color(0, 204, 255));
        LoginButton.setForeground(new java.awt.Color(204, 0, 0));
        LoginButton.setText("Login");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        ForgotButton.setBackground(new java.awt.Color(204, 0, 0));
        ForgotButton.setForeground(new java.awt.Color(255, 255, 255));
        ForgotButton.setText("Forgot Password");
        ForgotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgotButtonActionPerformed(evt);
            }
        });

        ShowPWD.setBackground(new java.awt.Color(255, 255, 255));
        ShowPWD.setText("Show password");
        ShowPWD.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ShowPWDStateChanged(evt);
            }
        });
        ShowPWD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPWDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(LoginLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                            .addComponent(LoginButton)
                            .addGap(90, 90, 90)
                            .addComponent(ForgotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(PasswordLabel)
                        .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SignUpButtons)))
                        .addComponent(UsernameLabel))
                    .addComponent(ShowPWD, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(LoginLabel)
                .addGap(19, 19, 19)
                .addComponent(UsernameLabel)
                .addGap(18, 18, 18)
                .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PasswordLabel)
                .addGap(18, 18, 18)
                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(ShowPWD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ForgotButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LoginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(SignUpButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        Login.add(Right);
        Right.setBounds(450, 0, 450, 500);

        getContentPane().add(Login, "login");

        SignUp.setBackground(new java.awt.Color(255, 255, 255));
        SignUp.setPreferredSize(new java.awt.Dimension(900, 500));
        SignUp.setLayout(null);

        Left2.setBackground(new java.awt.Color(204, 0, 0));
        Left2.setPreferredSize(new java.awt.Dimension(400, 500));

        BrandName2.setFont(new java.awt.Font("Showcard Gothic", 3, 36)); // NOI18N
        BrandName2.setForeground(new java.awt.Color(255, 255, 255));
        BrandName2.setText("CLC04 Airlines");

        CopyRight2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        CopyRight2.setForeground(new java.awt.Color(255, 255, 255));
        CopyRight2.setText("copyright (c) CLC04 AIRLINES All rights reversed");

        logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icon/logo.png"))); // NOI18N

        javax.swing.GroupLayout Left2Layout = new javax.swing.GroupLayout(Left2);
        Left2.setLayout(Left2Layout);
        Left2Layout.setHorizontalGroup(
            Left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Left2Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addGroup(Left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CopyRight2)
                    .addGroup(Left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Left2Layout.createSequentialGroup()
                            .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(93, 93, 93))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Left2Layout.createSequentialGroup()
                            .addComponent(BrandName2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(69, 69, 69)))))
        );
        Left2Layout.setVerticalGroup(
            Left2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Left2Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(BrandName2)
                .addGap(91, 91, 91)
                .addComponent(CopyRight2)
                .addGap(106, 106, 106))
        );

        SignUp.add(Left2);
        Left2.setBounds(0, 0, 450, 500);

        Right1.setBackground(new java.awt.Color(255, 255, 255));

        SignUpLabel.setBackground(new java.awt.Color(255, 255, 255));
        SignUpLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        SignUpLabel.setForeground(new java.awt.Color(204, 0, 0));
        SignUpLabel.setText("SIGN UP");

        Fullname.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Fullname.setText("Email");

        signupUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupUsernameActionPerformed(evt);
            }
        });

        signupEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupEmailActionPerformed(evt);
            }
        });

        Email.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Email.setText("Username");

        Password.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Password.setText("Password");

        SignUpButton.setBackground(new java.awt.Color(204, 0, 0));
        SignUpButton.setForeground(new java.awt.Color(255, 255, 255));
        SignUpButton.setText("Sign Up");
        SignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonActionPerformed(evt);
            }
        });

        quitSignUp.setBackground(new java.awt.Color(204, 204, 204));
        quitSignUp.setText("Quit");
        quitSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitSignUpActionPerformed(evt);
            }
        });

        confirmLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        confirmLabel.setText("Confirm Password");

        javax.swing.GroupLayout Right1Layout = new javax.swing.GroupLayout(Right1);
        Right1.setLayout(Right1Layout);
        Right1Layout.setHorizontalGroup(
            Right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Right1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SignUpLabel)
                .addGap(151, 151, 151))
            .addGroup(Right1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(Right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Right1Layout.createSequentialGroup()
                        .addGroup(Right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fullname)
                            .addComponent(signupEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Email)
                            .addComponent(signupUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Password)
                            .addComponent(signupPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(82, Short.MAX_VALUE))
                    .addGroup(Right1Layout.createSequentialGroup()
                        .addComponent(SignUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quitSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(Right1Layout.createSequentialGroup()
                        .addGroup(Right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmLabel))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        Right1Layout.setVerticalGroup(
            Right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Right1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(SignUpLabel)
                .addGap(18, 18, 18)
                .addComponent(Fullname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signupEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(Email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signupUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Password)
                .addGap(18, 18, 18)
                .addComponent(signupPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(Right1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quitSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SignUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        SignUp.add(Right1);
        Right1.setBounds(450, 0, 460, 500);

        getContentPane().add(SignUp, "signup");

        ForgotPassword.setPreferredSize(new java.awt.Dimension(90, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("QUÊN MẬT KHẨU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setText("Nhập Username:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setText("Nhập Email đã đăng kí:");

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jButton1.setText("Xác nhận");

        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jButton2.setText("Hủy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jButton1)
                        .addGap(141, 141, 141)
                        .addComponent(jButton2)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ForgotPasswordLayout = new javax.swing.GroupLayout(ForgotPassword);
        ForgotPassword.setLayout(ForgotPasswordLayout);
        ForgotPasswordLayout.setHorizontalGroup(
            ForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ForgotPasswordLayout.setVerticalGroup(
            ForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(ForgotPassword, "forgotpassword");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailFieldActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void SignUpButtonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButtonsActionPerformed
        showPanel("signup");
    }//GEN-LAST:event_SignUpButtonsActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        String username = EmailField.getText();
        String password = new String(PasswordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống thông tin!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                if (manager.userManager.isValidUser(username, password)) {
                    new Login().dispose();
                    Menu MenuFrame = new Menu();
                    MenuFrame.setVisible(true);
                    MenuFrame.pack();
                    MenuFrame.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void signupUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signupUsernameActionPerformed

    private void signupEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signupEmailActionPerformed

    private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButtonActionPerformed

        String email = signupEmail.getText();
        String username = signupUsername.getText();
        String password = new String(signupPassword.getPassword());
        String confirm = new String(confirmPasswordField.getPassword());


        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống thông tin!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        } else if (!password.equals(confirm)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không khớp!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                if (manager.userManager.IfExists(username)) {
                    JOptionPane.showMessageDialog(null, "Email đã tồn tại", "Lỗi!", JOptionPane.ERROR_MESSAGE);

                } else {
                    manager.userManager.addUser(username, password, email);
                    JOptionPane.showMessageDialog(null, "Đăng kí thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    signupUsername.setText("");
                    signupPassword.setText("");
                    signupEmail.setText("");
                    showPanel("login");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_SignUpButtonActionPerformed

    private void quitSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitSignUpActionPerformed
        showPanel("login");
    }//GEN-LAST:event_quitSignUpActionPerformed

    private void ForgotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForgotButtonActionPerformed
        showPanel("forgotpassword");
    }//GEN-LAST:event_ForgotButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        showPanel("login");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ShowPWDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPWDActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_ShowPWDActionPerformed

    private void ShowPWDStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ShowPWDStateChanged
        // TODO add your handling code here:
        if (ShowPWD.isSelected()) {
            PasswordField.setEchoChar((char) 0);
        } else {
            PasswordField.setEchoChar('*');
        }
    }//GEN-LAST:event_ShowPWDStateChanged


    private void showPanel(String panelName) {
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.show(getContentPane(), panelName);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login l = new Login();
                l.setVisible(true);
                l.pack();
                l.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BrandName;
    private javax.swing.JLabel BrandName2;
    private javax.swing.JLabel CopyRight;
    private javax.swing.JLabel CopyRight2;
    private javax.swing.JLabel Email;
    private javax.swing.JTextField EmailField;
    private javax.swing.JButton ForgotButton;
    private javax.swing.JPanel ForgotPassword;
    private javax.swing.JLabel Fullname;
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Left2;
    private javax.swing.JPanel Login;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JLabel Password;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPanel Right;
    private javax.swing.JPanel Right1;
    private javax.swing.JCheckBox ShowPWD;
    private javax.swing.JPanel SignUp;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JButton SignUpButtons;
    private javax.swing.JLabel SignUpLabel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JLabel confirmLabel;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logo1;
    private javax.swing.JButton quitSignUp;
    private javax.swing.JTextField signupEmail;
    private javax.swing.JPasswordField signupPassword;
    private javax.swing.JTextField signupUsername;
    // End of variables declaration//GEN-END:variables
}
