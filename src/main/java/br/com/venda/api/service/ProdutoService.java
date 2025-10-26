package br.com.venda.api.service;

import br.com.venda.api.model.Produto;
import br.com.venda.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public void atualizar(Produto produto) {
        produtoRepository.save(produto);
    }

    public Optional<Produto> buscarPorId(Long idProduto) {
        return produtoRepository.findById(idProduto);
    }
}
