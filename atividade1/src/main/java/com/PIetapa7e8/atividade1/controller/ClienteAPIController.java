package com.PIetapa7e8.atividade1.controller;

import com.PIetapa7e8.atividade1.model.Cliente;
import com.PIetapa7e8.atividade1.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteAPIController {
    
    @Autowired
    ClienteService clienteService;
    
    //Cadastrar
    @PostMapping("/adicionar")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente client){
        var novoCliente = clienteService.criar(client);
        return new ResponseEntity<>(novoCliente,HttpStatus.CREATED);
    }
    
    //Listar
    @GetMapping("/listar")
    public ResponseEntity<List> listarClientes(){
        List<Cliente> clientes = clienteService.listarTodos();
        return new ResponseEntity<>(clientes,HttpStatus.OK);
    }
    
    //Buscar
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Cliente> pesquisar(@PathVariable Integer id){
        Cliente clienteEncontrado = clienteService.buscarPorId(id);
        return new ResponseEntity<>(clienteEncontrado,HttpStatus.OK);
    }
    
    //Deletar
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirCliente(@PathVariable Integer id){
        clienteService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    //Atualizar
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> editarCliente (@PathVariable Integer id,@RequestBody Cliente client){
        var editarCliente = clienteService.atualizar(id, client);
        return new ResponseEntity<>(editarCliente,HttpStatus.OK);
    }
    
}
