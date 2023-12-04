package com.example.SistemaCursosFIC.model.entity;

import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 03/12/2023
 */
public class Curso {
    private Long id;
    private String nome;
    private String cargaHoraria;
    private String descricao;
    private List<TurmaCurso> turmaCursos;

    public Curso() {
    }

    public Curso(Long id, String nome, String cargaHoraria, String descricao) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.descricao = descricao;
    }

    public Curso(Long id, String nome, String cargaHoraria, String descricao, List<TurmaCurso> turmaCursos) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.descricao = descricao;
        this.turmaCursos = turmaCursos;
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

    public void setTurmaCursos(List<TurmaCurso> turmaCursos) {
        this.turmaCursos = turmaCursos;
    }
}
