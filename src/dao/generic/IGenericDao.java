package dao.generic;

import domain.IPersistente;
import exception.DaoException;
import exception.MaisDeUmRegistroException;
import exception.TableException;
import exception.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;

public interface IGenericDao <T extends IPersistente, E extends Serializable> {
    boolean cadastrar(T objeto) throws TipoChaveNaoEncontradaException, DaoException;
    T buscar(E valor) throws MaisDeUmRegistroException, TableException, DaoException;
    void excluir(E valor) throws DaoException, SQLException;
    void atualizar(T objeto) throws TipoChaveNaoEncontradaException, DaoException, SQLException;
    Collection<T> listaElementos() throws DaoException;
}
