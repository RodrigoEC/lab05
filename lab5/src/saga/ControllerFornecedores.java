package saga;

import java.util.HashMap;

public class ControllerFornecedores {
    private HashMap<String, Fornecedor> mapaFornecedores;

    public ControllerFornecedores() {
        mapaFornecedores = new HashMap<String, Fornecedor>();
    }

    public HashMap<String, Fornecedor> getMapaFornecedores() {
        return mapaFornecedores;
    }

    public void cadastraFornecedor(String nome, String email, String telefone) {
        if (!mapaFornecedores.containsKey(nome)) {
            Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
            mapaFornecedores.put(nome, fornecedor);
        }
    }

    public String dadosFornecedor(String nome) {
        return mapaFornecedores.get(nome).toString();
    }

    public String dadosTodosFornecedores() {
        String stringSaida = "";
        boolean contador = true;
        for (Fornecedor fornecedor : this.mapaFornecedores.values()) {
            if (contador) {
                stringSaida += fornecedor.toString();
                contador = false;
            } else {
                stringSaida += " | " + fornecedor.toString();
            }
        }
        return stringSaida;
    }

    public void editaEmail(String nome, String novoEmail) {
        mapaFornecedores.get(nome).setEmail(novoEmail);
    }

    public void removeFornecedor(String nome) {
        mapaFornecedores.remove(nome);
    }
}
