package saga;

import saga.contasControl.Conta;
import saga.controlClientes.ControllerClientes;
import saga.controlFornecedores.ControllerFornecedores;
import saga.pacoteDeOrdenacoes.OrdenaData;
import saga.pacoteDeOrdenacoes.OrdenaFornecedor;
import saga.pacoteDeOrdenacoes.OrdenaNome;
import saga.pacoteDeOrdenacoes.Ordenacao;

import java.util.*;

/**
 * Essa classe e responsavel por reunir em uma fachada os controllers das outras classes.
 *
 * @author rodrigo Eloy Cavalcanti - 118210111
 */
public class ControllerGeral {

    private Map<String, Conta> contas;

    private Ordenacao ordenacao;
    /**
     * Controller da classe Cliente.
     */
    private ControllerClientes controlaClientes;

    /**
     * Controller da classe Fornecedor
     */
    private ControllerFornecedores controlaFornecedores;



    /**
     * Construtor responsavel por criar o objeto do tipo Facade e  incializar seus atributos.
     */
    public ControllerGeral() {
        this.controlaClientes  = new ControllerClientes();
        this.controlaFornecedores = new ControllerFornecedores();
        this.contas = new HashMap<>();
    }

    // PARTE DO CONTROLLER DOS CLIENTES

    /**
     * Metodo responsavel por criar e cadastrar um novo cliente, cujo atributos são passados como parâmetros do metodo.
     * Caso algum dos parâmetros passados seja uma string vazia, apenas de espaços ou um valor null uma exceção
     * sera lançada.
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
     * Metodo responsavel por retornar a representacao textual do cliente, cujo cpf e passado como parâmetro. Caso
     * o parâmetro seja uma string vazia, apenas de espaços ou um valor null uma exceção sera lançada.
     *
     * @param cpf cpf do cliente.
     * @return representação textual do cliente.
     */
    public String exibeCliente(String cpf) {
        return this.controlaClientes.dadosCliente(cpf);
    }

    /**
     * Metodo responsavel por retornar as representações textuais de todos os clientes cadastrados.
     *
     * @return as representações textuais dos clientes.
     */
    public String exibeClientes() {
        return controlaClientes.dadosTodosClientes();
    }


    /**
     * Metodo responsavel por chamar o metodo o metodo "editaCliente" no controller de clientes.
     *
     * @param cpf cpf do cliente.
     * @param atributo atributo a ser alterado.
     * @param novoValor valor que sera colocado no atributo.
     */
    public void editaCliente(String cpf, String atributo, String novoValor) {
        this.controlaClientes.editaCliente(cpf, atributo, novoValor);
    }



    /**
     * Metodo responsavel por remover o cliente, cujo cpf e passado como parâmetro, do hashMap de clientes. Caso o
     * parâmetro seja uma string vazia, apenas de espaços, um valor null  ou um cpf não cadastrado uma exceção sera
     * lançada.
     *
     * @param cpf cpf do cliente que sera removido.
     */
    public void removeCliente(String cpf) {
        this.controlaClientes.removeCliente(cpf);
    }

    // PARTE DO CONTROLLER DOS FORNECEDORES


    /**
     * Metodo responsavel por criar e cadastrar um objeto do tipo Fornecedor e adiciona-lo ao mapa de Fornecedores.
     * Caso algum dos parâmetros passados seja uma string vazia, apenas de espaços ou um valor null uma exceção
     * sera lançada.
     *
     * @param nome Nome do fornecedor.
     * @param email E-mail do fornecedor.
     * @param telefone Telefone do fornecedor.
     * @return nome do fornecedor.
     */
    public String adicionaFornecedor(String nome, String email, String telefone) {
        return this.controlaFornecedores.cadastraFornecedor(nome, email, telefone);
    }

