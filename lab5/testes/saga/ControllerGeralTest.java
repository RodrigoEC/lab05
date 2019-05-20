package saga;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.NumberUp;

import static org.junit.jupiter.api.Assertions.*;

class ControllerGeralTest {

    private ControllerGeral controller;

    @BeforeEach
    void controllerPadrao() {
        controller = new ControllerGeral();
        controller.adicionaCliente("07345161420", "rodrigo", "rodrigo.cavalcanti@ccc.ufcg.edubr.br", "lcc2");
        controller.adicionaFornecedor("padaria", "padaria@gmail.com", "999902587");
        controller.adicionaProduto("padaria", "sapato", "eh um sapato", 2.50);

    }

    @Test
    void testAdicionaProdutoPadrao() {
        controller.adicionaCompra("07345161420", "padaria", "01/11/2019", "sapato", "eh um sapato");
    }

    @Test
    void testAdicionaProdutoEntradasInvalidas() {
        try {
            controller.adicionaCompra("07345161422", "padaria", "01/11/2019", "sapato", "eh um sapato");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            controller.adicionaCompra("07345161420", "padar", "01/11/2019", "sapato", "eh um sapato");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
        try {
            controller.adicionaCompra("07345161420", "padaria", "32/11/2019", "sapato", "eh um sapato");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            controller.adicionaCompra("07345161420", "padaria", "01/13/2019", "sapato", "eh um sapato");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            controller.adicionaCompra("07345161420", "padaria", "01/11/2019", "sapa", "eh um sapato");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            controller.adicionaCompra("07345161420", "padaria", "01/13/20129", "sapato", "eh um sapato");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            controller.adicionaCompra("07345161420", "padaria", "01/134/2019", "sapato", "eh um sapato");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            controller.adicionaCompra("07345161420", "padaria", "013/13/2019", "sapato", "eh um sapato");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }


    @Test
    void testAdicionaCompraParametrosNulos() {

        try {
            controller.adicionaCompra(null, "padaria", "01/11/2019", "sapato", "eh um sapato");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            controller.adicionaCompra("07345161420", null, "01/11/2019", "sapato", "eh um sapato");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            controller.adicionaCompra("07345161420", "padaria", null, "sapato", "eh um sapato");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            controller.adicionaCompra("07345161420", "padaria", "01/11/2019", null, "eh um sapato");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            controller.adicionaCompra("07345161420", "padaria", "01/11/2019", "sapato", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testGetDebitoPadrao() {
        controller.adicionaCompra("07345161420", "padaria", "01/11/2019", "sapato", "eh um sapato");
        assertEquals(2.50, controller.getDebito("07345161420", "padaria"));
    }

    @Test
    void testGetDebitoEntradasInvalidas() {
        controller.adicionaCompra("07345161420", "padaria", "01/11/2019", "sapato", "eh um sapato");

        try {
            controller.getDebito("45161420", "padaria");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }


        try {
            controller.getDebito("007345161420", "padaria");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }


        try {
            controller.getDebito("07345161422", "padaria");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
        }


        try {
            controller.getDebito("07345161420", "padar");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
        }


        try {
            controller.getDebito("07345161420", "  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testGetDebitoEntradasNulas() {
        controller.adicionaCompra("07345161420", "padaria", "01/11/2019", "sapato", "eh um sapato");

        try {
            controller.getDebito(null, "padaria");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            controller.getDebito("07345161420", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void testExibeContasPadrao() {
        controller.adicionaCompra("07345161420", "padaria", "01/11/2019", "sapato", "eh um sapato");

        assertEquals("Cliente: rodrigo | padaria | sapato - 01-11-2019", controller.exibeContas("07345161420", "padaria"));
    }

    @Test
    void testExibeContasEntradasInvalidas() {
        controller.adicionaCompra("07345161420", "padaria", "01/11/2019", "sapato", "eh um sapato");

        try {
            controller.exibeContas("07345161422", "padaria");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }


        try {
            controller.exibeContas("07345161420", "padara");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }
    }