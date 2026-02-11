package com.bruno.primeira_api_simples.model;

import jakarta.persistence.*;

@Entity(name = "produto")
@Table(name = "produto")

public class Produto {
    //Atributos que um produto tem que ter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long preco;


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
    public Long getPreco() {
        return preco;
    }
    public void setPreco(Long preco) {
        this.preco = preco;
    }
}

