package saga;

public class ValidaFornecedor {

    public void validaNomeFornecedor(String fornecedor) {
        if (fornecedor == null) {
            throw new NullPointerException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        }
        if ("".trim().equals(fornecedor)) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        }
    }

    public void validaEmailFornecedor(String email) {
        if (email == null) {
            throw new NullPointerException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        }
        if ("".trim().equals(email)) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        }
    }

    public void validaTelefoneFornecedor(String telefone) {
        if (telefone == null) {
            throw new NullPointerException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        }
        if ("".trim().equals(telefone)) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        }
    }

    public void valida
}
