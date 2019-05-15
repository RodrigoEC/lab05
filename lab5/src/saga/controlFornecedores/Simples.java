package saga.controlFornecedores;

/**
 * Classe que cria um objeto que representa um produto em um mercado.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class Simples extends Produto {

    private Enum<TipoProduto> tipoProdutoEnum;

    /**
     * Construtor responsável por criar o objeto baseado nos parâmetros que serão passados.
     *
     * @param preco Preço do produto.
     * @param nomeProduto Nome do produto.
     * @param descricao Descrição do produto criado.
     */
    public Simples(String nomeProduto, String descricao, double preco) {
        super(nomeProduto, descricao, preco);
        this.tipoProdutoEnum = TipoProduto.simples;
    }

}
