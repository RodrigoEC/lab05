package saga;

/**
 * Classe que eh um validador dos parametros que sao passados em todos os metodos da classe "ControllerFornecedor".
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class ValidaEntradasDeMetodos {


    /**
     * Metodo responsavel por validar o parametro "parametro" que for passado.
     *
     * @param parametro frase que sera validada.
     * @param mensagem mensagem que sera msotrada quando a excecao for lancada.
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
     * Metodo responsavel por validar um CPF baseado no tamanho do CPF.
     *
     * @param cpf cpf que sera validado
     * @param mensagem mensagem que sera mostrado quando a excecao for lancada.
     */
    public static void validaCPF(String cpf, String mensagem) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    /**
     * Metodo responsavel por validar o preco do produto.
     *
     * @param preco preco do produto.
     * @param mensagem mensagem que sera mostrada quando a excecao for lancada
     */
    private static void validaPreco(double preco, String mensagem) {
        if (preco < 0) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    /**
     * Metodo responsavel por validar o fator que determinara o preco de um combo
     *
     * @param fator fator que determinara o preco do produto combo.
     * @param mensagem mensagem que sera mostrada quando a excecao for lancada.
     */
    private static void validaFator(double fator, String mensagem) {
        if (fator <= 0 || fator >= 1) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    /**
     * Metodo responsavel por validar a data da compra.
     *
     * @param data data da compra.
     * @param mensagem mensagem que sera lancada como excecao.
     */
    private static void validaData(String data, String mensagem) {
        if (data == null) {
            throw new NullPointerException(mensagem);
        }
        if ("".equals(data.trim())) {
            throw new IllegalArgumentException(mensagem);
        }

        String[] dadosData = data.split("/");
        if (dadosData[0].length() != 2 || dadosData[1].length() != 2 || dadosData[2].length() != 4) {
            throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
        }

        if (Integer.parseInt(dadosData[0]) > 31 || Integer.parseInt(dadosData[1]) > 12) {
            throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
        }
    }

    /**
     * Metodo responsavel por validar os parametros  do metodo "cadastraFornecedor".
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
     * Metodo responsavel por validar os parametros  do metodo "editaForneedor"
     *
     * @param nome nome do fornecedor.
     * @param atributo atributo que sera editado.
     * @param novoValor valor a ser atribuido ao atributo passado como parametro.
     */
    public static void validaEntradasEditaFornecedor(String nome, String atributo, String novoValor) {
        validadorAuxiliar(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        validadorAuxiliar(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
    }

    /**
     * Metodo responsavel por validar o parametro do metodo "removeFornecedor".
     *
     * @param fornecedor noem do fornecedor.
     */
    public static void validaEntradaRemoveFornecedor(String fornecedor) {
        validadorAuxiliar(fornecedor, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
    }

    // Execões que serao lancadas em metodos relacionados a produtos.

    /**
     * Metodo responsavel por validar os parametros  do metodo "addProduto".
     *
     * @param fornecedor nome do fornecedor.
     * @param nomeProduto nome do produto.
     * @param descricao descricao do produto.
     * @param preco preco do produto.
     */
    public static void validaEntradasAddProduto(String fornecedor, String nomeProduto, String descricao, double preco) {
        validadorAuxiliar(fornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        validadorAuxiliar(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        validaPreco(preco, "Erro no cadastro de produto: preco invalido.");
    }

    /**
     * Metodo responsavel por validar os parametros  do metodo "exibeProduto".
     *
     * @param fornecedor nome do fornecedor.
     * @param nomeProduto nome do produto.
     * @param descricao descricao do produto.
     */
    public static void validaEntradasExibeProduto(String fornecedor, String nomeProduto, String descricao) {
        validadorAuxiliar(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        validadorAuxiliar(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
    }

    /**
     * Metodo responsavel por validar os parametros  do metodo "editaProduto".
     *
     * @param fornecedor nome do fornecedor.
     * @param nomeProduto nome do produto.
     * @param descricao descricao do produto.
     * @param novoPreco novo preco a ser editado.
     */
    public static void validaEntradasEditaProduto(String fornecedor, String nomeProduto, String descricao, double novoPreco) {
        validadorAuxiliar(fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        validadorAuxiliar(nomeProduto ,"Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        validaPreco(novoPreco, "Erro na edicao de produto: preco invalido.");
    }

    /**
     * Metodo responsavel por validar o parametro do metodo "removeProduto".
     *
     * @param fornecedor nome do fornecedor.
     * @param nomeProduto nome do produto.
     * @param descricao descricao do produto.
     */
    public static void validaEntradasRemoveProduto(String fornecedor, String nomeProduto, String descricao) {
        validadorAuxiliar(fornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        validadorAuxiliar(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
    }

    /**
     * Metodo responsavel por validar o parametro do metodo "dadosTodosProdutosFornecedor".
     *
     * @param fornecedor nome do fornecedor.
     */
    public static void validaEntradasDadosTodosProdutosFornecedor(String fornecedor) {
        validadorAuxiliar(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
    }

    /**
     * Metodo responsavel por validar os parametros  do metodo "addCombo".
     *
     * @param fornecedor nome do fornecedor.
     * @param nomeCombo nome do combo.
     * @param descricaoCombo descricao do combo.
     * @param fator fator que determinara o preco do combo.
     * @param produtos string com nome e descricao dos produtos que compoem o combo.
     */
    public static void validaEntradasAddCombo(String fornecedor, String nomeCombo, String descricaoCombo, double fator, String produtos) {
        validadorAuxiliar(fornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
        validadorAuxiliar(nomeCombo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(descricaoCombo, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
        validadorAuxiliar(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
        validaFator(fator, "Erro no cadastro de combo: fator invalido.");
    }

    /**
     * Metodo responsavel por validar os parametros  do metodo "editaCombo".
     *
     * @param nome nome do combo.
     * @param descricao descricao do combo.
     * @param nomeFornecedor nome do fornecedor.
     * @param fator fator que desterminara o novo preco do combo.
     */
    public static void validaEntradasEditaCombo(String nome, String descricao, String nomeFornecedor, double fator) {
        validadorAuxiliar(nome,"Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
        validadorAuxiliar(nomeFornecedor, "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
        validaFator(fator, "Erro na edicao de combo: fator invalido.");
    }

    /**
     * Metodo responsavel por validar os parametros  do metodo "addCompra".
     *
     * @param cpf cpf do cliente.
     * @param fornecedor nome do fornecedor.
     * @param data data da realizacao da compra.
     * @param nomeProd nome do produto que sera comprado.
     * @param descProd descricao do produto que sera comprado.
     */
    public static void validaEntradasAddCompra(String cpf, String fornecedor, String data, String nomeProd, String descProd) {
        validadorAuxiliar(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
        validaCPF(cpf, "Erro ao cadastrar compra: cpf invalido.");
        validadorAuxiliar(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
        validadorAuxiliar(nomeProd, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        validadorAuxiliar(descProd, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
        validaData(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
    }

    /**
     * Metodo responsavel por validar os parametros  do metodo "getDebito".
     *
     * @param cpf cpf do cliente.
     * @param fornecedor nome do fornecedor.
     */
    public static void validaEntradasGetDebito(String cpf, String fornecedor) {
        validadorAuxiliar(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
        validadorAuxiliar(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
        validaCPF(cpf,"Erro ao recuperar debito: cpf invalido.");
    }

    /**
     * Metodo responsavel por validar os parametros  do metodo "exibeContas".
     *
     * @param cpf cpf do cliente.
     * @param fornecedor nome do fornecedor.
     */
    public static void validaEntradasExibeContas(String cpf, String fornecedor) {
        validadorAuxiliar(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
        validadorAuxiliar(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
        validaCPF(cpf, "Erro ao exibir conta do cliente: cpf invalido.");
    }


    // Parte relacionada a Clientes

    /**
     * Metodo que serve para validas as entradas do metodo "cadastraCliente".
     *
     * @param cpf cpf do cliente.
     * @param nome nome do cliente.
     * @param email email do cliente.
     * @param local local de trabalho do cliente.
     */
    public static void validaEntradasCadastraCliente(String cpf, String nome, String email, String local) {
        validadorAuxiliar(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        validaCPF(cpf, "Erro no cadastro do cliente: cpf invalido.");
        validadorAuxiliar(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        validadorAuxiliar(local, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
    }

    /**
     * Metodo responsavel por validar o parametro do metodo "dadosCliente".
     *
     * @param cpf cpf do cliente.
     */
    public static void validaEntradasDadosCliente(String cpf) {
        validadorAuxiliar(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
        validaCPF(cpf,"Erro na exibicao do cliente: cpf invalido.");
    }

    /**
     * Metodo responsavel por validar os parametros do metodo "editaCliente".
     *
     * @param cpf nome do cliente.
     * @param atributo atributo que sera editado.
     * @param novoValor valor que sera atribuido ao atributo.
     */
    public static void validaEntradasEditaCliente(String cpf, String atributo, String novoValor) {
        validadorAuxiliar(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
        validaCPF(cpf, "Erro na edicao do cliente: cpf invalido.");
        validadorAuxiliar(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        validadorAuxiliar(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");

    }

    /**
     * Metodo responsavel por validar o parametro do metodo "removeCliente".
     *
     * @param cpf nome do cliente.
     */
    public static void validaEntradasRemoveCliente(String cpf) {
        validadorAuxiliar(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
    }

    /**
     * Metodo responsavel por validar o parametro do metodo "exibeContasCliente".
     *
     * @param cpf cpf do cliente.
     */
    public static void validaEntradaExibeContasCliente(String cpf) {
        validadorAuxiliar(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
        validaCPF(cpf, "Erro ao exibir contas do cliente: cpf invalido.");
    }

    /**
     * Metodo responsavel por validar o parametro do metodo "realizaPagamento".
     *
     * @param cpf cpf do cliente.
     * @param fornecedor nome do fornecedor.
     */
    public static void validaEntradasRealizaPagamento(String cpf, String fornecedor) {
        validadorAuxiliar(cpf, "Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
        validaCPF(cpf, "Erro no pagamento de conta: cpf invalido.");
        validadorAuxiliar(fornecedor, "Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
    }

    /**
     * Metodo responsavel por validar o parametro do metodo "ordenaPor".
     *
     * @param criterio criterio que determina o tipo de ordenacao que sera feito
     */
    public static void ValidaEntradasOrdenaPor(String criterio) {
        validadorAuxiliar(criterio, "Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");

        if (!"cliente".equals(criterio.toLowerCase()) && !"fornecedor".equals(criterio.toLowerCase()) && !"data".equals(criterio.toLowerCase())) {
            throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
        }
    }
}
