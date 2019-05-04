package saga.controlFornecedores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saga.controlFornecedores.Produto;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProdutoTest {
    private Produto produto;


    @BeforeEach
    void produtoPadrao() {
        produto = new Produto("3,00", "placebo", "placebo");
    }

    @Test
    void testToString() {
        assertEquals("placebo - placebo - R$3,00", produto.toString());
    }
}