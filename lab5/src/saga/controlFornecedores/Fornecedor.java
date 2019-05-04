package saga.controlFornecedores;

import saga.Avaliador;

import java.util.HashMap;
import java.util.Objects;

public class Fornecedor {
    private String nome;
    private String email;
    private String telefone;
    private HashMap<String, Produto> mapaProdutos;
    private Avaliador avalia;

    public Fornecedor(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.mapaProdutos = new HashMap<String, Produto>();
        avalia = new Avaliador();
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public HashMap<String, Produto> getMapaProdutos() {
        return mapaProdutos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", this.nome, this.email, this.telefone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fornecedor)) return false;
        Fornecedor that = (Fornecedor) o;
        return getNome().equals(that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    // PARTE RELACIONADA A CLASSE PRODUTO

    public void addProduto(String preco,String  nomeProduto, String descricao) {
        this.avalia.avaliar(preco);
        this.avalia.avaliar(nomeProduto);
        this.avalia.avaliar(descricao);

        Produto produto = new Produto(preco, nomeProduto, descricao);
        String chave = nomeProduto + descricao;

        this.mapaProdutos.put(chave, produto);
    }

    public String dadosProduto(String nomeProduto, String descricao) {
        this.avalia.avaliar(nomeProduto);
        this.avalia.avaliar(descricao);

        return this.mapaProdutos.get(nomeProduto + descricao).toString();
    }

    public String dadosTodosProdutos() {
        String stringSaida = "";
        boolean contador = true;
        for (Produto produto : this.mapaProdutos.values()) {
            if (contador) {
                stringSaida += this.nome + " - " + produto.toString();
                contador = false;
            } else {
                stringSaida += " | " + this.nome + " - " + produto.toString();
            }
        }
        return stringSaida;
    }

    public void editaProduto(String novoPreco, String nomeProduto, String descricao) {
        this.avalia.avaliar(nomeProduto);
        this.avalia.avaliar(descricao);
        this.avalia.avaliar(novoPreco);

        this.mapaProdutos.get(nomeProduto + descricao).setPreco(novoPreco);
    }

    public void removeProduto(String nomeProduto, String descricao) {
        this.avalia.avaliar(nomeProduto);
        this.avalia.avaliar(descricao);

        if (!this.mapaProdutos.containsKey(nomeProduto + descricao)){
            throw new NullPointerException("KEY INEXISTENTE");
        }

        this.mapaProdutos.remove(nomeProduto + descricao);
    }
}
