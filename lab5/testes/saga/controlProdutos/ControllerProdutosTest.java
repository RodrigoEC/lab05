package saga.controlProdutos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerProdutosTest {
    private ControllerProdutos controller;

    @BeforeEach
    void controllerPadrao() {
        controller = new ControllerProdutos();
        controller.getControleFornecedores().cadastraFornecedor("padaria", "padaria@gmail.com", "4002-8922");
    }
    // TESTES PARA O METODO "addProduto"

    @Test
    void testAddProdutoPadrao() {
        controller.addProduto("padaria", "3,00", "tapioca", "tapioca boaaaa");
        assertTrue(controller.getControleFornecedores().getMapaFornecedores().get("padaria").getMapaProdutos().containsKey("tapiocatapioca boaaaa"));
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

    // TESTES PARA O METODO "dadosProduto"

    @Test
    void testDadosProdutoPadrao() {
        controller.addProduto("padaria", "3,00", "tapioca", "tapioca boaaaa");
        assertEquals("tapioca - tapioca boaaaa - R$3,00", controller.dadosProduto("padaria", "tapioca", "tapioca boaaaa"));
    }

    @Test
    void testDadosProdutoParametrosInvalidos() {
        controller.addProduto("padaria", "3,00", "tapioca", "tapioca boaaaa");
        try {
            controller.dadosProduto("padaria", "tapioca", "    ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            controller.dadosProduto("padaria", " ", "tapioca boaaaa");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            controller.dadosProduto("", "tapioca", "tapioca boaaaa");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testDadosProdutoParametrosNulo() {
        controller.addProduto("padaria", "3,00", "tapioca", "tapioca boaaaa");
        try {
            controller.dadosProduto("padaria", "tapioca",  null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            controller.dadosProduto("padaria", null, "tapioca boaaaa");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            controller.dadosProduto(null, "tapioca", "tapioca boaaaa");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testDadosTodosProdutosFornecedorPadrao() {
        controller.addProduto("padaria", "3,00", "tapioca", "tapioca delicia");
        controller.addProduto("padaria", "70,00", "pao", "pao top");
        assertEquals("padaria - tapioca - tapioca delicia - R$3,00 | padaria - pao - pao top - R$70,00", controller.dadosTodosProdutosFornecedor("padaria"));
    }

    @Test
    void testDadosTodosProdutosFornecedorParametroInexistente() {
        try {
            controller.dadosTodosProdutosFornecedor("vaquinha");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testDadosTodosProdutosPadrao() {
        controller.getControleFornecedores().cadastraFornecedor("palmerinha", "palmerinha@gmail.com", "159357");
        controller.addProduto("padaria", "3,00", "tapioca", "tapioca delicia");
        controller.addProduto("padaria", "70,00", "pao", "pao top");
        controller.addProduto("palmerinha", "4,00", "sapatoDoce", "lalal");

        assertEquals("padaria - tapioca - tapioca delicia - R$3,00 | padaria - pao - pao top - R$70,00 | " +
                "palmerinha - sapatoDoce - lalal - R$4,00", controller.dadosTodosProdutos());
    }

    @Test
    void testEditaProdutoPadrao() {
        controller.addProduto("padaria", "3,00", "tapioca", "tapioca delicia");
        controller.editaProduto("padaria", "tapioca", "tapioca delicia", "100,00");

        assertEquals("100,00", controller.getControleFornecedores().getMapaFornecedores().get("padaria").getMapaProdutos().get("tapiocatapioca delicia").getPreco());
    }

    @Test
    void testEditaProdutosParametrosInvalidos() {
        controller.addProduto("padaria", "3,00", "tapioca", "tapioca delicia");
        try {
            controller.editaProduto("padaria", "", "tapioca delicia", "1,00");
        } catch (IllegalArgumentException iae) {
        }

        try {
            controller.editaProduto("padaria", "tapioca", "", "1,00");
        } catch (IllegalArgumentException iae) {
        }

        try {
            controller.editaProduto("padaria", "tapioca", "tapioca delicia", "");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testEditaProdutosParametrosNulos() {
        controller.addProduto("padaria", "3,00", "tapioca", "tapioca delicia");
        try {
            controller.editaProduto("padaria", null, "tapioca delicia", "1,00");
        } catch (NullPointerException npe) {
        }

        try {
            controller.editaProduto("padaria", "tapioca", null, "1,00");
        } catch (NullPointerException npe) {
        }

        try {
            controller.editaProduto("padaria", "tapioca", "tapioca delicia", null);
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testRemoveProdutoPadrao() {
        controller.addProduto("padaria", "3,00", "tapioca", "tapioca delicia");
        controller.removeProduto("padaria", "tapioca", "tapioca delicia");
        assertTrue(!controller.getControleFornecedores().getMapaFornecedores().get("padaria").getMapaProdutos().containsKey("tapiocatapioca delicia"));
    }

    @Test
    void testRemoveProdutosParametrosInvalidos() {
        controller.addProduto("padaria", "3,00", "tapioca", "tapioca delicia");

        try {
            controller.removeProduto("padaria", " ", "tapioca delicia");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            controller.removeProduto("padaria", "tapioca", " ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testRemoveProdutosParametrosNulos() {
        controller.addProduto("padaria", "3,00", "tapioca", "tapioca delicia");

        try {
            controller.removeProduto("padaria", null, "tapioca delicia");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            controller.removeProduto("padaria", "tapioca", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

}