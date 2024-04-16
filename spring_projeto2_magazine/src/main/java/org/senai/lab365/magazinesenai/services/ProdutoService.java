package org.senai.lab365.magazinesenai.services;

import org.senai.lab365.magazinesenai.models.Produto;
import org.senai.lab365.magazinesenai.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    // Recebendo o repository pronto (sem instanciar) e injetando a dependência via construtor
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    // Método salvar e atualizar (spring data fará o salvamento no banco)
    public void salvar(Produto produto){
        produtoRepository.save(produto);
    }

    // Método excluir
    public void excluir(Produto produto){
        produtoRepository.delete(produto);
    }

    // Método buscar todos os produtos
    public List<Produto> buscarTodos(){
        return (List<Produto>) produtoRepository.findAll(); // transforma interable em lista (realiza-se type casting)
    }

    // Método buscar por id
    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).get(); // retorna optional (por isso usar o .get()
    }
}
