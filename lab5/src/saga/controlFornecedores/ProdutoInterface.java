package saga.controlFornecedores;

public interface ProdutoInterface extends Comparable<ProdutoInterface>{


    String getNome();

    void setPreco(double novoPreco);

    double getPreco();
}
