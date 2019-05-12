package saga.controlClientes;

public class ValidaControllerCliente {

    private void validadorAuxiliar(String parametro, String mensagem) {
        if (parametro == null) {
            throw new NullPointerException(mensagem);
        }
        if ("".equals(parametro.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: "+ mensagem + " nao pode ser vazio ou nulo.");
        }

    }

    private void validaCPF(String cpf, String mensagem) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public void validaEntradasCadastraCliente(String cpf, String nome, String email, String local) {
        validaCPF(cpf, "Erro no cadastro do cliente: cpf invalido.");
        validadorAuxiliar(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        validadorAuxiliar(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        validadorAuxiliar(local, "Erro no cadastro do cliente: localizacao nao pode ser vazio ou nulo.");
    }

    public void validaEntradasDadosCliente(String cpf) {
        validaCPF(cpf,"Erro na exibicao do cliente: cpf invalido.");
    }

    public void validaEntradasEditaCliente(String cpf, String atributo, String novoValor) {
        validaCPF(cpf, "Erro na edicao do cliente: cpf invalido.");
        validadorAuxiliar(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        validadorAuxiliar(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
    }

    public void validaEntradasRemoveCliente(String cpf) {
        validaCPF(cpf, "Erro na remocao do cliente: cpf invalido.");
    }



}
