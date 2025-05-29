package com.sistema.parser;

import com.sistema.model.Professor;
public class ProfessorParser {

    public static Professor parse(String linha) throws Exception {
        System.out.println("Linha recebida para Professor: '" + linha + "'");
        System.out.println("Tamanho da linha: " + linha.length()); // Verificando o tamanho da linha

        // Verifica se a linha tem pelo menos 44 caracteres e começa com '3'
        if (linha.length() < 44 || linha.charAt(0) != '3') {
            System.out.println("Erro no formato da linha de Professor: " + linha); // Debug
            throw new Exception("Linha inválida para registro de Professor");
        }

        Professor professor = new Professor();

        // Pega o nome do professor (posições 2 a 41 - 40 caracteres)
        String nome = linha.substring(1, 41).trim();
        System.out.println("Nome extraído do professor: '" + nome + "'");
        professor.setNome(nome);

        // Pega o título docente (posições 42 a 43 - 2 caracteres)
        String tituloStr = linha.substring(41, 43).trim();
        System.out.println("Título docente extraído: '" + tituloStr + "'");
        professor.setTituloDocente(Integer.parseInt(tituloStr));

        return professor;
    }
}
