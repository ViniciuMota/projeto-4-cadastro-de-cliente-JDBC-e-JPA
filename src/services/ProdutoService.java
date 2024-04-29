package services;

import domain.Produto;
import services.generic.GenericService;
import services.generic.SingletonClass;

public class ProdutoService extends GenericService<Produto> implements IProdutoService {

    public ProdutoService() {
        super();
        Class classeInterna = SingletonClass.getInstance().getClasse();
        if (classeInterna == null) {
            SingletonClass.getInstance().setClasse(ProdutoService.class);
        }
    }

}
