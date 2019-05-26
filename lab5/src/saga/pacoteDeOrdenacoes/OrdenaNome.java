package saga.pacoteDeOrdenacoes;

import saga.comparators.NomeComparator;
import saga.contasControl.Compra;
import saga.contasControl.Conta;
import saga.pacoteDeOrdenacoes.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
/**
 * Classe que ordena as contas baseados nome do cliente.
 */
public class OrdenaNome implements Ordenacao {
    /**
     * Metodo responsável por ordenar o mapa de contas e retornar uma string que representa todos as contas ordenadas de
     * acorddo com o nome do cliente.
     *
     *
     * @param contas mapa de contas.
     * @return string que representa todas as contas ordenadas por fornecedor
     */
    @Override
    public String ordenacao(Map<String, Conta> contas) {
        ArrayList<Conta> listaDeContas = new ArrayList<>(contas.values());
        ordenaLista(listaDeContas);

        boolean contador = true;
        ArrayList<String> listaRepresentacoes = new ArrayList<>();
        for (Conta conta : listaDeContas) {
            for (Compra compra : conta.getCompras()) {
                listaRepresentacoes.add(String.format("%s, %s, %s, %s", conta.getNomeCliente(), conta.getNomeFornecedor(), compra.getDescrProduto(), compra.getData()));
            }
        }
        Collections.sort(listaRepresentacoes);

        String stringSaida = "";
        for (String representacao : listaRepresentacoes) {
            if (contador) {
                stringSaida += representacao;
                contador = false;
            } else {
                stringSaida += " | " + representacao;
            }
        }

        return stringSaida;
    }
    /**
     * Método que auxilia a ordenacao, sendo responsavel por ordenar a lista a partir do nome do cliente.
     *
     * @param listaDeContas lista com todas as contas.
     * @return lista de contas ordenada.
     */
    private ArrayList<Conta> ordenaLista(ArrayList<Conta> listaDeContas) {
        NomeComparator comparadorPorNome = new NomeComparator();
        Collections.sort(listaDeContas, comparadorPorNome);

        return listaDeContas;
    }
}
