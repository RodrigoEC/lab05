package saga.controlFornecedores;

import saga.controlFornecedores.Fornecedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    private Fornecedor fornecedor;

    @BeforeEach
    void fornecedorPadrao() {
        fornecedor = new Fornecedor( "padaria","padaria@gmail.com", "4002-8922");
        fornecedor.addProduto( "tapioca", "tapioca delicia", 3.00);

    }

    // TESTANDO O METODO "toString"

    @Test
    void testToString() {
        assertEquals("padaria - padaria@gmail.com - 4002-8922", fornecedor.toString());
    }

    // TESTANDO O METODO "addProduto"

    @Test
    void testAddProduto() {
        assertTrue(fornecedor.getMapaProdutos().containsKey("tapioca - tapioca delicia"));
    }


    // TESTANDO O METODO "exibeProduto"

    @Test
    void testDadosProdutopadrao() {
        assertEquals("tapioca - tapioca delicia - R$3,00", fornecedor.exibeProduto("tapioca", "tapioca delicia"));
    }


    // TESTANDO O METODO "dadosTodosProdutos"

    @Test
    void testDadosDeTodosOsProdutos() {
        fornecedor.addProduto( "tapio", "tapio", 3.00);
        assertEquals("padaria - tapio - tapio - R$3,00 | padaria - tapioca - tapioca delicia - R$3,00", fornecedor.dadosTodosProdutos());
    }

    @Test
    void testDadosDeTodosOSprodutosVazio() {
        fornecedor.removeProduto("tapioca", "tapioca delicia");
        assertEquals("", fornecedor.dadosTodosProdutos());
    }

    // TESTANDO O METODO "editaProduto"

    @Test
    void testEditaProdutoPadrao() {
        fornecedor.editaProduto(1.00, "tapioca", "tapioca delicia");
        assertEquals(1.00, fornecedor.getMapaProdutos().get("tapioca - tapioca delicia").getPreco());
    }

    @Test
    void testEditaProdutoKeyInexistente() {
        try {
            fornecedor.editaProduto(1.00, "tap", "tapioca delicia");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
                         npe.printStackTrace();

        }
    }

    // TESTANDO O METODO "removeProduto"

    @Test
    void testRemoveProduto() {
        fornecedor.removeProduto("tapioca", "tapioca delicia");
        assertTrue(!fornecedor.getMapaProdutos().containsKey("tapioca - tapioca delicia"));
    }

    @Test
    void testRemoveProdutoKeyInexistente() {
        try {
            fornecedor.removeProduto("tapi", "tapioca delicia");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }


    @Test
    void testFornecedoresIguais() {
        Fornecedor fornecedorGemeo = new Fornecedor("padaria","padaria@gmail.com", "4002-8922");
        assertTrue(fornecedor.equals(fornecedorGemeo));
    }

    @Test
    void testFornecedoresDiferentes() {
        Fornecedor fornecedor2 = new Fornecedor("parara","padaria@gmail.com", "4002-8922");
        assertFalse(fornecedor.equals(fornecedor2));
    }

    @Test
    void testHashCodesIguais() {
        Fornecedor fornecedorGemeo = new Fornecedor("padaria","padaria@gmail.com", "4002-8922");
        assertTrue(fornecedor.hashCode() == fornecedorGemeo.hashCode());
    }

    @Test
    void testHashCodesDiferentes() {
        Fornecedor fornecedor2 = new Fornecedor("parara","padaria@gmail.com", "4002-8922");
        assertTrue(fornecedor.hashCode() != fornecedor2.hashCode());
    }
}