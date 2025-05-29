package com.sistema;

import com.sistema.parser.ArquivoParser;
import com.sistema.model.Curso;
import com.sistema.model.Fase;
import com.sistema.model.Disciplina;
import com.sistema.model.Professor;

public class App {
    public static void main(String[] args) {
        ArquivoParser parser = new ArquivoParser();

        try {
            parser.lerArquivo("teste.txt");  // arquivo dentro de src/main/resources

            System.out.println("Cursos:");
            for (Curso curso : parser.getCursos()) {
                System.out.println(curso);
            }

            System.out.println("\nFases:");
            for (Fase fase : parser.getFases()) {
                System.out.println(fase);
            }

            System.out.println("\nDisciplinas:");
            for (Disciplina disciplina : parser.getDisciplinas()) {
                System.out.println(disciplina);
            }

            System.out.println("\nProfessores:");
            for (Professor professor : parser.getProfessores()) {
                System.out.println(professor);
            }

        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
