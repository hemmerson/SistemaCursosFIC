package com.example.SistemaCursosFIC.services;

import com.example.SistemaCursosFIC.entities.EstudantesMatriculados;
import com.example.SistemaCursosFIC.entities.TurmaCurso;
import com.example.SistemaCursosFIC.repositories.EstudantesMatriculadosRepository;
import com.example.SistemaCursosFIC.repositories.TurmaCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudantesMatriculadosService {

    @Autowired
    private EstudantesMatriculadosRepository repository;

    @Autowired
    private TurmaCursoRepository turmaRepository;

    public List<EstudantesMatriculados> findAll(){
        return repository.findAll();
    }

    public EstudantesMatriculados findById(Long id){
        Optional<EstudantesMatriculados> obj = repository.findById(id);
        return obj.get();
    }

    public EstudantesMatriculados insert(EstudantesMatriculados obj){
        validarMatricula(obj);
        return repository.save(obj);
    }

    private void validarMatricula(EstudantesMatriculados matriculados) {
        if (matriculados.getTurma().getVagasDisponiveis() <=0)
            throw new IllegalArgumentException("Vagas Esgotadas para a turma");
    }
}
