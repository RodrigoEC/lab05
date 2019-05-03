package saga;

public class Facade {
    ControlaClientes controlaClientes = new ControlaClientes();
    Avaliador avalia = new Avaliador();

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
        controlaClientes.editarNome(cpf, novoNome);
    }

    public void editarEmail(String cpf, String novoEmail) {
        avalia.avaliar(cpf);
        avalia.avaliar(novoEmail);
        controlaClientes.editarEmail(cpf, novoEmail);
    }

    public void editarLocal(String cpf, String novoLocal) {
        avalia.avaliar(cpf);
        avalia.avaliar(novoLocal);
        controlaClientes.editarLocal(cpf, novoLocal);
    }

    public void removeCliente(String cpf) {
        avalia.avaliar(cpf);
        controlaClientes.removeCliente(cpf);
    }



}
