package saga.contasControl;

/**
 * Classe que representa uma compra realizado com nome, descrição, data e preço.
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
     * Descrição do produto.
     */
    private String descrProduto;

    /**
     * Preço da compra realizada.
     */
    private double preco;

    /**
     * Construtor responsável por construir um objeto baseado na data, no nome do produto, descriçao e preço.
     *
     * @param data data da compra.
     * @param produto nome do produto comprado.
     * @param descrProduto descrição do produto comprado.
     * @param preco preço da compra.
     */
    public Compra(String data, String produto, String descrProduto, double preco) {
        this.data = data;
        this.produto = produto;
        this.descrProduto = descrProduto;
        this.preco = preco;
    }

    /**
     * Método responsável por retornar o atributo "preco";
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
     * Método que eh a representação textual de uma compra.
     *
     * @return representação textual de uma compra.
     */
    @Override
    public String toString() {
        return String.format("%s - %s",produto, data.replace("/", "-"));
    }

    /**
     * Método que determina o que será comparável entre dois objetos do tipo Compra.
     *
     * @param compra objeto do tipo Compra.
     * @return um inteiro que representa a comparação dos dois objetos.
     */
    @Override
    public int compareTo(Compra compra) {
        return this.toString().compareTo(compra.toString());
    }
}
