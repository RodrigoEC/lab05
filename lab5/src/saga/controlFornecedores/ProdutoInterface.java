package saga.controlFornecedores;

import java.util.ArrayList;

/**
 * Interface de objetos do tipo Produto.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public interface ProdutoInterface extends Comparable<ProdutoInterface>{

    /**
     * Método responsável por deixar disponível o atributo produtos dos objetos que implementam essa interface.
     * @return atributo produtos.
     */
    String[] getProdutos();

    /**
     * Método responsável por deixar disponível o atributo nome dos objetos que implementam essa interface.
     * @return atributo nome.
     */
    String getNome();

    /**
     * Método responsável por modificar o preço de um objeto baseado no novoPreço que eh passado como parâmetro.
     *
     * @param novoPreco novo preço que será atribuído ao objeto.
     */
    void setPreco(double novoPreco);

    /**
     * Método responsável por deixar disponível o atributo preço dos objetos que implementam essa interface.
     * @return atributo preço.
     */
    double getPreco();
}
