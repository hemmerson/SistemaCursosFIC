package com.example.SistemaCursosFIC.resources;

import com.example.SistemaCursosFIC.entities.TurmaCurso;
import com.example.SistemaCursosFIC.services.TurmaCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/{id}")
    public ResponseEntity<TurmaCurso> updateVagas(@PathVariable Long id, @RequestBody TurmaCurso obj) {
        obj = service.updateVagas(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
