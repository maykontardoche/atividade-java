package br.com.fintech.model.entity;

public class EnderecoEntity {
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public EnderecoEntity() { }

    public EnderecoEntity(String endereco, String bairro, String cidade, String estado, String cep) {
        this.endereco = endereco;
        this.bairro   = bairro;
        this.cidade   = cidade;
        this.estado   = estado;
        this.cep      = cep;
    }

    // getters/setters omitidos por brevidade…
    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s",
                endereco, bairro, cidade, estado, cep);
    }
}
