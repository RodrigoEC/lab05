package saga.comparators;

import saga.contasControl.Compra;
import saga.contasControl.Conta;

import java.util.Comparator;

public class DataComparator implements Comparator<Compra> {

    /**
     * Metodo que eh responsavel por comparar as compras baseado nas datas que elas foram realizadas.
     *
     * @param o1 compra 1.
     * @param o2 compra 2
     * @return um inteiro baseado no resultado da comparacao.
     */
    @Override
    public int compare(Compra o1, Compra o2) {
        String[] dataO1 = o1.getData().split("/");
        String[] dataO2 = o1.getData().split("/");

        if (dataO1[2].compareTo(dataO2[2]) != 0) {
            return dataO1[2].compareTo(dataO2[2]);

        } else if (dataO1[1].compareTo(dataO2[1]) != 0) {
            return dataO1[1].compareTo(dataO2[1]);

        } else {
            return dataO1[0].compareTo(dataO2[0]);

        }
    }
}
