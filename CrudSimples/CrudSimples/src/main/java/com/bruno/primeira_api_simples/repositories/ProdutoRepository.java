package com.bruno.primeira_api_simples.repositories;
import java.util.Optional;
import com.bruno.primeira_api_simples.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;
//tem que criar um repository para um codigo com banco de dados, ele vai entrar em contato com banco de dados

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}