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

    public void cadastraFornecedor(String nome, String email, String telefone) {
        this.avalia.avaliar(nome);
        this.avalia.avaliar(email);
        this.avalia.avaliar(telefone);

        if (!this.mapaFornecedores.containsKey(nome)) {
            Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
            this.mapaFornecedores.put(nome, fornecedor);
        }
    }

    public String dadosFornecedor(String nome) {
        this.avalia.avaliar(nome);

        return this.mapaFornecedores.get(nome).toString();
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
        this.avalia.avaliar(novoEmail);
        this.mapaFornecedores.get(nome).setEmail(novoEmail);
    }

    public void removeFornecedor(String nome) {
        this.avalia.avaliar(nome);

        if (this.mapaFornecedores.containsKey(nome)) {
            this.mapaFornecedores.remove(nome);
        } else {
            throw new NullPointerException("KEY INEXISTENTE");
        }
    }

    public void addProduto(String nome, String preco, String nomeProduto, String descricao) {
        this.mapaFornecedores.get(nome).addProduto(preco, nomeProduto, descricao);
    }

    public String dadosProduto(String nome, String nomeProduto, String descricao) {
        return this.mapaFornecedores.get(nome).dadosProduto(nomeProduto, descricao);
    }

    public String dadosTodosProdutosFornecedor(String nome) {
        return this.mapaFornecedores.get(nome).dadosTodosProdutos();
    }

    public void editaProduto(String nome, String nomeProduto, String descricao, String novoPreco) {
        this.mapaFornecedores.get(nome).editaProduto(novoPreco, nomeProduto, descricao);
    }


    public void removeProduto(String nome, String nomeProduto, String descricao) {
        this.mapaFornecedores.get(nome).removeProduto(nomeProduto, descricao);
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
