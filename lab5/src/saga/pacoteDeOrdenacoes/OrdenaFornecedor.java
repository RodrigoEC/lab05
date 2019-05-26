package saga.pacoteDeOrdenacoes;

import saga.comparators.FornecedorComparator;
import saga.contasControl.Compra;
import saga.contasControl.Conta;
import saga.pacoteDeOrdenacoes.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Classe que eh responsavel por ordenar as contas baseadas no nome do fornecedor.
 */
public class OrdenaFornecedor implements Ordenacao {
    /**
     * Metodo responsável por ordenar o mapa de contas e retornar uma string que representa todos as contas ordenadas por
     * fornecedor
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
                listaRepresentacoes.add(String.format("%s, %s, %s, %s", conta.getNomeFornecedor(), conta.getNomeCliente(), compra.getDescrProduto(), compra.getData()));
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
     * Método que auxilia a ordenacao, sendo responsavel por ordenar a lista a partir do nome do fornecedor.
     *
     * @param listaDeContas lista com todas as contas.
     * @return lista de contas ordenada.
     */
    private ArrayList<Conta> ordenaLista(ArrayList<Conta> listaDeContas) {
        FornecedorComparator comparadorPorFornecedor = new FornecedorComparator();
        listaDeContas.sort(comparadorPorFornecedor);

        return listaDeContas;
    }
}
