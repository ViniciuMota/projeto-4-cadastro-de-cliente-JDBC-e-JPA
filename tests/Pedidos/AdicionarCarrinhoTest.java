package Pedidos;

import dao.ClienteDao;
import dao.ProdutoDao;
import domain.Cliente;
import domain.Produto;
import domain.mock.MockCliente;
import domain.mock.MockProduto;
import domain.pedidos.ProdutoCarrinho;
import exception.DaoException;
import exception.TipoChaveNaoEncontradaException;
import fabricas.pedidos.FactoryCarrinho;
import fabricas.pedidos.IFactoryCarrinho;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class AdicionarCarrinhoTest {

    private ClienteDao clienteDao;
    private ProdutoDao produtoDao;
    private Cliente mockCliente;
    private Produto mockProduto;
    private Produto mockProduto2;
    private final MockCliente mock = new MockCliente();
    private final IFactoryCarrinho genericFactory = new FactoryCarrinho();

    @Before
    public void init() throws DaoException {
        clienteDao = new ClienteDao();
        clienteDao.listaElementos().clear();
        clienteDao = new ClienteDao();
        produtoDao = new ProdutoDao();
        produtoDao.listaElementos().clear();
        produtoDao = new ProdutoDao();
        MockProduto mockPr = new MockProduto();
        mockCliente = mock.getMockCliente();
        mockProduto = mockPr.getMockProduto();
        mockProduto2 = mockPr.getMockProdutoNaoCadastrado();
    }
    @Test
    public void adicionarProdutoCarrinhoExpectSuccess() throws TipoChaveNaoEncontradaException, DaoException {
        clienteDao.cadastrar(mockCliente);
        produtoDao.cadastrar(mockProduto);
        produtoDao.cadastrar(mockProduto2);

        IFactoryCarrinho genericFactory = new FactoryCarrinho();
        genericFactory.adicionarCarrinho(mockCliente, mockProduto);
        genericFactory.adicionarCarrinho(mockCliente, mockProduto2);

        Assert.assertTrue(mockCliente.verCarrinho().stream()
                .anyMatch(produtoFisico -> produtoFisico.getNome().equals(mockProduto.getNome())));
        Assert.assertTrue(mockCliente.verCarrinho().stream()
                .anyMatch(produtoFisico -> produtoFisico.getNome().equals(mockProduto2.getNome())));
        clienteDao.listaElementos().clear();
        produtoDao.listaElementos().clear();
    }

    @Test
    public void adicionarProdutoRepetidoCarrinhoExpectSuccess() throws TipoChaveNaoEncontradaException, DaoException {
        clienteDao.cadastrar(mockCliente);
        produtoDao.cadastrar(mockProduto);

        genericFactory.adicionarCarrinho(mockCliente, mockProduto);
        genericFactory.adicionarCarrinho(mockCliente, mockProduto);

        Assert.assertEquals(1, mockCliente.verCarrinho().size());

        ProdutoCarrinho produtoCarrinho = mockCliente.verCarrinho().get(0);
        Assert.assertEquals(2, (long) produtoCarrinho.getQuantidade());
        Assert.assertEquals(produtoCarrinho.getPreco().multiply(BigDecimal.valueOf(produtoCarrinho.getQuantidade())),
                produtoCarrinho.getPrecoQuantidade());
        clienteDao.listaElementos().clear();
        produtoDao.listaElementos().clear();
    }

    @Test
    public void adicionarProdutosMistosCarrinhoExpectSuccess() throws TipoChaveNaoEncontradaException, DaoException {
        clienteDao.cadastrar(mockCliente);
        produtoDao.cadastrar(mockProduto);
        produtoDao.cadastrar(mockProduto2);

        genericFactory.adicionarCarrinho(mockCliente, mockProduto);
        genericFactory.adicionarCarrinho(mockCliente, mockProduto);
        genericFactory.adicionarCarrinho(mockCliente, mockProduto2);

        Assert.assertEquals(2, mockCliente.verCarrinho().size());

        List<ProdutoCarrinho> produtosRepetidos = mockCliente.verCarrinho().stream()
                .filter(produto -> Objects.equals(produto.getNome(), mockProduto.getNome())).toList();
        Assert.assertEquals(2, (long) produtosRepetidos.get(0).getQuantidade());

        List<ProdutoCarrinho> produtoUnico = mockCliente.verCarrinho().stream()
                .filter(produto -> Objects.equals(produto.getNome(), mockProduto2.getNome())).toList();
        Assert.assertEquals(1, (long) produtoUnico.get(0).getQuantidade());
        clienteDao.listaElementos().clear();
        produtoDao.listaElementos().clear();
    }
}
