package saga.controlFornecedores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saga.controlFornecedores.Produto;
import static org.junit.jupiter.api.Assertions.*;


class ProdutoTest {
    private Produto produto;


    @BeforeEach
    void produtoPadrao() {
        produto = new Produto( "placebo", "placebo", 3.00);
    }

    @Test
    void testToString() {
        assertEquals("placebo - placebo - R$3,00", produto.toString());
    }

    @Test
    void comparaProdutosIguais() {
        Produto produtoGemeo = new Produto( "placebo", "placebo", 3.00);
        assertTrue(produto.equals(produtoGemeo));
    }

    @Test
    void comparaProdutosDiferenca() {
        Produto produto2 = new Produto( "lalala", "plalalal", 1.00);
        assertFalse(produto.equals(produto2));
    }

    @Test
    void comparaHashcodesIguais() {
        Produto produtoGemeo = new Produto( "placebo", "placebo", 3.00);
        assertTrue(produto.hashCode() == produtoGemeo.hashCode());
    }

    @Test
    void comparaHashcodesDiferentes() {
        Produto produto2 = new Produto( "lalala", "plalalal", 1.00);
        assertFalse(produto.hashCode() == produto2.hashCode());
    }
}