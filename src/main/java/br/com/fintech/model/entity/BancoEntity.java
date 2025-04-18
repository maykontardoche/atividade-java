package br.com.fintech.model.entity;

public class BancoEntity {
    protected String codigo;
    protected String instituicao;

    public BancoEntity(String codigo, String instituicao) {
        this.codigo = codigo;
        this.instituicao = instituicao;
    }

    // + estes métodos:
    public String getCodigo() {
        return codigo;
    }

    public String getInstituicao() {
        return instituicao;
    }

    @Override
    public String toString() {
        return String.format("codigo=%s | instituicao=%s ", codigo, instituicao);
    }
}
