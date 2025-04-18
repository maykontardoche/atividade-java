package br.com.fintech.model.entity;

import java.math.BigDecimal;

public class ContaEntity extends BancoEntity {
    private String titular;
    private String agencia;
    private String conta;
    private boolean poupanca;
    private BigDecimal saldo;

    public ContaEntity(String instituicao, String codigo, String titular,
                       String agencia, String conta, boolean poupanca, BigDecimal saldo) {
        super(codigo, instituicao);
        this.titular  = titular;
        this.agencia  = agencia;
        this.conta    = conta;
        this.poupanca = poupanca;
        this.saldo    = saldo;
    }

    // + getters abaixo:
    public String getTitular() {
        return titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getConta() {
        return conta;
    }

    public boolean isPoupanca() {
        return poupanca;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    // herda getCodigo() de BancoEntity

    @Override
    public String toString() {
        var saldoFmt = saldo.compareTo(BigDecimal.ZERO) < 0
            ? "Você está usando limite: " + saldo
            : saldo.toString();
        return String.format(
            "Titular: %s | Banco: %s | Código: %s | Agência: %s | Conta: %s | %s | Saldo: %s",
             titular, getInstituicao(), getCodigo(), agencia, conta,
             (poupanca ? "Conta Poupança" : "Conta Corrente"),
             saldoFmt
        );
    }
}
