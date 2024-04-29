package fabricas;

import dao.ProdutoDao;
import domain.Produto;
import exception.DaoException;
import exception.TipoChaveNaoEncontradaException;
import fabricas.generic.GenericFactory;

public class FactoryProdutos extends GenericFactory<Produto> implements IFactoryProdutos {
    private final ProdutoDao produtoDao;

    public FactoryProdutos(ProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }

    @Override
    public boolean cadastrar(Produto produto) {
        try {
            produtoDao.cadastrar(produto);
        } catch (TipoChaveNaoEncontradaException | DaoException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
