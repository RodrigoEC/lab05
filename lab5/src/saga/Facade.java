package saga;

import easyaccept.EasyAccept;

import java.util.Locale;

/**
 * Essa classe e responsavel por reunir em uma fachada os controllers das outras classes.
 *
 * @author rodrigo Eloy Cavalcanti - 118210111
 */
public class Facade {

    ControllerGeral controllerGeral;

    /**
     * Construtor responsavel por criar o objeto do tipo Facade e  incializar seus atributos.
     */
    public Facade() {
        controllerGeral = new ControllerGeral();
    }

    public static void main(String[] args) {
        args = new String[] {"saga.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt",
                "acceptance_test/use_case_3.txt", "acceptance_test/use_case_4.txt", "acceptance_test/use_case_5.txt",
                "acceptance_test/use_case_6.txt", "acceptance_test/use_case_7.txt", "acceptance_test/use_case_8.txt"};
        EasyAccept.main(args);
    }

    // PARTE DO CONTROLLER DOS CLIENTES

    /**
     * Metodo responsavel por criar e cadastrar um novo cliente, cujo atributos sao passados como parametros do metodo.
     * Caso algum dos parametros passados seja uma string vazia, apenas de espacos ou um valor null uma excecao
     * sera lancada.
     *
     * @param cpf cpf do cliente.
     * @param nome nome do cliente.
     * @param email email do cliente.
     * @param local local que o cliente trabalha.
     * @return o cpf do cliente.
     */
    public String adicionaCliente(String cpf, String nome, String email, String local) {
        return controllerGeral.adicionaCliente(cpf, nome, email, local);
    }

    /**
     * Metodo responsavel por retornar a representacao textual do cliente, cujo cpf e passado como parametro. Caso
     * o parametro seja uma string vazia, apenas de espacos ou um valor null uma excecao sera lancada.
     *
     * @param cpf cpf do cliente.
     * @return representacao textual do cliente.
     */
    public String exibeCliente(String cpf) {
        return this.controllerGeral.exibeCliente(cpf);
    }

    /**
     * Metodo responsavel por retornar as representacões textuais de todos os clientes cadastrados.
     *
     * @return as representacões textuais dos clientes.
     */
    public String exibeClientes() {
        return controllerGeral.exibeClientes();
    }


    /**
     * Metodo responsavel por chamar o metodo o metodo "editaCliente" no controller de clientes.
     *
     * @param cpf cpf do cliente.
     * @param atributo atributo a ser alterado.
     * @param novoValor valor que sera colocado no atributo.
     */
    public void editaCliente(String cpf, String atributo, String novoValor) {
        this.controllerGeral.editaCliente(cpf, atributo, novoValor);
    }



    /**
     * Metodo responsavel por remover o cliente, cujo cpf e passado como parametro, do hashMap de clientes. Caso o
     * parametro seja uma string vazia, apenas de espacos, um valor null  ou um cpf nao cadastrado uma excecao sera
     * lancada.
     *
     * @param cpf cpf do cliente que sera removido.
     */
    public void removeCliente(String cpf) {
        this.controllerGeral.removeCliente(cpf);
    }

    // PARTE DO CONTROLLER DOS FORNECEDORES

    /**
     * Metodo responsavel por criar e cadastrar um objeto do tipo Fornecedor e adiciona-lo ao mapa de Fornecedores.
     * Caso algum dos parametros passados seja uma string vazia, apenas de espacos ou um valor null uma excecao
     * sera lancada.
     *
     * @param nome Nome do fornecedor.
     * @param email E-mail do fornecedor.
     * @param telefone Telefone do fornecedor.
     * @return O nome do fornecedor.
     */
    public String adicionaFornecedor(String nome, String email, String telefone) {
        return this.controllerGeral.adicionaFornecedor(nome, email, telefone);
    }

    /**
     * Metodo responsavel por retornar a representacao textual do fornecedor, cujo nome e passado como parametro. Caso
     * o parametro seja uma string vazia, apenas de espacos ou um valor null uma excecao sera lancada.
     *
     * @param nome nome do fornecedor.
     * @return A representacao textual do fornecedor.
     */
    public String exibeFornecedor(String nome) {
        return this.controllerGeral.exibeFornecedor(nome);
    }

