package saga.comparators;

import saga.contasControl.Conta;

import java.util.Comparator;

public class FornecedorComparator implements Comparator<Conta> {


    @Override
    public int compare(Conta conta, Conta t1) {
        return conta.getNomeFornecedor().compareTo(t1.getNomeFornecedor());
    }
}
