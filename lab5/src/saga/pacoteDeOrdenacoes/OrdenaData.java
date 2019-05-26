package saga.pacoteDeOrdenacoes;

import saga.contasControl.Conta;
import saga.pacoteDeOrdenacoes.Ordenacao;

import java.util.Map;


public class OrdenaData implements Ordenacao {
    @Override
    public String ordenacao(Map<String, Conta> contas) {
        return "Não consegui fazer isso, beijos e abraços a todos <3";
    }
}
