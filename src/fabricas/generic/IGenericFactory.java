package fabricas.generic;

import domain.IPersistente;

public interface IGenericFactory<T extends IPersistente> {
    boolean cadastrar(T objeto);
    boolean excluir(T objeto);
}
