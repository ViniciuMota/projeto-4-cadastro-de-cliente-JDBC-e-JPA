package Fabricas;

import dao.ProdutoDao;
import domain.Produto;
import fabricas.FactoryProdutos;
import fabricas.IFactoryProdutos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ProdutoFactoryTest {
    private final IFactoryProdutos produtoFactory;
    private Produto produto;

    public ProdutoFactoryTest() {
        ProdutoDao produtoDao = new ProdutoDao();
        produtoFactory = new FactoryProdutos(produtoDao);
    }

    @Before
    public void init() {
        produto = new Produto();
        produto.setNome("Xícara");
        produto.setDescricao("Uma xícara para um bom café");
        produto.setPreco(BigDecimal.valueOf(14.90));
    }

    @Test
    public void CadastrarClienteExpectsSuccess() {
        boolean retorno = produtoFactory.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

}
