package saga.controlFornecedores;

/**
 * Metodo que representa um Objeto do tipo Combo que tambem eh um objeto do tipo Produto.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class Combo extends Produto {

    /**
     * Array de do nome dos produtos que compoem o combo.
     */
    private String[] produtos;

    /**
     * Construtor responsavel por construiu um objeto "Combo" baseado no seu nome, descricao, preco e um array do nome e descricao
     * dos produtos que compoem o combo.
     *
     * @param nomeCombo nome do combo.
     * @param descricaoCombo descricao do combo.
     * @param preco preco do combo.
     * @param produtos array de nomes dos produtos que compoem o combo.
     */
    public Combo(String nomeCombo, String descricaoCombo, double preco, String[] produtos) {
        super(nomeCombo, descricaoCombo, preco);
        this.produtos = produtos;
    }

    /**
     * Metodo que deixa disponivel o atributo "produtos".
     *
     * @return o array de nomes dos produtos que compoem o combo.
     */
    @Override
    public String[] getProdutos() {
        return produtos;
    }
}
