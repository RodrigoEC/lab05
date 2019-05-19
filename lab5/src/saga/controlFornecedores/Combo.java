package saga.controlFornecedores;

/**
 * Método que representa um Objeto do tipo Combo que tambem eh um objeto do tipo Produto.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class Combo extends Produto {

    /**
     * Array de do nome dos produtos que compoem o combo.
     */
    private String[] produtos;

    /**
     * Construtor responsável por construiu um objeto "Combo" baseado no seu nome, descrição, preco e um array do nome e descrição
     * dos produtos que compoem o combo.
     *
     * @param nomeCombo nome do combo.
     * @param descricaoCombo descrição do combo.
     * @param preco preço do combo.
     * @param produtos array de nomes dos produtos que compoem o combo.
     */
    public Combo(String nomeCombo, String descricaoCombo, double preco, String[] produtos) {
        super(nomeCombo, descricaoCombo, preco);
        this.produtos = produtos;
    }

    /**
     * Método que deixa disponível o atributo "produtos".
     *
     * @return o array de nomes dos produtos que compoem o combo.
     */
    @Override
    public String[] getProdutos() {
        return produtos;
    }
}
