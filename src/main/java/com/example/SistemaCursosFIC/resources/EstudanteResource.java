package com.example.SistemaCursosFIC.resources;

import com.example.SistemaCursosFIC.entities.Celular;
import com.example.SistemaCursosFIC.entities.Estudante;
import com.example.SistemaCursosFIC.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/estudantes")
public class EstudanteResource {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public ResponseEntity<List<Estudante>> findAll(){
        List<Estudante> list = estudanteService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estudante> findById(@PathVariable Long id){
        Estudante obj = estudanteService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
