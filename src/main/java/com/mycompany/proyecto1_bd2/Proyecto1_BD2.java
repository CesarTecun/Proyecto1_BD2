package com.mycompany.proyecto1_bd2;

import java.sql.Connection;

public class Proyecto1_BD2 {
    public static void main(String[] args) {
        try (Connection conn = Conexion.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Conexión exitosa a Oracle con el usuario atm.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error de conexión:");
            e.printStackTrace();
        }
    }
}
