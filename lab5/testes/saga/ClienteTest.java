package saga;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saga.controlClientes.Cliente;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    private Cliente cliente;

    @BeforeEach
    void clientePadrao() {
        cliente = new Cliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
    }
    @Test
    void testToString() {
        assertEquals("rodrigo - lcc3 - rodrigo.cavalcanti@ccc.ufcg.edu.br", cliente.toString());

    }
}