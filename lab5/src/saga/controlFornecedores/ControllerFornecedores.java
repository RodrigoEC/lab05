package saga.controlFornecedores;

import saga.AvaliadorClientes;
import saga.ValidaFornecedor;

import java.util.HashMap;
/**
 * Classe responsável por criar um controller responsável por fazer operações sobre objetos do tipo Fornecedor.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class ControllerFornecedores {
    /**
     * Mapa de objetos do tipo Fornecedor, onde a chave é o nome do fornecedor.
     */
    private HashMap<String, Fornecedor> mapaFornecedores;

    /**
     * Atributo que representa um objeto reponsavel por avaliar os parâmetros, lançando as exceções adequadas se
     * necessário.
     */
    private ValidaFornecedor avalia;

    /**
     * Construtor responsável por criar o objeto do tipo ControllerFornecedores e inicializar os atributos da classe.
     */
    public ControllerFornecedores() {
        this.mapaFornecedores = new HashMap<>();
        this.avalia = new ValidaFornecedor();
    }

    /**
     * Método que deixa acessível o atributo mapaFornecedores.
     *
     * @return o hashMap mapaFornecedores.
     */
    public HashMap<String, Fornecedor> getMapaFornecedores() {
        return this.mapaFornecedores;
    }

    /**
     * Método responsável por criar e cadastrar um objeto do tipo Fornecedor e adiciona-lo ao mapa de Fornecedores.
     * Caso algum dos parâmetros passados seja uma string vazia, apenas de espaços ou um valor null uma exceção
     * será lançada.
     *
     * @param fornecedor Nome do fornecedor.
     * @param email E-mail do fornecedor.
     * @param telefone Telefone do fornecedor.
     */
    public void cadastraFornecedor(String fornecedor, String email, String telefone) {
        this.avalia.validaNomeFornecedor(fornecedor);
        this.avalia.validaEmailFornecedor(email);
        this.avalia.validaTelefoneFornecedor(telefone);

        if (!this.mapaFornecedores.containsKey(fornecedor)) {
            Fornecedor novoFornecedor = new Fornecedor(fornecedor, email, telefone);
            this.mapaFornecedores.put(fornecedor, novoFornecedor);
        } else {
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        }
    }

    /**
     * Método responsável por retornar a representacao textual do fornecedor, cujo nome é passado como parâmetro. Caso
     * o parâmetro seja uma string vazia, apenas de espaços ou um valor null uma exceção será lançada.
     *
     * @param fornecedor nome do fornecedor.
     * @return A representação textual do fornecedor.
     */
    public String dadosFornecedor(String fornecedor){
        this.avalia.validaNomeFornecedor(fornecedor);

        return this.mapaFornecedores.get(fornecedor).toString();
    }

    /**
     * Método responsável por retornar as representações textuais de todos os fornecedores cadastrados.
     *
     * @return A representação textual de todos os fornecedores.
     */
    public String dadosTodosFornecedores() {
        String stringSaida = "";
        boolean contador = true;
        for (Fornecedor fornecedor : this.mapaFornecedores.values()) {
            if (contador) {
                stringSaida += fornecedor.toString();
                contador = false;
            } else {
                stringSaida += " | " + fornecedor.toString();
            }
        }
        return stringSaida;
    }

    /**
     * Método responsável por alterar o email do fornecedor, cujo nome é passado como parâmetro, pelo novo email que foi
     * passado como parâmetro. Caso algum dos parâmetros seja uma string vazia, apenas de espaços ou um valor null uma
     * exceção será lançada.
     *
     * @param fornecedor nome do fornecedor.
     * @param novoEmail novo e-mail que substituirá o antigo.
     */
    public void editaEmail(String fornecedor, String novoEmail) {
        this.avalia.validaEmailFornecedor(novoEmail);
        this.mapaFornecedores.get(fornecedor).setEmail(novoEmail);
    }

    /**
     * Método responsável por alterar o telefone do fornecedor, cujo nome é passado como parâmetro, pelo novo telefone
     * que foi passado como parâmetro. Caso algum dos parâmetros seja uma string vazia, apenas de espaços ou um valor
     * null uma exceção será lançada.
     *
     * @param fornecedor Nome do fornecedor.
     * @param novoTelefone Novo telefone que substituirá o antigo.
     */
    public void editaTelefone(String fornecedor, String novoTelefone) {
        this.avalia.validaTelefoneFornecedor(novoTelefone);
        this.mapaFornecedores.get(fornecedor).setTelefone(novoTelefone);
    }

    /**
     * Método responsável por remover um fornecedor, cujo nome é passado como parâmetro, do hashMap de clientes. Caso o
     * parâmetro seja uma string vazia, apenas de espaços, um valor null  ou um nome não cadastrado uma exceção será
     * lançada.
     *
     * @param fornecedor Nome do fornecedor.
     */
    public void removeFornecedor(String fornecedor) {
        this.avalia.validaEmailFornecedor(fornecedor);

        if (this.mapaFornecedores.containsKey(fornecedor)) {
            this.mapaFornecedores.remove(fornecedor);
        } else {
            throw new NullPointerException("KEY INEXISTENTE");
        }
    }

    // PARTE RELACIONADA A PRODUTOS

    /**
     * Método que cria um novo produto baseado no preço, no nome do produto e na sua descrição e o adiciona no mapa de
     * produtos de determinado fornecedor, cujo nome foi passado como o parâmetro "fornecedor". Caso algum dos
     * parâmetros passados seja uma string vazia, apenas de espaços ou um valor null uma exceção será lançada.
     *
     * @param fornecedor nome do fornecedor.
     * @param preco preço do produto.
     * @param nomeProduto nome do produto.
     * @param descricao descrição do produto.
     */
    public void addProduto(String fornecedor, String preco, String nomeProduto, String descricao) {
        if (!this.mapaFornecedores.)
        this.mapaFornecedores.get(fornecedor).addProduto(preco, nomeProduto, descricao);
    }

    /**
     * Método que retorna a representacao textual do produto, baseando-se no nome e na descrição, de determinado
     * fornecedor, cujo nome foi passado como parâmetro. Caso algum dos parâmetros passados seja uma string vazia,
     * apenas de espaços ou um valor null uma exceção será lançada.
     *
     * @param fornecedor Nome do fornecedor.
     * @param nomeProduto Nome do produto.
     * @param descricao Descrição fo produto.
     *
     * @return Os dados do produto de um fornecedor específico.
     */
    public String dadosProduto(String fornecedor, String nomeProduto, String descricao) {
        return this.mapaFornecedores.get(fornecedor).dadosProduto(nomeProduto, descricao);
    }

    /**
     * Método que retorna a representação textual de todos os produtos que foram adicionados ao fornecedor, cujo nome
     * foi passado como parâmetro.
     *
     * @param fornecedor nome do fornecedor.
     * @return A representação textual de todos os produtos.
     */
    public String dadosTodosProdutosFornecedor(String fornecedor) {
        return this.mapaFornecedores.get(fornecedor).dadosTodosProdutos();
    }

    /**
     * Método responsável por alterar o preço do produto, cujo nome e descrição sao iguais aos parametros, produto esse
     * de um determinado forncedor cujo no é passado como parâmetro.Caso algum dos parâmetros passados seja uma string
     * vazia, apenas de espaços ou um valor null uma exceção será lançada.
     *
     * @param fornecedor Nome do fornecedor.
     * @param novoPreco novo preço a ser alterado.
     * @param nomeProduto nome do produto que terá o preço alterado.
     * @param descricao descrição do produto que terá o preço alterado.
     */
    public void editaProduto(String fornecedor, String nomeProduto, String descricao, String novoPreco) {
        this.mapaFornecedores.get(fornecedor).editaProduto(novoPreco, nomeProduto, descricao);
    }

    /**
     * Método responsável por remover um produto ja cadastrados de um fornecedor também ja cadastrado.Caso algum dos
     * parâmetros passados seja uma string vazia, apenas de espaços ou um valor null uma exceção será lançada.
     * Além disso, se a key não existir no mapa, uma exceção também será lançada.
     *
     * @param fornecedor Nome do fornecedor
     * @param nomeProduto Nome do produto.
     * @param descricao Descrição do produto.
     */
    public void removeProduto(String fornecedor, String nomeProduto, String descricao) {
        this.mapaFornecedores.get(fornecedor).removeProduto(nomeProduto, descricao);
    }

    /**
     * Método responsável por criar uma representação texutal de todos os produtos cadastrados de todos os fornecedores
     * cadastrados.
     *
     * @return uma string com todas as representações textuais de todos os produtos cadastrados em todos os fornecedores.
     */
    public String dadosTodosProdutos() {
        String stringSaida = "";
        boolean contador = true;
        for (Fornecedor fornecedor : this.mapaFornecedores.values()) {
            if (contador) {
                stringSaida += dadosTodosProdutosFornecedor(fornecedor.getNome());
                contador = false;
            } else {
                stringSaida += " | ";
                stringSaida += dadosTodosProdutosFornecedor(fornecedor.getNome());
            }
        }
        return stringSaida;
    }
}
