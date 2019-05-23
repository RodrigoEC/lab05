package saga.comparators;

import saga.contasControl.Conta;

import java.util.Comparator;

public class NomeComparator implements Comparator<Conta> {
    @Override
    public int compare(Conta conta, Conta t1) {
        return conta.getNomeCliente().compareTo(t1.getNomeCliente());
    }
}
