package com.example.SistemaCursosFIC.services;

import com.example.SistemaCursosFIC.entities.EstudantesMatriculados;
import com.example.SistemaCursosFIC.entities.TurmaCurso;
import com.example.SistemaCursosFIC.repositories.TurmaCursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaCursoService {

    @Autowired
    private TurmaCursoRepository repository;

    public List<TurmaCurso> findAll() {
        List<TurmaCurso> turmas = repository.findAll();
        List<TurmaCurso> saida = new ArrayList<>();
        for (TurmaCurso turma : turmas) {
            if (!turma.getMatriculados().isEmpty()) {
                saida.add(turma);
            }
        }
        return saida;
    }

    public TurmaCurso findById(Long id) {
        Optional<TurmaCurso> obj = repository.findById(id);
        if (obj.get().getMatriculados().isEmpty())
            throw new IllegalArgumentException("Esta turma não possui estudantes matriculados.");
        return obj.get();
    }

    public TurmaCurso insert(TurmaCurso obj) {
        validarTurma(obj);
        return repository.save(obj);
    }

    private void validarTurma(TurmaCurso turma) {
        if (turma.getLocal() == null || turma.getVagas() == null || turma.getVagasDisponiveis() == null
                || turma.getInicioAulas() == null || turma.getFimAulas() == null || turma.getInicioMatriculas() == null
                || turma.getFimMatriculas() == null) {
            throw new IllegalArgumentException("Todos os campos do curso são obrigatórios.");
        }

        if (turma.getInicioMatriculas().isAfter(turma.getFimMatriculas()))
            throw new IllegalArgumentException("A data de inicio das matriculas deve ser posterior ao fim das matriculas");

        if (turma.getInicioAulas().isAfter(turma.getFimAulas()))
            throw new IllegalArgumentException("A data de inicio das aulas deve ser posterior ao fim das aulas");

        if (turma.getFimMatriculas().isAfter(turma.getInicioAulas()) || turma.getFimMatriculas().isAfter(turma.getInicioAulas()))
            throw new IllegalArgumentException("O período de matriculas deve ser anterior ao início das aulas");

    }

    public List<EstudantesMatriculados> listaEstudantesMatriculados(Long id) {
        TurmaCurso turma = findById(id);
        if (turma.getMatriculados().isEmpty())
            throw new RuntimeException("A lista de estudantes está vazia!");
        else {
            return turma.getMatriculados();
        }
    }


}
