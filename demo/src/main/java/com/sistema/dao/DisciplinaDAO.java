package com.sistema.dao;

import com.sistema.model.Disciplina;
import com.sistema.util.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DisciplinaDAO {

    public void insertDisciplina(Disciplina disciplina) throws SQLException {
    // Definindo o comando SQL para inserir a disciplina
    String sql = "INSERT INTO tb_disciplinas (codigo, dia_semana, quantidade_professores, fase_id) " +
                 "VALUES (?, ?, ?, ?)";

    // Usando try-with-resources para garantir o fechamento da conexão
    try (Connection conn = ConexaoDB.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Verificando se o FaseID é válido
        if (disciplina.getFaseId() == 0) {
            throw new SQLException("FaseID inválido. Verifique se o FaseID está sendo corretamente atribuído.");
        }

        // Definindo os parâmetros do PreparedStatement
        stmt.setString(1, disciplina.getCodigo());
        stmt.setInt(2, disciplina.getDiaSemana());
        stmt.setInt(3, disciplina.getQuantidadeProfessores());
        stmt.setInt(4, disciplina.getFaseId());  // Passando o fase_id da disciplina

        // Executando a inserção
        int rowsAffected = stmt.executeUpdate();

        // Verificando se a inserção foi bem-sucedida
        if (rowsAffected > 0) {
            System.out.println("Disciplina inserida com sucesso: " + disciplina.getCodigo());
        } else {
            System.out.println("Nenhuma disciplina inserida. Verifique os dados.");
        }
    } catch (SQLException e) {
        // Adicionando informações detalhadas para o log
        System.err.println("Erro ao inserir disciplina: " + e.getMessage());
        e.printStackTrace();
        throw e;  // Propaga a exceção
    }
}

}
