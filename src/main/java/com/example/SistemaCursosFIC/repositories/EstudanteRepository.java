package com.example.SistemaCursosFIC.repositories;

import com.example.SistemaCursosFIC.entities.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}
