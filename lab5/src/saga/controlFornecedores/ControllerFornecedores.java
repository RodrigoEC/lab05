package saga.controlFornecedores;

import saga.Avaliador;

import java.util.HashMap;

public class ControllerFornecedores {
    private HashMap<String, Fornecedor> mapaFornecedores;
    private Avaliador avalia;


    public ControllerFornecedores() {
        this.mapaFornecedores = new HashMap<String, Fornecedor>();
        this.avalia = new Avaliador();
    }

    public HashMap<String, Fornecedor> getMapaFornecedores() {
        return this.mapaFornecedores;
    }

    public void cadastraFornecedor(String fornecedor, String email, String telefone) {
        this.avalia.avaliar(fornecedor);
        this.avalia.avaliar(email);
        this.avalia.avaliar(telefone);

        if (!this.mapaFornecedores.containsKey(fornecedor)) {
            Fornecedor novoFornecedor = new Fornecedor(fornecedor, email, telefone);
            this.mapaFornecedores.put(fornecedor, novoFornecedor);
        }
    }

    public String dadosFornecedor(String fornecedor) {
        this.avalia.avaliar(fornecedor);

        return this.mapaFornecedores.get(fornecedor).toString();
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

    public void editaEmail(String fornecedor, String novoEmail) {
        this.avalia.avaliar(novoEmail);
        this.mapaFornecedores.get(fornecedor).setEmail(novoEmail);
    }

    public void editaTelefone(String fornecedor, String novoTelefone) {
        this.avalia.avaliar(novoTelefone);
        this.mapaFornecedores.get(fornecedor).setTelefone(novoTelefone);
    }

    public void removeFornecedor(String fornecedor) {
        this.avalia.avaliar(fornecedor);

        if (this.mapaFornecedores.containsKey(fornecedor)) {
            this.mapaFornecedores.remove(fornecedor);
        } else {
            throw new NullPointerException("KEY INEXISTENTE");
        }
    }

    // PARTE RELACIONADA A PRODUTOS

    public void addProduto(String fornecedor, String preco, String nomeProduto, String descricao) {
        this.mapaFornecedores.get(fornecedor).addProduto(preco, nomeProduto, descricao);
    }

    public String dadosProduto(String fornecedor, String nomeProduto, String descricao) {
        return this.mapaFornecedores.get(fornecedor).dadosProduto(nomeProduto, descricao);
    }

    public String dadosTodosProdutosFornecedor(String fornecedor) {
        return this.mapaFornecedores.get(fornecedor).dadosTodosProdutos();
    }

    public void editaProduto(String fornecedor, String nomeProduto, String descricao, String novoPreco) {
        this.mapaFornecedores.get(fornecedor).editaProduto(novoPreco, nomeProduto, descricao);
    }


    public void removeProduto(String fornecedor, String nomeProduto, String descricao) {
        this.mapaFornecedores.get(fornecedor).removeProduto(nomeProduto, descricao);
    }

    public String dadosTodosProdutos() {
        String stringSaida = "";
        boolean contador = true;
        for (Fornecedor fornecedor : this.mapaFornecedores.values()) {
            if (contador) {
                stringSaida += dadosTodosProdutosFornecedor(fornecedor.getNome());
                contador = false;
            } else {
                stringSaida += " | ";
                stringSaida += dadosTodosProdutosFornecedor(fornecedor.getNome());
            }

        }
        return stringSaida;
    }
}
