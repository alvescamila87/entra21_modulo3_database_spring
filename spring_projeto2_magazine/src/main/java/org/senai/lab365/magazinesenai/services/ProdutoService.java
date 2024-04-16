package org.senai.lab365.magazinesenai.services;

import org.senai.lab365.magazinesenai.models.Produto;
import org.senai.lab365.magazinesenai.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    // Recebendo o repository pronto (sem instanciar) e injetando a dependência via construtor
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    // Método salvar (spring data fará o salvamento no banco)
    public void salvar(Produto produto){
        produtoRepository.save(produto);
    }
}
