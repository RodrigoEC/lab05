package saga.controlClientes;

import java.util.Objects;

/**
 * Classe responsável por criar e alterar um objeto que representa um cliente.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class Cliente {
    /**
     * Atributo que representa o cpf do cliente.jeflknelfkne
     */
    private String cpf;

    /**
     * Atributo que representa o nome do cliente.
     */
    private String nome;

    /**
     * Atributo que representa o email do cliente.
     */
    private String email;

    /**
     * Atributo que representa o local de trabalho do cliente
     */
    private String localizacao;

    /**
     * Construtor de um objeto do tipo Cliente.
     *
     * @param cpf cpf do cliente
     * @param nome nome do cliente
     * @param email e-mail do cliente
     * @param local local onde o cliente trabalha
     */
    public Cliente(String cpf, String nome, String email, String local) {

        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = local;
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
     * metodo que deixa disponivel o atributo "email".
     *
     * @return o atributo email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo que deixa disponivel o atributo "localizacao".
     *
     * @return o atributo localizacao.
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * Metodo que permite a alteracao do atributo "nome" por outro objeto.
     *
     * @param nome o novo nome a ser atribuido ao atributo nome.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo que permite a alteracao do atributo "email" por outro objeto.
     *
     * @param email o novo email a ser atribuido ao atributo email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo que permite a alteracao do atributo "localizacao" por outro objeto.
     *
     * @param localizacao o novo email a ser atribuido ao atributo localizacao
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * Metodo que cria uma representacao textual do cliente.
     *
     * @return uma string que representa textualmente o cliente.
     */
    @Override
    public String toString() {
        return String.format("%s - %s - %s", this.nome, this.localizacao, this.email);
    }

    /**
     * Metodo que serve para  comparar dois objetos do tipo Cliente baseado no seu identificador unico, o cpf.
     *
     * @param o objeto a ser comparado.
     * @return true se for igual e false se nao for igual.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return cpf == cliente.cpf;
    }

    /**
     * Método que cria um novo hashCode para o objeto
     *
     * @return O novo HashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
