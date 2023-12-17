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
        obj.getTurma().setVagasDisponiveis();
        return repository.save(obj);
    }

    public List<EstudantesMatriculados> listaEstudantesMatriculados(TurmaCurso turma){
        List<EstudantesMatriculados> lista = repository.findAll();
        for (EstudantesMatriculados matriculados : lista){
            if (matriculados.getTurma() == turma){
                if (matriculados.getTurma().getMatriculados().isEmpty())
                    throw new IllegalArgumentException("A lista de estudantes está vazia!");
                else{
                    return matriculados.getTurma().getMatriculados();
                }
            }
        }
        throw new IllegalArgumentException("Turma não encontrada!");
    }

}
