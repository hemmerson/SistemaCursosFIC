package com.example.SistemaCursosFIC.repositories;

import com.example.SistemaCursosFIC.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
