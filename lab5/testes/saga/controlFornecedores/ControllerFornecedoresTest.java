package saga.controlFornecedores;

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

    // TESTES PARA O METODO "cadastraFornecedor"
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
            iae.printStackTrace();

        }

        try {

            controller.cadastraFornecedor("padaria", "  ", "4002-8922");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();

        }

        try {

            controller.cadastraFornecedor("padaria", "padaria@gmail.com", "   ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();

        }

    }

    @Test
    void tesCadastraFornecedorComParametroNulo() {
        try {

            controller.cadastraFornecedor(null, "padaria@gmail.com", "4002-8922");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
             npe.printStackTrace();
        }

        try {

            controller.cadastraFornecedor("padaria", null, "4002-8922");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
             npe.printStackTrace();
        }

        try {

            controller.cadastraFornecedor("padaria", "padaria@gmail.com", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
             npe.printStackTrace();
        }

    }


    // TESTES PARA O METODO "dadosFornecedor"

    @Test
    void testDadosFornecedor() {
        assertEquals("padaria - padaria@gmail.com - 4002-8922", controller.dadosFornecedor("padaria"));
    }


    @Test
    void testDadosFornecedorInexistente() {
        try {
            controller.dadosTodosProdutosFornecedor("lalala");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
             npe.printStackTrace();
        }
    }

    @Test
    void testDadosFornecedorInvalido() {
        try {
            controller.dadosFornecedor("  ");
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
            iae.printStackTrace();

        }
    }

    @Test
    void testDadosFornecedorNulo() {
        try {
            controller.dadosFornecedor(null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

    // TESTES PARA O METODO "dadosTodosFornecedores"

    @Test
    void testDadosDeTodosOsFornecedoresPadrao() {
        controller.cadastraFornecedor("pradaria", "pradaria@gmail.com", "4002-8922");
        assertEquals("padaria - padaria@gmail.com - 4002-8922 | pradaria - pradaria@gmail.com - 4002-8922", controller.dadosTodosFornecedores());
    }

    @Test
    void testDadosDeTodosOsFornecedoresVazio() {
        controller.getMapaFornecedores().remove("padaria");
        assertEquals("", controller.dadosTodosFornecedores());
    }


    @Test
    void testDadosTodosProdutosFornecedorParametroInexistente() {
        try {
            controller.dadosTodosProdutosFornecedor("vaquinha");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
             npe.printStackTrace();
        }
    }

    //TESTANDO O METODO "dadosTodosFornecedores"
    @Test
    void testDadosTodosProdutosPadrao() {
        controller.cadastraFornecedor("palmerinha", "palmerinha@gmail.com", "159357");
        controller.addProduto("padaria",  "tapioca", "tapioca delicia", 3.00);
        controller.addProduto("padaria","pao", "pao top", 70.00);
        controller.addProduto("palmerinha",  "sapatoDoce", "lalal", 4.00);

        assertEquals("padaria - pao - pao top - R$70,00 | padaria - tapioca - tapioca delicia - R$3,00 | " +
                "palmerinha - sapatoDoce - lalal - R$4,00", controller.dadosTodosProdutos());
    }

    // TESTES PARA O METODO "editaEmail"


    // TESTES PARA O METODO "removeFornecedor"

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
             npe.printStackTrace();
        }
    }

    // Test parametros do métodp "addProduto"

    @Test
    void testAddProdutoParametrosInexistente() {
        try {
            controller.addProduto( "  ","tapioca", "", 3.00);
            fail("ERA PRA DAR RUIM");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();

        }

        try {
            controller.addProduto( "padaria","tapioca", "", 3.00);
            fail("ERA PRA DAR RUIM");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();

        }

        try {
            controller.addProduto(  "padaria"," ", "tapioca boaaaa", 3.00);
            fail("ERA PRA DAR RUIM");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();

        }

        try {
            controller.addProduto( "padaria","tapioca", "tapioca boaaaa", -1);
            fail("ERA PRA DAR RUIM");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();

        }
    }

    @Test
    void testAddProdutoParametrosNulos() {
        try {
            controller.addProduto( null,"tapioca", "FEFE", 3.00);
            fail("ERA PRA DAR RUIM");
        } catch (NullPointerException npe) {
             npe.printStackTrace();

        }

        try {
            controller.addProduto( "padaria",null, "FEFEFEF", 3.00);
            fail("ERA PRA DAR RUIM");
        } catch (NullPointerException npe) {
             npe.printStackTrace();
        }

        try {
            controller.addProduto(  "padaria","FEFEFEF", null, 3.00);
            fail("ERA PRA DAR RUIM");
        } catch (NullPointerException npe) {
             npe.printStackTrace();
        }
    }

    @Test
    void exibeProdutoParametrosInvalidos() {
        controller.addProduto(  "padaria","tapioca", "tapioca boaaaa", 3.00);
        try {
            controller.exibeProduto( "padaria","tapioca", "    ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();

        }

        try {
            controller.exibeProduto(  "padaria" ," ", "tapioca boaaaa");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();

        }
    }

    // teste do metodo editaCliente

    @Test
    void testEditaProdutosParametrosInvalidos() {
        controller.addProduto(  "padaria", "tapioca", "tapioca delicia", 3.00);
        try {
            controller.editaProduto( "padaria", "tapioca", "tapioca delicia", -1);
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();

        }

        try {
            controller.editaProduto( "padaria", "", "tapioca delicia", 1.00);
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();

        }

        try {
            controller.editaProduto(  "padaria", "tapioca", "", 1.00);
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();

        }
    }

    @Test
    void testEditaProdutosParametrosNulos() {
        controller.addProduto( "padaria" ,"tapioca", "tapioca delicia", 3.00);

        try {
            controller.editaProduto( "padaria", null, "tapioca delicia", 1.00);
        } catch (NullPointerException npe) {
             npe.printStackTrace();
        }

        try {
            controller.editaProduto( "padaria", "tapioca", null,1.00);
        } catch (NullPointerException npe) {
             npe.printStackTrace();
        }
    }

    // testes da do metodo "removeProduto"


    @Test
    void testRemoveProdutosParametrosInvalidos() {
        controller.addProduto(  "padaria","tapioca", "tapioca delicia", 3.00);

        try {
            controller.removeProduto( "padaria"," ", "tapioca delicia");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();

        }

        try {
            controller.removeProduto( "padaria","tapioca", " ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();

        }
    }

    @Test
    void testRemoveProdutosParametrosNulos() {
        controller.addProduto(  "padaria","tapioca", "tapioca delicia", 3.00);

        try {
            controller.removeProduto("padaria",null, "tapioca delicia");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
             npe.printStackTrace();
        }

        try {
            controller.removeProduto("padaria","tapioca", null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
             npe.printStackTrace();
        }
    }

    // TESTANDO METODO "addCombo"
    @Test
    void testAddComboPadrao() {
        controller.addProduto("padaria", "2:50(yep)", "horario", 2.50);
        controller.addCombo("padaria", "2:48(acordado)", "hoario que eu to acordado", 0.3, "2:50(yep) - horario");
    }

    @Test
    void testAddComboParametrosInvalidos() {
        controller.addProduto("padaria", "2:50(yep)", "horario", 2.50);

        try {
            controller.addCombo("pada", "2:53(help)", "horario", 0.5, "2:50(yep) - horario");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

        try {
            controller.addCombo("padaria", " ", "horario", 0.5, "2:50(yep) - horario");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException npe) {
            npe.printStackTrace();
        }

        try {
            controller.addCombo("padaria", "2:53(help)", " ", 1, "2:50(yep) - horario");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException npe) {
            npe.printStackTrace();
        }

        try {
            controller.addCombo("padaria", "2:53(help)", "horario", 0, "2:50(yep) - horario");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException npe) {
            npe.printStackTrace();
        }

        try {
            controller.addCombo("padaria", "2:53(help)", "horario", 0.5, "2:50(yep) - ");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        controller.addCombo("padaria", "2:53(help)", "horario", 0.5, "2:50(yep) - horario");
    }

    @Test
    void testAddComboParametrosNulos() {
        controller.addProduto("padaria", "2:50(yep)", "horario", 2.50);

        try {
            controller.addCombo(null, "2:53(help)", "horario", 0.5, "2:50(yep) - horario");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

        try {
            controller.addCombo("padaria", null, "horario", 0.5, "2:50(yep) - horario");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

        try {
            controller.addCombo("padaria", "2:53(help)", null, 0.7, "2:50(yep) - horario");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }


        try {
            controller.addCombo("padaria", "2:53(help)", "horario", 0.5, null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

    // TESTANDO METODO "editaCombo"

    @Test
    void testEditaComboParametrosInvalidos() {
        controller.addProduto("padaria", "2:50(yep)", "horario", 2.50);
        try {
            controller.editaCombo("2:50(yep)", "horar", "padaria", 0.5);
            fail("era pra dar ruim");
        } catch ( NullPointerException npe) {
        }

        try {
            controller.editaCombo("2:50(yep)", "horario", "pada", 0.5);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            controller.editaCombo("2:50(ye", "horario", "padaria", 0.5);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            controller.editaCombo("2:50(yep)", "horario", "padaria", 1);
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }

        try {
            controller.editaCombo("2:50(yep)", "horario", "padaria", 0);
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void testEditaComboParametrosNulos() {
        controller.addProduto("padaria", "2:50(yep)", "horario", 2.50);
        try {
            controller.editaCombo("2:50(yep)", null, "padaria", 0.5);
            fail("era pra dar ruim");
        } catch ( NullPointerException npe) {
        }

        try {
            controller.editaCombo(null, "horario", "pada", 0.5);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }

        try {
            controller.editaCombo("2:50(ye", "horario", null, 0.5);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }
}