package org.senai.lab365.magazinesenai.repositories;

import org.senai.lab365.magazinesenai.models.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
