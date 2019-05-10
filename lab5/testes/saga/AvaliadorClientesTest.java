package saga;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvaliadorClientesTest {
    private AvaliadorClientes avalia;

    @BeforeEach
    void avaliadorPadrao() {
        avalia = new AvaliadorClientes();
    }

    @Test
    void avaliaStringNull() {
        try {
            avalia.avaliar(null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void avaliaStringInvalida() {
        try {
            avalia.avaliar("  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

}