package br.com.fintech.model.entity;

import java.util.UUID;

public class ClienteEntity {
    private final UUID id = UUID.randomUUID();
    private String nome;
    private String documento;
    private String email;
    private String telefone;
    private EnderecoEntity endereco;

    public ClienteEntity(String nome, String documento, String email, String telefone, EnderecoEntity endereco) {
        this.nome      = nome;
        this.documento = documento;
        this.email     = email;
        this.telefone  = telefone;
        this.endereco  = endereco;
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public String getDocumento() { return documento; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public EnderecoEntity getEndereco() { return endereco; }

    @Override
    public String toString() {
        return String.format("ID:%s | %s (%s) | %s | %s",
                id, nome, documento, email, telefone);
    }
}
