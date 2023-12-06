package com.example.SistemaCursosFIC.services;

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

    public List<TurmaCurso> findAll(){
        List<TurmaCurso> turmas = repository.findAll();
        List<TurmaCurso> saida = new ArrayList<>();
        for (TurmaCurso turma : turmas){
            if (!turma.getMatriculados().isEmpty()){
                saida.add(turma);
            }
        }
        return saida;
    }

    public TurmaCurso findById(Long id){
        Optional<TurmaCurso> obj = repository.findById(id);
        if (obj.get().getMatriculados().isEmpty())
            throw new IllegalArgumentException("Esta turma não possui estudantes matriculados.");
        return obj.get();
    }

    public TurmaCurso insert(TurmaCurso obj){
        validarTurma(obj);
        return repository.save(obj);
    }

    public TurmaCurso updateVagas(Long id, TurmaCurso obj) {
        try {
            TurmaCurso entity = repository.getReferenceById(id);
            updateVagasDisponiveis(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Turma não encontrada.");
        }
    }

    private void updateVagasDisponiveis(TurmaCurso entity, TurmaCurso obj) {
        entity.setVagasDisponiveis(obj.getVagasDisponiveis());
    }



    private void validarTurma(TurmaCurso turma) {
        if (turma.getLocal() == null || turma.getVagas() == null || turma.getVagasDisponiveis() == null
        || turma.getInicioAulas() == null || turma.getFimAulas() == null || turma.getInicioMatriculas() == null
                || turma.getFimMatriculas() == null) {
            throw new IllegalArgumentException("Todos os campos do curso são obrigatórios.");
        }
    }

}
