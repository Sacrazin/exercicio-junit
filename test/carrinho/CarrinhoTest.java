package carrinho;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {
    private Carrinho carrinho;
    private Produto p1;
    private Produto p2;

    @BeforeEach
    public void setUp() {
        carrinho = new Carrinho();
        p1 = new Produto("Livro", 50.0);
        p2 = new Produto("Caneta", 5.0);
    }

    @Test
    public void testAdicionarItem() {
        carrinho.addItem(p1);
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    public void testValorTotal() {
        carrinho.addItem(p1);
        carrinho.addItem(p2);
        assertEquals(55.0, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    public void testRemoverItem() throws ProdutoNaoEncontradoException {
        carrinho.addItem(p1);
        carrinho.addItem(p2);
        carrinho.removeItem(p1);
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    public void testEsvaziarCarrinho() {
        carrinho.addItem(p1);
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
    }
}