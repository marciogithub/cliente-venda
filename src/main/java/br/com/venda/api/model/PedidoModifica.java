package br.com.venda.api.model;

import java.util.List;

public class PedidoModifica {

    private Long idPedido;
    private List<ProdutoVenda> itensPedidoVenda;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public List<ProdutoVenda> getItensPedidoVenda() {
        return itensPedidoVenda;
    }

    public void setItensPedidoVenda(List<ProdutoVenda> itensPedidoVenda) {
        this.itensPedidoVenda = itensPedidoVenda;
    }
}
