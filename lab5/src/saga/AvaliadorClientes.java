package saga;

/**
 * Classe que representa um avaliador que vê se uma string é nula ou invalida, lançando a exceção adequada.
 *
 * @author Rodrigo Eloy Cavalcanti - 118210111
 */
public class AvaliadorClientes {
    public void validaNomeCliente(String mensagem) {
        if (mensagem == null) {
            throw new NullPointerException("Erro no cadastro do cliente: "+ mensagem + " nome nao pode ser vazio ou nulo.");
        }
        if (mensagem.trim().equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: "+ mensagem + " nome nao pode ser vazio ou nulo.");
        }
    }

    public void stringVazia(String mensagem) {
        throw new IllegalArgumentException("")
    }

    public void validaEmailCliente(String stringASerAvaliada) {
        if (stringASerAvaliada == null) {
            throw new NullPointerException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        }
        if (stringASerAvaliada.trim().equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        }
    }

    public void validaLocalizacaoCliente(String stringASerAvaliada) {
        if (stringASerAvaliada == null) {
            throw new NullPointerException("Erro no cadastro do cliente: localizacao nao pode ser vazio ou nulo.");
        }
        if (stringASerAvaliada.trim().equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazio ou nulo.");
        }
    }

    public void validarCPFCliente(int cpf) {
        String str = String.format("%d", cpf);
        if (str.length() != 11) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }
    }
}
