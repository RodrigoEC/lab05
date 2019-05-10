package saga;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvaliadorTest {
    private Avaliador avalia;

    @BeforeEach
    void avaliadorPadrao() {
        avalia = new Avaliador();
    }

    @Test
    void avaliaStringNull() {
        try {
            avalia.validaNome(null, "fornecedor");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void avaliaStringInvalida() {
        try {
            avalia.validaNome("  ", "fornecedor");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void avaliaPreco() {
        try {
            avalia.validaPrecoProduto(-3);
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void avaliaCPFGrande() {
        try {
            avalia.validarCPFCliente("182547896325");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void avaliaCPFPequeno() {
        try {
            avalia.validarCPFCliente("12455");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

}