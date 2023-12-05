package com.example.SistemaCursosFIC.resources;

import com.example.SistemaCursosFIC.entities.Celular;
import com.example.SistemaCursosFIC.services.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/celulares")
public class CelularResource {

    @Autowired
    private CelularService service;

    @GetMapping
    public ResponseEntity<List<Celular>> findAll(){
        List<Celular> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Celular> findById(@PathVariable Long id){
        Celular obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
