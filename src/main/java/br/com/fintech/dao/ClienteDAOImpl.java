package br.com.fintech.dao;

import br.com.fintech.model.entity.ClienteEntity;
import br.com.fintech.model.entity.EnderecoEntity;
import br.com.fintech.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public void insert(ClienteEntity cliente) throws Exception {
        String sql = "INSERT INTO T_FIN_USUARIO (nr_usuario, nm_usuario, ds_email, ds_senha, dt_cadastro, cd_tipo_usuario, vl_meta_financeira) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cliente.getId().toString());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, "senha_default");
            ps.setDate(5, new Date(System.currentTimeMillis()));
            ps.setString(6, "Comum");
            ps.setDouble(7, 0.0);
            ps.executeUpdate();
        }
    }

    @Override
    public List<ClienteEntity> getAll() throws Exception {
        String sql = "SELECT nr_usuario, nm_usuario, ds_email FROM T_FIN_USUARIO";
        List<ClienteEntity> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                EnderecoEntity end = new EnderecoEntity();
                ClienteEntity c = new ClienteEntity(
                    rs.getString("nm_usuario"),
                    rs.getString("nr_usuario"),
                    rs.getString("ds_email"),
                    "",
                    end
                );
                lista.add(c);
            }
        }
        return lista;
    }
}
