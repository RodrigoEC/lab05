package saga.controlClientes;

import saga.AvaliadorClientes;

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
    private HashMap<Integer, Cliente> clientes;

    /**
     * Atributo que representa um objeto reponsavel por avaliar os parâmetros, lançando as exceções adequadas se
     * necessário.
     */
    private AvaliadorClientes avalia;

    /**
     * Construtor responsável por inicializar os atributos da classe.
     */
    public ControllerClientes() {
        clientes = new HashMap<>();
        avalia = new AvaliadorClientes();
    }

    /**
     * Método que deixa acessível o atributo clientes.
     *
     * @return o atributo clientes.
     */
    public HashMap<Integer, Cliente> getClientes() {
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
    public int cadastraCliente(int cpf, String nome, String email, String local) {
        avalia.validarCPFCliente(cpf);
        avalia.validaNomeCliente(nome);
        avalia.validaEmailCliente(email);
        avalia.validaLocalizacaoCliente(local);

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
    public String dadosCliente(int cpf) {
        avalia.validarCPFCliente(cpf);

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
     * Método responsável por alterar o nome do cliente, cujo cpf é passado como parâmetro, pelo novo nome que foi
     * passado como parâmetro. Caso algum dos parâmetros seja uma string vazia, apenas de espaços ou um valor null uma
     * exceção será lançada.
     *
     * @param cpf cpf do cliente.
     * @param novoNome nome que vai substituir o nome antigo.
     */
    public void editaNome(int cpf, String novoNome) {
        avalia.validarCPFCliente(cpf);
        avalia.validaNomeCliente(novoNome);

        clientes.get(cpf).setNome(novoNome);
    }

    /**
     * Método responsável por alterar o email do cliente, cujo cpf é passado como parâmetro, pelo novo email que foi
     * passado como parâmetro. Caso algum dos parâmetros seja uma string vazia, apenas de espaços ou um valor null uma
     * exceção será lançada.
     *
     * @param cpf cpf do cliente.
     * @param novoEmail email que vai substituir o email antigo.
     */
    public void editaEmail(int cpf, String novoEmail) {
        avalia.validarCPFCliente(cpf);
        avalia.validaEmailCliente(novoEmail);

        clientes.get(cpf).setEmail(novoEmail);
    }

    /**
     * Método responsável por alterar o local de trabalho do cliente, cujo cpf é passado como parâmetro, pelo novo local
     * que foi passado como parâmetro. Caso algum dos parâmetros seja uma string vazia, apenas de espaços ou um valor
     * null uma exceção será lançada.
     *
     * @param cpf cpf do cliente.
     * @param novoLocal local de trabalho que será substituir o atributo "localizacao" antigo.
     */
    public void editaLocal(int cpf, String novoLocal) {
        avalia.validarCPFCliente(cpf);
        avalia.validaLocalizacaoCliente(novoLocal);

        clientes.get(cpf).setLocalizacao(novoLocal);
    }

    /**
     * Método responsável por remover o cliente, cujo cpf é passado como parâmetro, do hashMap de clientes. Caso o
     * parâmetro seja uma string vazia, apenas de espaços, um valor null  ou um cpf não cadastrado uma exceção será
     * lançada.
     *
     * @param cpf cpf do cliente que será removido.
     */
    public void removeCliente(int cpf) {
        avalia.validarCPFCliente(cpf);

        if (this.clientes.containsKey(cpf)) {
            clientes.remove(cpf, clientes.get((cpf)));
        } else {
            throw new NullPointerException("KEY INEXISTENTE");
        }
    }
}
