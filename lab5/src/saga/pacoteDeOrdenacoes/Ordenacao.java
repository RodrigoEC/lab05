package saga.pacoteDeOrdenacoes;

import saga.contasControl.Conta;

import java.util.ArrayList;
import java.util.Map;

/**
 * Classe que representa a interface das classes que fazem diferentes tipos de ordenação.
 */
public interface Ordenacao {

    /**
     * Metodo que deve existir em todas as classes que implementem essa interface.
     *
     * @param contas mapa das contas
     * @return String com as compras ordenadas baseado em um criterio definido.
     */
    public String ordenacao(Map<String, Conta> contas);
}
