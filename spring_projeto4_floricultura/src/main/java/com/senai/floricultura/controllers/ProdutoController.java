package com.senai.floricultura.controllers;

import com.senai.floricultura.models.Produto;
import com.senai.floricultura.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarProduto(){
        return produtoService.listarProdutos();
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarproduto(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.criarProduto(produto));
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long produtoId, @RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.atualizarProduto(produtoId, produto));
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Object> excluirProduto(@PathVariable Long produtoId){
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluído com sucesso");
    }
}
