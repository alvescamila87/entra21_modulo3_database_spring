package br.com.labs365.livros.controller;

import br.com.labs365.livros.repository.LivroRepository;
import br.com.labs365.livros.model.Livro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Operation(
            summary = "Consultar Livros",
            description = "Consulta todos os livros registrados",
            responses = {
                            @ApiResponse(
                                    responseCode = "200",
                                    description = "Consulta realizada")
                        }
            )
    @GetMapping
    public ResponseEntity<List<Livro>> consultar() {
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(livros);
    }

    @Operation(
            summary = "Consultar Livros por id",
            description = "Consulta de livro pelo identificador",
            responses = {
                            @ApiResponse(
                                    responseCode = "200",
                                    description = "Consulta realizada"),
                            @ApiResponse(
                                    responseCode = "404",
                                    description = "Registro não encontrado")
                        }
            )
    @GetMapping("/{id}")
    public ResponseEntity<Livro> consultarPorId(@PathVariable Integer id){
        Livro livro = livroRepository.findById(id);
        return ResponseEntity.ok(livro);
    }

    @Operation(
            summary = "Cadastrar novo livro",
            description = "Cadastra novo livro",
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
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro){
        Livro livroInserido = livroRepository.insert(livro);
        URI uri = URI.create(livroInserido.getId().toString());
        return ResponseEntity.created(uri).body(livroInserido);
    }

    @Operation(
            summary = "Alterar dados de livro",
            description = "Altera os dados de um livro",
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
    @PutMapping("/{id}")
    public ResponseEntity<Livro> alterar(@PathVariable("id") Integer id, @RequestBody Livro livro) {
        livro.setId(id);
        Livro atualizado = livroRepository.update(livro);
        return ResponseEntity.ok(atualizado);
    }

    @Operation(
            summary = "Excluir livro",
            description = "Excluir um livro existente",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Exclusão realizada"),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Registro não encontrado")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable("id") Integer id) {
        livroRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

}
