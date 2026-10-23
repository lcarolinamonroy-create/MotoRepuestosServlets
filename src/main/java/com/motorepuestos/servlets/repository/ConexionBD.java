package com.motorepuestos.servlets.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Centraliza la conexión JDBC utilizada por el módulo Servlet. */
public final class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/motorepuestos"
                    + "?useSSL=false"
                    + "&serverTimezone=America/Bogota"
                    + "&allowPublicKeyRetrieval=true";

    private static final String USUARIO = "root";

    private ConexionBD() {
    }

    public static Connection obtenerConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException error) {
            throw new SQLException(
                    "No se encontró el controlador JDBC de MySQL.",
                    error
            );
        }

        String password = System.getenv()
                .getOrDefault("DB_PASSWORD", "");

        return DriverManager.getConnection(
                URL,
                USUARIO,
                password
        );
    }
}