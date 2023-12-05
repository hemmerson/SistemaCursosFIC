package com.example.SistemaCursosFIC.resources;

import com.example.SistemaCursosFIC.entities.Celular;
import com.example.SistemaCursosFIC.entities.Estudante;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/estudantes")
public class EstudanteResource {

    @GetMapping
    public ResponseEntity<Estudante> findAll(){
        Celular c = new Celular(1L, "99922233");
        Estudante e = new Estudante(1L,"Hemmerson", "2023221234", LocalDate.now(), "806 Sul","hemmerson@email.com");
        e.setCelulares(c);
        return ResponseEntity.ok().body(e);
    }
}
