package com.example.SistemaCursosFIC.services;

import com.example.SistemaCursosFIC.entities.Estudante;
import com.example.SistemaCursosFIC.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<Estudante> findAll(){
        return estudanteRepository.findAll();
    }

    public Estudante findById(Long id){
        Optional<Estudante> obj = estudanteRepository.findById(id);
        return obj.get();
    }
}
