package com.PIetapa7e8.atividade1.repository;

import com.PIetapa7e8.atividade1.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente,Integer>  {
    
}
