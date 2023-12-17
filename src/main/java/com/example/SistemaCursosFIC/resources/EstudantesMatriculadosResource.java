package com.example.SistemaCursosFIC.resources;

import com.example.SistemaCursosFIC.entities.EstudantesMatriculados;
import com.example.SistemaCursosFIC.entities.TurmaCurso;
import com.example.SistemaCursosFIC.services.EstudantesMatriculadosService;
import com.example.SistemaCursosFIC.services.TurmaCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/matriculados")
public class EstudantesMatriculadosResource {

    @Autowired
    private EstudantesMatriculadosService service;

    @Autowired
    private TurmaCursoService turmaService;

    @GetMapping
    public ResponseEntity<List<EstudantesMatriculados>> findAll(){
        List<EstudantesMatriculados> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EstudantesMatriculados> findById(@PathVariable Long id){
        EstudantesMatriculados obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/listamatriculados/{id}")
    public ResponseEntity<List<EstudantesMatriculados>> listaMatriculados(@PathVariable Long id){
        TurmaCurso turma = turmaService.findById(id);
        List<EstudantesMatriculados> list = service.listaEstudantesMatriculados(turma);
        return ResponseEntity.ok().body(list);
    }
}
