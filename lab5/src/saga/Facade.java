package saga;

import saga.controlClientes.ControllerClientes;
import saga.controlFornecedores.ControllerFornecedores;

/**
 * Essa classe é responsável por reunir em uma fachada os controllers das outras classes.
 *
 * @author rodrigo Eloy Cavalcanti - 118210111
 */
public class Facade {

    /**
     * Controller da classe Cliente.
     */
    private ControllerClientes controlaClientes;

    /**
     * Controller da classe Fornecedor
     */
    private ControllerFornecedores controlaFornecedores;

    /**
     * Construtor responsável por criar o objeto do tipo Facade e  incializar seus atributos.
     */
    public Facade() {
        this.controlaClientes  = new ControllerClientes();
        this.controlaFornecedores = new ControllerFornecedores();
    }

    // PARTE DO CONTROLLER DOS CLIENTES

    /**
     * Método responsável por criar e cadastrar um novo cliente, cujo atributos são passados como parâmetros do método.
     * Caso algum dos parâmetros passados seja uma string vazia, apenas de espaços ou um valor null uma exceção
     * será lançada.
     *
     * @param cpf cpf do cliente.
     * @param nome nome do cliente.
     * @param email email do cliente.
     * @param local local que o cliente trabalha.
     * @return o cpf do cliente.
     */
    public String cadastraCliente(String cpf, String nome, String email, String local) {
        return controlaClientes.cadastraCliente(cpf, nome, email, local);
    }

    /**
     * Método responsável por retornar a representacao textual do cliente, cujo cpf é passado como parâmetro. Caso
     * o parâmetro seja uma string vazia, apenas de espaços ou um valor null uma exceção será lançada.
     *
     * @param cpf cpf do cliente.
     * @return representação textual do cliente.
     */
    public String dadosCliente(String cpf) {
        return controlaClientes.dadosCliente(cpf);
    }

    /**
     * Método responsável por retornar as representações textuais de todos os clientes cadastrados.
     *
     * @return as representações textuais dos clientes.
     */
    public String dadosTodosClientes() {
        return controlaClientes.dadosTodosClientes();
    }

    /**
     * Método responsável por alterar o nome do cliente, cujo cpf é passado como parâmetro, pelo novo nome que foi
     * passado como parâmetro. Caso algum dos parâmetros seja uma string vazia, apenas de espaços ou um valor null uma
     * exceção será lançada.
     *
     * @param cpf cpf do cliente.
     * @param novoNome nome que vai substituir o nome antigo.
     */
    public void editarNome(String cpf, String novoNome) {
        controlaClientes.editaNome(cpf, novoNome);
    }

    /**
     * Método responsável por alterar o email do cliente, cujo cpf é passado como parâmetro, pelo novo email que foi
     * passado como parâmetro. Caso algum dos parâmetros seja uma string vazia, apenas de espaços ou um valor null uma
     * exceção será lançada.
     *
     * @param cpf cpf do cliente.
     * @param novoEmail email que vai substituir o email antigo.
     */
    public void editaEmail(String cpf, String novoEmail) {
        controlaClientes.editaEmail(cpf, novoEmail);
    }

    /**
     * Método responsável por alterar o local de trabalho do cliente, cujo cpf é passado como parâmetro, pelo novo local
     * que foi passado como parâmetro. Caso algum dos parâmetros seja uma string vazia, apenas de espaços ou um valor
     * null uma exceção será lançada.
     *
     * @param cpf cpf do cliente.
     * @param novoLocal local de trabalho que será substituir o atributo "localizacao" antigo.
     */
    public void editaLocal(String cpf, String novoLocal) {
        controlaClientes.editaLocal(cpf, novoLocal);
    }

    /**
     * Método responsável por remover o cliente, cujo cpf é passado como parâmetro, do hashMap de clientes. Caso o
     * parâmetro seja uma string vazia, apenas de espaços, um valor null  ou um cpf não cadastrado uma exceção será
     * lançada.
     *
     * @param cpf cpf do cliente que será removido.
     */
    public void removeCliente(String cpf) {
        controlaClientes.removeCliente(cpf);
    }

    // PARTE DO CONTROLLER DOS FORNECEDORES

