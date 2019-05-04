package saga.controlFornecedores;

import saga.controlFornecedores.Fornecedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    private Fornecedor fornecedor;

    @BeforeEach
    void fornecedorPadrao() {
        fornecedor = new Fornecedor("padaria", "padaria@gmail.com", "4002-8922");
        fornecedor.addProduto("3,00", "tapioca", "tapioca delicia");

    }

    @Test
    void testToString() {
        assertEquals("padaria - padaria@gmail.com - 4002-8922", fornecedor.toString());
    }

    // testando o metodo "addProduto"

    @Test
    void testAddProduto() {
        assertTrue(fornecedor.getMapaProdutos().containsKey("tapiocatapioca delicia"));
    }


    // testando o metodo "dadosProduto"

    @Test
    void testDadosProdutopadrao() {
        assertEquals("tapioca - tapioca delicia - R$3,00", fornecedor.dadosProduto("tapioca", "tapioca delicia"));
    }

    // testando o metodo "dadosTodosProdutos"

    @Test
    void testDadosDeTodosOsProdutos() {
        fornecedor.addProduto("3,00", "tapio", "tapio");
        assertEquals("padaria - tapio - tapio - R$3,00 | padaria - tapioca - tapioca delicia - R$3,00", fornecedor.dadosTodosProdutos());
    }

    @Test
    void testDadosDeTodosOSprodutosVazio() {
        fornecedor.removeProduto("tapioca", "tapioca delicia");
        assertEquals("", fornecedor.dadosTodosProdutos());
    }

    // testando o metodo "editaProduto"

    @Test
    void testEditaProdutoPadrao() {
        fornecedor.editaProduto("1,00", "tapioca", "tapioca delicia");
        assertEquals("1,00", fornecedor.getMapaProdutos().get("tapiocatapioca delicia").getPreco());
    }

    @Test
    void testEditaProdutoKeyInexistente() {
        try {
            fornecedor.editaProduto("1,00", "tap", "tapioca delicia");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    // testando o metodo "removeProduto"

    @Test
    void testRemoveProduto() {
        fornecedor.removeProduto("tapioca", "tapioca delicia");
        assertTrue(!fornecedor.getMapaProdutos().containsKey("tapiocatapioca delicia"));
    }

    @Test
    void testRemoveProdutoKeyInexistente() {
        try {
            fornecedor.removeProduto("tapi", "tapioca delicia");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }
}