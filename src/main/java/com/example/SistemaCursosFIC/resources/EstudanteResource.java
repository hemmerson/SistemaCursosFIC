package com.example.SistemaCursosFIC.resources;

import com.example.SistemaCursosFIC.entities.Celular;
import com.example.SistemaCursosFIC.entities.Estudante;
import com.example.SistemaCursosFIC.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/estudantes")
public class EstudanteResource {

    @Autowired
    private EstudanteService service;

    @GetMapping
    public ResponseEntity<List<Estudante>> findAll(){
        List<Estudante> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estudante> findById(@PathVariable Long id){
        Estudante obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Estudante> insert(@RequestBody Estudante obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
