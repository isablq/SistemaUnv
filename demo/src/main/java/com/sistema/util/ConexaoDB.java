package com.sistema.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/sistema_escolar";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Isabele30.";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver não encontrado.");
        }
    }
}
