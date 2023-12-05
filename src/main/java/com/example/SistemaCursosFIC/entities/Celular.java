package com.example.SistemaCursosFIC.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 03/12/2023
 */

@Entity
@Table(name = "tb_celular")
public class Celular implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "estudante_id")
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
