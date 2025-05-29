package com.sistema.model;

public class Fase {
    private String codigo;
    private int quantidadeDisciplinas;
    private int quantidadeProfessores;
    private int cursoId;

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public int getQuantidadeDisciplinas() { return quantidadeDisciplinas; }
    public void setQuantidadeDisciplinas(int quantidadeDisciplinas) { this.quantidadeDisciplinas = quantidadeDisciplinas; }

    public int getQuantidadeProfessores() { return quantidadeProfessores; }
    public void setQuantidadeProfessores(int quantidadeProfessores) { this.quantidadeProfessores = quantidadeProfessores; }

    public int getCursoId() { return cursoId; }
    public void setCursoId(int cursoId) { this.cursoId = cursoId; }

    @Override
    public String toString() {
        return "Fase{" +
                "codigo='" + codigo + '\'' +
                ", quantidadeDisciplinas=" + quantidadeDisciplinas +
                ", quantidadeProfessores=" + quantidadeProfessores +
                ", cursoId=" + cursoId +
                '}';
    }
}
