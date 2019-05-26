package saga.contasControl;

import java.util.*;

/**
 * Classe que representa a conta, a qual possui o noem do cliente que possui a conta e o fornecedor de onde a conta foi
 * cadastrada calem de uma lista de compras realizadas pelo cliente no fornecedor.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class Conta implements Comparable<Conta> {
    /**
     * Nome do cliente.
     */
    private String nomeCliente;

    /**
     * nome do fornecedor.
     */
    private String nomeFornecedor;

    /**
     * lista de objetos do tipo Compra..
     */
    private ArrayList<Compra> compras;

    /**
     * Construtor responsavel por construir uma conta baseada no nome do cliente, do fornecedor, no nome do produto, na
     * sua descricao, da data da primeira compra e no preco da primeira compra;
     *
     * @param nomeCliente nome do cliente.
     * @param nomeFornecedor nome do fornecedor.
     * @param data data dda primeira compra;
     * @param nomeProd nome do produto que foi comprado.
     * @param descProd descricao do produto.
     * @param precoCompra preco da primeira compra;
     */
    public Conta(String nomeCliente, String nomeFornecedor, String data, String nomeProd, String descProd, double precoCompra) {
        this.nomeCliente = nomeCliente;
        this.nomeFornecedor = nomeFornecedor;
        this.compras = new ArrayList<>();
        Compra compra = new Compra(data, nomeProd, descProd, precoCompra);
        compras.add(compra);

    }

    /**
     * Metodo responsavel por criar e cadastras uma compra.
     *
     * @param data data da compra;
     * @param nomeProd nome do produto;
     * @param descrProd descricao do produto;
     * @param precoCompra preco da compra.
     */
    public void addCompra(String data, String nomeProd, String descrProd, double precoCompra) {
        Compra novaCompra = new Compra(data, nomeProd, descrProd, precoCompra);
        this.compras.add(novaCompra);
    }


    /**
     * Metodo que deixa disponvel o atributo "NomeCLiente" que representa o nome do cliente.
     *
     * @return atributo "nomeCliente".
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * Metodo que deixa disponvel o atributo "NomeFornecedor" que representa o nome do fornecedor.
     *
     * @return atributo "nomeFornecedor".
     */
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    /**
     * Metodo que deixa disponvel o atributo "compras" que representa as compras feitas pelo cliente.
     *
     * @return atributo "compras".
     */
    public ArrayList<Compra> getCompras() {
        return compras;
    }




    /**
     * Metodo que calculo o debito total de todas as compras da conta.
     *
     * @return o debito total d cliente com o fornecedor
     */
    public double debitoTotal() {
        double debitoTotal = 0;
        for (Compra compra : compras) {
            debitoTotal += compra.getPreco();
        }

        return debitoTotal;
    }


    /**
     * Metodo que cria uma representacao textual da conta.
     *
     * @return representacao textual
     */
    public String exibeConta() {
        String representacaoCompras = " | " + this.nomeFornecedor;

        for (Compra compra : compras) {
            representacaoCompras += " | " + compra.toString();
        }

        return representacaoCompras;

    }

    /**
     * Metodo que cria uma representacao textual da conta.
     *
     * @return representacao textual
     */
    @Override
    public String toString() {
        String representacaoCompra = "";

        boolean interruptor = true;
        for (Compra compra : compras) {
            if (interruptor) {
                representacaoCompra += compra.toString();
                interruptor = false;
            } else {
                representacaoCompra += " | ";
                representacaoCompra += compra.toString();
            }
        }
        return String.format("Cliente: %s | %s | %s", this.nomeCliente, this.nomeFornecedor, representacaoCompra);
    }

    /**
     * Metodo que determina o que sera comparavel entre dois objetos do tipo Conta.
     *
     * @param o objeto do tipo Conta.
     * @return um inteiro que representa a comparacao dos dois objetos.
     */
    @Override
    public int compareTo(Conta o) {
        return this.exibeConta().compareTo(o.exibeConta());
    }
}
