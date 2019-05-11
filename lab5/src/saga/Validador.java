package saga;

public class Validador {
    public void  validarCPFCliente(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }
    }

    public void validaNome(String frase, String mensagem) {
        if (frase == null) {
            throw new NullPointerException(mensagem);
        }
        if ("".equals(frase.trim())) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public void validaEmail(String frase, String mensagem) {
        if (frase == null) {
            throw new NullPointerException(mensagem);
        }
        if ("".equals(frase.trim())) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public void validaLocalizacao(String frase) {
        if (frase == null) {
            throw new NullPointerException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        }
        if ("".equals(frase.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        }
    }

    public void validaTelefone(String frase) {
        if (frase == null) {
            throw new NullPointerException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        }
        if ("".equals(frase.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        }
    }

    public void validaAtributo(String atributo, String mensagem) {
        if (atributo == null) {
            throw new NullPointerException(mensagem);
        }
        if ("".equals(atributo.trim())) {
            throw new IllegalArgumentException(mensagem);
        }

    }

    public void validaNovoValor(String novoValor, String mensagem) {
        if (novoValor == null) {
            throw new NullPointerException(mensagem);
        }
        if ("".equals(novoValor.trim())) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public void validaPrecoProduto(double preco, String mensagem) {
        if (preco < 0) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public void validaDescricaoProduto(String frase, String mensagem) {
        if (frase == null) {
            throw new NullPointerException(mensagem);
        }
        if ("".equals(frase.trim())) {
            throw new IllegalArgumentException(mensagem);
        }
    }
}
