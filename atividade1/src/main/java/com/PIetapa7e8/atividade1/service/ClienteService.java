package com.PIetapa7e8.atividade1.service;

import com.PIetapa7e8.atividade1.model.Cliente;
import com.PIetapa7e8.atividade1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    
        public Cliente criar(Cliente client){
        client.setId(null);
        clienteRepository.save(client);
        return client;
    }
}
