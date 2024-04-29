package Servicos;

import dao.ProdutoDao;
import domain.IPersistente;
import domain.Produto;
import exception.DaoException;
import exception.TipoChaveNaoEncontradaException;
import fabricas.FactoryProdutos;
import services.generic.GenericService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;

public class ProdutoServiceTest<T extends IPersistente> {
    private Produto produto;
    private final ProdutoDao produtoDao = new ProdutoDao();
    private final GenericService<T> service;
    private FactoryProdutos factoryProdutos;

    public ProdutoServiceTest() {
        service = new GenericService<>();
    }

    @Before
    public void init() throws DaoException {
        produtoDao.listaElementos().clear();
        factoryProdutos = new FactoryProdutos(produtoDao);
        produto = null;
        produto = new Produto(1L,
                "Lápis de Cor",
                "Precisamos escrever nessa vida.",
                BigDecimal.valueOf(2.80),
                8);
    }

    @Test
    public void BuscarProdutoExpectsSuccess() throws DaoException {
        factoryProdutos.cadastrar(produto);
        Produto produtoConsultado = (Produto) service.buscar((T) produto);
        Assert.assertNotNull(produtoConsultado);
        produto = null;
        produtoDao.listaElementos().clear();
    }

    @Test
    public void AtualizarProdutoExpectsSuccess() throws SQLException, TipoChaveNaoEncontradaException, DaoException {
        factoryProdutos.cadastrar(produto);
        Produto produtoConsultado = (Produto) service.buscar((T) produto);
        boolean retorno = service.atualizar((T) produtoConsultado, (T) produtoConsultado);
        Assert.assertTrue(retorno);
    }
}
