package com.example.SistemaCursosFIC.pk;

import com.example.SistemaCursosFIC.entities.Estudante;
import com.example.SistemaCursosFIC.entities.TurmaCurso;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 06/12/2023
 */
@Embeddable
public class EstudantesMatriculadosPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private TurmaCurso turma;

    public EstudantesMatriculadosPK() {
    }

    public EstudantesMatriculadosPK(Estudante estudante, TurmaCurso turma) {
        this.estudante = estudante;
        this.turma = turma;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public TurmaCurso getTurma() {
        return turma;
    }

    public void setTurma(TurmaCurso turma) {
        this.turma = turma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudantesMatriculadosPK that = (EstudantesMatriculadosPK) o;
        return Objects.equals(estudante, that.estudante) && Objects.equals(turma, that.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estudante, turma);
    }
}
