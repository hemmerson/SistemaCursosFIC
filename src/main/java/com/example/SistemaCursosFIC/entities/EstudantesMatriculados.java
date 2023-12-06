package com.example.SistemaCursosFIC.entities;

import com.example.SistemaCursosFIC.pk.EstudantesMatriculadosPK;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

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

    public EstudantesMatriculados(Estudante estudante, TurmaCurso turma, LocalDate dataMatricula) {
        id.setEstudante(estudante);
        id.setTurma(turma);
        this.dataMatricula = dataMatricula;
    }


}