    /**
     * Metodo responsavel por retornar a representacao textual do fornecedor, cujo nome e passado como parâmetro. Caso
     * o parâmetro seja uma string vazia, apenas de espaços ou um valor null uma exceção sera lançada.
     *
     * @param nome nome do fornecedor.
     * @return A representação textual do fornecedor.
     */
    public String exibeFornecedor(String nome) {
        return this.controlaFornecedores.dadosFornecedor(nome);
    }

    /**
     * Metodo responsavel por retornar as representações textuais de todos os fornecedores cadastrados.
     *
     * @return A representação textual de todos os fornecedores.
     */
    public String exibeFornecedores() {
        return this.controlaFornecedores.dadosTodosFornecedores();
    }


    /**
     * Metodo responsavel por alterar o atributo que e passado como parâmetro novo valor que foi passado como parâmetro.
     * Caso algum dos parâmetros seja uma string vazia, apenas de espaços ou um valor null uma exceção sera lançada.
     *
     * @param nome nome do fornecedor
     * @param atributo atributo a ser modificado
     * @param novoValor valor a ser atribuito ao atributo
     */
    public void editaFornecedor(String nome, String atributo, String novoValor) {
        this.controlaFornecedores.editaFornecedor(nome, atributo, novoValor);
    }


    /**
     * Metodo responsavel por remover um fornecedor, cujo nome e passado como parâmetro, do hashMap de clientes. Caso o
     * parâmetro seja uma string vazia, apenas de espaços, um valor null  ou um nome não cadastrado uma exceção sera
     * lançada.
     *
     * @param fornecedor Nome do fornecedor.
     */
    public void removeFornecedor(String fornecedor) {
        this.controlaFornecedores.removeFornecedor(fornecedor);
    }

    /**
     * Metodo que cria um novo produto baseado no preço, no nome do produto e na sua descrição e o adiciona no mapa de
     * produtos de determinado fornecedor, cujo nome foi passado como o parâmetro "fornecedor". Caso algum dos
     * parâmetros passados seja uma string vazia, apenas de espaços ou um valor null uma exceção sera lançada.
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
     * Metodo que retorna a representacao textual do produto, baseando-se no nome e na descrição, de determinado
     * fornecedor, cujo nome foi passado como parâmetro. Caso algum dos parâmetros passados seja uma string vazia,
     * apenas de espaços ou um valor null uma exceção sera lançada.
     *
     * @param fornecedor Nome do fornecedor.
     * @param nomeProduto Nome do produto.
     * @param descricao Descrição fo produto.
     *
     * @return Os dados do produto de um fornecedor especfico.
     */
    public String exibeProduto( String fornecedor, String nomeProduto, String descricao) {
        return this.controlaFornecedores.exibeProduto(fornecedor, nomeProduto, descricao);
    }

    /**
     * Metodo que retorna a representação textual de todos os produtos que foram adicionados ao fornecedor, cujo nome
     * foi passado como parâmetro.
     *
     * @param fornecedor nome do fornecedor.
     * @return A representação textual de todos os produtos.
     */
    public String exibeProdutosFornecedor(String fornecedor) {
        return this.controlaFornecedores.dadosTodosProdutosFornecedor(fornecedor);
    }

    /**
     * Metodo responsavel por criar uma representação texutal de todos os produtos cadastrados de todos os fornecedores
     * cadastrados.
     *
     * @return uma string com todas as representações textuais de todos os produtos cadastrados em todos os fornecedores.
     */
    public String exibeProdutos() {
        return this.controlaFornecedores.dadosTodosProdutos();
    }

    /**
     * Metodo responsavel por alterar o preço do produto, cujo nome e descrição sao iguais aos parametros, produto esse
     * de um determinado forncedor cujo no e passado como parâmetro.Caso algum dos parâmetros passados seja uma string
     * vazia, apenas de espaços ou um valor null uma exceção sera lançada.
     *
     * @param fornecedor Nome do fornecedor.
     * @param novoPreco novo preço a ser alterado.
     * @param nomeProduto nome do produto que tera o preço alterado.
     * @param descricao descrição do produto que tera o preço alterado.
     */
    public void editaProduto(String fornecedor, String nomeProduto, String descricao, double novoPreco)   {
        this.controlaFornecedores.editaProduto(fornecedor, nomeProduto, descricao, novoPreco);
    }

