package br.com.fintech.dao;

import br.com.fintech.model.entity.ContaEntity;
import java.util.List;

public interface ContaDAO {
    void insert(ContaEntity conta) throws Exception;
    List<ContaEntity> getAll() throws Exception;
}
