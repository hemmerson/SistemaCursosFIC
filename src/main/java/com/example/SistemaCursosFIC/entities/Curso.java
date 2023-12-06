package com.example.SistemaCursosFIC.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 03/12/2023
 */

@Entity
@Table(name = "tb_curso")
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cargaHoraria;
    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<TurmaCurso> turmaCursos;

    public Curso() {
    }

    public Curso(Long id, String nome, String cargaHoraria, String descricao) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.descricao = descricao;
    }

    public Curso(String nome, String cargaHoraria, String descricao) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<TurmaCurso> getTurmaCursos() {
        return turmaCursos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
