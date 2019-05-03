package saga;

import saga.controlFornecedores.ControllerFornecedores;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerFornecedoresTest {
    private ControllerFornecedores controller;

    @BeforeEach
    void controllerPadrao() {
        controller = new ControllerFornecedores();
        controller.cadastraFornecedor("padaria", "padaria@gmail.com", "4002-8922");
    }

    @Test
    void testCadastraFornecedorPadrao() {
        assertTrue(controller.getMapaFornecedores().containsKey("padaria"));
    }

    @Test
    void testCadastraFornecedorComParametroInvalido() {
        try {

            controller.cadastraFornecedor("", "padaria@gmail.com", "4002-8922");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {

            controller.cadastraFornecedor("padaria", "  ", "4002-8922");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {

            controller.cadastraFornecedor("padaria", "padaria@gmail.com", "   ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

    }

    @Test
    void tesCadastraFornecedorComParametroNulo() {
        try {

            controller.cadastraFornecedor(null, "padaria@gmail.com", "4002-8922");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {

            controller.cadastraFornecedor("padaria", null, "4002-8922");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {

            controller.cadastraFornecedor("padaria", "padaria@gmail.com", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

    }


    @Test
    void testDadosFornecedor() {
        assertEquals("padaria - padaria@gmail.com - 4002-8922", controller.dadosFornecedor("padaria"));
    }

    @Test
    void testDadosFornecedorInvalido() {
        try {
            controller.dadosFornecedor("  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testDadosFornecedorNulo() {
        try {
            controller.dadosFornecedor(null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testDadosDeTodosOsFornecedoresPadrao() {
        controller.cadastraFornecedor("pradaria", "pradaria@gmail.com", "4002-8922");
        assertEquals("pradaria - pradaria@gmail.com - 4002-8922 | padaria - padaria@gmail.com - 4002-8922", controller.dadosTodosFornecedores());
    }

    @Test
    void testDadosDeTodosOsFornecedoresVazio() {
        controller.getMapaFornecedores().remove("padaria");
        assertEquals("", controller.dadosTodosFornecedores());
    }

    @Test
    void testEditaEmail() {
        controller.editaEmail("padaria", "padarinha@gmail.com");
        assertEquals("padarinha@gmail.com", controller.getMapaFornecedores().get("padaria").getEmail());
    }

    @Test
    void testEditaEmailNomeInexistente() {
        try {
            controller.editaEmail("vacas loucas", " edefef");
            fail("ERA PRA DAR RUIM");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testEditaEmailNomeNulo() {
        try {
            controller.editaEmail(null, "cmcmcm");
            fail("ERA PRA DAR RUIM");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testEditaEmaiNovoEmailnvalido() {
        try {
            controller.editaEmail("padaria",  " ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testEditaEmailNovoEmailNulo() {
        try {
            controller.editaEmail("padaria" ,null);
            fail("ERA PRA DAR RUIM");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testRemoveFornecedor() {
        controller.removeFornecedor("padaria");
        assertTrue(!controller.getMapaFornecedores().containsKey("padaria"));
    }

    @Test
    void testRemoveFornecedorKeyInexistente() {
        try {
            controller.removeFornecedor("cabeloPreto");
            fail("ERA PRA DAR RUIM");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testAddProdutoPadrao() {
        controller.addProduto("padaria", "3,00", "tapioca", "tapioca boaaaa");
        assertTrue(controller.getMapaFornecedores().get("padaria").getMapaProdutos().containsKey("tapiocatapioca boaaaa"));
    }

    @Test
    void testAddProdutoFornecedorInexistente() {
        try {
            controller.addProduto("paria", "3,00", "tapioca", "tapioca boaaaa");
            fail("ERA PRA DAR RUIM");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testAddProdutoParametrosInexistente() {
        try {
            controller.addProduto("paria", "3,00", "tapioca", "");
            fail("ERA PRA DAR RUIM");
        } catch (IllegalArgumentException iae) {
        }

        try {
            controller.addProduto("paria", "3,00", " ", "tapioca boaaaa");
            fail("ERA PRA DAR RUIM");
        } catch (IllegalArgumentException iae) {
        }

        try {
            controller.addProduto("paria", "   ", "tapioca", "tapioca boaaaa");
            fail("ERA PRA DAR RUIM");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testAddProdutoParametrosNulos() {
        try {
            controller.addProduto("paria", null, "tapioca", "tapioca boaaaa");
            fail("ERA PRA DAR RUIM");
        } catch (NullPointerException npe) {
        }

        try {
            controller.addProduto("paria", "3,00", null, "tapioca boaaaa");
            fail("ERA PRA DAR RUIM");
        } catch (NullPointerException npe) {
        }

        try {
            controller.addProduto("paria", "3,00", "tapioca", null);
            fail("ERA PRA DAR RUIM");
        } catch (NullPointerException npe) {
        }
    }
}