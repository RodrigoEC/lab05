package saga.controlFornecedores;

import java.util.Objects;

public class Produto {
    private String descricao;
    private String nomeProduto;
    private String preco;

    public Produto(String preco, String nomeProduto, String descricao) {
        this.preco = preco;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    @Override
    public String toString()     {
        return String.format("%s - %s - R$%s", this.nomeProduto, this.descricao, this.preco);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return descricao.equals(produto.descricao) &&
                nomeProduto.equals(produto.nomeProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, nomeProduto);
    }
}
