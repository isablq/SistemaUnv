package com.sistema.model;

public class Disciplina {
    private String codigo;
    private int diaSemana;
    private int quantidadeProfessores;
    private int faseId;

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public int getDiaSemana() { return diaSemana; }
    public void setDiaSemana(int diaSemana) { this.diaSemana = diaSemana; }

    public int getQuantidadeProfessores() { return quantidadeProfessores; }
    public void setQuantidadeProfessores(int quantidadeProfessores) { this.quantidadeProfessores = quantidadeProfessores; }

    public int getFaseId() { return faseId; }
    public void setFaseId(int faseId) { this.faseId = faseId; }

    @Override
    public String toString() {
        return "Disciplina{" +
                "codigo='" + codigo + '\'' +
                ", diaSemana=" + diaSemana +
                ", quantidadeProfessores=" + quantidadeProfessores +
                ", faseId=" + faseId +
                '}';
    }
}
