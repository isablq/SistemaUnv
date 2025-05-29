package com.sistema.dao;

import com.sistema.model.Fase;
import com.sistema.util.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FaseDAO {

    public void insertFase(Fase fase) throws SQLException {
        String sql = "INSERT INTO tb_fases (codigo, quantidade_disciplinas, quantidade_professores, curso_id) " +
                     "VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Verificando se o curso_id é válido
            if (fase.getCursoId() == 0) {
                throw new SQLException("CursoID inválido. Verifique se o curso_id está sendo corretamente atribuído.");
            }

            // Definindo os parâmetros do PreparedStatement
            stmt.setString(1, fase.getCodigo());
            stmt.setInt(2, fase.getQuantidadeDisciplinas());
            stmt.setInt(3, fase.getQuantidadeProfessores());
            stmt.setInt(4, fase.getCursoId());

            // Executando a inserção
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Fase inserida com sucesso: " + fase.getCodigo());
            } else {
                System.out.println("Nenhuma fase inserida. Verifique os dados.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir fase: " + e.getMessage());
            e.printStackTrace();
            throw e;  // Propaga a exceção
        }
    }
}
