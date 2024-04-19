package com.senai.floricultura.services;

import com.senai.floricultura.models.Produto;
import com.senai.floricultura.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto atualizarProduto(Long id, Produto produto){
        if(!produtoRepository.existsById(id)){
            throw new RuntimeException("Produto não encontrado! ID: " + id);
        }
        produto.setIdProduto(id);
        return produtoRepository.save(produto);
    }


}
