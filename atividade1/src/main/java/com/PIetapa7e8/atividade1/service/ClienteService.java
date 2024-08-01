package com.PIetapa7e8.atividade1.service;

import com.PIetapa7e8.atividade1.model.Cliente;
import com.PIetapa7e8.atividade1.repository.ClienteRepository;
import java.util.List;
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
        
        public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }
        
        public Cliente buscarPorId(Integer id){
        return clienteRepository.findById(id).orElseThrow();
    }
        
        public void excluir (Integer id){
        Cliente clienteEncontrado = buscarPorId(id);
        clienteRepository.deleteById(clienteEncontrado.getId());
    }
        
       public Cliente atualizar(Integer id,Cliente clienteAtualizado){
        Cliente clienteEncontrado = buscarPorId(id);
        clienteEncontrado.setNome(clienteAtualizado.getNome());
        clienteEncontrado.setEndereco(clienteAtualizado.getEndereco());
        clienteEncontrado.setBairro(clienteAtualizado.getBairro());
        clienteEncontrado.setCidade(clienteAtualizado.getCidade());
        clienteEncontrado.setUf(clienteAtualizado.getUf());
        clienteEncontrado.setCep(clienteAtualizado.getCep());
        clienteEncontrado.setEmail(clienteAtualizado.getEmail());
        clienteEncontrado.setTelefone(clienteAtualizado.getTelefone());
        clienteRepository.save(clienteEncontrado);
        return clienteEncontrado;
     }

}
