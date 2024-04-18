package org.senai.lab365.magazinesenai.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(
            summary = "Cadastrar novo produto",
            description = "Cadastra novo produto",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Cadastro realizado"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Requisição com dados inválidos")
            }
    )
    @PostMapping
    public void cadastrar(@RequestBody Produto produto){
        produtoService.salvar(produto);
    }

    @Operation(
            summary = "Alterar dados de produto",
            description = "Altera os dados de um produto",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Cadastro atualizado"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Requisição com dados inválidos"),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Registro não encontrado")
            }
    )
    @PutMapping
    public void atualizar(@RequestBody Produto produto){
        produtoService.salvar(produto);
    }

    @Operation(
            summary = "Excluir produto",
            description = "Excluir um produto existente",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Exclusão realizada"),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Registro não encontrado")
            }
    )
    @DeleteMapping
    public void excluir(@RequestBody Produto produto){
        produtoService.excluir(produto);
    }

    @Operation(
            summary = "Consultar produtos",
            description = "Consulta todos os produtos registrados",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Consulta realizada")
            }
    )
    @GetMapping("/lista")
    public List<Produto> listarTodos(){
        return produtoService.buscarTodos();
    }

    @Operation(
            summary = "Consultar produto por id",
            description = "Consulta de produto pelo identificador",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Consulta realizada"),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Registro não encontrado")
            }
    )
    @GetMapping("/{produtoId}") // path parameter
    public Produto listarPorId(@PathVariable Long produtoId){
        return produtoService.buscarPorId(produtoId);
    }
}