    /**
     * Metodo responsavel por remover um produto ja cadastrados de um fornecedor tambem ja cadastrado.Caso algum dos
     * parâmetros passados seja uma string vazia, apenas de espaços ou um valor null uma exceção sera lançada.
     * Alem disso, se a key não existir no mapa, uma exceção tambem sera lançada.
     *
     * @param fornecedor Nome do fornecedor
     * @param nomeProduto Nome do produto.
     * @param descricao Descrição do produto.
     */
    public void removeProduto(String fornecedor, String nomeProduto, String descricao) {
        this.controlaFornecedores.removeProduto(fornecedor, nomeProduto, descricao);
    }

    /**
     * Metodo responsavel por adicionar um novo Combo.
     *
     * @param fornecedor nome do fornecedor
     * @param nomeCombo nome do combo.
     * @param descricaoCombo descrição do combo.
     * @param fator fator responsavel por alterar o preço do combo baseado nos produtos
     * @param produtos string com os produtos.
     */
    public void adicionaCombo(String fornecedor, String nomeCombo, String descricaoCombo, double fator, String produtos) {
        this.controlaFornecedores.addCombo(fornecedor, nomeCombo, descricaoCombo, fator, produtos);
    }

    /**
     * Metodo que edita o fator de um combo, alterando assim o seu preço.
     *
     * @param nome nome do combo.
     * @param descricao descrição do combo.
     * @param nomeFornecedor nome do fornecedor.
     * @param fator novo fator.
     */
    public void editaCombo(String nome, String descricao, String nomeFornecedor, double fator) {
        this.controlaFornecedores.editaCombo(nome, descricao, nomeFornecedor, fator);
    }

