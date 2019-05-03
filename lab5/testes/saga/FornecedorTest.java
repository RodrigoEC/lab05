package saga;

import saga.controlFornecedores.Fornecedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    private Fornecedor fornecedor;

    @BeforeEach
    void fornecedorPadrao() {
        fornecedor = new Fornecedor("padaria", "padaria@gmail.com", "4002-8922");
    }

    @Test
    void testToString() {
        assertEquals("padaria - padaria@gmail.com - 4002-8922", fornecedor.toString());
    }
}