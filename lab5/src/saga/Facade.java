package saga;

import saga.controlClientes.ControllerClientes;
import saga.controlFornecedores.ControllerFornecedores;
import saga.controlProdutos.ControllerProdutos;

public class Facade {
    private ControllerClientes controlaClientes;
    private ControllerFornecedores controlaFornecedores;
    private ControllerProdutos controlaProdutos;

    public Facade() {
        controlaClientes  = new ControllerClientes();
        controlaFornecedores = new ControllerFornecedores();
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
        controlaFornecedores.cadastraFornecedor(nome, email, telefone);
    }

    public String dadosFornecedor(String nome) {
        return controlaFornecedores.dadosFornecedor(nome);
    }

    public String dadosDeTodosFornecedores() {
        return controlaFornecedores.dadosTodosFornecedores();
    }

    public void editaEmailFornecedor(String nome, String novoEmail) {
        controlaFornecedores.editaEmail(nome, novoEmail);
    }

    public void removeFornecedor(String nome) {
        controlaFornecedores.removeFornecedor(nome);
    }

    public void addProduto(String nome, String preco, String nomeProduto, String descricao) {
        controlaProdutos.addProduto(nome, preco, nomeProduto, descricao);
    }

    public void dadosProduto(String nome, String nomeProduto, String descricao) {
        controlaProdutos.dadosProduto(nome, nomeProduto, descricao);
    }

    public void dadosDosProdutosDoFornecedor(String nome) {
        controlaProdutos.dadosTodosProdutosFornecedor(nome);
    }

    public void dadosDeTodosOsProdutos() {
        controlaProdutos.dadosTodosProdutos();
    }

    public void editaProduto(String nome, String novoPreco, String nomeProduto, String descricao)   {
        controlaProdutos.editaProduto(nome, nomeProduto, descricao, novoPreco);
    }

    public void removeProduto(String nome, String nomeProduto, String descricao) {
        controlaProdutos.removeProduto(nome, nomeProduto, descricao);
    }
}