    /**
     * Metodo responsavel por adicionar uma nova compra.
     *
     * @param cpf cpf do cliente.
     * @param fornecedor nome do fornecedor.
     * @param data data da compra.
     * @param nomeProd nome do produto.
     * @param descProd descrição do produto.
     */
    public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProd, String descProd) {
        ValidaEntradasDeMetodos.validaEntradasAddCompra(cpf, fornecedor, data, nomeProd, descProd);

        double precoCompra  = this.controlaFornecedores.getValor(fornecedor, nomeProd, descProd);
        String nomeCliente = this.controlaClientes.getNomeCliente(cpf);

        Conta novaConta = new Conta(nomeCliente, fornecedor, data, nomeProd, descProd, precoCompra);

        if (this.contas.containsKey(cpf + " - " + fornecedor)) {
            this.contas.get(cpf + " - " + fornecedor).addCompra(data, nomeProd, descProd, precoCompra);
        } else {
            this.contas.put(cpf + " - " + fornecedor, novaConta);
        }

    }

    /**
     * Metodo responsavel por retornar o número double que representa o debito de um cliente para um fornecedor.
     *
     * @param cpf cpf do cliente.
     * @param fornecedor nome do fornecedor.
     *
     * @return debito de um cliente com um determinado fornecedor.
     */
    public double getDebito(String cpf, String fornecedor) {
        ValidaEntradasDeMetodos.validaEntradasGetDebito(cpf, fornecedor);

        if (!this.controlaClientes.containsClient(cpf)) {
            throw new NullPointerException("Erro ao recuperar debito: cliente nao existe.");
        }

        if (this.controlaFornecedores.containsFornecedor(fornecedor)) {
            throw new NullPointerException("Erro ao recuperar debito: fornecedor nao existe.");
        }

        if (!this.contas.containsKey(cpf + " - " + fornecedor)) {
            throw new NullPointerException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
        }
        return this.contas.get(cpf + " - " + fornecedor).debitoTotal();
    }

    /**
     * Metodo reponsavel por retornar a representação textual de um determinado cpf em determinado fornecedor.
     *
     * @param cpf cpf do cliente.
     * @param fornecedor nome do fornecedor.
     * @return representação textual de um cliente em determinado fornecedor.
     */
    public String exibeContas(String cpf, String fornecedor) {
        ValidaEntradasDeMetodos.validaEntradasExibeContas(cpf, fornecedor);

        if (!this.controlaClientes.containsClient(cpf)) {
            throw new NullPointerException("Erro ao exibir conta do cliente: cliente nao existe.");
        }

        if (this.controlaFornecedores.containsFornecedor(fornecedor)) {
            throw new NullPointerException("Erro ao exibir conta do cliente: fornecedor nao existe.");
        }

        if (!this.contas.containsKey(cpf + " - " + fornecedor)) {
            throw new NullPointerException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
        }

        return this.contas.get(cpf + " - " + fornecedor).toString();
    }

    /**
     * Metodo responsavel por exibir a representação textual de todas as contas de um determinado cliente.
     *
     * @param cpf cpf do cliente.
     * @return a representação textual das contas de determinado cliente.
     */
    public String exibeContasClientes(String cpf) {
        ValidaEntradasDeMetodos.validaEntradaExibeContasCliente(cpf);

        if (!this.controlaClientes.containsClient(cpf)) {
            throw new NullPointerException("Erro ao exibir contas do cliente: cliente nao existe.");
        }

        String nomeCliente = this.controlaClientes.getClientes().get(cpf).getNome();
        String representaContas = "Cliente: " + nomeCliente;

        ArrayList<Conta> listaContas = new ArrayList<>(contas.values());

        Collections.sort(listaContas);

        int contadorContas = 0;
        for (Conta conta: listaContas) {
            if (conta.getNomeCliente().equals(nomeCliente)) {
                representaContas += conta.exibeConta();
                contadorContas += 1;
            }
        }
        if (contadorContas == 0) {
            throw new NullPointerException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
        }

        return representaContas;
    }

    /**
     * Metodo que representa o pagamento do debito de um cliente para o seu fornecedor, fazendo com que a conta do cliente
     * com o fornecedor seja apagado
     *
     * @param cpf cpf do cliente.
     * @param fornecedor nome do fornecedor.
     */
    public void realizaPagamento(String cpf, String fornecedor) {
        ValidaEntradasDeMetodos.validaEntradasRealizaPagamento(cpf, fornecedor);

        if (!this.controlaClientes.containsClient(cpf)) {
            throw new NullPointerException("Erro no pagamento de conta: cliente nao existe.");
        }

        if (this.controlaFornecedores.containsFornecedor(fornecedor)) {
            throw new NullPointerException("Erro no pagamento de conta: fornecedor nao existe.");
        }

        if (!this.contas.containsKey(cpf + " - " + fornecedor)) {
            throw new NullPointerException("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
        }

        this.contas.remove(cpf + " - " + fornecedor);
    }

    /**
     * Metodo responsavel por definir qual o tipo de ordenacao que sera feita.
     *
     * @param criterio criterio de ordencao.
     */
    public void ordenaPor(String criterio) {
        ValidaEntradasDeMetodos.ValidaEntradasOrdenaPor(criterio);

        if ("cliente".equals(criterio.toLowerCase())) {
            this.ordenacao = new OrdenaNome();
        } else if ("fornecedor".equals(criterio.toLowerCase())) {
            this.ordenacao = new OrdenaFornecedor();
        } else if ("data".equals(criterio.toLowerCase())) {
            this.ordenacao = new OrdenaData();
        }
    }

    /**
     * listar todas as compras baseados no criterio que deve ser anteriormente definidio.
     * @return a string que representa as compras, ordenadas de acordo com o criterio definido.
     */
    public String listarCompras() {
        if (this.ordenacao == null) {
            throw new NullPointerException("Erro na listagem de compras: criterio ainda nao definido pelo sistema.");
        }
        return this.ordenacao.ordenacao(this.contas);
    }
}

