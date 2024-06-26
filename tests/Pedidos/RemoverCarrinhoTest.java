package Pedidos;

import dao.ClienteDao;
import dao.ProdutoDao;
import domain.Cliente;
import domain.Produto;
import domain.mock.MockCliente;
import domain.mock.MockProduto;
import exception.DaoException;
import exception.TipoChaveNaoEncontradaException;
import fabricas.pedidos.FactoryCarrinho;
import fabricas.pedidos.IFactoryCarrinho;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RemoverCarrinhoTest {

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
    public void removerItemCarrinhoExpectSuccess() throws TipoChaveNaoEncontradaException, DaoException {
        clienteDao.cadastrar(mockCliente);
        produtoDao.cadastrar(mockProduto);

        genericFactory.adicionarCarrinho(mockCliente, mockProduto);
        Assert.assertEquals(1, mockCliente.verCarrinho().size());

        genericFactory.removerCarrinho(mockCliente, mockProduto);
        Assert.assertNull(mockCliente.verCarrinho());
        clienteDao.listaElementos().clear();
        produtoDao.listaElementos().clear();
    }

    @Test(expected = RuntimeException.class)
    public void removerItemAusenteCarrinhoExpectError() throws TipoChaveNaoEncontradaException, DaoException {
        clienteDao.cadastrar(mockCliente);
        produtoDao.cadastrar(mockProduto);
        produtoDao.cadastrar(mockProduto2);

        genericFactory.adicionarCarrinho(mockCliente, mockProduto);
        Assert.assertEquals(1, mockCliente.verCarrinho().size());

        genericFactory.removerCarrinho(mockCliente, mockProduto2);
        clienteDao.listaElementos().clear();
        produtoDao.listaElementos().clear();
    }
}
