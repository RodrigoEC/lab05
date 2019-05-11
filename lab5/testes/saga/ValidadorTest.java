package saga;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorTest {

    private Validador validador;

    @BeforeEach
    void validadorPadrao() {
        validador = new Validador();
    }


    @Test
    void cpfGrande() {
        try {
            validador.validarCPFCliente("014785236987");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void cpfPequeno() {
        try {
            validador.validarCPFCliente("6987");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void nomeNulo() {
        try {
            validador.validaNome(null, "allalala");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void nomeInvalido() {
        try {
            validador.validaNome("  ", "lalalal");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void emailNulo() {
        try {
            validador.validaEmail(null, "allalala");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }


    @Test
    void emailInvalido() {
        try {
            validador.validaEmail("  ", "lalalal");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void localizacaoNulo() {
        try {
            validador.validaLocalizacao(null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }


    @Test
    void localInvalido() {
        try {
            validador.validaLocalizacao("  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void telefoneNulo() {
        try {
            validador.validaTelefone(null);
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }


    @Test
    void telefoneInvalido() {
        try {
            validador.validaTelefone("  ");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void atributoNulo() {
        try {
            validador.validaAtributo(null, "eeeee");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }


    @Test
    void atributoInvalido() {
        try {
            validador.validaAtributo("  ", "eeee");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void novoValorNulo() {
        try {
            validador.validaNovoValor(null, "eeee");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }


    @Test
    void novoValorInvalido() {
        try {
            validador.validaNovoValor("  ", "eeee");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }


    @Test
    void precoInvalido() {
        try {
            validador.validaPrecoProduto(-1, "eeee");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void descricaoProdutoNulo() {
        try {
            validador.validaDescricaoProduto(null, "eeee");
            fail("era pra dar ruim");
        } catch (NullPointerException npe) {
        }
    }


    @Test
    void descricaoProdutoInvalido() {
        try {
            validador.validaDescricaoProduto("  ", "eeee");
            fail("era pra dar ruim");
        } catch (IllegalArgumentException iae) {
        }
    }
}