    /**
     * Metodo responsavel por retornar as representacões textuais de todos os fornecedores cadastrados.
     *
     * @return A representacao textual de todos os fornecedores.
     */
    public String exibeFornecedores() {
        return this.controllerGeral.exibeFornecedores();
    }


    /**
     * Metodo responsavel por alterar o atributo que e passado como parametro novo valor que foi passado como parametro.
     * Caso algum dos parametros seja uma string vazia, apenas de espacos ou um valor null uma excecao sera lancada.
     *
     * @param nome nome do fornecedor
     * @param atributo atributo a ser modificado
     * @param novoValor valor a ser atribuito ao atributo
     */
    public void editaFornecedor(String nome, String atributo, String novoValor) {
        this.controllerGeral.editaFornecedor(nome, atributo, novoValor);
    }


    /**
     * Metodo responsavel por remover um fornecedor, cujo nome e passado como parametro, do hashMap de clientes. Caso o
     * parametro seja uma string vazia, apenas de espacos, um valor null  ou um nome nao cadastrado uma excecao sera
     * lancada.
     *
     * @param fornecedor Nome do fornecedor.
     */
    public void removeFornecedor(String fornecedor) {
        this.controllerGeral.removeFornecedor(fornecedor);
    }

    /**
     * Metodo que cria um novo produto baseado no preco, no nome do produto e na sua descricao e o adiciona no mapa de
     * produtos de determinado fornecedor, cujo nome foi passado como o parametro "fornecedor". Caso algum dos
     * parametros passados seja uma string vazia, apenas de espacos ou um valor null uma excecao sera lancada.
     *
     * @param fornecedor nome do fornecedor.
     * @param preco preco do produto.
     * @param nomeProduto nome do produto.
     * @param descricao descricao do produto.
     */
    public void adicionaProduto(String fornecedor, String nomeProduto, String descricao, double preco) {
        this.controllerGeral.adicionaProduto(fornecedor, nomeProduto, descricao, preco);
    }

    /**
     * Metodo que retorna a representacao textual do produto, baseando-se no nome e na descricao, de determinado
     * fornecedor, cujo nome foi passado como parametro. Caso algum dos parametros passados seja uma string vazia,
     * apenas de espacos ou um valor null uma excecao sera lancada.
     *
     * @param fornecedor Nome do fornecedor.
     * @param nomeProduto Nome do produto.
     * @param descricao Descricao fo produto.
     *
     * @return Os dados do produto de um fornecedor especifico.
     */
    public String exibeProduto(String nomeProduto, String descricao, String fornecedor) {
        return this.controllerGeral.exibeProduto(fornecedor, nomeProduto, descricao);
    }

    /**
     * Metodo que retorna a representacao textual de todos os produtos que foram adicionados ao fornecedor, cujo nome
     * foi passado como parametro.
     *
     * @param fornecedor nome do fornecedor.
     * @return A representacao textual de todos os produtos.
     */
    public String exibeProdutosFornecedor(String fornecedor) {
        return this.controllerGeral.exibeProdutosFornecedor(fornecedor);
    }

    /**
     * Metodo responsavel por criar uma representacao texutal de todos os produtos cadastrados de todos os fornecedores
     * cadastrados.
     *
     * @return uma string com todas as representacões textuais de todos os produtos cadastrados em todos os fornecedores.
     */
    public String exibeProdutos() {
        return this.controllerGeral.exibeProdutos();
    }

    /**
     * Metodo responsavel por alterar o preco do produto, cujo nome e descricao sao iguais aos parametros, produto esse
     * de um determinado forncedor cujo no e passado como parametro.Caso algum dos parametros passados seja uma string
     * vazia, apenas de espacos ou um valor null uma excecao sera lancada.
     *
     * @param fornecedor Nome do fornecedor.
     * @param novoPreco novo preco a ser alterado.
     * @param nomeProduto nome do produto que tera o preco alterado.
     * @param descricao descricao do produto que tera o preco alterado.
     */
    public void editaProduto(String nomeProduto, String descricao, String fornecedor, double novoPreco)   {
        this.controllerGeral.editaProduto(fornecedor, nomeProduto, descricao, novoPreco);
    }

