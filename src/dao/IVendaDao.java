package dao;

import dao.generic.IGenericDao;
import domain.Venda;
import exception.DaoException;
import exception.TipoChaveNaoEncontradaException;

public interface IVendaDao extends IGenericDao<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DaoException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DaoException;
}
