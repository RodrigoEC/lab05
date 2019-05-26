package saga;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saga.ControllerGeral;

import static org.junit.jupiter.api.Assertions.*;

class OrdenaTest {

    private ControllerGeral control;


    @BeforeEach
    void controlPadrao() {
        control = new ControllerGeral();

        control.adicionaFornecedor("Joabe" ,"joabecompena@gmail.com" ,"83 90036-5012");
        control.adicionaFornecedor("Severo" ,"seusevero@hotmail.com" ,"83 7898-4565");

        control.adicionaCliente("12312312312", "Joao Neto" ,"joao.neto@ccc.ufcg.edu.br","LIA");
        control.adicionaCliente("45645645645", "Dalton" ,"dalton@gmail.com","SPLAB");
        control.adicionaCliente("78978978978", "Zana" ,"zanazaninha@bol.com","LSI");

        control.adicionaProduto("Joabe" ,"Bolo de Chocolate" ,"Bolo de trigo com cobertura de chocolate",2.00);
        control.adicionaProduto("Joabe" ,"Trufa de Beijinho" ,"Doce sabor beijinho",1.50);
        control.adicionaProduto("Severo","Cocada de Amendoim","Cocada de doce de leite com pedacos de amendoim",1.50);
        control.adicionaProduto("Severo","Agua", "Garrafa de agua 500ml",1.00);

        control.adicionaCombo("Joabe" ,"Bolo de Chocolate + Trufa de Beijinho","Um Bolo e uma Trufa" ,0.10 ,"Bolo de Chocolate - Bolo de trigo com cobertura de chocolate, Trufa de Beijinho - Doce sabor beijinho");
        control.adicionaCombo("Severo","Cocada com Agua","Cocada de doce de leite com amendoim e agua gelada" ,0.25 ,"Cocada de Amendoim - Cocada de doce de leite com pedacos de amendoim, Agua - Garrafa de agua 500ml");

        control.adicionaCompra("12312312312","Joabe", "08/11/2018" ,"Bolo de Chocolate" ,"Bolo de trigo com cobertura de chocolate");
        control.adicionaCompra("12312312312","Joabe", "07/11/2018" ,"Trufa de Beijinho" ,"Doce sabor beijinho");
        control.adicionaCompra("12312312312","Severo", "08/11/2018" ,"Agua" ,"Garrafa de agua 500ml");
        control.adicionaCompra("45645645645","Joabe","06/11/2018" ,"Bolo de Chocolate + Trufa de Beijinho" ,"Um Bolo e uma Trufa");
        control.adicionaCompra("78978978978","Severo", "05/11/2018" ,"Cocada de Amendoim" ,"Cocada de doce de leite com pedacos de amendoim");
        control.adicionaCompra("45645645645","Severo", "04/11/2018" ,"Cocada com Agua" ,"Cocada de doce de leite com amendoim e agua gelada");
    }

    @Test
    void listarComprasSemCriterio() {
        try {
            control.listarCompras();
            fail("era pra dar ruim");
        } catch (NullPointerException iae) {
        }
    }

    @Test
    void ordenarPorCriterioInvalido() {
        try {
            control.ordenaPor("vacas");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException npe) {
        }

        try {
            control.ordenaPor("");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException npe) {
        }

        try {
            control.ordenaPor(null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void listarComprasFornecedor() {
        control.ordenaPor("fornecedor");

        assertEquals("Joabe, Dalton, Um Bolo e uma Trufa, 06/11/2018 | " +
                        "Joabe, Joao Neto, Bolo de trigo com cobertura de chocolate, 08/11/2018 | Joabe, Joao Neto, Doce sabor beijinho, 07/11/2018 | " +
                        "Severo, Dalton, Cocada de doce de leite com amendoim e agua gelada, 04/11/2018 | " +
                "Severo, Joao Neto, Garrafa de agua 500ml, 08/11/2018 | Severo, Zana, Cocada de doce de leite com pedacos de amendoim, 05/11/2018",  control.listarCompras());
    }

    @Test
    void listarComprasCliente() {
        control.ordenaPor("cliente");

        assertEquals("Dalton, Joabe, Um Bolo e uma Trufa, 06/11/2018 | Dalton, Severo, Cocada de doce de leite com amendoim e agua gelada, 04/11/2018 | " +
                        "Joao Neto, Joabe, Bolo de trigo com cobertura de chocolate, 08/11/2018 | Joao Neto, Joabe, Doce sabor beijinho, 07/11/2018 | " +
                        "Joao Neto, Severo, Garrafa de agua 500ml, 08/11/2018 | Zana, Severo, Cocada de doce de leite com pedacos de amendoim, 05/11/2018", control.listarCompras());
    }
}