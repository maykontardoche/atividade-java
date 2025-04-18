package br.com.fintech.dao;

import br.com.fintech.model.entity.TransacaoEntity;
import br.com.fintech.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransacaoDAOImpl implements TransacaoDAO {
    @Override
    public void insert(TransacaoEntity tx) throws Exception {
        String sql = "INSERT INTO T_FIN_TRANSACAO (nr_transacao, dt_transacao, cd_tipo, vl_transacao, ds_transacao, nr_conta) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, UUID.randomUUID().toString());
            ps.setDate(2, new Date(tx.getData().getTime()));
            ps.setString(3, tx.getTipo());
            ps.setBigDecimal(4, tx.getValor());
            ps.setString(5, ""); // sem descrição
            ps.setString(6, tx.getContaDestino().getConta());
            ps.executeUpdate();
        }
    }

    @Override
    public List<TransacaoEntity> getAll() throws Exception {
        String sql = "SELECT nr_transacao, dt_transacao, cd_tipo, vl_transacao FROM T_FIN_TRANSACAO";
        List<TransacaoEntity> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TransacaoEntity t = new TransacaoEntity();
                t.setValor(rs.getBigDecimal("vl_transacao"));
                t.setData(rs.getDate("dt_transacao"));
                t.setTipo(rs.getString("cd_tipo"));
                lista.add(t);
            }
        }
        return lista;
    }
}
