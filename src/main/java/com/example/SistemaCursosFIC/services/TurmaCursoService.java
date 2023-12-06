package com.example.SistemaCursosFIC.services;

import com.example.SistemaCursosFIC.entities.TurmaCurso;
import com.example.SistemaCursosFIC.repositories.TurmaCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaCursoService {

    @Autowired
    private TurmaCursoRepository repository;

    public List<TurmaCurso> findAll(){
        return repository.findAll();
    }

    public TurmaCurso findById(Long id){
        Optional<TurmaCurso> obj = repository.findById(id);
        return obj.get();
    }
}
