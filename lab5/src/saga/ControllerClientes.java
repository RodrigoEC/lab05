package saga;

import java.security.InvalidKeyException;
import java.util.HashMap;

public class ControllerClientes {
    private HashMap<String, Cliente> clientes;
    private Avaliador avalia;

    public ControllerClientes() {
        clientes = new HashMap<>();
        avalia = new Avaliador();
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public String cadastraCliente(String cpf, String nome, String email, String local) {
        avalia.avaliar(cpf);
        avalia.avaliar(nome);
        avalia.avaliar(email);
        avalia.avaliar(local);
        if (!clientes.containsKey(cpf)) {
            Cliente cliente = new Cliente(cpf, nome, email, local);
            clientes.put(cpf, cliente);
            return cpf;
        } else {
            throw new IllegalArgumentException("CLIENTE JA CADASTRADO");
        }
    }

    public String dadosCliente(String cpf) {
        avalia.avaliar(cpf);
        return clientes.get(cpf).toString();

    }

    public String dadosTodosClientes() {
        String stringSaida = "";
        boolean contador = true;
        for (Cliente cliente : this.clientes.values()) {
            if (contador) {
                stringSaida += cliente.toString();
                contador = false;
            } else {
                stringSaida += " | " + cliente.toString();
            }
        }
        return stringSaida;
    }

    public void editaNome(String cpf, String novoNome) {
        avalia.avaliar(cpf);
        avalia.avaliar(novoNome);
        clientes.get(cpf).setNome(novoNome);
    }

    public void editaEmail(String cpf, String novoEmail) {
        avalia.avaliar(cpf);
        avalia.avaliar(novoEmail);
        clientes.get(cpf).setEmail(novoEmail);
    }

    public void editaLocal(String cpf, String novoLocal) {
        avalia.avaliar(cpf);
        avalia.avaliar(novoLocal);
        clientes.get(cpf).setLocalizacao(novoLocal);
    }

    public void removeCliente(String cpf) {
        avalia.avaliar(cpf);
        clientes.remove(cpf);
    }
}
