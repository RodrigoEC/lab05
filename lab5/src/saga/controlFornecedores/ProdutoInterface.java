package saga.controlFornecedores;

import java.util.ArrayList;

/**
 * Interface de objetos do tipo Produto.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public interface ProdutoInterface extends Comparable<ProdutoInterface>{

    /**
     * Metodo responsavel por deixar disponivel o atributo produtos dos objetos que implementam essa interface.
     * @return atributo produtos.
     */
    public String[] getProdutos();

    /**
     * Metodo responsavel por deixar disponivel o atributo nome dos objetos que implementam essa interface.
     * @return atributo nome.
     */
    public String getNome();

    /**
     * Metodo responsavel por modificar o preço de um objeto baseado no novoPreço que eh passado como parâmetro.
     *
     * @param novoPreco novo preço que sera atribuido ao objeto.
     */
    public void setPreco(double novoPreco);

    /**
     * Metodo responsavel por deixar disponivel o atributo preço dos objetos que implementam essa interface.
     * @return atributo preço.
     */
    public double getPreco();
}
