package saga.controlFornecedores;

public class Combo {

    private double preco;
    private String descricao;
    private String nome;

    public Combo(String nomeCombo, String descricaoCombo, double preco) {
        this.nome = nomeCombo;
        this.descricao = descricaoCombo;
        this.preco = preco;
    }
}
