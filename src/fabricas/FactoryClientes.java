package fabricas;

import domain.Cliente;
import fabricas.generic.GenericFactory;
import services.ProdutoService;
import services.generic.SingletonClass;

public class FactoryClientes extends GenericFactory<Cliente> implements IFactoryClientes {
    public FactoryClientes() {
        super();
        Class classeInterna = SingletonClass.getInstance().getClasse();
        if (classeInterna == null) {
            SingletonClass.getInstance().setClasse(ProdutoService.class);
        }
    }
}
