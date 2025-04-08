package com.mycompany.proyecto1_bd2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "atm";
        String password = "atm123";

        return DriverManager.getConnection(url, user, password);
    }
}
