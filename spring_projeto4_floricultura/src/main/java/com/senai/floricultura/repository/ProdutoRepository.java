package com.senai.floricultura.repository;


import com.senai.floricultura.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // JPQL
    @Query(value = "SELECT nome FROM produto WHERE nome = ")
    Produto findByName(String nome);
}
