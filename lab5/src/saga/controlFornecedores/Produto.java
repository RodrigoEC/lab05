package saga.controlFornecedores;

import java.util.Objects;

public class Produto implements ProdutoInterface{
    protected String descricao;
    protected String nomeProduto;
    protected double preco;

    /**
     * Atributo que representa um array vazio de produtos, com o fim de que ficasse disponível
     */
    private String[] produtos;

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



    @Override
    public int compareTo(ProdutoInterface produtoInterface) {
        return this.nomeProduto.compareTo(produtoInterface.getNome());
    }


}
