package services;

import domain.Cliente;
import services.generic.GenericService;
import services.generic.SingletonClass;

public class ClienteService extends GenericService<Cliente> implements IClienteService {
    public ClienteService() {
        super();
        Class classeInterna = SingletonClass.getInstance().getClasse();
        if (classeInterna == null) {
            SingletonClass.getInstance().setClasse(ClienteService.class);
        }
    }
}
