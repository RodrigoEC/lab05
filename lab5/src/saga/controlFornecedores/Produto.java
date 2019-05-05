package saga.controlFornecedores;

import java.util.Objects;

/**
 * Classe que cria um objeto que representa um produto em um mercado.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class Produto {
    /**
     * Atributo que representa a descrição do produto.
     */
    private String descricao;

    /**
     * Atributo que representa o nome do produto.
     */
    private String nomeProduto;

    /**
     * Atributo que representa o preço do produto.
     */
    private String preco;

    /**
     * Construtor responsável por criar o objeto baseado nos parâmetros que serão passados.
     *
     * @param preco Preço do produto.
     * @param nomeProduto Nome do produto.
     * @param descricao Descrição do produto criado.
     */
    public Produto(String preco, String nomeProduto, String descricao) {
        this.preco = preco;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
    }

    /**
     * Método que deixa dísponível para consulta o atributo "preco".
     *
     * @return o atributo "preco".
     */
    public String getPreco() {
        return preco;
    }

    /**
     * Método responsável por deixar disponível para modificação o atributo "preco".
     *
     * @param preco o preço que será atribuído ao atributo "preco".
     */
    public void setPreco(String preco) {
        this.preco = preco;
    }

    /**
     * Método que produz uma representação texutal do objeto do tipo Produto, baseado no nome do produto, descrição e no
     * preço do produto.
     *
     * @return A representação textual do objeto.
     */
    @Override
    public String toString()     {
        return String.format("%s - %s - R$%s", this.nomeProduto, this.descricao, this.preco);
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
        Produto produto = (Produto) o;
        return descricao.equals(produto.descricao) &&
                nomeProduto.equals(produto.nomeProduto);
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
}
