package br.com.venda.api.repository;

import br.com.venda.api.model.ItemPedido;
import br.com.venda.api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPedidorRepository  extends JpaRepository<ItemPedido, Long> {

    List<ItemPedido> findByPedido(Pedido pedido);
}
