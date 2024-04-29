import Fabricas.ClientFactoryTest;
import Fabricas.ProdutoFactoryTest;
import Pedidos.AdicionarCarrinhoTest;
import Pedidos.LimparCarrinhoTest;
import Pedidos.RemoverCarrinhoTest;
import Pedidos.VerCarrinhoVazioTest;
import Servicos.ClientServiceTest;
import Servicos.ProdutoServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ AdicionarCarrinhoTest.class, RemoverCarrinhoTest.class, LimparCarrinhoTest.class, VerCarrinhoVazioTest.class,
                    ClientServiceTest.class, ProdutoServiceTest.class,
                    ClientFactoryTest.class, ProdutoFactoryTest.class})
public class AllTests {
}
