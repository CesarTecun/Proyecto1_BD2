package com.mycompany.proyecto1_bd2;

import java.sql.*;

public class Validacion {

    public static boolean validarPin(String numeroTarjeta, String pin) {
        boolean valido = false;

        try (Connection conn = Conexion.getConnection()) {
            CallableStatement cs = conn.prepareCall("{call VALIDAR_PIN(?, ?, ?)}");
            cs.setString(1, numeroTarjeta);
            cs.setString(2, pin);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.execute();

            String resultado = cs.getString(3);
            System.out.println("🛡️ " + resultado);

            if (resultado.contains("válido")) {
                valido = true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al validar PIN:");
            e.printStackTrace();
        }

        return valido;
    }

    public static int obtenerTarjetaId(String numeroTarjeta) {
        try (Connection conn = Conexion.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT tarjeta_id FROM TARJETA WHERE numero = ?");
            ps.setString(1, numeroTarjeta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("tarjeta_id");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener tarjeta_id:");
            e.printStackTrace();
        }
        return -1;
    }
}
