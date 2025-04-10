package com.mycompany.proyecto1_bd2;

import java.sql.*;

public class Validacion {

    public static boolean validarPin(String numeroTarjeta, String pin) {
        boolean valido = false;

        try (Connection conn = Conexion.getConnection()) {
            CallableStatement cs = conn.prepareCall("{call BANCO.VALIDAR_PIN(?, ?, ?)}"); // ✅ Agregamos schema BANCO
            cs.setString(1, numeroTarjeta);
            cs.setString(2, pin);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.execute();

            String resultado = cs.getString(3);

            if (resultado.equalsIgnoreCase("VALIDO")) {
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
            PreparedStatement ps = conn.prepareStatement("SELECT tarjeta_id FROM BANCO.TARJETA WHERE numero = ?"); // ✅ Referencia explícita a BANCO
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
    
         //VALIDACION PARA LA TARJETA O PIN
     public static boolean existeTarjeta(String numeroTarjeta) {
    try (Connection conn = Conexion.getConnection()) {
        String query = "SELECT COUNT(*) FROM banco.TARJETA WHERE numero = ? AND estado = 'ACTIVA'";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, numeroTarjeta);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        System.out.println("⚠️ Error al verificar tarjeta:");
        e.printStackTrace();
    }
    return false;
}
     //Validamos el acceso para el cajero
     public static String validarAcceso(String numeroTarjeta, String pin) {
    if (!numeroTarjeta.matches("\\d{16}")) {
        return "ERROR_TARJETA_FORMATO";
    }

    if (!existeTarjeta(numeroTarjeta)) {
        return "ERROR_TARJETA_NO_EXISTE";
    }

    if (!pin.matches("\\d{4}")) {
        return "ERROR_PIN_FORMATO";
    }

    if (!validarPin(numeroTarjeta, pin)) {
        return "ERROR_PIN_INCORRECTO";
    }

    return "ACCESO_CONCEDIDO";
}

    public static boolean realizarTransferencia(int tarjetaId, int cuentaDestino, double monto, int atmId) {
    boolean exito = false;
    try (Connection conn = Conexion.getConnection()) {
        CallableStatement cs = conn.prepareCall("{call BANCO.REALIZAR_TRANSFERENCIA(?, ?, ?, ?, ?)}");
        cs.setInt(1, tarjetaId);
        cs.setInt(2, cuentaDestino);
        cs.setDouble(3, monto);
        cs.setInt(4, atmId);
        cs.registerOutParameter(5, Types.VARCHAR); // Resultado: 'EXITO' o 'ERROR'

        cs.execute();
        String resultado = cs.getString(5);

        if (resultado != null && resultado.toUpperCase().contains("TRANSFERENCIA REALIZADA")) {
            exito = true;
        }
    } catch (SQLException e) {
        System.out.println("❌ Error al realizar transferencia:");
        e.printStackTrace();
    }
    return exito;
}    
    
    public static String realizarExtraccion(int tarjetaId, double monto, int atmId) {
    String resultado = null;

    try (Connection conn = Conexion.getConnection()) {
        CallableStatement cs = conn.prepareCall("{call BANCO.REALIZAR_EXTRACCION(?, ?, ?, ?)}");
        cs.setInt(1, tarjetaId);
        cs.setDouble(2, monto);
        cs.setInt(3, atmId);
        cs.registerOutParameter(4, Types.VARCHAR);

        cs.execute();
        resultado = cs.getString(4);

        System.out.println("🧾 Resultado extracción: " + resultado);
    } catch (SQLException e) {
        System.out.println("❌ Error al realizar extracción:");
        e.printStackTrace();
        resultado = "ERROR: " + e.getMessage();
    }

    return resultado;
}

}
