package com.example.SistemaCursosFIC.services;

import com.example.SistemaCursosFIC.entities.Estudante;
import com.example.SistemaCursosFIC.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository repository;

    public List<Estudante> findAll(){
        return repository.findAll();
    }

    public Estudante findById(Long id){
        Optional<Estudante> obj = repository.findById(id);
        return obj.get();
    }

    public Estudante insert(Estudante obj){
        validarEstudante(obj);
        return repository.save(obj);
    }

    private void validarEstudante(Estudante estudante) {
        if (estudante.getNome() == null || estudante.getMatricula() == null ||
                estudante.getDataNascimento() == null || estudante.getEndereco() == null ||
                estudante.getEmailInstitucional() == null) {
            throw new IllegalArgumentException("Todos os campos do estudante são obrigatórios.");
        }

        if (estudante.getCelulares() == null || estudante.getCelulares().isEmpty()) {
            throw new IllegalArgumentException("O estudante deve ter no mínimo 1 número de celular.");
        }

        // Verificar se o estudante tem pelo menos 15 anos
        LocalDate dataNascimento = estudante.getDataNascimento();
        LocalDate hoje = LocalDate.now();

        if (ChronoUnit.YEARS.between(dataNascimento, hoje) < 15) {
            throw new IllegalArgumentException("O estudante deve ter no mínimo 15 anos completos.");
        }
    }
}
