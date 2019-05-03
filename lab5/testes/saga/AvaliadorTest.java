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