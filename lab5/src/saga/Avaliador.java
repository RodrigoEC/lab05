package saga;

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
