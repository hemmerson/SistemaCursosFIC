package com.example.SistemaCursosFIC.services;

import com.example.SistemaCursosFIC.entities.EstudantesMatriculados;
import com.example.SistemaCursosFIC.repositories.EstudantesMatriculadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudantesMatriculadosService {

    @Autowired
    private EstudantesMatriculadosRepository repository;

    public List<EstudantesMatriculados> findAll(){
        return repository.findAll();
    }

    public EstudantesMatriculados findById(Long id){
        Optional<EstudantesMatriculados> obj = repository.findById(id);
        return obj.get();
    }
}
