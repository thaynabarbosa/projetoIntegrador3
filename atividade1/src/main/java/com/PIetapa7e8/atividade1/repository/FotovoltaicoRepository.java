package com.PIetapa7e8.atividade1.repository;

import com.PIetapa7e8.atividade1.model.Fotovoltaico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotovoltaicoRepository extends JpaRepository <Fotovoltaico,Integer> {
    List<Fotovoltaico> findByClientesId(Integer clienteId);
}
