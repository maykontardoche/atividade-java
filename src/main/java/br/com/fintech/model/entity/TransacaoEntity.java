package br.com.fintech.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class TransacaoEntity {
    private final UUID id = UUID.randomUUID();
    private BigDecimal valor;
    private Date data;
    private String tipo;
    private ContaEntity contaDestino;

    // getters/setters que faltam:
    public UUID getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ContaEntity getContaDestino() {
        return contaDestino;
    }
    public void setContaDestino(ContaEntity contaDestino) {
        this.contaDestino = contaDestino;
    }

    @Override
    public String toString() {
        return String.format("Id: %s | Valor: %s | Data: %s | Tipo: %s",
            id, valor, data, tipo);
    }
}
