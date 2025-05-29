package com.sistema.model;

public class Professor {
    private String nome;
    private int tituloDocente;
    private int disciplinaId;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getTituloDocente() { return tituloDocente; }
    public void setTituloDocente(int tituloDocente) { this.tituloDocente = tituloDocente; }

    public int getDisciplinaId() { return disciplinaId; }
    public void setDisciplinaId(int disciplinaId) { this.disciplinaId = disciplinaId; }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", tituloDocente=" + tituloDocente +
                ", disciplinaId=" + disciplinaId +
                '}';
    }
}
