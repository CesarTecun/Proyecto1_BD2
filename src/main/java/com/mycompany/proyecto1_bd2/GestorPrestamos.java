package com.mycompany.proyecto1_bd2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            resultado = cs.getString(9);

        } catch (SQLException e) {
            resultado = "❌ Error al registrar préstamo: " + e.getMessage();
        }

        return resultado;
    }

    public static double obtenerSaldoCuenta(int tarjetaId) {
        double saldo = 0;
        try (Connection conn = Conexion.getConnection()) {
            String query = "SELECT c.saldo FROM BANCO.CUENTA c JOIN BANCO.TARJETA t ON c.cuenta_id = t.cuenta_id WHERE t.tarjeta_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, tarjetaId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                saldo = rs.getDouble("saldo");
            }
        } catch (SQLException e) {
            System.out.println("⚠️ Error al obtener saldo: " + e.getMessage());
        }
        return saldo;
    }

    public static List<String> pagarPrestamos(List<Integer> pagosSeleccionados, int tarjetaId) {
        List<String> resultados = new ArrayList<>();

        for (int pagoId : pagosSeleccionados) {
            try (Connection conn = Conexion.getConnection()) {
                CallableStatement cs = conn.prepareCall("{ call banco.realizar_pago_prestamo(?, ?) }");
                cs.setInt(1, pagoId);
                cs.setInt(2, tarjetaId);

                cs.execute();
                resultados.add("✅ Pago realizado para cuota ID: " + pagoId);
            } catch (SQLException e) {
                resultados.add("❌ Error en cuota ID " + pagoId + ": " + e.getMessage());
            }
        }

        return resultados;
    }

    public static List<Object[]> obtenerPagosPendientes(int tarjetaId) {
      List<Object[]> pagos = new ArrayList<>();
      String query = 
          "SELECT p.pago_id, p.numero_pago, p.fecha_vencimiento, p.capital, p.interes, p.total, p.estado " +
          "FROM banco.PAGO_PRESTAMO p " +
          "JOIN banco.PRESTAMO pr ON pr.prestamo_id = p.prestamo_id " +
          "JOIN banco.CLIENTE_TARJETA ct ON ct.cliente_id = pr.cliente_id " +
          "JOIN banco.TARJETA t ON t.tarjeta_id = ct.tarjeta_id " +
          "WHERE t.tarjeta_id = ? AND p.estado = 'PENDIENTE'";

      try (Connection conn = Conexion.getConnection();
           PreparedStatement ps = conn.prepareStatement(query)) {
          ps.setInt(1, tarjetaId);
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
              pagos.add(new Object[]{
                  false, // Checkbox para seleccionar
                  rs.getInt("pago_id"),
                  rs.getInt("numero_pago"),
                  rs.getDate("fecha_vencimiento"),
                  rs.getDouble("capital"),
                  rs.getDouble("interes"),
                  rs.getDouble("total"),
                  rs.getString("estado")
              });
          }
      } catch (SQLException e) {
          System.out.println("❌ Error al obtener pagos pendientes: " + e.getMessage());
      }

      return pagos;
  }

}
