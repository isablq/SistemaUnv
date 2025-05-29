package com.sistema.parser;

import com.sistema.model.Curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CursoParser {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static Curso parse(String linha) throws Exception {
        System.out.println("Linha recebida (tamanho=" + linha.length() + "): '" + linha + "'");

        if (linha.length() < 84 || linha.charAt(0) != '0') {
            throw new Exception("Linha inválida para registro de Curso");
        }

        Curso curso = new Curso();

        // Pos 2-51: nome do curso (50 caracteres)
        String nome = linha.substring(1, 51).trim();
        curso.setNome(nome);

        // Pos 52-59: data de processamento (8 caracteres)
        String dataProcStr = linha.substring(51, 59); 
        LocalDate dataProcessamento = LocalDate.parse(dataProcStr, formatter);
        curso.setDataProcessamento(dataProcessamento);

       String periodoInicial = linha.substring(59, 65).trim();
       curso.setPeriodoInicial(periodoInicial);

       String periodoFinal = linha.substring(65, 72).trim();
       curso.setPeriodoFinal(periodoFinal);

        // Pos 74-80: sequência (7 caracteres)
        String sequenciaStr = linha.substring(73, 80).trim(); 
        curso.setSequencia(Integer.parseInt(sequenciaStr)); 
        
        // Pos 81-83: versão do layout (3 caracteres)
        String versaoLayout = linha.substring(80, 83).trim(); // Pega da posição 81 até 83
        curso.setVersaoLayout(versaoLayout);

        return curso; // Retorna o objeto 'Curso' preenchido
    }
}
