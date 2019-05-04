package saga;

import saga.controlClientes.ControllerClientes;
import saga.controlFornecedores.ControllerFornecedores;

public class Facade {
    private ControllerClientes controlaClientes;
    private ControllerFornecedores controlaFornecedores;

    public Facade() {
        this.controlaClientes  = new ControllerClientes();
        this.controlaFornecedores = new ControllerFornecedores();
    }

    // PARTE DO CONTROLLER DOS CLIENTES

    public String cadastraCliente(String cpf, String nome, String email, String local) {
        return controlaClientes.cadastraCliente(cpf, nome, email, local);
    }

    public String dadosCliente(String cpf) {
        return controlaClientes.dadosCliente(cpf);
    }

    public String dadosTodosClientes() {
        return controlaClientes.dadosTodosClientes();
    }

    public void editarNome(String cpf, String novoNome) {
        controlaClientes.editaNome(cpf, novoNome);
    }

    public void editaEmail(String cpf, String novoEmail) {
        controlaClientes.editaEmail(cpf, novoEmail);
    }

    public void editaLocal(String cpf, String novoLocal) {
        controlaClientes.editaLocal(cpf, novoLocal);
    }

    public void removeCliente(String cpf) {
        controlaClientes.removeCliente(cpf);
    }

    // PARTE DO CONTROLLER DOS FORNECEDORES

    public void cadastrarFornecedores(String nome, String email, String telefone) {
        this.controlaFornecedores.cadastraFornecedor(nome, email, telefone);
    }

    public String dadosFornecedor(String nome) {
        return this.controlaFornecedores.dadosFornecedor(nome);
    }

    public String dadosDeTodosFornecedores() {
        return this.controlaFornecedores.dadosTodosFornecedores();
    }

    public void editaEmailFornecedor(String nome, String novoEmail) {
        this.controlaFornecedores.editaEmail(nome, novoEmail);
    }

    public void editaTelefoneFornecedor(String nome, String novoTelefone) {
        this.controlaFornecedores.editaTelefone(nome, novoTelefone);
    }

    public void removeFornecedor(String nome) {
        this.controlaFornecedores.removeFornecedor(nome);
    }

    public void addProduto(String nome, String preco, String nomeProduto, String descricao) {
        this.controlaFornecedores.addProduto(nome, preco, nomeProduto, descricao);
    }

    public void dadosProduto(String nome, String nomeProduto, String descricao) {
        this.controlaFornecedores.dadosProduto(nome, nomeProduto, descricao);
    }

    public void dadosDosProdutosDoFornecedor(String nome) {
        this.controlaFornecedores.dadosTodosProdutosFornecedor(nome);
    }

    public void dadosDeTodosOsProdutos() {
        this.controlaFornecedores.dadosTodosProdutos();
    }

    public void editaProduto(String nome, String novoPreco, String nomeProduto, String descricao)   {
        this.controlaFornecedores.editaProduto(nome, nomeProduto, descricao, novoPreco);
    }

    public void removeProduto(String nome, String nomeProduto, String descricao) {
        this.controlaFornecedores.removeProduto(nome, nomeProduto, descricao);
    }
}
