package saga.controlFornecedores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    private Produto simples;


    @BeforeEach
    void produtoPadrao() {
        simples = new Produto( "placebo", "placebo", 3.00);
    }

    @Test
    void testToString() {
        assertEquals("placebo - placebo - R$3,00", simples.toString());
    }

    @Test
    void comparaProdutosIguais() {
        Produto simplesGemeo = new Produto( "placebo", "placebo", 3.00);
        assertTrue(simples.equals(simplesGemeo));
    }

    @Test
    void comparaProdutosDiferenca() {
        Produto simples2 = new Produto( "lalala", "plalalal", 1.00);
        assertFalse(simples.equals(simples2));
    }

    @Test
    void comparaHashcodesIguais() {
        Produto simplesGemeo = new Produto( "placebo", "placebo", 3.00);
        assertTrue(simples.hashCode() == simplesGemeo.hashCode());
    }

    @Test
    void comparaHashcodesDiferentes() {
        Produto simples2 = new Produto( "lalala", "plalalal", 1.00);
        assertFalse(simples.hashCode() == simples2.hashCode());
    }

}