package saga.controlFornecedores;

import saga.controlClientes.Cliente;

import java.util.*;

/**
 * Classer responsavel por criar um objeto que representa um fornecedor de um mercado.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 *
 */
public class Fornecedor implements Comparable<Fornecedor>{
    /**
     * Atributo que representa o nome do fornecedor.
     */
    private String nome;

    /**
     * Atributo que representa o email do fornecedor.
     */
    private String email;

    /**
     * Atributo que representa o telefone do fornecedor.
     */
    private String telefone;

    /**
     * Atributo que e um hashMap de objetos do tipo Produto, em que a chave do mapa e o nome do produto e a sua descricao.
     */
    private Map<String, ProdutoInterface> mapaProdutos;

    /**
     * Construtor responsavel por criar um objeto do tipo Fornecedor baseado nos parametros "nome", "email" e "telefone".
     *
     * @param nome nome do fornecedor.
     * @param email email do fornecedor.
     * @param telefone telefone do fornecedor.
     */
    public Fornecedor(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.mapaProdutos = new HashMap<>();
    }

    /**
     * metodo que deixa disponivel o atributo "email".
     *
     * @return o atributo email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * metodo que deixa disponivel o atributo "nome".
     *
     * @return o atributo nome.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo que deixa disponvel para consulta o atributo "mapaProdutos"
     *
     * @return O atributo mapaProdutos.
     */
    public Map<String, ProdutoInterface> getMapaProdutos() {
        return mapaProdutos;
    }

    /**
     * Metodo que permite a alteracao do atributo email.
     *
     * @param email email do fornecedor.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo que permite a alteracao do atributo telefone.
     *
     * @param telefone Telefone do fornecedor.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Metodo que cria uma representacao textual do objeto do tipo Fornecedor baseado nos seus atributos "nome", "email"
     * e "telefone".
     *
     * @return A representacao textual do fornecedor.
     */
    @Override
    public String toString() {
        return String.format("%s - %s - %s", this.nome, this.email, this.telefone);
    }

    /**
     * Metodo que serve para  comparar dois objetos do tipo Cliente baseado no seu identificador unico, o nome.
     *
     * @param o objeto a ser comparado.
     * @return true se for igual e false se nao for igual.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fornecedor)) return false;
        Fornecedor that = (Fornecedor) o;
        return getNome().equals(that.getNome());
    }

    /**
     * Metodo que cria um novo hashCode para o objeto
     *
     * @return O novo HashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    // PARTE RELACIONADA A CLASSE PRODUTO

    /**
     * Metodo que cria um novo produto baseado no preco, no nome do produto e na sua descricao e o adiciona no mapa de
     * produtos.Caso o mapa nao tiver uma key que sera passada uma excecao sera lancada.
     *
     * @param preco preco do produto.
     * @param nomeProduto nome do produto.
     * @param descricao descricao do produto.
     */
    public void addProduto(String nomeProduto, String descricao, double preco) {

        Produto simples = new Produto(nomeProduto, descricao, preco);
        String chave = nomeProduto + " - " + descricao;

        if (this.mapaProdutos.containsKey(chave)) {
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        }
        this.mapaProdutos.put(chave, simples);
    }

    /**
     * Metodo que retorna a representacao textual do produto que tem o nome e a descricao iguais aos parametros. Caso o
     * mapa nao tiver uma key que sera passada uma excecao sera lancada.
     *
     * @param nomeProduto nome do produto.
     * @param descricao descricao do produto.
     *
     * @return A representacao textual do produto.
     */
    public String exibeProduto(String nomeProduto, String descricao) {
        if (!this.mapaProdutos.containsKey(nomeProduto + " - " + descricao)) {
            throw new NullPointerException("Erro na exibicao de produto: produto nao existe.");
        }
        return this.mapaProdutos.get(nomeProduto + " - " + descricao).toString();
    }

    /**
     * Metodo que retorna a representacao textual de todos os produtos que foram adicionados ao fornecedor em ordem
     * alfabetica.
     *
     * @return A representacao textual de todos os produtos.
     */
    public String dadosTodosProdutos() {
        ArrayList<ProdutoInterface> produtos = new ArrayList<>(this.mapaProdutos.values());
        Collections.sort(produtos);

        String stringSaida = "";
        boolean contador = true;
        if (produtos.isEmpty()) {
            stringSaida +=  this.nome + " -";
            return stringSaida;
        }

        for (ProdutoInterface produto : produtos) {

            if (contador) {
                stringSaida += this.nome + " - " + produto.toString();
                contador = false;
            } else {
                stringSaida += " | " + this.nome + " - " + produto.toString();
            }
        }
        return stringSaida;
    }

