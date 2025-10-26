package br.com.venda.api.model;

import java.util.List;

public class PedidoNovo {

    private Long idCliente;
    private List<ProdutoVenda> itensPedidoVenda;


    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<ProdutoVenda> getItensPedidoVenda() {
        return itensPedidoVenda;
    }

    public void setItensPedidoVenda(List<ProdutoVenda> itensPedidoVenda) {
        this.itensPedidoVenda = itensPedidoVenda;
    }
}
