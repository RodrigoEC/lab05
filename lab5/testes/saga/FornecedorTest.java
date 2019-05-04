package saga;

import saga.controlFornecedores.Fornecedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    private Fornecedor fornecedor;

    @BeforeEach
    void fornecedorPadrao() {
        fornecedor = new Fornecedor( "padaria","padaria@gmail.com", "4002-8922");
        fornecedor.addProduto("3,00", "tapioca", "tapioca delicia");

    }

    // TESTANDO O METODO "toString"

    @Test
    void testToString() {
        assertEquals("padaria - padaria@gmail.com - 4002-8922", fornecedor.toString());
    }

    // TESTANDO O METODO "addProduto"

    @Test
    void testAddProduto() {
        assertTrue(fornecedor.getMapaProdutos().containsKey("tapiocatapioca delicia"));
    }

    @Test
    void testAddProdutoParametrosInexistente() {
        try {
            fornecedor.addProduto("3,00", "tapioca", "");
            fail("ERA PRA DAR RUIM");
        } catch (IllegalArgumentException iae) {
        }

        try {
            fornecedor.addProduto( "3,00", " ", "tapioca boaaaa");
            fail("ERA PRA DAR RUIM");
        } catch (IllegalArgumentException iae) {
        }

        try {
            fornecedor.addProduto( "   ", "tapioca", "tapioca boaaaa");
            fail("ERA PRA DAR RUIM");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testAddProdutoParametrosNulos() {
        try {
            fornecedor.addProduto( null, "tapioca", "tapioca boaaaa");
            fail("ERA PRA DAR RUIM");
        } catch (NullPointerException npe) {
        }

        try {
            fornecedor.addProduto( "3,00", null, "tapioca boaaaa");
            fail("ERA PRA DAR RUIM");
        } catch (NullPointerException npe) {
        }

        try {
            fornecedor.addProduto( "3,00", "tapioca", null);
            fail("ERA PRA DAR RUIM");
        } catch (NullPointerException npe) {
        }
    }

    // TESTANDO O METODO "dadosProduto"

    @Test
    void testDadosProdutopadrao() {
        assertEquals("tapioca - tapioca delicia - R$3,00", fornecedor.dadosProduto("tapioca", "tapioca delicia"));
    }

    @Test
    void testDadosProdutoParametrosInvalidos() {
        fornecedor.addProduto( "3,00", "tapioca", "tapioca boaaaa");
        try {
            fornecedor.dadosProduto( "tapioca", "    ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            fornecedor.dadosProduto( " ", "tapioca boaaaa");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

    }

    @Test
    void testDadosProdutoParametrosNulo() {
        fornecedor.addProduto( "3,00", "tapioca", "tapioca boaaaa");
        try {
            fornecedor.dadosProduto( "tapioca",  null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            fornecedor.dadosProduto( null, "tapioca boaaaa");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

    }

    // TESTANDO O METODO "dadosTodosProdutos"

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

    // TESTANDO O METODO "editaProduto"

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

    @Test
    void testEditaProdutosParametrosInvalidos() {
        fornecedor.addProduto( "3,00", "tapioca", "tapioca delicia");
        try {
            fornecedor.editaProduto( "", "tapioca", "tapioca delicia");
        } catch (IllegalArgumentException iae) {
        }

        try {
            fornecedor.editaProduto( "1,00", "", "tapioca delicia");
        } catch (IllegalArgumentException iae) {
        }

        try {
            fornecedor.editaProduto( "1,00", "tapioca", "");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testEditaProdutosParametrosNulos() {
        fornecedor.addProduto( "3,00", "tapioca", "tapioca delicia");
        try {
            fornecedor.editaProduto( null, "tapioca", "tapioca delicia");
        } catch (NullPointerException npe) {
        }

        try {
            fornecedor.editaProduto( "1,00", null, "tapioca delicia");
        } catch (NullPointerException npe) {
        }

        try {
            fornecedor.editaProduto( "1,00", "tapioca", null);
        } catch (NullPointerException npe) {
        }
    }

    // TESTANDO O METODO "removeProduto"

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

    @Test
    void testRemoveProdutosParametrosInvalidos() {
        fornecedor.addProduto( "3,00", "tapioca", "tapioca delicia");

        try {
            fornecedor.removeProduto( " ", "tapioca delicia");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            fornecedor.removeProduto( "tapioca", " ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testRemoveProdutosParametrosNulos() {
        fornecedor.addProduto( "3,00", "tapioca", "tapioca delicia");

        try {
            fornecedor.removeProduto(null, "tapioca delicia");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            fornecedor.removeProduto("tapioca", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }
}