package saga;

/**
 * Classe que representa um avaliador que vê se uma string é nula ou invalida, lançando a exceção adequada.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class Avaliador {
    public void validaNome(String frase, String tipoEntidade) {
        if (frase == null) {
            throw new NullPointerException("Erro no cadastro do " + tipoEntidade + ": nome nao pode ser vazio ou nulo.");
        }
        if ("".equals(frase.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do " + tipoEntidade + ": nome nao pode ser vazio ou nulo.");
        }
    }

    public void validaEmail(String frase, String tipoEntidade) {
        if (frase == null) {
            throw new NullPointerException("Erro no cadastro do " + tipoEntidade + ": email nao pode ser vazio ou nulo.");
        }
        if ("".equals(frase.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do " + tipoEntidade + ": email nao pode ser vazio ou nulo.");
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
            throw new NullPointerException("Erro no cadastro do cliente: telefone nao pode ser vazio ou nulo.");
        }
        if ("".equals(frase.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: telefone nao pode ser vazio ou nulo.");
        }
    }

    public void validarCPFCliente(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }
    }

    public void validaPrecoProduto(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }
    }


    public void validaDescricaoProduto(String frase) {
        if (frase == null) {
            throw new NullPointerException("Erro no cadastro do cliente: descricao nao pode ser vazia ou nula.");
        }
        if ("".equals(frase.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: descricao nao pode ser vazia ou nula.");
        }
    }

    public void validaAtributo(String atributo, String tipoEntidade) {
        if (atributo == null) {
            throw new NullPointerException("Erro na edicao do " + tipoEntidade + ": atributo nao pode ser vazio ou nulo.");
        }
        if ("".equals(atributo.trim())) {
            throw new IllegalArgumentException("Erro na edicao do " + tipoEntidade + ": atributo nao pode ser vazio ou nulo.");
        }
        if (!"nome".equals(atributo.toLowerCase()) && !"email".equals(atributo.toLowerCase())
                && !"localizacao".equals(atributo.toLowerCase()) && !"telefone".equals(atributo.toLowerCase())) {
            throw new IllegalArgumentException("Erro na edicao do "+ tipoEntidade + ": atributo nao existe.");
        }
    }

    public void validaNovoValor(String novoValor, String tipoEntidade) {
        if (novoValor == null) {
            throw new NullPointerException("Erro na edicao do " + tipoEntidade+ ": novo valor nao pode ser vazio ou nulo.");
        }
        if ("".equals(novoValor.trim())) {
            throw new IllegalArgumentException("Erro na edicao do " + tipoEntidade+ ": novo valor nao pode ser vazio ou nulo.");
        }
    }

    public void validaNomeFornecedorRemover (String fornecedor) {
        if (fornecedor == null) {
            throw new NullPointerException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
        }
        if ("".equals(fornecedor.trim())) {
            throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
        }
    }
}
