package saga;

import easyaccept.EasyAccept;
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

    public static void main(String[] args) {
        args = new String[] {"saga.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt",
                "acceptance_test/use_case_3.txt", "acceptance_test/use_case_4.txt", "acceptance_test/use_case_5.txt",
                "acceptance_test/use_case_6.txt"};
        EasyAccept.main(args);
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
    public String adicionaCliente(String cpf, String nome, String email, String local) {
        return controlaClientes.cadastraCliente(cpf, nome, email, local);
    }

    /**
     * Método responsável por retornar a representacao textual do cliente, cujo cpf é passado como parâmetro. Caso
     * o parâmetro seja uma string vazia, apenas de espaços ou um valor null uma exceção será lançada.
     *
     * @param cpf cpf do cliente.
     * @return representação textual do cliente.
     */
    public String exibeCliente(String cpf) {
        return this.controlaClientes.dadosCliente(cpf);
    }

    /**
     * Método responsável por retornar as representações textuais de todos os clientes cadastrados.
     *
     * @return as representações textuais dos clientes.
     */
    public String exibeClientes() {
        return controlaClientes.dadosTodosClientes();
    }


    /**
     * Método responsável por chamar o método o método "editaCliente" no controller de clientes.
     *
     * @param cpf cpf do cliente.
     * @param atributo atributo a ser alterado.
     * @param novoValor valor que será colocado no atributo.
     */
    public void editaCliente(String cpf, String atributo, String novoValor) {
        this.controlaClientes.editaCliente(cpf, atributo, novoValor);
    }



    /**
     * Método responsável por remover o cliente, cujo cpf é passado como parâmetro, do hashMap de clientes. Caso o
     * parâmetro seja uma string vazia, apenas de espaços, um valor null  ou um cpf não cadastrado uma exceção será
     * lançada.
     *
     * @param cpf cpf do cliente que será removido.
     */
    public void removeCliente(String cpf) {
        this.controlaClientes.removeCliente(cpf);
    }

    // PARTE DO CONTROLLER DOS FORNECEDORES


    /**
     * Método responsável por criar e cadastrar um objeto do tipo Fornecedor e adiciona-lo ao mapa de Fornecedores.
     * Caso algum dos parâmetros passados seja uma string vazia, apenas de espaços ou um valor null uma exceção
     * será lançada.
     *
     * @param nome Nome do fornecedor.
     * @param email E-mail do fornecedor.
     * @param telefone Telefone do fornecedor.
     */
    public String adicionaFornecedor(String nome, String email, String telefone) {
        return this.controlaFornecedores.cadastraFornecedor(nome, email, telefone);
    }

    /**
     * Método responsável por retornar a representacao textual do fornecedor, cujo nome é passado como parâmetro. Caso
     * o parâmetro seja uma string vazia, apenas de espaços ou um valor null uma exceção será lançada.
     *
     * @param nome nome do fornecedor.
     * @return A representação textual do fornecedor.
     */
    public String exibeFornecedor(String nome) {
        return this.controlaFornecedores.dadosFornecedor(nome);
    }

    /**
     * Método responsável por retornar as representações textuais de todos os fornecedores cadastrados.
     *
     * @return A representação textual de todos os fornecedores.
     */
    public String exibeFornecedores() {
        return this.controlaFornecedores.dadosTodosFornecedores();
    }


    /**
     * Método responsável por alterar o atributo que é passado como parâmetro novo valor que foi passado como parâmetro.
     * Caso algum dos parâmetros seja uma string vazia, apenas de espaços ou um valor null uma exceção será lançada.
     *
     * @param nome nome do fornecedor
     * @param atributo atributo a ser modificado
     * @param novoValor valor a ser atribuito ao atributo
     */
    public void editaFornecedor(String nome, String atributo, String novoValor) {
        this.controlaFornecedores.editaFornecedor(nome, atributo, novoValor);
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
    public void adicionaProduto(String fornecedor, String nomeProduto, String descricao, double preco) {
        this.controlaFornecedores.addProduto(fornecedor, nomeProduto, descricao, preco);
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
    public String exibeProduto(String nomeProduto, String descricao, String fornecedor) {
        return this.controlaFornecedores.exibeProduto(fornecedor, nomeProduto, descricao);
    }

    /**
     * Método que retorna a representação textual de todos os produtos que foram adicionados ao fornecedor, cujo nome
     * foi passado como parâmetro.
     *
     * @param fornecedor nome do fornecedor.
     * @return A representação textual de todos os produtos.
     */
    public String exibeProdutosFornecedor(String fornecedor) {
        return this.controlaFornecedores.dadosTodosProdutosFornecedor(fornecedor);
    }

    /**
     * Método responsável por criar uma representação texutal de todos os produtos cadastrados de todos os fornecedores
     * cadastrados.
     *
     * @return uma string com todas as representações textuais de todos os produtos cadastrados em todos os fornecedores.
     */
    public String exibeProdutos() {
        return this.controlaFornecedores.dadosTodosProdutos();
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
    public void editaProduto(String nomeProduto, String descricao, String fornecedor, double novoPreco)   {
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
    public void removeProduto(String nomeProduto, String descricao, String fornecedor) {
        this.controlaFornecedores.removeProduto(fornecedor, nomeProduto, descricao);
    }

    /**
     * Método responsável por adicionar um novo Combo.
     *
     * @param fornecedor nome do fornecedor
     * @param nomeCombo nome do combo.
     * @param descricaoCombo descrição do combo.
     * @param fator fator responsável por alterar o preço do combo baseado nos produtos
     * @param produtos string com os produtos.
     */
    public void adicionaCombo(String fornecedor, String nomeCombo, String descricaoCombo, double fator, String produtos) {
        this.controlaFornecedores.addCombo(fornecedor, nomeCombo, descricaoCombo, fator, produtos);
    }

    /**
     * Método que edita o fator de um combo, alterando assim o seu preço.
     *
     * @param nome nome do combo.
     * @param descricao descrição do combo.
     * @param nomeFornecedor nome do fornecedor.
     * @param fator novo fator.
     */
    public void editaCombo(String nome, String descricao, String nomeFornecedor, double fator) {
        this.controlaFornecedores.editaCombo(nome, descricao, nomeFornecedor, fator);
    }
}
