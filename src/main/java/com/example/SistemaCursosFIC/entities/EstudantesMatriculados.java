package com.example.SistemaCursosFIC.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 04/12/2023
 */
public class EstudantesMatriculados {
    private Long id;
    private LocalDate dataMatricula;

    @ManyToOne
    @JoinColumn(name = "estudante_id")
    private Estudante estudanteMatriculado;

    @ManyToMany(mappedBy = "matriculados")
    private List<TurmaCurso> turmas = new ArrayList<>();

    public EstudantesMatriculados() {
    }

    public EstudantesMatriculados(LocalDate dataMatricula, Estudante estudanteMatriculado) {
        this.dataMatricula = dataMatricula;
        this.estudanteMatriculado = estudanteMatriculado;
    }

    public EstudantesMatriculados(Long id, LocalDate dataMatricula, Estudante estudanteMatriculado) {
        this.id = id;
        this.dataMatricula = dataMatricula;
        this.estudanteMatriculado = estudanteMatriculado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Estudante getEstudanteMatriculado() {
        return estudanteMatriculado;
    }

    public void setEstudanteMatriculado(Estudante estudanteMatriculado) {
        this.estudanteMatriculado = estudanteMatriculado;
    }

    public List<TurmaCurso> getTurmas() {
        return turmas;
    }

    public void adicionaTurmas(TurmaCurso turma) {
        this.turmas.add(turma);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudantesMatriculados that = (EstudantesMatriculados) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
