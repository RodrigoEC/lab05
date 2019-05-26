package saga.contasControl;

/**
 * Classe que representa uma compra realizado com nome, descricao, data e preco.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class Compra implements Comparable<Compra>{

    /**
     * Data da compra.
     */
    private String data;

    /**
     * nome do produto.
     */
    private String produto;

    /**
     * Descricao do produto.
     */
    private String descrProduto;

    /**
     * Preco da compra realizada.
     */
    private double preco;

    /**
     * Construtor responsavel por construir um objeto baseado na data, no nome do produto, descricao e preco.
     *
     * @param data data da compra.
     * @param produto nome do produto comprado.
     * @param descrProduto descricao do produto comprado.
     * @param preco preco da compra.
     */
    public Compra(String data, String produto, String descrProduto, double preco) {
        this.data = data;
        this.produto = produto;
        this.descrProduto = descrProduto;
        this.preco = preco;
    }

    /**
     * Metodo responsavel por retornar o atributo "preco";
     *
     * @return atributo preco;
     */
    public double getPreco() {
        return preco;
    }

    public String getProduto() {
        return produto;
    }

    public String getDescrProduto() {
        return descrProduto;
    }

    public String getData() {
        return data;
    }

    /**
     * Metodo que eh a representacao textual de uma compra.
     *
     * @return representacao textual de uma compra.
     */
    @Override
    public String toString() {
        return String.format("%s - %s",produto, data.replace("/", "-"));
    }

    /**
     * Metodo que determina o que sera comparavel entre dois objetos do tipo Compra.
     *
     * @param compra objeto do tipo Compra.
     * @return um inteiro que representa a comparacao dos dois objetos.
     */
    @Override
    public int compareTo(Compra compra) {
        return this.toString().compareTo(compra.toString());
    }
}
