package services.generic;


import domain.IPersistente;
import exception.DaoException;
import exception.TipoChaveNaoEncontradaException;

import java.sql.SQLException;

public interface IGenericService<T extends IPersistente> {
    T buscar(T objeto);
    boolean atualizar(T objeto1, T objeto2) throws SQLException, TipoChaveNaoEncontradaException, DaoException;
}
