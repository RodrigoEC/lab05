package saga.controlFornecedores;

public class ValidaControllerFornecedor {


    /**
     * Método responsável por validar o parametro "parametro" que for passado.
     *
     * @param parametro frase que será validada.
     * @param mensagem mensagem que será msotrada quando a exceção for lançada.
     */
    private static void validadorAuxiliar(String parametro, String mensagem) {
        if (parametro == null) {
            throw new NullPointerException(mensagem);
        }
        if ("".equals(parametro.trim())) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    /**
     * Método responsável por validar o preço do produto.
     *
     * @param preco preço do produto.
     * @param mensagem mensagem que será mostrada quando a exceção for lançada
     */
    private static void validaPreco(double preco, String mensagem) {
        if (preco < 0) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    private static void validaFator(double fator, String mensagem) {
        if (fator < 0 || fator >= 1) {
            throw new IllegalArgumentException(mensagem);
        }
    }


    /**
     * Método responsável por validar os parâmetros  do método "cadastraFornecedor".
     *
     * @param fornecedor nome do fornecedor.
     * @param email email do fornecedor.
     * @param telefone telefone do fornecedor.
     */
    public static void validaEntradasCadastraFornecedor(String fornecedor, String email, String telefone) {
        validadorAuxiliar(fornecedor, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        validadorAuxiliar(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
    }

    /**
     * Método responsável por validar os parâmetros  do método "editaForneedor"
     *
     * @param nome nome do fornecedor.
     * @param atributo atributo que será editado.
     * @param novoValor valor a ser atribuido ao atributo passado como parâmetro.
     */
    public static void validaEntradasEditaFornecedor(String nome, String atributo, String novoValor) {
        validadorAuxiliar(nome, "Erro na edicao do fornecedor: nome nao pode ser editado.");
        validadorAuxiliar(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        validadorAuxiliar(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
    }

    /**
     * Método responsável por validar o parâmetro do método "removeFornecedor".
     *
     * @param fornecedor noem do fornecedor.
     */
    public static void validaEntradaRemoveFornecedor(String fornecedor) {
        validadorAuxiliar(fornecedor, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
    }

    // Execões que serão lançadas em métodos relacionados a produtos.

    /**
     * Método responsável por validar os parâmetros  do método "addProduto".
     *
     * @param fornecedor nome do fornecedor.
     * @param nomeProduto nome do produto.
     * @param descricao descrição do produto.
     * @param preco preço do produto.
     */
    public static void validaEntradasAddProduto(String fornecedor, String nomeProduto, String descricao, double preco) {
        validadorAuxiliar(fornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        validadorAuxiliar(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        validaPreco(preco, "Erro no cadastro de produto: preco invalido.");
    }

    /**
     * Método responsável por validar os parâmetros  do método "exibeProduto".
     *
     * @param fornecedor nome do fornecedor.
     * @param nomeProduto nome do produto.
     * @param descricao descrição do produto.
     */
    public static void validaEntradasExibeProduto(String fornecedor, String nomeProduto, String descricao) {
        validadorAuxiliar(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        validadorAuxiliar(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
    }

    /**
     * Método responsável por validar os parâmetros  do método "editaProduto".
     *
     * @param fornecedor nome do fornecedor.
     * @param nomeProduto nome do produto.
     * @param descricao descrição do produto.
     * @param novoPreco novo preço a ser editado.
     */
    public static void validaEntradasEditaProduto(String fornecedor, String nomeProduto, String descricao, double novoPreco) {
        validadorAuxiliar(fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        validadorAuxiliar(nomeProduto ,"Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        validaPreco(novoPreco, "Erro na edicao de produto: preco invalido.");
    }

    /**
     * Método responsável por validar os parâmetros  do método "removeProduto".
     *
     * @param fornecedor nome do fornecedor.
     * @param nomeProduto nome do produto.
     * @param descricao descrição do produto.
     */
    public static void validaEntradasRemoveProduto(String fornecedor, String nomeProduto, String descricao) {
        validadorAuxiliar(fornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        validadorAuxiliar(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
    }

    public static void validaEntradasDadosTodosProdutosFornecedor(String fornecedor) {
        validadorAuxiliar(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
    }

    public static void validaEntradasAddCombo(String fornecedor, String nomeCombo, String descricaoCombo, double fator, String produtos) {
        validadorAuxiliar(fornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
        validadorAuxiliar(nomeCombo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(descricaoCombo, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
        validadorAuxiliar(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
        validaFator(fator, "Erro no cadastro de combo: fator invalido.");

    }



}
