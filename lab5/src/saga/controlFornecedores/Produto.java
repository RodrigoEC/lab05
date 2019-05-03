package saga.controlFornecedores;

public class Produto {
    private String descricao;
    private String nomeProduto;
    private String preco;

    public Produto(String preco, String nomeProduto, String descricao) {
        this.preco = preco;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
    }


}
