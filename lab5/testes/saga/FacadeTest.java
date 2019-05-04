package saga;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {
    private Facade facade;

    @BeforeEach
    void facadePadrao() {
        facade = new Facade();
    }

    @Test
    void testCadastraClientePadrao() {
        assertEquals("07345161420", facade.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc2"));
    }

    @Test
    void testCadastraClienteParametrosInvalidos() {
        try {

        } catch (IllegalArgumentException iae) {
        }
    }

}