package com.example.SistemaCursosFIC.services;

import com.example.SistemaCursosFIC.entities.Celular;
import com.example.SistemaCursosFIC.entities.Estudante;
import com.example.SistemaCursosFIC.repositories.CelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelularService {

    @Autowired
    private CelularRepository repository;

    public List<Celular> findAll(){
        return repository.findAll();
    }

    public Celular findById(Long id){
        Optional<Celular> obj = repository.findById(id);
        return obj.get();
    }

    public Celular insert(Celular obj){
        return repository.save(obj);
    }
}
