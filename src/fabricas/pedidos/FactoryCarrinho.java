package fabricas.pedidos;

import domain.Cliente;
import domain.Produto;
import domain.pedidos.ProdutoCarrinho;

import java.util.List;

public class FactoryCarrinho implements IFactoryCarrinho {
    @Override
    public void adicionarCarrinho(Cliente cliente, Produto produto) {
        cliente.adicionarProduto(produto);
    }

    @Override
    public void removerCarrinho(Cliente cliente, Produto produto) {
        Produto produtoEncontrado = cliente.buscarNoCarrinho(produto);
        if (produtoEncontrado == null) throw new RuntimeException("Produto não existe no carrinho!");
        else cliente.removerProduto(produto);
    }

    @Override
    public void limparCarrinho(Cliente cliente) {
        cliente.limparCarrinho();
    }

    @Override
    public List<ProdutoCarrinho> mostrarCarrinho(Cliente cliente) {
        return cliente.verCarrinho();
    }

    @Override
    public void finalizarPedido(Cliente cliente) {
        cliente.adicionarPedido();
    }

    @Override
    public void mostrarPedidos(Cliente cliente) {

    }
}
