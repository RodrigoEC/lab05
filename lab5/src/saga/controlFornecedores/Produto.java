package saga.controlFornecedores;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe que representa a construcao de um produto que possui nome, descricao e preco.
 */
public class Produto implements ProdutoInterface{
    /**
     * descricao do produto
     */
    protected String descricao;

    /**
     * nome do produto.
     */
    protected String nomeProduto;

    /**
     * preco do produto.
     */
    protected double preco;

    /**
     * Construtor responsavel por construir um objeto do tipo "Produto" a partir de um nome, descricao e preco que sao
     * passados como parametro.
     *
     * @param nomeProduto nome do produto.
     * @param descricao descricao.
     * @param preco preco do produto.
     */
    public Produto(String nomeProduto, String descricao, double preco) {
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * Metodo que deixa disponivel para consulta o atributo "preco".
     *
     * @return o atributo "preco".
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Metodo responsavel por deixar disponivel para modificacao o atributo "preco".
     *
     * @param preco o preco que sera atribuido ao atributo "preco".
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }


    /**
     * Metodo reponsavel por deixar disponivel para consulta o atributo "produtos".
     *
     * @return Atributo produtos.
     */
    @Override
    public String[] getProdutos() {
        return null;
    }

    /**
     * Metodo reponsavel por deixar disponivel para consulta o atributo nomeProduto.
     *
     * @return Atributo nomeProduto.
     */
    @Override
    public String getNome() {
        return nomeProduto;
    }

    /**
     * Metodo que produz uma representacao texutal do objeto, baseado no nome do produto, descricao e no
     * preco do produto.
     *
     * @return A representacao textual do objeto.
     */
    @Override
    public String toString()     {
        return String.format("%s - %s - R$%,.2f", this.nomeProduto, this.descricao, this.preco);
    }

    /**
     * Metodo que serve para comparar dois objetos do tipo Cliente baseado no seus identificadores, a descricao do
     * produto e no seu nome.
     *
     * @param o Objeto a ser comparado.
     * @return True se for igual e false se nao for igual.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto that = (Produto) o;
        return descricao.equals(that.descricao) &&
                nomeProduto.equals(that.nomeProduto);
    }

    /**
     * Metodo que cria um novo hashCode para o objeto
     *
     * @return O novo HashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(descricao, nomeProduto);
    }


    /**
     * Metodo que determina o que sera comparavel entre dois objetos do tipo Cliente.
     *
     * @param produtoInterface interface de objetos do tipo Produto.
     * @return um inteiro que representa a comparacao dos dois objetos.
     */
    @Override
    public int compareTo(ProdutoInterface produtoInterface) {
        return this.nomeProduto.compareTo(produtoInterface.getNome());
    }


}
