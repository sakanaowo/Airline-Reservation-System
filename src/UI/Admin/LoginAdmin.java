package UI.Admin;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import DataHandle.Data.*;


/**
 *
 * @author ADMIN
 */
public class LoginAdmin extends javax.swing.JFrame {

    /**
     * Creates new form LoginAdmin
     */
    public LoginAdmin() {
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

        AdminLogin = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        BrandName = new javax.swing.JLabel();
        CopyRight = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        Right = new javax.swing.JPanel();
        LoginLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        EmailField = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        ForgotPassword = new javax.swing.JPanel();
        pnContainer = new javax.swing.JPanel();
        pnTitle = new javax.swing.JPanel();
        lbl_quen_mat_khau = new javax.swing.JLabel();
        icon_quen_mat_khau = new javax.swing.JLabel();
        lbl_username = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        btn_xac_nhan = new javax.swing.JButton();
        btn_huy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        AdminLogin.setBackground(new java.awt.Color(255, 255, 255));
        AdminLogin.setPreferredSize(new java.awt.Dimension(900, 500));
        AdminLogin.setLayout(null);

        Left.setBackground(new java.awt.Color(204, 0, 0));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        BrandName.setFont(new java.awt.Font("Showcard Gothic", 3, 36)); // NOI18N
        BrandName.setForeground(new java.awt.Color(255, 255, 255));
        BrandName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BrandName.setText("CLC04 Airlines");

        CopyRight.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        CopyRight.setForeground(new java.awt.Color(255, 255, 255));
        CopyRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CopyRight.setText("copyright (c) CLC04 AIRLINES All rights reversed");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icon/admin.png"))); // NOI18N

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
                LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BrandName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(LeftLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(CopyRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(LeftLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(logo)
                                .addGap(0, 101, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
                LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LeftLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(logo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BrandName)
                                .addGap(78, 78, 78)
                                .addComponent(CopyRight)
                                .addContainerGap(88, Short.MAX_VALUE))
        );

        AdminLogin.add(Left);
        Left.setBounds(0, 0, 450, 500);

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        LoginLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LoginLabel.setForeground(new java.awt.Color(204, 0, 0));
        LoginLabel.setText("ADMIN LOGIN");

        EmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        EmailLabel.setText("Admin Name");

        EmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //EmailFieldActionPerformed(evt);
            }
        });

        PasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PasswordLabel.setText("Password");

        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //PasswordFieldActionPerformed(evt);
            }
        });

        LoginButton.setBackground(new java.awt.Color(204, 0, 0));
        LoginButton.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Login");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
                RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                                .addContainerGap(77, Short.MAX_VALUE)
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(PasswordField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(PasswordLabel)
                                                .addComponent(EmailLabel)
                                                .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(76, 76, 76))
                        .addGroup(RightLayout.createSequentialGroup()
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(RightLayout.createSequentialGroup()
                                                .addGap(101, 101, 101)
                                                .addComponent(LoginLabel))
                                        .addGroup(RightLayout.createSequentialGroup()
                                                .addGap(188, 188, 188)
                                                .addComponent(LoginButton)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
                RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RightLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(LoginLabel)
                                .addGap(43, 43, 43)
                                .addComponent(EmailLabel)
                                .addGap(18, 18, 18)
                                .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(PasswordLabel)
                                .addGap(18, 18, 18)
                                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(114, Short.MAX_VALUE))
        );

        AdminLogin.add(Right);
        Right.setBounds(450, 0, 450, 500);

        getContentPane().add(AdminLogin, "card2");

        ForgotPassword.setPreferredSize(new java.awt.Dimension(900, 500));

        pnContainer.setBackground(new java.awt.Color(255, 255, 255));

        pnTitle.setBackground(new java.awt.Color(204, 0, 0));

        lbl_quen_mat_khau.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        lbl_quen_mat_khau.setForeground(new java.awt.Color(255, 255, 255));
        lbl_quen_mat_khau.setText("QUÊN MẬT KHẨU");

        icon_quen_mat_khau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Icon/forgotpassword.png"))); // NOI18N

        javax.swing.GroupLayout pnTitleLayout = new javax.swing.GroupLayout(pnTitle);
        pnTitle.setLayout(pnTitleLayout);
        pnTitleLayout.setHorizontalGroup(
                pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnTitleLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(icon_quen_mat_khau, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_quen_mat_khau)
                                .addGap(259, 259, 259))
        );
        pnTitleLayout.setVerticalGroup(
                pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnTitleLayout.createSequentialGroup()
                                .addGroup(pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnTitleLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(icon_quen_mat_khau))
                                        .addGroup(pnTitleLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(lbl_quen_mat_khau)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        lbl_username.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lbl_username.setText("Nhập Username:");

        lbl_email.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lbl_email.setText("Nhập Email đã đăng kí:");

        btn_xac_nhan.setBackground(new java.awt.Color(204, 204, 204));
        btn_xac_nhan.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btn_xac_nhan.setText("Xác nhận");

        btn_huy.setBackground(new java.awt.Color(204, 204, 204));
        btn_huy.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btn_huy.setText("Hủy");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btn_huyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnContainerLayout = new javax.swing.GroupLayout(pnContainer);
        pnContainer.setLayout(pnContainerLayout);
        pnContainerLayout.setHorizontalGroup(
                pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnContainerLayout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_username)
                                        .addComponent(lbl_email)
                                        .addGroup(pnContainerLayout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(btn_xac_nhan)))
                                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnContainerLayout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(pnContainerLayout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addComponent(btn_huy)))
                                .addContainerGap(190, Short.MAX_VALUE))
        );
        pnContainerLayout.setVerticalGroup(
                pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnContainerLayout.createSequentialGroup()
                                .addComponent(pnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_username)
                                        .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_email)
                                        .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69)
                                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_xac_nhan)
                                        .addComponent(btn_huy))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ForgotPasswordLayout = new javax.swing.GroupLayout(ForgotPassword);
        ForgotPassword.setLayout(ForgotPasswordLayout);
        ForgotPasswordLayout.setHorizontalGroup(
                ForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ForgotPasswordLayout.setVerticalGroup(
                ForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(ForgotPassword, "forgotpassword");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        String getEmail = EmailField.getText().trim();
        String getAdminPassword = new String(PasswordField.getPassword()).trim();

        if (getEmail.isEmpty() || getAdminPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all data field!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean authen = Admin.checkAdminLogin(getEmail, getAdminPassword);
        if (authen) {
            // Tu update va view lai
            Planes.updatePlaneBaseOnFlight();
            refresh.handleRefreshAirportsList(mainFrame.getAirportsPanel());
            refresh.handleRefreshList(mainFrame.getFlightsPanel());
            refresh.handleRefreshPlaneList(mainFrame.getPlanesPanel());

            view.viewAirports(mainFrame.getAirportsPanel());
            view.viewFlights(mainFrame.getFlightsPanel());
            view.viewPlanes(mainFrame.getPlanesPanel());
            JFrame frame = new JFrame("Admin");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1400, 750);

            // Sử dụng NoiAdmin để tạo panel
            JPanel adminPanel = mainFrame.mainAdmin(frame);

            frame.add(adminPanel);
            frame.setLocationRelativeTo(null);

            frame.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Admin email or password is wrong!", "Failed", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_LoginButtonActionPerformed

    private void showPanel(String panelName) {
        CardLayout layout = (CardLayout) getContentPane().getLayout();
        layout.show(getContentPane(), panelName);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdminLogin;
    private javax.swing.JLabel BrandName;
    private javax.swing.JLabel CopyRight;
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JPanel ForgotPassword;
    private javax.swing.JPanel Left;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPanel Right;
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_xac_nhan;
    private javax.swing.JTextField email_field;
    private javax.swing.JLabel icon_quen_mat_khau;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_quen_mat_khau;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel pnContainer;
    private javax.swing.JPanel pnTitle;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}