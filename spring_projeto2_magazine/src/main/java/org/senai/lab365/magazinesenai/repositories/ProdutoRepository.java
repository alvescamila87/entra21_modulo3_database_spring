package org.senai.lab365.magazinesenai.repositories;

import org.senai.lab365.magazinesenai.models.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    //@Query(value = "SELECT p FROM produtos p WHERE p.descricao = :descricao")
    public Produto findByDescricao(String descricao);

    // Não precisa de @Query (derived queries)
    public List<Produto> findByNome(String nome);
}
