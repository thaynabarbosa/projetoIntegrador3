package com.PIetapa7e8.atividade1.controller;

import com.PIetapa7e8.atividade1.model.Fotovoltaico;
import com.PIetapa7e8.atividade1.service.FotovoltaicoService;
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
@RequestMapping("/fotovoltaico")
public class FotovoltaicoAPIController {
    
    @Autowired
    FotovoltaicoService fotovoltaicoService;
    
    @PostMapping("/adicionar")
    public ResponseEntity<Fotovoltaico> addFotovoltaico(@RequestBody Fotovoltaico fotovoltaico){
        var novoFotovoltaico = fotovoltaicoService.criar(fotovoltaico);
        return new ResponseEntity<>(novoFotovoltaico,HttpStatus.CREATED);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<List> pesquisar(@PathVariable Integer id){
        List<Fotovoltaico> lista = fotovoltaicoService.listarTodos(id);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirFotovoltaico(@PathVariable Integer id){
        fotovoltaicoService.excluirFotovoltaico(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    //Listar
    @GetMapping("/listar")
    public ResponseEntity<List> listarFotovoltaico(){
        List<Fotovoltaico> fotovoltaicos = fotovoltaicoService.listar();
        return new ResponseEntity<>(fotovoltaicos,HttpStatus.OK);
    }
    
    @DeleteMapping("/excluirFotovoltaicoPorCliente/{id}")
    public ResponseEntity<?> excluirFotovoltaicoPorCliente(@PathVariable Integer idCliente){
        fotovoltaicoService.excluirTodosFotovoltaicos(idCliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Fotovoltaico> editarFotovoltaico (@PathVariable Integer id,@RequestBody Fotovoltaico fotovo){
        var editarFotovoltaico = fotovoltaicoService.atualizar(id, fotovo);
        return new ResponseEntity<>(editarFotovoltaico,HttpStatus.OK);
    }
}
