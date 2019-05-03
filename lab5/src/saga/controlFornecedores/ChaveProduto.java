package saga.controlFornecedores;

import java.util.Objects;

public class ChaveProduto {
    private String nome;
    private String descricao;

    public ChaveProduto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChaveProduto)) return false;
        ChaveProduto that = (ChaveProduto) o;
        return Objects.equals(nome, that.nome) &&
                Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }
}
