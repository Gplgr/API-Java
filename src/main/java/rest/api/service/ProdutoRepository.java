package rest.api.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rest.api.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}