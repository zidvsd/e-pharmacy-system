/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package epharmacysystem.main;

import epharmacysystem.ui.auth.LoginFrame;

/**
 *
 * @author Zid
 */
public class EPharmacySystem {
    
    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
        /* Set the Nimbus or System Look and Feel if desired here */
        setUIFont(new java.awt.Font("Inter 18pt", java.awt.Font.PLAIN, 12));
        // Use invokeLater to ensure thread safety for the Swing UI
        java.awt.EventQueue.invokeLater(() -> {
            // 1. Create the instance of your LoginFrame
            LoginFrame login = new LoginFrame();
            
            // 2. Center it on the screen (Optional but looks better)
            login.setLocationRelativeTo(null);
            
            // 3. Make it visible
            login.setVisible(true);
        });
    }
    public static void setUIFont(java.awt.Font font) {
    java.util.Enumeration<Object> keys = javax.swing.UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
        Object key = keys.nextElement();
        Object value = javax.swing.UIManager.get(key);
        if (value instanceof javax.swing.plaf.FontUIResource) {
            javax.swing.UIManager.put(key, font);
        }
    }
}
}

