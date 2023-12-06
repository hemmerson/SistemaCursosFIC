package com.example.SistemaCursosFIC.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 03/12/2023
 */
@Entity
@Table(name = "tb_estudante")
public class Estudante implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String matricula;
    private LocalDate dataNascimento;
    private String endereco;
    private String emailInstitucional;

    @OneToMany(mappedBy = "estudante")
    private List<Celular> celulares = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "estudanteMatriculado")
    private List<EstudantesMatriculados> matriculas = new ArrayList<>();

    public Estudante() {
    }

    public Estudante(Long id, String nome, String matricula, LocalDate dataNascimento, String endereco, String emailInstitucional) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.emailInstitucional = emailInstitucional;
    }

    public Estudante(String nome, String matricula, LocalDate dataNascimento, String endereco, String emailInstitucional) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.emailInstitucional = emailInstitucional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmailInstitucional() {
        return emailInstitucional;
    }

    public void setEmailInstitucional(String emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }

    public List<Celular> getCelulares() {
        return celulares;
    }

    public List<EstudantesMatriculados> getMatriculas() {
        return matriculas;
    }

    public void adicionaMatriculas(EstudantesMatriculados matriculas) {
        this.matriculas.add(matriculas);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudante estudante = (Estudante) o;
        return Objects.equals(id, estudante.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
