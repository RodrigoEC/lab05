package saga.controlFornecedores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saga.controlClientes.ValidaControllerCliente;

import static org.junit.jupiter.api.Assertions.*;

class ValidaControllerFornecedorTest {

    private ValidaControllerFornecedor validador;

    @BeforeEach
    void validadorPadrao() {
        validador = new ValidaControllerFornecedor();
    }

    @Test
    void testValidaEntradasInvalidasCadastraFornecedor() {
        try {
            validador.validaEntradasCadastraFornecedor(" ", "rodrigo", "0751462");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasCadastraFornecedor("rodrigo", " ", "0751462");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasCadastraFornecedor("rodrigo", "rodrigo", " ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaEntradasNulasCadastraFornecedor() {
        try {
            validador.validaEntradasCadastraFornecedor(null, "rodrigo", "0751462");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasCadastraFornecedor("rodrigo", null, "0751462");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasCadastraFornecedor("rodrigo", "rodrigo", null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void tesValidaEntradasInvalidasEditaFornecedor() {
        try {
            validador.validaEntradasEditaFornecedor(" ", "rodrigo", "0751462");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasEditaFornecedor("rodrigo", " ", "0751462");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasEditaFornecedor("rodrigo", "rodrigo", " ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaEntradasNulasEditaFornecedor() {
        try {
            validador.validaEntradasEditaFornecedor(null, "rodrigo", "0751462");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasEditaFornecedor("rodrigo", null, "0751462");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasEditaFornecedor("rodrigo", "rodrigo", null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaEntradaInvalidaRemoveFornecedor() {
        try {
            validador.validaEntradaRemoveFornecedor(" ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }
    @Test
    void testValidaEntradaNulaRemoveFornecedor() {
        try {
            validador.validaEntradaRemoveFornecedor(null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaEntradasInvalidasAddProdutos() {
        try {
            validador.validaEntradasAddProduto(" ", "rodrigo", "0751462", 20);
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasAddProduto("rodrigo", " ", "0751462", 20);
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasAddProduto("rodrigo", "rodrigo", " ", 20);
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasAddProduto("rodrigo", "rodrigo", " 044588", -1);
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaEntradasNulasAddProdutos() {
        try {
            validador.validaEntradasAddProduto(null, "rodrigo", "0751462", 20);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasAddProduto("rodrigo", null, "0751462", 20);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasAddProduto("rodrigo", "rodrigo", null, 20);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaEntradasInvalidasExibeProduto() {
        try {
            validador.validaEntradasExibeProduto("", "rodrigo", "0751462");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasExibeProduto("rodrigo", " ", "0751462");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasExibeProduto("rodrigo", "rodrigo",  " ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaEntradasNulasExibeProduto() {
        try {
            validador.validaEntradasExibeProduto(null, "rodrigo", "0751462");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasExibeProduto("rodrigo", null, "0751462");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasExibeProduto("rodrigo", "rodrigo",  null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaEntradasInvalidasEditaProduto() {
        try {
            validador.validaEntradasEditaProduto("  ", "rodrigo", "0751462", 20);
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasEditaProduto("rodrigo", "  ", "0751462", 20);
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasEditaProduto("rodrigo", "rodrigo", "   ", 20);
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasEditaProduto("rodrigo", "rodrigo", "0751462", -1);
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasEditaProduto("rodrigo", "rodrigo", "0751462", -10);
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaEntradasNulasEditaProduto() {
        try {
            validador.validaEntradasEditaProduto(null, "rodrigo", "0751462", 20);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasEditaProduto("rodrigo", null, "0751462", 20);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasEditaProduto("rodrigo", "rodrigo", null, 20);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaEntradasInvalidasRemoveProduto() {
        try {
            validador.validaEntradasRemoveProduto("", "rodrigo", "0751462");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasRemoveProduto("rodrigo", " ", "0751462");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasRemoveProduto("rodrigo", "rodrigo", "  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaEntradasNulasRemoveProduto() {
        try {
            validador.validaEntradasRemoveProduto("rodrigo", null, "0751462");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasRemoveProduto(null, "rodrigo", "0751462");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasRemoveProduto("rodrigo", "rodrigo", null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

    }
}