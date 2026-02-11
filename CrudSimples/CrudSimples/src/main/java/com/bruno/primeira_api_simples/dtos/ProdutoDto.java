package com.bruno.primeira_api_simples.dtos;

// DTOs: Ele existe só pra transportar dados entre camadas do sistema.

// Record usado como DTO para transportar dados de forma simples e imutável entre camadas da aplicação


public record ProdutoDto(String nome, Long preco) {
}
