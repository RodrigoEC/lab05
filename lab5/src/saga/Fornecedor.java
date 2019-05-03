package saga;

public class Fornecedor {
    private String nome;
    private String email;
    private String telefone;

    public Fornecedor(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", this.nome, this.email, this.telefone);
    }
}
