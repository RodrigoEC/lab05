package saga.controlFornecedores;

public class Combo extends Produto {

    private String[] produtos;
    private Enum<TipoProduto> tipoContaEnum;

    public Combo(String nomeCombo, String descricaoCombo, double preco, String[] produtos) {
        super(nomeCombo, descricaoCombo, preco);
        this.produtos = produtos;
        this.tipoContaEnum = TipoProduto.combo;
    }

    public Enum<TipoProduto> getTipoContaEnum() {
        return tipoContaEnum;
    }
}
