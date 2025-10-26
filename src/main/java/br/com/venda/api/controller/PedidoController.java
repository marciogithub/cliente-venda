package br.com.venda.api.controller;

import br.com.venda.api.model.Pedido;
import br.com.venda.api.model.PedidoModifica;
import br.com.venda.api.model.PedidoNovo;
import br.com.venda.api.service.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pedido")
@Tag(name = "Pedido", description = "Gerencia os pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido salvar(@RequestBody PedidoNovo pedidoNovo) throws Exception {
        if(pedidoNovo.getIdCliente() == null){
            throw new Exception("Infomre cliente para o pedido");
        }
        if(pedidoNovo.getItensPedidoVenda() == null){
            throw new Exception("Infomre itens para o pedido");
        }
        return pedidoService.salvarPedido(pedidoNovo);
    }

    @PutMapping
    public Pedido atualizar(@RequestBody PedidoModifica pedidoModifica) throws Exception {
        if(pedidoModifica.getIdPedido() == null){
            throw new Exception("Infomre pedido para atualizar");
        }
        if(pedidoModifica.getItensPedidoVenda() == null){
            throw new Exception("Infomre itens para atualizar pedido");
        }
        return pedidoService.atualizarPedido(pedidoModifica);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) throws Exception {
        if(id == null){
            throw new Exception("Infomre pedido para exclusao");
        }
        pedidoService.cancelar(id);
    }

    @GetMapping("/{id}")
    public Optional<Pedido> buscarPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.buscaPorId(id);
        return pedido;
    }


}
