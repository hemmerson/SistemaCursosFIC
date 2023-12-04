package com.example.SistemaCursosFIC.model.entity;

import java.time.LocalDate;
import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 03/12/2023
 */
public class Estudante {
    private Long id;
    private String nome;
    private String matricula;
    private LocalDate dataNascimento;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private Long numero;
    private String emailInstitucional;
    private List<Celular> celulares;

}
