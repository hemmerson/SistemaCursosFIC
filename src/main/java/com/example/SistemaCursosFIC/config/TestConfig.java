package com.example.SistemaCursosFIC.config;

import com.example.SistemaCursosFIC.entities.Celular;
import com.example.SistemaCursosFIC.entities.Estudante;
import com.example.SistemaCursosFIC.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private EstudanteRepository estudanteRepository;


    @Override
    public void run(String... args) throws Exception {

        Estudante e1 = new Estudante("Hemmerson", "2023221234", LocalDate.now(), "806 Sul","hemmerson@email.com");
        Estudante e2 = new Estudante("Thaize", "2023221214", LocalDate.now(), "806 Sul","thaize@email.com");


        estudanteRepository.saveAll(Arrays.asList(e1,e2));
    }
}
