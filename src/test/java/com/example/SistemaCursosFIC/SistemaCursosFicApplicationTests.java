package com.example.SistemaCursosFIC;

import com.example.SistemaCursosFIC.entities.Celular;
import com.example.SistemaCursosFIC.entities.Estudante;
import com.example.SistemaCursosFIC.services.CursoService;
import com.example.SistemaCursosFIC.services.EstudanteService;
import com.example.SistemaCursosFIC.services.TurmaCursoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SistemaCursosFicApplicationTests {

	@Autowired
	private EstudanteService estudanteService;

	@Autowired
	private CursoService cursoService;

	@Autowired
	private TurmaCursoService turmaCursoService;

	@Test
	public void cadastrarEstudanteComCamposObrigatorios() {
		// Testa se é possível cadastrar um estudante com todos os campos obrigatórios
		Celular c1 = new Celular();
		Celular c2 = new Celular();
		c1.setNumero("(63)98877-6655");
		c2.setNumero("(63)99884-4455");
		List<Celular> celulares = new ArrayList<>();
		celulares.add(c1);
		celulares.add(c2);
		Estudante estudante = new Estudante("Nome", "Matricula", LocalDate.now().minusYears(15), "Endereco", "email@example.com", celulares);
		Estudante novoEstudante = estudanteService.insert(estudante);
		Assertions.assertNotNull(novoEstudante.getId());
	}

	@Test
	public void cadastrarEstudanteSemCamposObrigatorios() {
		// Testa se o sistema gera uma exceção ao tentar cadastrar um estudante sem campos obrigatórios
		Estudante estudante = new Estudante();
		Assertions.assertThrows(IllegalArgumentException.class, () -> estudanteService.insert(estudante));
	}

	@Test
	public void cadastrarEstudanteComIdadeInferiorA15Anos() {
		// Testa se o sistema gera uma exceção ao tentar cadastrar um estudante com idade inferior a 15 anos
		Estudante estudante = new Estudante("Nome", "Matricula", LocalDate.now().minusYears(14), "Endereco", "email@example.com");
		Assertions.assertThrows(IllegalArgumentException.class, () -> estudanteService.insert(estudante));
	}

	
}
