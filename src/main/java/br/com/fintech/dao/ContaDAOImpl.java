package br.com.fintech.dao;

import br.com.fintech.model.entity.ContaEntity;
import br.com.fintech.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDAOImpl implements ContaDAO {
    @Override
    public void insert(ContaEntity conta) throws Exception {
        String sql = "INSERT INTO T_FIN_CONTA (nr_conta, cd_tipo_conta, vl_saldo, dt_abertura, cd_status, nr_usuario, nr_banco) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, conta.getConta());
            ps.setString(2, conta.isPoupanca() ? "Poupança" : "Corrente");
            ps.setBigDecimal(3, conta.getSaldo());
            ps.setDate(4, new Date(System.currentTimeMillis()));
            ps.setString(5, "Ativa");
            ps.setString(6, conta.getTitular());
            ps.setString(7, conta.getCodigo());
            ps.executeUpdate();
        }
    }

    @Override
    public List<ContaEntity> getAll() throws Exception {
        String sql = "SELECT nr_conta, cd_tipo_conta, vl_saldo, nr_usuario, nr_banco FROM T_FIN_CONTA";
        List<ContaEntity> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ContaEntity c = new ContaEntity(
                    rs.getString("nr_banco"),
                    rs.getString("nr_usuario"),
                    "",    // titular não usado aqui
                    "",    // agência vazio
                    rs.getString("nr_conta"),
                    rs.getString("cd_tipo_conta").equals("Poupança"),
                    rs.getBigDecimal("vl_saldo")
                );
                lista.add(c);
            }
        }
        return lista;
    }
}
