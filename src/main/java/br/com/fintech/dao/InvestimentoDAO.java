package br.com.fintech.dao;

import br.com.fintech.model.entity.InvestimentoEntity;
import java.util.List;

public interface InvestimentoDAO {
    void insert(InvestimentoEntity inv) throws Exception;
    List<InvestimentoEntity> getAll() throws Exception;
}
