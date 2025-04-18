package br.com.fintech.dao;

import br.com.fintech.model.entity.InvestimentoEntity;
import br.com.fintech.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InvestimentoDAOImpl implements InvestimentoDAO {
    @Override
    public void insert(InvestimentoEntity inv) throws Exception {
        String sql = "INSERT INTO T_FIN_INVESTIMENTO (nr_investimento, cd_tipo_investimento, vl_inicial, vl_rentabilidade, dt_inicio, dt_final, cd_status, nr_conta) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, "TipoX");
            ps.setBigDecimal(3, inv.getValor());
            ps.setBigDecimal(4, inv.getRendimento());
            ps.setDate(5, new Date(inv.getDataInicio().getTime()));
            ps.setDate(6, new Date(System.currentTimeMillis()));
            ps.setString(7, "Ativo");
            ps.setString(8, inv.getDocumentoTitular());
            ps.executeUpdate();
        }
    }

    @Override
    public List<InvestimentoEntity> getAll() throws Exception {
        String sql = "SELECT nr_investimento, vl_inicial, vl_rentabilidade, dt_inicio FROM T_FIN_INVESTIMENTO";
        List<InvestimentoEntity> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                InvestimentoEntity i = new InvestimentoEntity(
                    rs.getString("nr_investimento"),
                    rs.getBigDecimal("vl_inicial"),
                    rs.getBigDecimal("vl_rentabilidade"),
                    rs.getDate("dt_inicio")
                );
                lista.add(i);
            }
        }
        return lista;
    }
}
