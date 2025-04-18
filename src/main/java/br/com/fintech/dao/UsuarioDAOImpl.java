// package br.com.fintech.dao;

// import br.com.fintech.util.ConnectionFactory;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.util.Date;
// import java.util.Optional;

// public class UsuarioDAOImpl implements UsuarioDAO {
//     @Override
//     public void register(String username, String password) throws Exception {
//         String sql = "INSERT INTO T_FIN_USUARIO (nr_usuario, nm_usuario, ds_email, ds_senha, dt_cadastro) VALUES (?, ?, ?, ?, ?)";
//         try (Connection conn = ConnectionFactory.getConnection();
//              PreparedStatement ps = conn.prepareStatement(sql)) {
//             ps.setString(1, username);
//             ps.setString(2, username);
//             ps.setString(3, username + "@exemplo.com");
//             ps.setString(4, password);
//             ps.setDate(5, new java.sql.Date(new Date().getTime()));
//             ps.executeUpdate();
//         }
//     }

//     @Override
//     public Optional<String> login(String username, String password) throws Exception {
//         String sql = "SELECT ds_senha FROM T_FIN_USUARIO WHERE nr_usuario = ?";
//         try (Connection conn = ConnectionFactory.getConnection();
//              PreparedStatement ps = conn.prepareStatement(sql)) {
//             ps.setString(1, username);
//             try (ResultSet rs = ps.executeQuery()) {
//                 if (rs.next() && rs.getString("ds_senha").equals(password)) {
//                     return Optional.of(username);
//                 }
//             }
//         }
//         return Optional.empty();
//     }
// }

// src/main/java/br/com/fintech/dao/UsuarioDAOImpl.java
package br.com.fintech.dao;

import br.com.fintech.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class UsuarioDAOImpl implements UsuarioDAO {
    @Override
    public void register(String username, String fullName, String email, String password) throws Exception {
        String sql = """
                INSERT INTO T_FIN_USUARIO
                  (nr_usuario, nm_usuario, ds_email, ds_senha, dt_cadastro, cd_tipo_usuario)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, fullName);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            ps.setString(6, "Comum");
            ps.executeUpdate();
        }
    }

    @Override
    public Optional<String> login(String username, String password) throws Exception {
        String sql = """
                SELECT nm_usuario
                  FROM T_FIN_USUARIO
                 WHERE nr_usuario = ?
                   AND ds_senha   = ?
                """;

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(rs.getString("nm_usuario"));
                }
            }
        }
        return Optional.empty();
    }
}
