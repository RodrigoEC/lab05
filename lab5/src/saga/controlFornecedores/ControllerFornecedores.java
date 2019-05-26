package saga.controlFornecedores;

import saga.ValidaEntradasDeMetodos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/**
 * Classe responsavel por criar um controller responsavel por fazer operacões sobre objetos do tipo Fornecedor.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class ControllerFornecedores {
    /**
     * Mapa de objetos do tipo Fornecedor, onde a chave e o nome do fornecedor.
     */
    private HashMap<String, Fornecedor> mapaFornecedores;



    /**
     * Construtor responsavel por criar o objeto do tipo ControllerFornecedores e inicializar os atributos da classe.
     */
    public ControllerFornecedores() {
        this.mapaFornecedores = new HashMap<>();
    }

    /**
     * Metodo que deixa acessçvel o atributo mapaFornecedores.
     *
     * @return o hashMap mapaFornecedores.
     */
    public HashMap<String, Fornecedor> getMapaFornecedores() {
        return this.mapaFornecedores;
    }

    public boolean containsFornecedor(String fornecedor) {
        if (this.mapaFornecedores.containsKey(fornecedor)) {
            return false;
        } return true;
    }

    public double getValor(String fornecedor, String nomeProd, String descProd) {
        if (!this.mapaFornecedores.containsKey(fornecedor)) {
            throw new NullPointerException("Erro ao cadastrar compra: fornecedor nao existe.");
        }

        return this.mapaFornecedores.get(fornecedor).getValor(nomeProd, descProd);
    }

    /**
     * Metodo responsavel por criar e cadastrar um objeto do tipo Fornecedor e adiciona-lo ao mapa de Fornecedores.
     * Caso algum dos parametros passados seja uma string vazia, apenas de espacos ou um valor null uma excecao
     * sera lancada.
     *
     * @param fornecedor Nome do fornecedor.
     * @param email E-mail do fornecedor.
     * @param telefone Telefone do fornecedor.
     * @return nome do fornecedor.
    */
    public String cadastraFornecedor(String fornecedor, String email, String telefone) {
        ValidaEntradasDeMetodos.validaEntradasCadastraFornecedor(fornecedor, email, telefone);

        if (!this.mapaFornecedores.containsKey(fornecedor)) {
            Fornecedor novoFornecedor = new Fornecedor(fornecedor, email, telefone);
            this.mapaFornecedores.put(fornecedor, novoFornecedor);
        } else {
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        }
        return fornecedor;
    }

    /**
     * Metodo responsavel por retornar a representacao textual do fornecedor, cujo nome e passado como parametro. Caso
     * o parametro seja uma string vazia, apenas de espacos ou um valor null uma excecao sera lancada.
     *
     * @param fornecedor nome do fornecedor.
     * @return A representacao textual do fornecedor.
     */
    public String dadosFornecedor(String fornecedor){
        if (!this.mapaFornecedores.containsKey(fornecedor)) {
            throw new NullPointerException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }
        return this.mapaFornecedores.get(fornecedor).toString();
    }

    /**
     * Metodo responsavel por retornar as representacões textuais de todos os fornecedores cadastrados.
     *
     * @return A representacao textual de todos os fornecedores.
     */
    public String dadosTodosFornecedores() {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        for (Fornecedor fornecedor : this.mapaFornecedores.values()) {
            fornecedores.add(fornecedor);
        }
        Collections.sort(fornecedores);

        String stringSaida = "";
        boolean contador = true;
        for (Fornecedor fornecedor : fornecedores) {
            if (contador) {
                stringSaida += fornecedor.toString();
                contador = false;
            } else {
                stringSaida += " | " + fornecedor.toString();
            }
        }
        return stringSaida;
    }


    /**
     * Metodo responsavel por alterar o atributo que e passado como parametro novo valor que foi passado como parametro.
     * Caso algum dos parametros seja uma string vazia, apenas de espacos ou um valor null uma excecao sera lancada.
     *
     * @param nome cpf do fornecedor
     * @param atributo atributo que sera alterado
     * @param novoValor valor que sera colocado no atributo
     */
    public void editaFornecedor(String nome, String atributo, String novoValor) {
        ValidaEntradasDeMetodos.validaEntradasEditaFornecedor(nome, atributo, novoValor);

        if (!this.mapaFornecedores.containsKey(nome)) {
            throw new NullPointerException("Erro na edicao do fornecedor: fornecedor nao existe.");
        }
        if ("nome".equals(atributo.toLowerCase())) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");

        } else if ("email".equals(atributo.toLowerCase())) {
            this.mapaFornecedores.get(nome).setEmail(novoValor);

        } else if ("telefone".equals(atributo.toLowerCase())) {
            this.mapaFornecedores.get(nome).setTelefone(novoValor);
        } else {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
        }
    }


    /**
     * Metodo responsavel por remover um fornecedor, cujo nome e passado como parametro, do hashMap de clientes. Caso o
     * parametro seja uma string vazia, apenas de espacos, um valor null  ou um nome nao cadastrado uma excecao sera
     * lancada.
     *
     * @param fornecedor Nome do fornecedor.
     */
    public void removeFornecedor(String fornecedor) {
        ValidaEntradasDeMetodos.validaEntradaRemoveFornecedor(fornecedor);

        if (this.mapaFornecedores.containsKey(fornecedor)) {
            this.mapaFornecedores.remove(fornecedor);
        } else {
            throw new NullPointerException("Erro na remocao do fornecedor: fornecedor nao existe.");
        }
    }

    // PARTE RELACIONADA A PRODUTOS

    /**
     * Metodo que cria um novo produto baseado no preco, no nome do produto e na sua descricao e o adiciona no mapa de
     * produtos de determinado fornecedor, cujo nome foi passado como o parametro "fornecedor". Caso algum dos
     * parametros passados seja uma string vazia, apenas de espacos ou um valor null uma excecao sera lancada.
     *
     * @param fornecedor nome do fornecedor.
     * @param preco preco do produto.
     * @param nomeProduto nome do produto.
     * @param descricao descricao do produto.
     */
    public void addProduto(String fornecedor, String nomeProduto, String descricao, double preco) {
        ValidaEntradasDeMetodos.validaEntradasAddProduto(fornecedor, nomeProduto, descricao, preco);

        if (!this.mapaFornecedores.containsKey(fornecedor)) {
            throw new NullPointerException("Erro no cadastro de produto: fornecedor nao existe.");
        }

        this.mapaFornecedores.get(fornecedor).addProduto(nomeProduto, descricao, preco);
    }

    /**
     * Metodo que retorna a representacao textual do produto, baseando-se no nome e na descricao, de determinado
     * fornecedor, cujo nome foi passado como parametro. Caso algum dos parametros passados seja uma string vazia,
     * apenas de espacos ou um valor null uma excecao sera lancada.
     *
     * @param fornecedor Nome do fornecedor.
     * @param nomeProduto Nome do produto.
     * @param descricao Descricao fo produto.
     *
     * @return Os dados do produto de um fornecedor especçfico.
     */
    public String exibeProduto(String fornecedor, String nomeProduto, String descricao) {
        ValidaEntradasDeMetodos.validaEntradasExibeProduto(fornecedor, nomeProduto, descricao);

        if (!this.mapaFornecedores.containsKey(fornecedor)) {
            throw new NullPointerException("Erro na exibicao de produto: fornecedor nao existe.");
        }
        return this.mapaFornecedores.get(fornecedor).exibeProduto(nomeProduto, descricao);
    }

    /**
     * Metodo que retorna a representacao textual de todos os produtos que foram adicionados ao fornecedor, cujo nome
     * foi passado como parametro.
     *
     * @param fornecedor nome do fornecedor.
     * @return A representacao textual de todos os produtos.
     */
    public String dadosTodosProdutosFornecedor(String fornecedor) {
        ValidaEntradasDeMetodos.validaEntradasDadosTodosProdutosFornecedor(fornecedor);

        if (!this.mapaFornecedores.containsKey(fornecedor)) {
            throw new NullPointerException("Erro na exibicao de produto: fornecedor nao existe.");
        }
        return this.mapaFornecedores.get(fornecedor).dadosTodosProdutos();
    }

    /**
     * Metodo responsavel por alterar o preco do produto, cujo nome e descricao sao iguais aos parametros, produto esse
     * de um determinado forncedor cujo no e passado como parametro.Caso algum dos parametros passados seja uma string
     * vazia, apenas de espacos ou um valor null uma excecao sera lancada.
     *
     * @param fornecedor Nome do fornecedor.
     * @param novoPreco novo preco a ser alterado.
     * @param nomeProduto nome do produto que tera o preco alterado.
     * @param descricao descricao do produto que tera o preco alterado.
     */
    public void editaProduto(String fornecedor, String nomeProduto, String descricao, double novoPreco) {
        ValidaEntradasDeMetodos.validaEntradasEditaProduto(fornecedor, nomeProduto, descricao, novoPreco);

        if (!this.mapaFornecedores.containsKey(fornecedor)) {
            throw new NullPointerException("Erro na edicao de produto: fornecedor nao existe.");
        }
        this.mapaFornecedores.get(fornecedor).editaProduto(novoPreco, nomeProduto, descricao);
    }

    /**
     * Metodo responsavel por remover um produto ja cadastrados de um fornecedor tambem ja cadastrado.Caso algum dos
     * parametros passados seja uma string vazia, apenas de espacos ou um valor null uma excecao sera lancada.
     * Alem disso, se a key nao existir no mapa, uma excecao tambem sera lancada.
     *
     * @param fornecedor Nome do fornecedor
     * @param nomeProduto Nome do produto.
     * @param descricao Descricao do produto.
     */
    public void removeProduto(String fornecedor, String nomeProduto, String descricao) {
        ValidaEntradasDeMetodos.validaEntradasRemoveProduto(fornecedor, nomeProduto, descricao);

        if (!this.mapaFornecedores.containsKey(fornecedor)) {
            throw new NullPointerException("Erro na remocao de produto: fornecedor nao existe.");
        }
        this.mapaFornecedores.get(fornecedor).removeProduto(nomeProduto, descricao);
    }

    /**
     * Metodo responsavel por criar uma representacao textual de todos os produtos cadastrados de todos os fornecedores
     * cadastrados.
     *
     * @return uma string com todas as representacões textuais de todos os produtos cadastrados em todos os fornecedores.
     */
    public String dadosTodosProdutos() {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>(this.mapaFornecedores.values());
        Collections.sort(fornecedores);

        String stringSaida = "";
        boolean contador = true;
        for (Fornecedor fornecedor : fornecedores) {

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

    /**
     * Metodo responsavel por adicionar um novo Combo, se as entradas forem invalidas ou nulas uma excecao e lancada.Caso
     * algum dos parametros passados seja uma string vazia, apenas de espacos ou um valor null uma excecao sera lancada.
     *
     * @param fornecedor nome do fornecedor
     * @param nomeCombo nome do combo.
     * @param descricaoCombo descricao do combo.
     * @param fator fator responsavel por alterar o preco do combo baseado nos produtos
     * @param produtos string com os produtos.
     */
    public void addCombo(String fornecedor, String nomeCombo, String descricaoCombo, double fator, String produtos) {
        ValidaEntradasDeMetodos.validaEntradasAddCombo(fornecedor, nomeCombo, descricaoCombo, fator, produtos);

        if (!this.mapaFornecedores.containsKey(fornecedor)) {
            throw new NullPointerException("Erro no cadastro de combo: fornecedor nao existe.");
        }
        this.mapaFornecedores.get(fornecedor).addCombo(nomeCombo, descricaoCombo, fator, produtos);
    }


    /**
     * Metodo que edita o fator de um combo, alterando assim o seu preco.Caso algum dos parametros passados seja uma
     * string vazia, apenas de espacos ou um valor null uma excecao sera lancada.
     *
     * @param nome nome do combo.
     * @param descricao descricao do combo.
     * @param nomeFornecedor nome do fornecedor.
     * @param fator novo fator.
     */
    public void editaCombo(String nome, String descricao, String nomeFornecedor, double fator) {
        ValidaEntradasDeMetodos.validaEntradasEditaCombo(nome, descricao, nomeFornecedor, fator);

        if (!this.mapaFornecedores.containsKey(nomeFornecedor)) {
            throw new NullPointerException("Erro na edicao de combo: fornecedor nao existe.");
        }

        String chave = nome + " - " + descricao;
        this.mapaFornecedores.get(nomeFornecedor).editaCombo(chave, fator);
    }
}
