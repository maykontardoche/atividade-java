// package br.com.fintech.dao;

// import java.util.Optional;

// public interface UsuarioDAO {
//     void register(String username, String password) throws Exception;
//     Optional<String> login(String username, String password) throws Exception;
// }
package br.com.fintech.dao;

import java.util.Optional;

public interface UsuarioDAO {
    /**
     * Registra um novo usuário.
     * @param username o login (chave primaria)
     * @param fullName nome completo
     * @param email email
     * @param password senha em texto puro (ideal seria hash, mas para o exemplo simplificamos)
     */
    void register(String username, String fullName, String email, String password) throws Exception;

    /**
     * Tenta logar. Retorna Optional.empty() se falhar,
     * ou Optional<fullName> se sucesso.
     */
    Optional<String> login(String username, String password) throws Exception;
}
