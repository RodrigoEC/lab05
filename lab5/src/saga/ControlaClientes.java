package saga;

import java.security.InvalidKeyException;
import java.util.HashMap;

public class ControlaClientes {
    private HashMap<String, Cliente> clientes;
    private Avaliador avalia;

    public ControlaClientes() {
        clientes = new HashMap<>();
        avalia = new Avaliador();
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
        return clientes.get(cpf).toString();

    }


    public String dadosTodosClientes() {
        String stringSaida = "";
        int contador = 0;
        for (Cliente cliente : this.clientes.values()) {
            if (contador == 0) {
                stringSaida += cliente.toString();
            } else {
                stringSaida += " | " + cliente.toString();
            }
        }
        return stringSaida;
    }
}
