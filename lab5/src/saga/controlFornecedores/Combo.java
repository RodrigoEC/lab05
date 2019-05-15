package saga.controlFornecedores;

import java.util.HashSet;

public class Combo extends Produto {

    private String[] produtos;

    public Combo(String nomeCombo, String descricaoCombo, double preco, String[] produtos) {
        super(nomeCombo, descricaoCombo, preco);
        this.produtos = produtos;
    }







}
