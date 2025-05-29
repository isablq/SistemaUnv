package com.sistema.parser;

import com.sistema.model.Disciplina;

public class DisciplinaParser {

    public static Disciplina parse(String linha) throws Exception {
        if (linha.length() < 11 || linha.charAt(0) != '2') {
            throw new Exception("Linha inválida para registro de Disciplina");
        }

        Disciplina disciplina = new Disciplina();

        // Pos 2-7: código da disciplina (6 chars)
        String codigo = linha.substring(2, 7).trim();
        disciplina.setCodigo(codigo);

        // Pos 7-9: dia da semana (2 chars)
        String diaSemanaStr = linha.substring(7, 9).trim();
        disciplina.setDiaSemana(Integer.parseInt(diaSemanaStr));

        // Pos 9-11: quantidade de professores (2 chars)
        String qtdProfessoresStr = linha.substring(9, 11).trim();
        disciplina.setQuantidadeProfessores(Integer.parseInt(qtdProfessoresStr));

        // Não setamos faseId aqui (isso deve ser feito depois, durante o processamento das fases)
        return disciplina;
    }
}
