package saga;

/**
 * Classe que representa um avaliador que vê se uma string é nula ou invalida, lançando a exceção adequada.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class Avaliador {
    public void avaliar(String stringASerAvaliada) {
        if (stringASerAvaliada == null) {
            throw new NullPointerException("PARAMETRO NULO");
        }
        if (stringASerAvaliada.trim().equals("")) {
            throw new IllegalArgumentException("PARAMETRO INVALIDO");
        }
    }
}
