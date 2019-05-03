package saga;

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
    void testDadosFornecedor() {
        assertEquals("padaria - padaria@gmail.com - 4002-8922", controller.dadosFornecedor("padaria"));
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
    void testRemoveFornecedor() {
        controller.removeFornecedor("padaria");
        assertTrue(!controller.getMapaFornecedores().containsKey("padaria"));
    }
}