package saga.controlClientes;

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

    @Test
    void testClientesIguais() {
        Cliente clienteGemeo = new Cliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        assertTrue(cliente.equals(clienteGemeo));
    }

    @Test
    void testClientesDiferentes() {
        Cliente cliente2 = new Cliente("0734546859", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        assertTrue(!cliente.equals(cliente2));
    }

    @Test
    void testHashCodesIguais() {
        Cliente clienteGemeo = new Cliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        assertTrue(cliente.hashCode() == clienteGemeo.hashCode());
    }

    @Test
    void testHashCodesDiferentes() {
        Cliente cliente2 = new Cliente("0734546859", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        assertTrue(cliente.hashCode() != cliente2.hashCode());
    }
}