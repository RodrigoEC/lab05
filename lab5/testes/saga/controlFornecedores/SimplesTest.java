package saga.controlFornecedores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SimplesTest {
    private Simples simples;


    @BeforeEach
    void produtoPadrao() {
        simples = new Simples( "placebo", "placebo", 3.00);
    }

    @Test
    void testToString() {
        assertEquals("placebo - placebo - R$3,00", simples.toString());
    }

    @Test
    void comparaProdutosIguais() {
        Simples simplesGemeo = new Simples( "placebo", "placebo", 3.00);
        assertTrue(simples.equals(simplesGemeo));
    }

    @Test
    void comparaProdutosDiferenca() {
        Simples simples2 = new Simples( "lalala", "plalalal", 1.00);
        assertFalse(simples.equals(simples2));
    }

    @Test
    void comparaHashcodesIguais() {
        Simples simplesGemeo = new Simples( "placebo", "placebo", 3.00);
        assertTrue(simples.hashCode() == simplesGemeo.hashCode());
    }

    @Test
    void comparaHashcodesDiferentes() {
        Simples simples2 = new Simples( "lalala", "plalalal", 1.00);
        assertFalse(simples.hashCode() == simples2.hashCode());
    }
}