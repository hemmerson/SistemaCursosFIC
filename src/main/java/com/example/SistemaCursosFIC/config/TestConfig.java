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

        Estudante e3 = new Estudante();
        e3.setNome("Miguel");
        e3.setMatricula("20222233002");
        e3.setDataNascimento(LocalDate.parse("2007-01-01"));
        e3.setEndereco("806 Sul");
        e3.setEmailInstitucional("miguel@email.com");
        estudanteRepository.save(e3);

        Celular c1 = new Celular("999886655", e1);
        Celular c2 = new Celular("999872121", e2);

        Curso curso1 = new Curso("Introdução à programação", "100", "Disciplina do turno matutino de Palmas");
        Curso curso2 = new Curso("Teste de Software", "60", "Disciplina do turno matutino de Palmas");

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
