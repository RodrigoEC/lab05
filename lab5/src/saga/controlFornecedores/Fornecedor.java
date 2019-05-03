package saga.controlFornecedores;

import java.util.HashMap;

public class Fornecedor {
    private String nome;
    private String email;
    private String telefone;
    private HashMap<String, Produto> mapaProdutos;

    public Fornecedor(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.mapaProdutos = new HashMap<String, Produto>();
    }

    public String getEmail() {
        return email;
    }

    public HashMap<String, Produto> getMapaProdutos() {
        return mapaProdutos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", this.nome, this.email, this.telefone);
    }

    public void addProduto(String preco,String  nomeProduto, String descricao) {
        Produto produto = new Produto(preco, nomeProduto, descricao);
        String chave = nomeProduto + descricao;
        mapaProdutos.put(chave, produto);
    }
}
