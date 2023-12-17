package com.example.SistemaCursosFIC;

import com.example.SistemaCursosFIC.entities.Celular;
import com.example.SistemaCursosFIC.entities.Curso;
import com.example.SistemaCursosFIC.entities.Estudante;
import com.example.SistemaCursosFIC.entities.TurmaCurso;
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


	//TESTES PARA ESTUDANTE
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

	//TESTES PARA CURSO ================================================================

	@Test
	public void cadastrarCursoComCamposObrigatorios() {
		// Testa se é possível cadastrar um curso com todos os campos obrigatórios
		Curso curso = new Curso("Teste de Software", "60 horas", "Disciplina de teste de softwares");
		Curso novoCurso = cursoService.insert(curso);
		Assertions.assertNotNull(novoCurso.getId());
	}

	@Test
	public void cadastrarCursoSemCamposObrigatorios() {
		// Testa se o sistema gera uma exceção ao tentar cadastrar um curso sem campos obrigatórios
		Curso curso = new Curso();
		Assertions.assertThrows(IllegalArgumentException.class, () -> cursoService.insert(curso));
	}

	//TESTES PARA TURMACURSO ================================================================

	@Test
	public void cadastrarTurmaCursoComCamposObrigatorios() {
		// Testa se é possível cadastrar uma TurmaCurso com todos os campos obrigatórios
		String local = "Palmas/TO";
		LocalDate inicioMatriculas = LocalDate.parse("2023-06-20");
		LocalDate fimMatriculas = LocalDate.parse("2023-07-20");
		LocalDate inicioAulas = LocalDate.parse("2023-08-01");
		LocalDate fimAulas = LocalDate.parse("2023-12-15");
		TurmaCurso turma = new TurmaCurso(local,40,40,inicioAulas,fimAulas,inicioMatriculas,fimMatriculas);
		TurmaCurso novaTurma = turmaCursoService.insert(turma);
		Assertions.assertNotNull(novaTurma.getId());
	}

	@Test
	public void cadastrarTurmaCursoSemCamposObrigatorios() {
		// Testa se o sistema gera uma exceção ao tentar cadastrar uma TurmaCurso sem campos obrigatórios
		TurmaCurso turma = new TurmaCurso();
		Assertions.assertThrows(IllegalArgumentException.class, () -> turmaCursoService.insert(turma));
	}

	@Test
	public void cadastrarTurmaCursoComInicioMaiorFimMatriculas() {
		// Testa se é possível cadastrar uma TurmaCurso com o inicio da matricula após o fim de matricula
		String local = "Palmas/TO";
		LocalDate inicioMatriculas = LocalDate.parse("2023-08-20");
		LocalDate fimMatriculas = LocalDate.parse("2023-07-20");
		LocalDate inicioAulas = LocalDate.parse("2023-08-01");
		LocalDate fimAulas = LocalDate.parse("2023-12-15");
		TurmaCurso turma = new TurmaCurso(local,40,40,inicioAulas,fimAulas,inicioMatriculas,fimMatriculas);
		Assertions.assertThrows(IllegalArgumentException.class, () -> turmaCursoService.insert(turma));
	}

	@Test
	public void cadastrarTurmaCursoComInicioMaiorFimAulas() {
		// Testa se é possível cadastrar uma TurmaCurso com o inicio das aulas após o fim das aulas
		String local = "Palmas/TO";
		LocalDate inicioMatriculas = LocalDate.parse("2023-06-20");
		LocalDate fimMatriculas = LocalDate.parse("2023-07-20");
		LocalDate inicioAulas = LocalDate.parse("2023-08-01");
		LocalDate fimAulas = LocalDate.parse("2023-07-15");
		TurmaCurso turma = new TurmaCurso(local,40,40,inicioAulas,fimAulas,inicioMatriculas,fimMatriculas);
		Assertions.assertThrows(IllegalArgumentException.class, () -> turmaCursoService.insert(turma));
	}

	@Test
	public void cadastrarTurmaCursoComInicioMatriculaMaiorInicioAulas() {
		// Testa se é possível cadastrar uma TurmaCurso com o inicio das matriculas após o inicio das aulas
		String local = "Palmas/TO";
		LocalDate inicioMatriculas = LocalDate.parse("2023-08-02");
		LocalDate fimMatriculas = LocalDate.parse("2023-08-20");
		LocalDate inicioAulas = LocalDate.parse("2023-08-01");
		LocalDate fimAulas = LocalDate.parse("2023-12-15");
		TurmaCurso turma = new TurmaCurso(local,40,40,inicioAulas,fimAulas,inicioMatriculas,fimMatriculas);
		Assertions.assertThrows(IllegalArgumentException.class, () -> turmaCursoService.insert(turma));
	}

	
}
