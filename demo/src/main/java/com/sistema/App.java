package com.sistema;

import com.sistema.parser.ArquivoParser;
import com.sistema.model.Curso;
import com.sistema.model.Fase;
import com.sistema.model.Disciplina;
import com.sistema.model.Professor;

public class App {
    public static void main(String[] args) {
        // Cria uma instância do parser para processar o arquivo
        ArquivoParser parser = new ArquivoParser();

        try {
            // Lê o arquivo de dados
            parser.lerArquivo("teste.txt");  // arquivo dentro de src/main/resources

            // Exibe os cursos lidos
            System.out.println("\n----- CURSOS -----");
            for (Curso curso : parser.getCursos()) {
                System.out.printf("Curso: %-20s | Data Processamento: %-10s | Período Inicial: %-7s | Período Final: %-7s | Versão Layout: %-3s%n",
                        curso.getNome(), curso.getDataProcessamento(), curso.getPeriodoInicial(), curso.getPeriodoFinal(), curso.getVersaoLayout());
            }

            // Exibe as fases lidas
            System.out.println("\n----- FASES -----");
            for (Fase fase : parser.getFases()) {
                System.out.printf("Fase: %-10s | Disciplinas: %-2d | Professores: %-2d%n",
                        fase.getCodigo(), fase.getQuantidadeDisciplinas(), fase.getQuantidadeProfessores());
            }

            // Exibe as disciplinas lidas
            System.out.println("\n----- DISCIPLINAS -----");
            for (Disciplina disciplina : parser.getDisciplinas()) {
                System.out.printf("Disciplina: %-6s | Dia da Semana: %-2d | Professores: %-2d%n",
                        disciplina.getCodigo(), disciplina.getDiaSemana(), disciplina.getQuantidadeProfessores());
            }

            // Exibe os professores lidos
            System.out.println("\n----- PROFESSORES -----");
            for (Professor professor : parser.getProfessores()) {
                System.out.printf("Professor: %-30s | Título Docente: %-2d%n",
                        professor.getNome(), professor.getTituloDocente());
            }

        } catch (Exception e) {
            // Caso haja algum erro ao ler o arquivo
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

    
    