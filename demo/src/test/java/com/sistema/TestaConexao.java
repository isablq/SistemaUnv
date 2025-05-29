package com.sistema;

import java.sql.Connection;

import com.sistema.util.ConexaoDB;

public class TestaConexao {
    public static void main(String[] args) {
        try (Connection conn = ConexaoDB.getConnection()) {
            if (conn != null) {
                System.out.println("Conexão com banco de dados estabelecida com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}