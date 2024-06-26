package fabricas.generic;

import dao.ClienteDao;
import dao.ProdutoDao;
import dao.generic.GenericDao;
import domain.Cliente;
import domain.IPersistente;
import exception.DaoException;
import exception.TipoChaveNaoEncontradaException;

import java.sql.SQLException;

public class GenericFactory<T extends IPersistente> implements IGenericFactory<T> {

    private GenericDao<T, Long> genericDao;
    private final ClienteDao clienteDao;
    private final ProdutoDao produtoDao;

    public GenericFactory() {
        clienteDao = new ClienteDao();
        produtoDao = new ProdutoDao();
    }

    @Override
    public boolean cadastrar(T objeto) {
        genericDao = getDao(objeto);
        try {
            genericDao.cadastrar(objeto);
        } catch (TipoChaveNaoEncontradaException | DaoException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean excluir(T objeto) {
        genericDao = getDao(objeto);
        try {
            genericDao.excluir(objeto.getId());
        } catch (DaoException | SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public GenericDao<T, Long> getDao(T objeto) {
        if (objeto.getClass() == Cliente.class) return (GenericDao<T, Long>) clienteDao;
        else return (GenericDao<T, Long>) produtoDao;
    }
}
