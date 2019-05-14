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
            iae.printStackTrace();
        }

    }

    @Test
    void testCadastraClienteParametrosNulos() {
        try {
            clientes.cadastraCliente(null, "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();


        }

        try {
            clientes.cadastraCliente("07345161420", null, "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();


        }

        try {
            clientes.cadastraCliente("07345161420", "rodrigo", null, "lcc3");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();


        }

        try {
            clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();


        }
    }

    @Test
    void testCadastraClienteParametrosInvalidos() {

        try {
            clientes.cadastraCliente("07345161420", " ", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            clientes.cadastraCliente("07345161420", "rodrigo", "", "lcc3");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "    ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }



    //TESTANDO O METODO "dadosCliente"

    @Test
    void testDadosDoClientePadrao() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        assertEquals("rodrigo - lcc3 - rodrigo.cavalcanti@ccc.ufcg.edu.br", clientes.dadosCliente("07345161420"));
    }

    //TESTANDO O METODO "dadosTodosClientes"

    @Test
    void testDadosDeTodosOsClientesPadrao() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        clientes.cadastraCliente("07345161422", "rodro", "rodrigo.cavalcanti@ccc.ufg.edu.br", "lcc2");
        assertEquals("rodrigo - lcc3 - rodrigo.cavalcanti@ccc.ufcg.edu.br | rodro - lcc2 - rodrigo.cavalcanti@ccc.ufg.edu.br", clientes.dadosTodosClientes());
    }

    @Test
    void testDadosClientesVazio() {
        assertEquals("", clientes.dadosTodosClientes());
    }

    //TESTANDO O METODO "editaCliente"

    @Test
    void testEditaNome() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        clientes.editaCliente("07345161420", "nome", "gretchen");
        assertEquals("gretchen", clientes.getClientes().get("07345161420").getNome());
    }

    @Test
    void testEditaNomeInvalido() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.editaCliente("07345161420", "nome", " ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testEditaNomeNulo() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.editaCliente("07345161420", "nome", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();

        }
    }


    @Test
    void testEditaEmail() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        clientes.editaCliente("07345161420", "email", "gretchen");
        assertEquals("gretchen", clientes.getClientes().get("07345161420").getEmail());
    }

    @Test
    void testEditaEmailInvalido() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.editaCliente("07345161420", "email", " ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testEditaEmailNulo() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.editaCliente("07345161420", "email", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();

        }
    }

    @Test
    void testEditaLocal() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        clientes.editaCliente("07345161420", "localizacao", "gretchen");
        assertEquals("gretchen", clientes.getClientes().get("07345161420").getLocalizacao());
    }

    @Test
    void testEditaLocalInvalido() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.editaCliente("07345161420", "Localizacao", " ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testEditaLocalNulo() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.editaCliente("07345161420", "Localizacao", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();


        }
    }

    @Test
    void testEditaAtributoInvalido() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.editaCliente("07345161420", "zuzuzu", "gretchen");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();

        }
    }

    @Test
    void testEditaCPFInvalido() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");

        try {
            clientes.editaCliente("07345161422", "nome", "gretchen");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();

        }
    }


    //TESTANDO O METODO "removeCliente"

    @Test
    void testRemoveCliente() {
        clientes.cadastraCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edu.br", "lcc3");
        clientes.removeCliente("07345161420");
        assertFalse(clientes.getClientes().containsKey("07345161420"));
    }

    @Test
    void testRemoveClienteInexistente() {
        try {
            clientes.removeCliente("07345161420");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();

        }
    }
}