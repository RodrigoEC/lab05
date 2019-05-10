package saga.controlFornecedores;

import saga.Avaliador;

import java.util.HashMap;
import java.util.Objects;

/**
 * Classer responsável por criar um objeto que representa um fornecedor de um mercado.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 *
 */
public class Fornecedor {
    /**
     * Atributo que representa o nome do fornecedor.
     */
    private String nome;

    /**
     * Atributo que representa o email do fornecedor.
     */
    private String email;

    /**
     * Atributo que representa o telefone do fornecedor.
     */
    private String telefone;

    /**
     * Atributo que é um hashMap de objetos do tipo Produto, em que a chave do mapa é o nome do produto e a sua descrição.
     */
    private HashMap<String, Produto> mapaProdutos;
    private Avaliador avalia;

    /**
     * Construtor responsável por criar um objeto do tipo Fornecedor baseado nos parametros "nome", "email" e "telefone".
     *
     * @param nome nome do fornecedor.
     * @param email email do fornecedor.
     * @param telefone telefone do fornecedor.
     */
    public Fornecedor(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.mapaProdutos = new HashMap<String, Produto>();
        avalia = new Avaliador();
    }

    /**
     * metodo que deixa disponivel o atributo "email".
     *
     * @return o atributo email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * metodo que deixa disponivel o atributo "nome".
     *
     * @return o atributo nome.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que deixa disponível para consulta o atributo "mapaProdutos"
     *
     * @return O atributo mapaProdutos.
     */
    public HashMap<String, Produto> getMapaProdutos() {
        return mapaProdutos;
    }

    /**
     * Método que permite a alteração do atributo email.
     *
     * @param email email do fornecedor.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método que permite a alteração do atributo telefone.
     *
     * @param telefone Telefone do fornecedor.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Método que cria uma representação textual do objeto do tipo Fornecedor baseado nos seus atributos "nome", "email"
     * e "telefone".
     *
     * @return A representação textual do fornecedor.
     */
    @Override
    public String toString() {
        return String.format("%s - %s - %s", this.nome, this.email, this.telefone);
    }

    /**
     * Metodo que serve para  comparar dois objetos do tipo Cliente baseado no seu identificador unico, o nome.
     *
     * @param o objeto a ser comparado.
     * @return true se for igual e false se nao for igual.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fornecedor)) return false;
        Fornecedor that = (Fornecedor) o;
        return getNome().equals(that.getNome());
    }

    /**
     * Método que cria um novo hashCode para o objeto
     *
     * @return O novo HashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    // PARTE RELACIONADA A CLASSE PRODUTO

    /**
     * Método que cria um novo produto baseado no preço, no nome do produto e na sua descrição e o adiciona no mapa de
     * produtos. Caso algum dos parâmetros passados seja uma string vazia, apenas de espaços ou um valor null uma exceção
     * será lançada.
     *
     * @param preco preço do produto.
     * @param nomeProduto nome do produto.
     * @param descricao descrição do produto.
     */
    public void addProduto(double preco, String nomeProduto, String descricao) {
        this.avalia.validaPrecoProduto(preco);
        this.avalia.validaNome(nomeProduto, "fornecedor");
        this.avalia.validaDescricaoProduto(descricao);

        Produto produto = new Produto(preco, nomeProduto, descricao);
        String chave = nomeProduto + descricao;

        this.mapaProdutos.put(chave, produto);
    }

    /**
     * Método que retorna a representacao textual do produto que tem o nome e a descrição iguais aos parâmetros. Caso
     * algum dos parâmetros passados seja uma string vazia, apenas de espaços ou um valor null uma exceção será lançada.
     *
     * @param nomeProduto nome do produto.
     * @param descricao descrição do produto.
     *
     * @return A representação textual do produto.
     */
    public String dadosProduto(String nomeProduto, String descricao) {
        this.avalia.validaNome(nomeProduto, "fornecedor");
        this.avalia.validaDescricaoProduto(descricao);

        return this.mapaProdutos.get(nomeProduto + descricao).toString();
    }

    /**
     * Método que retorna a representação textual de todos os produtos que foram adicionados ao fornecedor.
     *
     * @return A representação textual de todos os produtos.
     */
    public String dadosTodosProdutos() {
        String stringSaida = "";
        boolean contador = true;
        for (Produto produto : this.mapaProdutos.values()) {
            if (contador) {
                stringSaida += this.nome + " - " + produto.toString();
                contador = false;
            } else {
                stringSaida += " | " + this.nome + " - " + produto.toString();
            }
        }
        return stringSaida;
    }

    /**
     * Método responsável por alterar o preço do produto, cujo nome e descrição sao iguais aos parametros.Caso
     * algum dos parâmetros passados seja uma string vazia, apenas de espaços ou um valor null uma exceção será lançada.
     *
     * @param novoPreco novo preço a ser alterado.
     * @param nomeProduto nome do produto que terá o preço alterado.
     * @param descricao descrição do produto que terá o preço alterado.
     */
    public void editaProduto(double novoPreco, String nomeProduto, String descricao) {
        this.avalia.validaNome(nomeProduto, "fornecedor");
        this.avalia.validaDescricaoProduto(descricao);
        this.avalia.validaPrecoProduto(novoPreco);

        this.mapaProdutos.get(nomeProduto + descricao).setPreco(novoPreco);
    }

    /**
     * Método responsável por remover um produto ja cadastrados.Caso algum dos parâmetros passados seja uma string
     * vazia, apenas de espaços ou um valor null uma exceção será lançada. Além disso, se a key não existir no mapa, uma
     * exceção também será lançada.
     *
     * @param nomeProduto Nome do produto.
     * @param descricao Descrição do produto.
     */
    public void removeProduto(String nomeProduto, String descricao) {
        this.avalia.validaNome(nomeProduto, "fornecedor");
        this.avalia.validaDescricaoProduto(descricao);

        if (!this.mapaProdutos.containsKey(nomeProduto + descricao)){
            throw new NullPointerException("KEY INEXISTENTE");
        }

        this.mapaProdutos.remove(nomeProduto + descricao);
    }
}
