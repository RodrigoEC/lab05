package saga.controlClientes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saga.controlClientes.ControllerClientes;

import static org.junit.jupiter.api.Assertions.*;

class ControllerClientesTest {
    private ControllerClientes clientes;

    @BeforeEach
    void inicializadorPadrao() {
        clientes = new ControllerClientes();

    }

    // Testes CadastraCliente
    @Test
    void testCadastraClientePadrao() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        assertTrue(clientes.getClientes().containsKey("07345161420"));
    }

    @Test
    void tesCadastraClienteJaCadastrado() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

    }

    @Test
    void testCadastraClienteParametrosNulos() {
        try {
            clientes.cadastraCliente(null, "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {

        }

        try {
            clientes.cadastraCliente("07345161420", null, "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {

        }

        try {
            clientes.cadastraCliente("07345161420", "rodrigo", null, "lcc3");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {

        }

        try {
            clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {

        }
    }

    @Test
    void testCadastraClienteParametrosInvalidos() {

        try {
            clientes.cadastraCliente("07345161420", " ", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            clientes.cadastraCliente("07345161420", "rodrigo", "", "lcc3");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "    ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }



    // Testes dadosCliente

    @Test
    void testDadosDoClientePadrao() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        assertEquals("rodrigo - lcc3 - rodrigo.cavalcanti@ccc.ufcg.edu.br", clientes.dadosCliente("07345161420"));
    }

    // Testedo metodo "dadosTodosClientes"

    @Test
    void testDadosDeTodosOsClientesPadrao() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        clientes.cadastraCliente("073451614", "rodro", "rodrigo.cavalcanti@ccc.ufg.edu.br", "lcc2");
        assertEquals("rodro - lcc2 - rodrigo.cavalcanti@ccc.ufg.edu.br | rodrigo - lcc3 - rodrigo.cavalcanti@ccc.ufcg.edu.br", clientes.dadosTodosClientes());
    }

    @Test
    void testDadosClientesVazio() {
        assertEquals("", clientes.dadosTodosClientes());
    }

    // Testeando metodo "editaNome"

    @Test
    void testEditaNomePadrao() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        clientes.editaNome("07345161420", "pablo escobar");
        assertEquals("pablo escobar", clientes.getClientes().get("07345161420").getNome());
    }

    @Test
    void testEditarNomeNulo() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.editaNome("07345161420", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

    }

    @Test
    void tesEditarNomeInvalido() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.editaNome("07345161420", "  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

    }

    // testando o metodo "editaEmail"

    @Test
    void testEditaEmailPadrao() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        clientes.editaEmail("07345161420", "rodrigolegal@marara.com");
        assertEquals("rodrigolegal@marara.com", clientes.getClientes().get("07345161420").getEmail());
    }

    @Test
    void testEditarEmailNulo() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.editaEmail("07345161420", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            clientes.editaEmail(null, "ororor");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void tesEditarEmailInvalido() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.editaEmail("07345161420", "  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            clientes.editaEmail(" ", "ellelelfl");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }


    // testando o metodo "editaLocal"

    @Test
    void testEditarLocal() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        clientes.editaLocal("07345161420", "lcc1");
        assertEquals("lcc1", clientes.getClientes().get("07345161420").getLocalizacao());
    }

    @Test
    void testEditarLocalNulo() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.editaLocal("07345161420", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            clientes.editaLocal(null, "llc1");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testEditarLocalInvalido() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.editaLocal("07345161420", "  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            clientes.editaLocal("", "lacc");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    // Teste para o metodo "removeCliente"

    @Test
    void testRemoveCliente() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        clientes.removeCliente("07345161420");
        assertFalse(clientes.getClientes().containsKey("07345161420"));
    }
}