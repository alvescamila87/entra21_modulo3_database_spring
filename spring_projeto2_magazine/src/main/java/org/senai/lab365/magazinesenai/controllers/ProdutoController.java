package org.senai.lab365.magazinesenai.controllers;

import org.senai.lab365.magazinesenai.models.Produto;
import org.senai.lab365.magazinesenai.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos") // http://localhost:8080/produtos
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public void cadastrar(@RequestBody Produto produto){
        produtoService.salvar(produto);
    }

    @PutMapping
    public void atualizar(@RequestBody Produto produto){
        produtoService.salvar(produto);
    }

    @DeleteMapping
    public void excluir(@RequestBody Produto produto){
        produtoService.excluir(produto);
    }

    @GetMapping("/lista")
    public List<Produto> listarTodos(){
        return produtoService.buscarTodos();
    }

    @GetMapping("/{produtoId}") // path parameter
    public Produto listarPorId(@PathVariable Long produtoId){
        return produtoService.buscarPorId(produtoId);
    }
}
