package br.com.fintech.dao;

import br.com.fintech.model.entity.TransacaoEntity;
import java.util.List;

public interface TransacaoDAO {
    void insert(TransacaoEntity tx) throws Exception;
    List<TransacaoEntity> getAll() throws Exception;
}
