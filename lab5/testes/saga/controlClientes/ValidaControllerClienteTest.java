package saga.controlClientes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saga.ValidaEntradasDeMetodos;

import static org.junit.jupiter.api.Assertions.*;

class ValidaControllerClienteTest {

    private ValidaEntradasDeMetodos validador;

    @BeforeEach
    void validadorPadrao() {
        validador = new ValidaEntradasDeMetodos();
        validador.validaEntradasCadastraCliente("07345161420", "rodrigo", "rodrigoeloy99@hotmail.com", "lcc2");

    }


    @Test
    void testValidaEntradasCadastraFornecedorEntradasInvalidas() {

        try {
            validador.validaEntradasCadastraCliente("07345161", "rodrigo", "rodrigoeloy99@hotmail.com", "lcc2");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasCadastraCliente("0734516142022", "rodrigo", "rodrigoeloy99@hotmail.com", "lcc2");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasCadastraCliente("07345161420", " ", "rodrigoeloy99@hotmail.com", "lcc2");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasCadastraCliente("07345161420", "rodrigo", " ", "lcc2");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasCadastraCliente("07345161420", "rodrigo", "rodrigoeloy99@hotmail.com", " ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }


    @Test
    void testValidaEntradasCadastraFornecedorEntradasNulas() {
        try {
            validador.validaEntradasCadastraCliente(null, "rodrigo", "rodrigoeloy99@hotmail.com", "lcc2");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasCadastraCliente("07345161420", null, "rodrigoeloy99@hotmail.com", "lcc2");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasCadastraCliente("07345161420", "rodrigo", null, "lcc2");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasCadastraCliente("07345161420", "rodrigo", "rodrigoeloy99@hotmail.com", null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaEntradasInvalidasDadosCliente() {
        try {
            validador.validaEntradasDadosCliente("0734516142");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasDadosCliente("0734516142011");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaNulasInvalidasDadosCliente() {
        try {
            validador.validaEntradasDadosCliente(null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaEntradasInvalidasEditaCliente() {
        try {
            validador.validaEntradasEditaCliente("07345161", "LALA", "rodrigoeloy99@hotmail.com");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasEditaCliente("0734516142022", "rodrigo", "rodrigoeloy99@hotmail.com");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasEditaCliente("07345161420", " ", "rodrigoeloy99@hotmail.com");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasEditaCliente("07345161420",  "rodrigoeloy99@hotmail.com", " ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaEntradasNulasEditaCliente() {
        try {
            validador.validaEntradasEditaCliente(null, "llala", "oooroor");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

        try {
            validador.validaEntradasEditaCliente("07345161420", null, "oooroor");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

        try {
            validador.validaEntradasEditaCliente("07345161420", "llala", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

    @Test
    void testValidaEntradasInvalidasRemoveCliente() {
        try {
            validador.validaEntradasRemoveCliente("0734516142");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }

        try {
            validador.validaEntradasDadosCliente("0734516142011");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }

    @Test
    void testValidaNulasInvalidasRemoveCliente() {
        try {
            validador.validaEntradasRemoveCliente(null);
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();
        }
    }

    // TESTANDO O METODO "ValidaEntradaExibeContasCliente"

    @Test
    void testValidaEntradaNulaExibeContasCliente() {
        try {
            validador.validaEntradaExibeContasCliente(null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

    @Test
    void testValidaEntradaInvalidaExibeContasCliente() {
        try {
            validador.validaEntradaExibeContasCliente("  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException npe) {
            npe.printStackTrace();
        }
    }
}