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

public class LimparCarrinhoTest {

    private ClienteDao clienteDao;
    private ProdutoDao produtoDao;
    private Cliente mockCliente;
    private Produto mockProduto;
    private Produto mockProduto2;
    private final MockCliente mockCl = new MockCliente();
    private final MockProduto mockPr = new MockProduto();
    private final IFactoryCarrinho genericFactory = new FactoryCarrinho();

    @Before
    public void init() throws DaoException {
        clienteDao = new ClienteDao();
        clienteDao.listaElementos().clear();
        clienteDao = new ClienteDao();
        produtoDao = new ProdutoDao();
        produtoDao.listaElementos().clear();
        produtoDao = new ProdutoDao();
        mockCliente = mockCl.getMockCliente();
        mockProduto = mockPr.getMockProduto();
        mockProduto2 = mockPr.getMockProdutoNaoCadastrado();
    }
    @Test
    public void limparCarrinhoExpectSuccess() throws TipoChaveNaoEncontradaException, DaoException {
        clienteDao.cadastrar(mockCliente);
        produtoDao.cadastrar(mockProduto);
        produtoDao.cadastrar(mockProduto2);

        genericFactory.adicionarCarrinho(mockCliente, mockProduto);
        genericFactory.adicionarCarrinho(mockCliente, mockProduto2);
        Assert.assertEquals(2, mockCliente.verCarrinho().size());

        genericFactory.limparCarrinho(mockCliente);
        Assert.assertNull(mockCliente.verCarrinho());
        clienteDao.listaElementos().clear();
        produtoDao.listaElementos().clear();
    }
}
