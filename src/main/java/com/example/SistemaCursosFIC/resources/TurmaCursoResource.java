package com.example.SistemaCursosFIC.resources;

import com.example.SistemaCursosFIC.entities.TurmaCurso;
import com.example.SistemaCursosFIC.services.TurmaCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaCursoResource {

    @Autowired
    private TurmaCursoService service;

    @GetMapping
    public ResponseEntity<List<TurmaCurso>> findAll(){
        List<TurmaCurso> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TurmaCurso> findById(@PathVariable Long id){
        TurmaCurso obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
