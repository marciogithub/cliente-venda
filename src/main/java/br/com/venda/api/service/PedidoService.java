package br.com.venda.api.service;

import br.com.venda.api.model.*;
import br.com.venda.api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoService itemPedidoService;

    public Pedido salvarPedido(PedidoNovo pedidoNovo) throws Exception {

        Optional<Cliente> cliente = clienteService.bucarPorId(pedidoNovo.getIdCliente());
        List<Produto> produtos = produtoService.listarTodos();
        Pedido pedido = new Pedido();

        pedido.setEstadoPedido(EstadoPedido.CRIADO);
        pedido.setCliente(cliente.get());
        pedido.setData(LocalDateTime.now());

        BigDecimal valorTotalPedido = this.getValorTotal(pedidoNovo.getItensPedidoVenda(), produtos);
        pedido.setValorTotal(valorTotalPedido);

        this.salvar(pedido);
        salvarItens(pedidoNovo, produtos, pedido);

        return pedido;
    }

    private void salvarItens(PedidoNovo pedidoNovo, List<Produto> produtos, Pedido pedido) throws Exception {

        for (Produto produto : produtos) {
            List<ProdutoVenda> itensPedidoVenda = pedidoNovo.getItensPedidoVenda();
            for (ProdutoVenda produtoVenda : itensPedidoVenda) {

                if(produto.getId().equals(produtoVenda.getIdProduto())){

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);

                    if(produtoVenda.getQuantidade() <= produto.getEstoque()){
                        itemPedido.setQuantidade(produtoVenda.getQuantidade());
                       this.atualizarProduto(produto, produtoVenda.getQuantidade());
                    }else{
                        throw new Exception("Produto não esta disponivel em estoque");
                    }
                    itemPedidoService.salvar(itemPedido);
                    pedido.getItemPedidos().add(itemPedido);
                }
            }
        }
    }

    private void atualizarProduto(Produto produto, Integer quantiade) {
        produto.setEstoque(produto.getEstoque() - quantiade);
        produtoService.atualizar(produto);
    }

    private static BigDecimal getValorTotal(List<ProdutoVenda> intesPedidoVenda, List<Produto> produtos) {
        BigDecimal valorTotalPedido = new BigDecimal(0);
        for (Produto produto : produtos) {
            for (ProdutoVenda produtoVenda : intesPedidoVenda) {
                if (produto.getId().equals(produtoVenda.getIdProduto())) {
                    BigDecimal multiplica = new BigDecimal(produtoVenda.getQuantidade());
                    valorTotalPedido = valorTotalPedido.add(produto.getValor().multiply(multiplica));
                }
            }
        }
        return valorTotalPedido;
    }

    public Pedido salvar(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public Optional<Pedido> buscaPorId(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido;
    }

    public Pedido atualizarPedido(PedidoModifica pedidoModifica) {
        List<Produto> produtos = produtoService.listarTodos();
        Optional<Pedido> pedidoAtual = this.buscaPorId(pedidoModifica.getIdPedido());

        BigDecimal valorTotalPedido = this.getValorTotal(pedidoModifica.getItensPedidoVenda(), produtos);

        for (ItemPedido itemPedidoAtual : pedidoAtual.get().getItemPedidos()) {
            for (ProdutoVenda produtoVenda : pedidoModifica.getItensPedidoVenda()) {
                if(itemPedidoAtual.getProduto().getId().equals(produtoVenda.getIdProduto())){
                    itemPedidoAtual.setQuantidade(produtoVenda.getQuantidade());
                    this.atualizarProduto(itemPedidoAtual.getProduto(), produtoVenda.getQuantidade());
                    itemPedidoService.atualizar(itemPedidoAtual);
                }
            }
        }
        pedidoAtual.get().setValorTotal(valorTotalPedido);
        salvar(pedidoAtual.get());
        return pedidoAtual.get();
    }

    public void cancelar(Long id) {
        Optional<Pedido> pedido = this.buscaPorId(id);
        pedido.get().setEstadoPedido(EstadoPedido.CANCELADO);
        salvar(pedido.get());
    }
}
