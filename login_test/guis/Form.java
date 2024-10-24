/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login_test.guis;

import constants.CommandConstants;
import javax.swing.*;

/**
 *
 * @author DELL
 */
public class Form extends JFrame {
    public Form(String title) {
        super(title);
        setSize(520, 680);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(CommandConstants.PRIMARY_COLOR);
    }
}