    /**
     * Metodo responsavel por alterar o preco do produto, cujo nome e descricao sao iguais aos parametros.
     *
     * @param novoPreco novo preco a ser alterado.
     * @param nomeProduto nome do produto que tera o preco alterado.
     * @param descricao descricao do produto que tera o preco alterado.
     */
    public void editaProduto(double novoPreco, String nomeProduto, String descricao) {
        if (!this.mapaProdutos.containsKey(nomeProduto + " - " + descricao)) {
            throw new NullPointerException("Erro na edicao de produto: produto nao existe.");
        }
        this.mapaProdutos.get(nomeProduto + " - " + descricao).setPreco(novoPreco);
    }

    /**
     * Metodo responsavel por remover um produto ja cadastrados. Se a key nao existir no mapa, uma
     * excecao tambem sera lancada.
     *
     * @param nomeProduto Nome do produto.
     * @param descricao Descricao do produto.
     */
    public void removeProduto(String nomeProduto, String descricao) {
        if (!this.mapaProdutos.containsKey(nomeProduto + " - " + descricao)){
            throw new NullPointerException("Erro na remocao de produto: produto nao existe.");
        }

        this.mapaProdutos.remove(nomeProduto + " - " + descricao);
    }

    /**
     * Metodo responsavel por adicionar um novo Combo.
     *
     * @param nomeCombo nome do combo.
     * @param descricaoCombo descricao do combo.
     * @param fator Fator que definira o preco do combo.
     * @param produtos string que tem o nome e descricao de todos os produtos que compoem o combo.
     */
    public void addCombo(String nomeCombo, String descricaoCombo, double fator, String produtos) {
        String[] frases = produtos.split(", ");
        for (String frase : frases) {

        if (this.mapaProdutos.get(frase) instanceof Combo) {
                throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
            }

            if (!this.mapaProdutos.containsKey(frase)) {
                throw new NullPointerException("Erro no cadastro de combo: produto nao existe.");
            }

        }

        double preco = calculaPrecoCombo(frases, fator);
        Combo combo = new Combo(nomeCombo, descricaoCombo, preco, frases);

        if (mapaProdutos.containsKey(nomeCombo + " - " + descricaoCombo)) {
            throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
        }
        this.mapaProdutos.put(nomeCombo + " - " + descricaoCombo, combo);
    }


    /**
     * Metodo que serve para calcular o preco de um combo baseado no fator que eh passado como parametro e o nome e
     * descricao dos produtos que compoem o combo.
     *
     * @param produtos nome e descricões dos produtos que compoem o combo.
     * @param fator fator que definira o preco do combo baseado no preco dos produtos que o compoem.
     * @return double que representa o preco do combo.
     */
    private double calculaPrecoCombo(String[] produtos, double fator) {
        double precoTotal = 0.0;
        for (String produto : produtos) {
            precoTotal += this.mapaProdutos.get(produto).getPreco();
        }
        return precoTotal * (1 - fator);
    }

    /**
     * Metodo responsavel por editar o preco de um combo baseado em um novo fator que e passado como parametro.
     *
     * @param chave nome do combo + " - " + descricao do combo.
     * @param fator fator que definira  o novo preco do combo, baseando-se no preco dos produtos que compoem o combo que
     * o qual a chave aponta.
     */
    public void editaCombo(String chave, double fator) {
        if (!mapaProdutos.containsKey(chave)) {
            throw new NullPointerException("Erro na edicao de combo: produto nao existe.");
        }

        double preco = calculaPrecoCombo(this.mapaProdutos.get(chave).getProdutos(), fator);

        this.mapaProdutos.get(chave).setPreco(preco);

    }

    /**
     * Metodo que retorna o preco do produto que tem seu nome e descricao passado como paametro.
     *
     * @param nomeProd nome do produto.
     * @param descProd descricao do produto.
     * @return o numero double que representa o preco do produto..
     */
    public double getValor(String nomeProd, String descProd) {
        if (!this.mapaProdutos.containsKey(nomeProd + " - " + descProd)) {
            throw new NullPointerException("Erro ao cadastrar compra: produto nao existe.");
        }
        return this.mapaProdutos.get(nomeProd + " - " + descProd).getPreco();
    }

    /**
     * Metodo que determina o que sera comparavel entre dois objetos do tipo Fornecedor.
     *
     * @param fornecedor objeto do tipo fornecedor.
     * @return um inteiro que representa a comparacao dos dois objetos.
     */
    @Override
    public int compareTo(Fornecedor fornecedor) {
        return this.toString().compareTo(fornecedor.toString());
    }
}
