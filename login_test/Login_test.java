/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package login_test;

import db.MyJDBC;
import javax.swing.SwingUtilities;
import login_test.guis.*;

/**
 *
 * @author DELL
 */
public class Login_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new LoginFormGUI().setVisible(true);
//                    System.out.println(MyJDBC.checkUser("tan"));
//                    System.out.println(MyJDBC.register("thinh", "060404"));
//                    System.out.println(MyJDBC.validateLogin("thinh", "060404"));
                }
            });
    }

    
}
