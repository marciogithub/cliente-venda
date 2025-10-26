package br.com.venda.api.service;

import br.com.venda.api.model.Produto;
import br.com.venda.api.model.ProdutoContagem;
import br.com.venda.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ProdutoContagem contar() {
        ProdutoContagem contagem = new ProdutoContagem();
        contagem.setContagemProdutos(produtoRepository.count());
        return contagem;
    }
}
