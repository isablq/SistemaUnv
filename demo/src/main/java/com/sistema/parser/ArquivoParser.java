package com.sistema.parser;

import com.sistema.model.Curso;
import com.sistema.model.Fase;
import com.sistema.model.Disciplina;
import com.sistema.model.Professor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoParser {

    private List<Curso> cursos = new ArrayList<>();
    private List<Fase> fases = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();

    public void lerArquivo(String nomeArquivo) throws Exception {
        // Abrir o arquivo com o caminho correto
        InputStream is = getClass().getClassLoader().getResourceAsStream(nomeArquivo);
        if (is == null) {
            throw new FileNotFoundException("Arquivo não encontrado no classpath: " + nomeArquivo);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Exibe a linha recebida e o tamanho para depuração
                System.out.println("Linha recebida (tamanho=" + linha.length() + "): '" + linha + "'");

                // Pula as linhas vazias
                if (linha.isEmpty()) continue;

                // Verifica o tipo de registro da linha
                char tipoRegistro = linha.charAt(0);
                switch (tipoRegistro) {
                    case '0':  // Tipo 0 - Curso
                        System.out.println("Processando registro de Curso...");
                        Curso curso = CursoParser.parse(linha);
                        cursos.add(curso);
                        break;

                    case '1':  // Tipo 1 - Fase
                        System.out.println("Processando registro de Fase...");
                        Fase fase = FaseParser.parse(linha);
                        fases.add(fase);
                        break;

                    case '2':  // Tipo 2 - Disciplina
                        System.out.println("Processando registro de Disciplina...");
                        Disciplina disciplina = DisciplinaParser.parse(linha);
                        disciplinas.add(disciplina);
                        break;

                    case '3':  // Tipo 3 - Professor
                        System.out.println("Processando registro de Professor...");
                        Professor professor = ProfessorParser.parse(linha);
                        professores.add(professor);
                        break;

                    case '9':  // Tipo 9 - Trailer
                        System.out.println("Processando Trailer...");
                        break;

                    default:
                        // Se o tipo de registro não for reconhecido, lança uma exceção
                        throw new Exception("Tipo de registro inválido: " + tipoRegistro);
                }
            }
        }
    }

    // Métodos para acessar as listas de registros processados
    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Fase> getFases() {
        return fases;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<Professor> getProfessores() {
        return professores;
    }
}
