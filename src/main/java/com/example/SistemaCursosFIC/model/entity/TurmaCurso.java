package com.example.SistemaCursosFIC.model.entity;

import java.time.LocalDate;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 03/12/2023
 */
public class TurmaCurso {
    private Long id;
    private String local;
    private Integer vagas;
    private Integer vagasDisponiveis;
    private LocalDate inicioAulas;
    private LocalDate fimAulas;
    private LocalDate inicioMatriculas;
    private LocalDate fimMatriculas;
    private Curso curso;

    public TurmaCurso() {
    }

    public TurmaCurso(Long id, String local, Integer vagas, Integer vagasDisponiveis, LocalDate inicioAulas, LocalDate fimAulas, LocalDate inicioMatriculas, LocalDate fimMatriculas) {
        this.id = id;
        this.local = local;
        this.vagas = vagas;
        this.vagasDisponiveis = vagasDisponiveis;
        this.inicioAulas = inicioAulas;
        this.fimAulas = fimAulas;
        this.inicioMatriculas = inicioMatriculas;
        this.fimMatriculas = fimMatriculas;
    }

    public TurmaCurso(Long id, String local, Integer vagas, Integer vagasDisponiveis, LocalDate inicioAulas, LocalDate fimAulas, LocalDate inicioMatriculas, LocalDate fimMatriculas, Curso curso) {
        this.id = id;
        this.local = local;
        this.vagas = vagas;
        this.vagasDisponiveis = vagasDisponiveis;
        this.inicioAulas = inicioAulas;
        this.fimAulas = fimAulas;
        this.inicioMatriculas = inicioMatriculas;
        this.fimMatriculas = fimMatriculas;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Integer getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(Integer vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public LocalDate getInicioAulas() {
        return inicioAulas;
    }

    public void setInicioAulas(LocalDate inicioAulas) {
        this.inicioAulas = inicioAulas;
    }

    public LocalDate getFimAulas() {
        return fimAulas;
    }

    public void setFimAulas(LocalDate fimAulas) {
        this.fimAulas = fimAulas;
    }

    public LocalDate getInicioMatriculas() {
        return inicioMatriculas;
    }

    public void setInicioMatriculas(LocalDate inicioMatriculas) {
        this.inicioMatriculas = inicioMatriculas;
    }

    public LocalDate getFimMatriculas() {
        return fimMatriculas;
    }

    public void setFimMatriculas(LocalDate fimMatriculas) {
        this.fimMatriculas = fimMatriculas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
