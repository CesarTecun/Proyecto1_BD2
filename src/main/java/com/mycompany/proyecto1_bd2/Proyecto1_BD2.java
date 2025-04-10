package com.mycompany.proyecto1_bd2;

import javax.swing.JFrame;
import GUI.Menu_Cajero;

public class Proyecto1_BD2 {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("💳 Cajero Automático");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Menu_Cajero menu = new Menu_Cajero(); // Asegúrate de tener el constructor correcto
            frame.getContentPane().add(menu);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
