package com.sistema.parser;

import com.sistema.model.Disciplina;

public class DisciplinaParser {

    public static Disciplina parse(String linha) throws Exception {
        if (linha.length() < 11 || linha.charAt(0) != '2') {
            throw new Exception("Linha inválida para registro de Disciplina");
        }

        Disciplina disciplina = new Disciplina();

        // Pos 2-8: código da disciplina (6 chars)
        String codigo = linha.substring(1, 7).trim();
        disciplina.setCodigo(codigo);

        // Pos 8-10: dia da semana (2 chars)
        String diaSemanaStr = linha.substring(7, 9).trim();
        disciplina.setDiaSemana(Integer.parseInt(diaSemanaStr));

        // Pos 10-12: quantidade de professores (2 chars)
        String qtdProfessoresStr = linha.substring(9, 11).trim();
        disciplina.setQuantidadeProfessores(Integer.parseInt(qtdProfessoresStr));

        // Não setamos faseId aqui (pode ser setado depois)
        return disciplina;
    }
}