    /**
     * Método responsável por criar e cadastrar um objeto do tipo Fornecedor e adiciona-lo ao mapa de Fornecedores.
     * Caso algum dos parâmetros passados seja uma string vazia, apenas de espaços ou um valor null uma exceção
     * será lançada.
     *
     * @param fornecedor Nome do fornecedor.
     * @param email E-mail do fornecedor.
     * @param telefone Telefone do fornecedor.
     */
    public void cadastrarFornecedores(String fornecedor, String email, String telefone) {
        this.controlaFornecedores.cadastraFornecedor(fornecedor, email, telefone);
    }

    /**
     * Método responsável por retornar a representacao textual do fornecedor, cujo nome é passado como parâmetro. Caso
     * o parâmetro seja uma string vazia, apenas de espaços ou um valor null uma exceção será lançada.
     *
     * @param fornecedor nome do fornecedor.
     * @return A representação textual do fornecedor.
     */
    public String dadosFornecedor(String fornecedor) {
        return this.controlaFornecedores.dadosFornecedor(fornecedor);
    }

    /**
     * Método responsável por retornar as representações textuais de todos os fornecedores cadastrados.
     *
     * @return A representação textual de todos os fornecedores.
     */
    public String dadosDeTodosFornecedores() {
        return this.controlaFornecedores.dadosTodosFornecedores();
    }

    /**
     * Método responsável por alterar o email do fornecedor, cujo nome é passado como parâmetro, pelo novo email que foi
     * passado como parâmetro. Caso algum dos parâmetros seja uma string vazia, apenas de espaços ou um valor null uma
     * exceção será lançada.
     *
     * @param fornecedor nome do fornecedor.
     * @param novoEmail novo e-mail que substituirá o antigo.
     */
    public void editaEmailFornecedor(String fornecedor, String novoEmail) {
        this.controlaFornecedores.editaEmail(fornecedor, novoEmail);
    }

    /**
     * Método responsável por alterar o telefone do fornecedor, cujo nome é passado como parâmetro, pelo novo telefone
     * que foi passado como parâmetro. Caso algum dos parâmetros seja uma string vazia, apenas de espaços ou um valor
     * null uma exceção será lançada.
     *
     * @param fornecedor Nome do fornecedor.
     * @param novoTelefone Novo telefone que substituirá o antigo.
     */
    public void editaTelefoneFornecedor(String fornecedor, String novoTelefone) {
        this.controlaFornecedores.editaTelefone(fornecedor, novoTelefone);
    }

    /**
     * Método responsável por remover um fornecedor, cujo nome é passado como parâmetro, do hashMap de clientes. Caso o
     * parâmetro seja uma string vazia, apenas de espaços, um valor null  ou um nome não cadastrado uma exceção será
     * lançada.
     *
     * @param fornecedor Nome do fornecedor.
     */
    public void removeFornecedor(String fornecedor) {
        this.controlaFornecedores.removeFornecedor(fornecedor);
    }

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
        this.controlaFornecedores.addProduto(fornecedor, preco, nomeProduto, descricao);
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
    public void dadosProduto(String fornecedor, String nomeProduto, String descricao) {
        this.controlaFornecedores.dadosProduto(fornecedor, nomeProduto, descricao);
    }

    /**
     * Método que retorna a representação textual de todos os produtos que foram adicionados ao fornecedor, cujo nome
     * foi passado como parâmetro.
     *
     * @param fornecedor nome do fornecedor.
     * @return A representação textual de todos os produtos.
     */
    public void dadosDosProdutosDoFornecedor(String fornecedor) {
        this.controlaFornecedores.dadosTodosProdutosFornecedor(fornecedor);
    }

    /**
     * Método responsável por criar uma representação texutal de todos os produtos cadastrados de todos os fornecedores
     * cadastrados.
     *
     * @return uma string com todas as representações textuais de todos os produtos cadastrados em todos os fornecedores.
     */
    public void dadosDeTodosOsProdutos() {
        this.controlaFornecedores.dadosTodosProdutos();
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
    public void editaProduto(String fornecedor, String novoPreco, String nomeProduto, String descricao)   {
        this.controlaFornecedores.editaProduto(fornecedor, nomeProduto, descricao, novoPreco);
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
        this.controlaFornecedores.removeProduto(fornecedor, nomeProduto, descricao);
    }
}