    /**
     * Metodo responsavel por remover um produto ja cadastrados de um fornecedor tambem ja cadastrado.Caso algum dos
     * parametros passados seja uma string vazia, apenas de espacos ou um valor null uma excecao sera lancada.
     * Alem disso, se a key nao existir no mapa, uma excecao tambem sera lancada.
     *
     * @param fornecedor Nome do fornecedor
     * @param nomeProduto Nome do produto.
     * @param descricao Descricao do produto.
     */
    public void removeProduto(String nomeProduto, String descricao, String fornecedor) {
        this.controllerGeral.removeProduto(fornecedor, nomeProduto, descricao);
    }

    /**
     * Metodo responsavel por adicionar um novo Combo.
     *
     * @param fornecedor nome do fornecedor
     * @param nomeCombo nome do combo.
     * @param descricaoCombo descricao do combo.
     * @param fator fator responsavel por alterar o preco do combo baseado nos produtos
     * @param produtos string com os produtos.
     */
    public void adicionaCombo(String fornecedor, String nomeCombo, String descricaoCombo, double fator, String produtos) {
        this.controllerGeral.adicionaCombo(fornecedor, nomeCombo, descricaoCombo, fator, produtos);
    }

    /**
     * Metodo que edita o fator de um combo, alterando assim o seu preco.
     *
     * @param nome nome do combo.
     * @param descricao descricao do combo.
     * @param nomeFornecedor nome do fornecedor.
     * @param fator novo fator.
     */
    public void editaCombo(String nome, String descricao, String nomeFornecedor, double fator) {
        this.controllerGeral.editaCombo(nome, descricao, nomeFornecedor, fator);
    }

    /**
     * Metodo responsavel por adicionar uma nova compra.
     *
     * @param cpf cpf do cliente.
     * @param fornecedor nome do fornecedor.
     * @param data data da compra.
     * @param nomeProd nome do produto.
     * @param descProd descricao do produto.
     */
    public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProd, String descProd) {
        this.controllerGeral.adicionaCompra(cpf, fornecedor, data, nomeProd, descProd);
    }

    /**
     * Metodo responsavel por retornar o número double que representa o debito de um cliente para um fornecedor.
     *
     * @param cpf cpf do cliente.
     * @param fornecedor nome do fornecedor.
     *
     * @return debito de um cliente com um determinado fornecedor.
     */
    public String getDebito(String cpf, String fornecedor) {
        return String.format(Locale.ENGLISH,"%.2f", this.controllerGeral.getDebito(cpf, fornecedor));
    }

    /**
     * Metodo reponsavel por retornar a representacao textual de um determinado cpf em determinado fornecedor.
     *
     * @param cpf cpf do cliente.
     * @param fornecedor nome do fornecedor.
     * @return representacao textual de um cliente em determinado fornecedor.
     */
    public String exibeContas(String cpf, String fornecedor) {
        return this.controllerGeral.exibeContas(cpf, fornecedor);
    }

    /**
     * Metodo responsavel por exibir a representacao textual de todas as contas de um determinado cliente.
     *
     * @param cpf cpf do cliente.
     * @return a representacao textual das contas de determinado cliente.
     */
    public String exibeContasClientes(String cpf) {
        return this.controllerGeral.exibeContasClientes(cpf);
    }

    /**
     * Metodo que representa o pagamento do debito de um cliente para o seu fornecedor, fazendo com que a conta do cliente
     * com o fornecedor seja apagado
     *
     * @param cpf cpf do cliente.
     * @param fornecedor nome do fornecedor.
     */
    public void realizaPagamento(String cpf, String fornecedor) {
        this.controllerGeral.realizaPagamento(cpf, fornecedor);
    }

    /**
     * Metodo responsavel por definir qual o tipo de ordenacao que sera feita.
     *
     * @param criterio criterio de ordencao.
     */
    public void ordenaPor(String criterio) {
        this.controllerGeral.ordenaPor(criterio);
    }

    /**
     * listar todas as compras baseados no criterio que deve ser anteriormente definidio.
     * @return a string que representa todas as compras.
     */
    public String listarCompras() {
        return this.controllerGeral.listarCompras();
    }

}
