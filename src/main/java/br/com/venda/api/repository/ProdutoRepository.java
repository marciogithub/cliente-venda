package br.com.venda.api.repository;


import br.com.venda.api.model.Cliente;
import br.com.venda.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}