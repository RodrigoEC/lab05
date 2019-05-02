package saga;

public class Cliente {
    private String cpf;
    private String nome;
    private String email;
    private String localizacao;

    public Cliente(String cpf, String nome, String email, String local) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = local;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", this.nome, this.localizacao, this.email);
    }
}
