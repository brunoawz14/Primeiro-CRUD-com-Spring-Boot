package com.bruno.primeira_api_simples.Controller;

import com.bruno.primeira_api_simples.dtos.ProdutoDto;

import com.bruno.primeira_api_simples.model.Produto;
import com.bruno.primeira_api_simples.repositories.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping
    public ResponseEntity getAll () {
        List<Produto> listprodutos = repository.findAll();
                return ResponseEntity.status(HttpStatus.OK).body(listprodutos);

                //esta retornando uma reposta do tipo http OK, e o corpo dessa reposta vai ser a Lista de produto
    }

    // Espeficando em especifico o registro da base q eu quero trazer na minha reposta.

    @GetMapping("/{id}")
    public ResponseEntity getById (@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ProdutoDto dto) {
        var produto = new Produto();
        BeanUtils.copyProperties(dto, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build(); //404 not found - n encontrou
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build(); //204 not found - deletou
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(
            @PathVariable Long id,
            @RequestBody ProdutoDto dto) {

        Optional<Produto> optionalProduto = repository.findById(id);

        if (optionalProduto.isEmpty()) {
            return ResponseEntity.notFound().build(); //404 Se n existir
        }

        Produto produto = optionalProduto.get();
        BeanUtils.copyProperties(dto, produto);

        Produto atualizado = repository.save(produto);
        return ResponseEntity.ok(atualizado); // 200 existe
    }
}
