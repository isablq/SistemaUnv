package com.sistema.parser;

import com.sistema.model.Fase;

public class FaseParser {

    public static Fase parse(String linha) throws Exception {
        if (linha.length() < 13 || linha.charAt(0) != '1') {
            throw new Exception("Linha inválida para registro de Fase");
        }

        Fase fase = new Fase();

        // Pos 2-9: código da fase (7 chars)
        String codigo = linha.substring(1, 8).trim();
        fase.setCodigo(codigo);

        // Pos 9-11: quantidade de disciplinas (2 chars)
        String qtdDisciplinasStr = linha.substring(8, 10).trim();
        fase.setQuantidadeDisciplinas(Integer.parseInt(qtdDisciplinasStr));

        // Pos 11-13: quantidade de professores (2 chars)
        String qtdProfessoresStr = linha.substring(10, 12).trim();
        fase.setQuantidadeProfessores(Integer.parseInt(qtdProfessoresStr));

        // Para simplificar, não setamos cursoId aqui (pode ser feito depois)
        return fase;
    }
}
