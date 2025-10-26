package br.com.venda.api.service;

import br.com.venda.api.model.*;
import br.com.venda.api.repository.ItemPedidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidorRepository itemPedidorRepository;

    public ItemPedido salvar(ItemPedido itemPedido) {
        ItemPedido save = itemPedidorRepository.save(itemPedido);
        return save;
    }

    public List<ItemPedido> buscar(Pedido pedido){
        return itemPedidorRepository.findByPedido(pedido);
    }


    public void atualizar(ItemPedido itemPedido) {
        itemPedidorRepository.save(itemPedido);
    }
}
