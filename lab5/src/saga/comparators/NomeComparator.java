package saga.comparators;

import saga.contasControl.Conta;

import java.util.Comparator;

/**
 * Classe que eh um comparador de dois objetos do tipo Conta, comparando-os baseado no nome do cliente.
 */
public class NomeComparator implements Comparator<Conta> {

    /**
     * Metodo responsavel pro comparar 2 objetos do tipo Conta.
     *
     * @param conta conta a ser comparada.
     * @param t1 conta a ser comparada.
     * @return um inteiro dependendo do resultado da comparacao.
     */
    @Override
    public int compare(Conta conta, Conta t1) {
        return conta.getNomeCliente().compareTo(t1.getNomeCliente());
    }
}
