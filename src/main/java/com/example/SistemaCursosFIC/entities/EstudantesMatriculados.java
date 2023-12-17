package com.example.SistemaCursosFIC.entities;

import com.example.SistemaCursosFIC.pk.EstudantesMatriculadosPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 04/12/2023
 */

@Entity
@Table(name = "tb_estudantes_matriculados")
public class EstudantesMatriculados implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private EstudantesMatriculadosPK id = new EstudantesMatriculadosPK();
    private LocalDate dataMatricula;

    public EstudantesMatriculados(){}

    public EstudantesMatriculados(Estudante estudante, TurmaCurso turma, LocalDate dataMatricula){
        super();
        id.setEstudante(estudante);
        if (podeMatricular(dataMatricula)) {
            id.setTurma(turma);
        }
        this.dataMatricula = dataMatricula;
    }

    public Estudante getEstudante(){
        return id.getEstudante();
    }

    public void setEstudante(Estudante estudante){
        id.setEstudante(estudante);
    }

    public TurmaCurso getTurma(){
        return id.getTurma();
    }

    public void setTurma(TurmaCurso turma){
        if (podeMatricular(dataMatricula)) {
            id.setTurma(turma);
        }
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
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

    public boolean podeMatricular(LocalDate dataMatricula){
        if (getTurma().getVagasDisponiveis() <= 0)
            return false;
        List<LocalDate> periodoMatriculas = getTurma().getPeriodoMatriculas();
        if (dataMatricula.isBefore(periodoMatriculas.get(0)) ||
                dataMatricula.isAfter(periodoMatriculas.get(1))){
            return false;
        }
        return true;
    }
}
