package saga.controlClientes;

import saga.Validador;

import java.util.HashMap;

/**
 * Classe responsável por criar um controller responsável por fazer operações sobre objetos do tipo Cliente.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class ControllerClientes {
    /**
     * Atributo que representa um mapa de clientes, onde a chave é o cpf do cliente.
     */
    private HashMap<String, Cliente> clientes;

    /**
     * Atributo que representa um objeto reponsavel por avaliar os parâmetros, lançando as exceções adequadas se
     * necessário.
     */
    private Validador avalia;

    /**
     * Construtor responsável por inicializar os atributos da classe.
     */
    public ControllerClientes() {
        clientes = new HashMap<>();
        avalia = new Validador();
    }

    /**
     * Método que deixa acessível o atributo clientes.
     *
     * @return o atributo clientes.
     */
    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    /**
     * Método responsável por criar e cadastrar um novo cliente, cujo atributos são passados como parâmetros do método.
     * Caso algum dos parâmetros passados seja uma string vazia, apenas de espaços ou um valor null uma exceção
     * será lançada.
     *
     * @param cpf cpf do cliente.
     * @param nome nome do cliente.
     * @param email email do cliente.
     * @param local local que o cliente trabalha.
     * @return o cpf do cliente.
     */
    public String cadastraCliente(String cpf, String nome, String email, String local) {
        avalia.validarCPFCliente(cpf);
        avalia.validaNome(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        avalia.validaEmail(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        avalia.validaLocalizacao(local);

        if (!clientes.containsKey(cpf)) {
            Cliente cliente = new Cliente(cpf, nome, email, local);
            clientes.put(cpf, cliente);
            return cpf;
        } else {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
        }
    }

    /**
     * Método responsável por retornar a representacao textual do cliente, cujo cpf é passado como parâmetro. Caso
     * o parâmetro seja uma string vazia, apenas de espaços ou um valor null uma exceção será lançada.
     *
     * @param cpf cpf do cliente.
     * @return representação textual do cliente.
     */
    public String dadosCliente(String cpf) {
        avalia.validarCPFCliente(cpf);

        if (!this.clientes.containsKey(cpf)) {
            throw new NullPointerException("Erro na exibicao do cliente: cliente nao existe.");
        }
        return clientes.get(cpf).toString();
    }

    /**
     * Método responsável por retornar as representações textuais de todos os clientes cadastrados.
     *
     * @return as representações textuais dos clientes.
     */
    public String dadosTodosClientes() {
        String stringSaida = "";
        boolean contador = true;
        for (Cliente cliente : this.clientes.values()) {
            if (contador) {
                stringSaida += cliente.toString();
                contador = false;
            } else {
                stringSaida += " | " + cliente.toString();
            }
        }
        return stringSaida;
    }

    /**
     * Método responsável por alterar o atributo que é passado como parâmetro novo valor que foi passado como parâmetro.
     * Caso algum dos parâmetros seja uma string vazia, apenas de espaços ou um valor null uma exceção será lançada.
     *
     * @param cpf cpf do cliente
     * @param atributo atributo que sera alterado
     * @param novoValor valor que será colocado no atributo
     */
    public void editaCliente(String cpf, String atributo, String novoValor) {
        avalia.validarCPFCliente(cpf);
        avalia.validaNovoValor(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        avalia.validaAtributo(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");

        if (!this.clientes.containsKey(cpf)) {
            throw new NullPointerException("Erro na edicao do cliente: cliente nao existe.");
        }

        if ("nome".equals(atributo.toLowerCase())) {
            clientes.get(cpf).setNome(novoValor);

        } else if ("email".equals(atributo.toLowerCase())) {
            clientes.get(cpf).setEmail(novoValor);

        } else if ("localizacao".equals(atributo.toLowerCase())) {
            clientes.get(cpf).setLocalizacao(novoValor);
        } else {
            throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
        }
    }


    /**
     * Método responsável por remover o cliente, cujo cpf é passado como parâmetro, do hashMap de clientes. Caso o
     * parâmetro seja uma string vazia, apenas de espaços, um valor null  ou um cpf não cadastrado uma exceção será
     * lançada.
     *
     * @param cpf cpf do cliente que será removido.
     */
    public void removeCliente(String cpf) {
        avalia.validarCPFCliente(cpf);

        if (this.clientes.containsKey(cpf)) {
            clientes.remove(cpf, clientes.get((cpf)));
        } else {
            throw new NullPointerException("KEY INEXISTENTE");
        }
    }
}
