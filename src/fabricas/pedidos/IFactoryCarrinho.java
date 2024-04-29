package fabricas.pedidos;

import domain.Cliente;
import domain.Produto;
import domain.pedidos.ProdutoCarrinho;

import java.util.List;

public interface IFactoryCarrinho {
    void adicionarCarrinho(Cliente cliente, Produto produto);
    void removerCarrinho(Cliente cliente, Produto produto);
    void limparCarrinho(Cliente cliente);
    List<ProdutoCarrinho> mostrarCarrinho(Cliente cliente);
    void finalizarPedido(Cliente cliente);
    void mostrarPedidos(Cliente cliente);
}
