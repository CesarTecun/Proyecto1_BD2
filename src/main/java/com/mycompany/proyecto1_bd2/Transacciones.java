package com.mycompany.proyecto1_bd2;
import java.sql.*;

public class Transacciones {

    public static void realizarExtraccion(int tarjetaId, double monto, int atmId) {
        try (Connection conn = Conexion.getConnection()) {
           CallableStatement cs = conn.prepareCall("{call banco.realizar_extraccion(?, ?, ?, ?)}");
            cs.setInt(1, tarjetaId);
            cs.setDouble(2, monto);
            cs.setInt(3, atmId);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.execute();
            System.out.println(cs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void realizarTransferencia(int tarjetaId, int cuentaDestino, double monto, int atmId) {
        try (Connection conn = Conexion.getConnection()) {
            CallableStatement cs = conn.prepareCall("{call banco.realizar_transferencia(?, ?, ?, ?, ?)}");
            cs.setInt(1, tarjetaId);
            cs.setInt(2, cuentaDestino);
            cs.setDouble(3, monto);
            cs.setInt(4, atmId);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.execute();
            System.out.println(cs.getString(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
