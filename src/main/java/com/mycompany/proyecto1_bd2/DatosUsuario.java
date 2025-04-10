
package com.mycompany.proyecto1_bd2;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mycompany.proyecto1_bd2.Conexion;

public class DatosUsuario {

    public static UsuarioInfo obtenerInfoDesdeTarjeta(String numeroTarjeta) {
        UsuarioInfo info = null;

        String sql = """
            SELECT c.nombre || ' ' || c.apellido AS nombre_completo,
                   cu.cuenta_id,
                   cu.saldo
            FROM banco.tarjeta t
            JOIN banco.cuenta cu ON t.cuenta_id = cu.cuenta_id
            JOIN banco.cliente c ON cu.cliente_id = c.cliente_id
            WHERE t.numero = ? AND t.estado = 'ACTIVA'
        """;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, numeroTarjeta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                info = new UsuarioInfo(
                    rs.getString("nombre_completo"),
                    rs.getInt("cuenta_id"),
                    rs.getDouble("saldo")
                );
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al obtener info del usuario:");
            e.printStackTrace();
        }

        return info;
    }
}