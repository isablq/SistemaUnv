package com.sistema.dao;

import com.sistema.model.Curso;
import com.sistema.util.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CursoDAO {

    public void insertCurso(Curso curso) throws SQLException {
        String sql = "INSERT INTO tb_cursos (nome, data_processamento, periodo_inicial, periodo_final, sequencia, versao_layout) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Definindo os parâmetros do PreparedStatement
            stmt.setString(1, curso.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(curso.getDataProcessamento()));
            stmt.setString(3, curso.getPeriodoInicial());
            stmt.setString(4, curso.getPeriodoFinal());
            stmt.setInt(5, curso.getSequencia());
            stmt.setString(6, curso.getVersaoLayout());

            // Executando a inserção
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Curso inserido com sucesso: " + curso.getNome());
            } else {
                System.out.println("Nenhum curso inserido. Verifique os dados.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir curso: " + e.getMessage());
            e.printStackTrace();
            throw e;  // Propaga a exceção
        }
    }
}
