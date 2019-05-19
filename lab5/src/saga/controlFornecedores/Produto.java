package saga.controlFornecedores;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe que representa a construção de um produto que possui nome, descrição e preco.
 */
public class Produto implements ProdutoInterface{
    /**
     * descrição do produto
     */
    protected String descricao;

    /**
     * nome do produto.
     */
    protected String nomeProduto;

    /**
     * preço do produto.
     */
    protected double preco;

    /**
     * Atributo que representa um array vazio de produtos, com o fim de que ficasse disponível
     */
    private String[] produtos;

    /**
     * Construtor responsável por construir um objeto do tipo "Produto" a partir de um nome, descrição e preço que são
     * passados como parâmetro.
     *
     * @param nomeProduto nome do produto.
     * @param descricao descrição.
     * @param preco preço do produto.
     */
    public Produto(String nomeProduto, String descricao, double preco) {
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * Método que deixa dísponível para consulta o atributo "preco".
     *
     * @return o atributo "preco".
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Método responsável por deixar disponível para modificação o atributo "preco".
     *
     * @param preco o preço que será atribuído ao atributo "preco".
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }


    /**
     * Método reponsável por deixar disponível para consulta o atributo "produtos".
     *
     * @return Atributo produtos.
     */
    @Override
    public String[] getProdutos() {
        return this.produtos;
    }

    /**
     * Método reponsável por deixar disponível para consulta o atributo nomeProduto.
     *
     * @return Atributo nomeProduto.
     */
    @Override
    public String getNome() {
        return nomeProduto;
    }

    /**
     * Método que produz uma representação texutal do objeto, baseado no nome do produto, descrição e no
     * preço do produto.
     *
     * @return A representação textual do objeto.
     */
    @Override
    public String toString()     {
        return String.format("%s - %s - R$%,.2f", this.nomeProduto, this.descricao, this.preco);
    }

    /**
     * Metodo que serve para comparar dois objetos do tipo Cliente baseado no seus identificadores, a descrição do
     * produto e no seu nome.
     *
     * @param o Objeto a ser comparado.
     * @return True se for igual e false se não for igual.
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
     * Método que cria um novo hashCode para o objeto
     *
     * @return O novo HashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(descricao, nomeProduto);
    }


    /**
     * Método que determina o que será comparável entre dois objetos do tipo Cliente.
     *
     * @param produtoInterface interface de objetos do tipo Produto.
     * @return um inteiro que representa a comparação dos dois objetos.
     */
    @Override
    public int compareTo(ProdutoInterface produtoInterface) {
        return this.nomeProduto.compareTo(produtoInterface.getNome());
    }


}
