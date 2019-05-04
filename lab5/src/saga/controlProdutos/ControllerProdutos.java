package saga.controlProdutos;

import saga.Avaliador;
import saga.controlFornecedores.ControllerFornecedores;
import saga.controlFornecedores.Fornecedor;

public class ControllerProdutos {
    private Avaliador avalia;
    private ControllerFornecedores controleFornecedores;

    public ControllerProdutos() {
        this.avalia = new Avaliador();
        this.controleFornecedores = new ControllerFornecedores();
    }

    public ControllerFornecedores getControleFornecedores() {
        return controleFornecedores;
    }

    public void addProduto(String fornecedor, String preco, String nomeProduto, String descricao) {
        this.avalia.avaliar(fornecedor);
        this.avalia.avaliar(preco);
        this.avalia.avaliar(nomeProduto);
        this.avalia.avaliar(descricao);

        if (this.controleFornecedores.getMapaFornecedores().containsKey(fornecedor)) {
            this.controleFornecedores.getMapaFornecedores().get(fornecedor).addProduto(preco, nomeProduto, descricao);
        } else {
            throw  new NullPointerException("KEY INEXISTENTE");
        }
    }

    public String dadosProduto(String fornecedor, String nomeProduto, String descricao) {
        this.avalia.avaliar(fornecedor);
        this.avalia.avaliar(nomeProduto);
        this.avalia.avaliar(descricao);

        if (this.controleFornecedores.getMapaFornecedores().containsKey(fornecedor)) {
            return this.controleFornecedores.getMapaFornecedores().get(fornecedor).dadosProduto(nomeProduto, descricao);
        } else {
            throw  new NullPointerException("KEY INEXISTENTE");
        }
    }

    public String dadosTodosProdutosFornecedor(String fornecedor) {
        this.avalia.avaliar(fornecedor);

        if (this.controleFornecedores.getMapaFornecedores().containsKey(fornecedor)) {
            return this.controleFornecedores.getMapaFornecedores().get(fornecedor).dadosTodosProdutos();
        } else {
            throw new NullPointerException("KEY INEXISTENTE");
        }

    }

    public String dadosTodosProdutos() {
        String stringSaida = "";
        boolean contador = true;
        for (Fornecedor fornecedor : this.controleFornecedores.getMapaFornecedores().values()) {
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

    public void editaProduto(String fornecedor, String nomeProduto, String descricao, String novoPreco) {
        this.avalia.avaliar(nomeProduto);
        this.avalia.avaliar(descricao);
        this.avalia.avaliar(novoPreco);

        if (!this.controleFornecedores.getMapaFornecedores().containsKey(fornecedor)) {
            throw new NullPointerException("KEYS INEXISTENTE");
        }
        this.controleFornecedores.getMapaFornecedores().get(fornecedor).editaProduto(novoPreco, nomeProduto, descricao);
    }

    public void removeProduto(String fornecedor, String nomeProduto, String descricao) {
        this.avalia.avaliar(fornecedor);
        this.avalia.avaliar(nomeProduto);
        this.avalia.avaliar(descricao);

        if (!this.controleFornecedores.getMapaFornecedores().containsKey(fornecedor)) {
            throw new NullPointerException("KEYS INEXISTENTE");
        }

        this.controleFornecedores.getMapaFornecedores().get(fornecedor).removeProduto(nomeProduto, descricao);
    }
}
