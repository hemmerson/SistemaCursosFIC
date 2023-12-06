package com.example.SistemaCursosFIC.config;

import com.example.SistemaCursosFIC.entities.Celular;
import com.example.SistemaCursosFIC.entities.Curso;
import com.example.SistemaCursosFIC.entities.Estudante;
import com.example.SistemaCursosFIC.entities.TurmaCurso;
import com.example.SistemaCursosFIC.repositories.CelularRepository;
import com.example.SistemaCursosFIC.repositories.CursoRepository;
import com.example.SistemaCursosFIC.repositories.EstudanteRepository;
import com.example.SistemaCursosFIC.repositories.TurmaCursoRepository;
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

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TurmaCursoRepository turmaRepository;


    @Override
    public void run(String... args) throws Exception {
        Estudante e1 = new Estudante("Hemmerson", "2023221234", LocalDate.parse("1989-05-04"), "806 Sul","hemmerson@email.com");
        Estudante e2 = new Estudante("Thaize", "2023221214", LocalDate.parse("1989-11-01"), "806 Sul","thaize@email.com");

        Celular c1 = new Celular("999886655", e1);
        Celular c2 = new Celular("999872121", e2);

        Curso curso1 = new Curso("Sistemas para Internet", "1940", "Curso de Sistemas para Internet de Palmas");
        Curso curso2 = new Curso("Enhenharia Civil", "2540", "Curso de Engenharia Civil de Palmas");

        TurmaCurso tc1 = new TurmaCurso("Palmas",40,40,LocalDate.parse("2024-01-17"),LocalDate.parse("2024-07-15"),
                LocalDate.parse("2024-01-03"),LocalDate.parse("2024-01-15"),curso1);
        TurmaCurso tc2 = new TurmaCurso("Palmas",40,40,LocalDate.parse("2024-01-17"),LocalDate.parse("2024-07-15"),
                LocalDate.parse("2024-01-03"),LocalDate.parse("2024-01-15"),curso2);

        cursoRepository.saveAll(Arrays.asList(curso1,curso2));
        turmaRepository.saveAll(Arrays.asList(tc1,tc2));

        estudanteRepository.saveAll(Arrays.asList(e1,e2));
        celularRepository.saveAll(Arrays.asList(c1,c2));
    }
}
