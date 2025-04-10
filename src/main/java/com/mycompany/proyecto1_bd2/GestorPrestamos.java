package com.mycompany.proyecto1_bd2;

import java.sql.*;

public class GestorPrestamos {

    public static String registrarPrestamo(
        int clienteId,
        String tipoPrestamo,
        double montoSolicitado,
        String moneda,
        int plazoMeses,
        String destino,
        String garantia,
        int cuentaDesembolso
    ) {
        String resultado = "";

        try (Connection conn = Conexion.getConnection()) {
            CallableStatement cs = conn.prepareCall("{ call banco.evaluar_y_crear_prestamo(?, ?, ?, ?, ?, ?, ?, ?, ?) }");
            cs.setInt(1, clienteId);
            cs.setString(2, tipoPrestamo);
            cs.setDouble(3, montoSolicitado);
            cs.setString(4, moneda);
            cs.setInt(5, plazoMeses);
            cs.setString(6, destino);
            cs.setString(7, garantia);
            cs.setInt(8, cuentaDesembolso);
            cs.registerOutParameter(9, java.sql.Types.VARCHAR);

            cs.execute();
            resultado = cs.getString(9); // ✅ Asigna a la variable ya existente

        } catch (SQLException e) {
            resultado = "❌ Error al registrar préstamo: " + e.getMessage();
        }

        return resultado;
    }
}
