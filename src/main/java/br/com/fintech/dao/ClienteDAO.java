package br.com.fintech.dao;

import br.com.fintech.model.entity.ClienteEntity;
import java.util.List;

public interface ClienteDAO {
    void insert(ClienteEntity cliente) throws Exception;
    List<ClienteEntity> getAll() throws Exception;
}
