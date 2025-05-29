package com.sistema.dao;

import com.sistema.model.Professor;
import com.sistema.util.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfessorDAO {

    public void insertProfessor(Professor professor) throws SQLException {
        String sql = "INSERT INTO tb_professores (nome, titulo_docente, disciplina_id) " +
                     "VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Verificando se o disciplina_id é válido
            if (professor.getDisciplinaId() == 0) {
                throw new SQLException("DisciplinaID inválido. Verifique se o DisciplinaID está sendo corretamente atribuído.");
            }

            // Definindo os parâmetros do PreparedStatement
            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getTituloDocente());
            stmt.setInt(3, professor.getDisciplinaId());

            // Executando a inserção
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Professor inserido com sucesso: " + professor.getNome());
            } else {
                System.out.println("Nenhum professor inserido. Verifique os dados.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir professor: " + e.getMessage());
            e.printStackTrace();
            throw e;  // Propaga a exceção
        }
    }
}
