package br.com.venda.api.controller;

import br.com.venda.api.model.Produto;
import br.com.venda.api.model.ProdutoContagem;
import br.com.venda.api.service.ProdutoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@Tag(name = "Produto", description = "Gerencia os produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService clienteService;

    @GetMapping
    public List<Produto> listarTodos(){
        return clienteService.listarTodos();
    }

    @GetMapping("/contagem")
    public ProdutoContagem contagem(){
        return clienteService.contar();
    }

}
