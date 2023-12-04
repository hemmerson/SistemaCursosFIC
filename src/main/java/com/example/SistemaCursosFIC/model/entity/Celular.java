package com.example.SistemaCursosFIC.model.entity;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 03/12/2023
 */
public class Celular {
    private Long id;
    private String numero;
    private Estudante estudante;

    public Celular() {
    }

    public Celular(Long id, String numero) {
        this.id = id;
        this.numero = numero;
    }

    public Celular(Long id, String numero, Estudante estudante) {
        this.id = id;
        this.numero = numero;
        this.estudante = estudante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
