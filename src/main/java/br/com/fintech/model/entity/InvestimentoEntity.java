package br.com.fintech.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class InvestimentoEntity {
    private final UUID id = UUID.randomUUID();
    private String documentoTitular;
    private BigDecimal valor;
    private BigDecimal rendimento;
    private Date dataInicio;

    public InvestimentoEntity(String documentoTitular,
            BigDecimal valor,
            BigDecimal rendimento,
            Date dataInicio) {
        this.documentoTitular = documentoTitular;
        this.valor = valor;
        this.rendimento = rendimento;
        this.dataInicio = dataInicio;
    }

    // + getters:
    public UUID getId() {
        return id;
    }

    public String getDocumentoTitular() {
        return documentoTitular;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    @Override
    public String toString() {
        return String.format("Investimento{id=%s, titular=%s, valor=%s, rendimento=%s, dataInicio=%s}",
                id, documentoTitular, valor, rendimento, dataInicio);
    }
}
