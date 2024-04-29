package Servicos;

import dao.ClienteDao;
import domain.Cliente;
import domain.IPersistente;
import exception.DaoException;
import exception.TipoChaveNaoEncontradaException;
import fabricas.generic.GenericFactory;
import services.generic.GenericService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class ClientServiceTest<T extends IPersistente> {
    private Cliente cliente;
    private final ClienteDao clienteDao = new ClienteDao();
    private final GenericService<T> service;
    private GenericFactory<T> factory;

    public ClientServiceTest() {
        service = new GenericService<>();
        factory = new GenericFactory<>();
    }

    @Before
    public void init() throws DaoException {
        clienteDao.listaElementos().clear();
        cliente = new Cliente(1L,
                "Chico",
                "Bento",
                "123.123.123-12",
                "(41) 98642-4287",
                "Rua das Glórias",
                25L,
                "Natal",
                "RN");
    }

    @Test
    public void BuscarClienteExpectsSuccess() throws DaoException {
        factory.cadastrar((T) cliente);
        Cliente clienteConsultado = (Cliente) service.buscar((T) cliente);
        Assert.assertNotNull(clienteConsultado);
        cliente = null;
        factory = null;
        clienteDao.listaElementos().clear();
    }

    @Test
    public void AtualizarClienteExpectsSuccess() throws SQLException, TipoChaveNaoEncontradaException, DaoException {
        factory.cadastrar((T) cliente);
        Cliente clienteConsultado = (Cliente) service.buscar((T) cliente);
        Assert.assertNotNull(clienteConsultado);
        boolean retorno = service.atualizar((T) clienteConsultado, (T) clienteConsultado);
        Assert.assertTrue(retorno);
    }
}
