package com.example.SistemaCursosFIC.config;

import com.example.SistemaCursosFIC.entities.Celular;
import com.example.SistemaCursosFIC.entities.Estudante;
import com.example.SistemaCursosFIC.repositories.CelularRepository;
import com.example.SistemaCursosFIC.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private CelularRepository celularRepository;


    @Override
    public void run(String... args) throws Exception {
        Estudante e1 = new Estudante("Hemmerson", "2023221234", LocalDate.parse("1989-05-04"), "806 Sul","hemmerson@email.com");
        Estudante e2 = new Estudante("Thaize", "2023221214", LocalDate.parse("1989-11-01"), "806 Sul","thaize@email.com");

        Celular c1 = new Celular("999886655", e1);
        Celular c2 = new Celular("999872121", e2);

        estudanteRepository.saveAll(Arrays.asList(e1,e2));
        celularRepository.saveAll(Arrays.asList(c1,c2));
    }
}
