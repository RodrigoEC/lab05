package saga.controlClientes;

/**
 * Classe que eh um validador dos parâmetros que são passados em todos os métodos da classe "ControllerCLientes".
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class ValidaControllerCliente {

    /**
     * Método responsável por validar o parametro "parametro" que for passado.
     *
     * @param parametro frase que será validada.
     * @param mensagem mensagem que será mostrada quando a exceção for lançada.
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
     * Método responsável por validar um CPF baseado no tamanho do CPF.
     *
     * @param cpf cpf que será validado
     * @param mensagem mensagem que será mostrado quando a exceção for lançada.
     */
    public static void validaCPF(String cpf, String mensagem) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException(mensagem);
        }


    }
    /**
     * Método que serve para validas as entradas do método "cadastraCliente".
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
     * Método responsável por validar o parâmetro do método "dadosCliente".
     *
     * @param cpf cpf do cliente.
     */
    public static void validaEntradasDadosCliente(String cpf) {
        validadorAuxiliar(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
        validaCPF(cpf,"Erro na exibicao do cliente: cpf invalido.");
    }

    /**
     * Método responsável por validar os parâmetros do método "editaCliente".
     *
     * @param cpf nome do cliente.
     * @param atributo atributo que será editado.
     * @param novoValor valor que será atribuido ao atributo.
     */
    public static void validaEntradasEditaCliente(String cpf, String atributo, String novoValor) {
        validadorAuxiliar(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
        validaCPF(cpf, "Erro na edicao do cliente: cpf invalido.");
        validadorAuxiliar(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        validadorAuxiliar(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");

    }

    /**
     * Método responsável por validar o parâmetro do método "removeCliente".
     *
     * @param cpf nome do cliente.
     */
    public static void validaEntradasRemoveCliente(String cpf) {
        validadorAuxiliar(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
    }

    /**
     * Método responsável por validar o parâmetro do método "exibeContasCliente".
     *
     * @param cpf cpf do cliente.
     */
    public static void validaEntradaExibeContasCliente(String cpf) {
        validadorAuxiliar(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
        ValidaControllerCliente.validaCPF(cpf, "Erro ao exibir contas do cliente: cpf invalido.");
    }

    public static void validaEntradasRealizaPagamento(String cpf, String fornecedor) {
        validadorAuxiliar(cpf, "Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
        validaCPF(cpf, "Erro no pagamento de conta: cpf invalido.");
        validadorAuxiliar(fornecedor, "Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
    }
}
