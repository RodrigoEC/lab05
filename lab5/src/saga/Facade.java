package saga;

public class Facade {
    private ControllerClientes controlaClientes;
    private ControllerFornecedores controlaFornecedores;
    private Avaliador avalia = new Avaliador();

    public Facade() {
        controlaClientes  = new ControllerClientes();
        controlaFornecedores = new ControllerFornecedores();
    }

    // PARTE DO CONTROLLER DOS CLIENTES

    public String cadastraCliente(String cpf, String nome, String email, String local) {
        avalia.avaliar(cpf);
        avalia.avaliar(nome);
        avalia.avaliar(email);
        avalia.avaliar(local);
        return controlaClientes.cadastraCliente(cpf, nome, email, local);
    }

    public String dadosCliente(String cpf) {
        avalia.avaliar(cpf);
        return controlaClientes.dadosCliente(cpf);
    }

    public String dadosTodosClientes() {
        return controlaClientes.dadosTodosClientes();
    }

    public void editarNome(String cpf, String novoNome) {
        avalia.avaliar(cpf);
        avalia.avaliar(novoNome);
        controlaClientes.editaNome(cpf, novoNome);
    }

    public void editaEmail(String cpf, String novoEmail) {
        avalia.avaliar(cpf);
        avalia.avaliar(novoEmail);
        controlaClientes.editaEmail(cpf, novoEmail);
    }

    public void editaLocal(String cpf, String novoLocal) {
        avalia.avaliar(cpf);
        avalia.avaliar(novoLocal);
        controlaClientes.editaLocal(cpf, novoLocal);
    }

    public void removeCliente(String cpf) {
        avalia.avaliar(cpf);
        controlaClientes.removeCliente(cpf);
    }

    // PARTE DO CONTROLLER DOS FORNECEDORES

    public void cadastrarFornecedores(String nome, String email, String telefone) {
        avalia.avaliar(nome);
        avalia.avaliar(email);
        avalia.avaliar(telefone);
        controlaFornecedores.cadastraFornecedor(nome, email, telefone);
    }

    public String dadosFornecedor(String nome) {
        avalia.avaliar(nome);
        return controlaFornecedores.dadosFornecedor(nome);
    }

    public String dadosDeTodosFornecedores() {
        return controlaFornecedores.dadosTodosFornecedores();
    }

    public void editaEmailFornecedor(String nome, String novoEmail) {
        avalia.avaliar(nome);
        avalia.avaliar(novoEmail);
        controlaFornecedores.editaEmail(nome, novoEmail);
    }

    public void removeFornecedor(String nome) {
        avalia.avaliar(nome);
        controlaFornecedores.removeFornecedor(nome);
    }







}
