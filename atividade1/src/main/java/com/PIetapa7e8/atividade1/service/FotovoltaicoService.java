package com.PIetapa7e8.atividade1.service;

import com.PIetapa7e8.atividade1.model.Cliente;
import com.PIetapa7e8.atividade1.model.Fotovoltaico;
import com.PIetapa7e8.atividade1.repository.FotovoltaicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotovoltaicoService {
    @Autowired
    FotovoltaicoRepository fotovoltaicoRepository;
    
    public Fotovoltaico criar(Fotovoltaico fotov){
        fotov.setId(null);
        fotovoltaicoRepository.save(fotov);
        return fotov;
    }
    
    public List<Fotovoltaico> listarTodos(Integer id){
       return fotovoltaicoRepository.findByClienteId(id);
    }
    
    public List<Fotovoltaico> listar(){
    return fotovoltaicoRepository.findAll();
    }
    
    public Fotovoltaico buscarPorId(Integer id){
    return fotovoltaicoRepository.findById(id).orElseThrow();
    }
    
    //exclui o fotovoltaico no banco de dados
    public void excluirFotovoltaico (Integer id){
      Fotovoltaico fotovoltaicoEncontrado = buscarPorId(id);
      fotovoltaicoRepository.deleteById(fotovoltaicoEncontrado.getId());
    }
    
    //exclui todos os fotovoltaicos relacionadas ao cliente no banco de dados
    public void excluirTodosFotovoltaicos(Integer id){
      for(Fotovoltaico fotovoltaico : listarTodos(id)){
          excluirFotovoltaico(fotovoltaico.getId());
      }
    }
    
    public Fotovoltaico atualizar(Integer id,Fotovoltaico fotovoltaicoAtualizado){
        Fotovoltaico fotovoltaicoEncontrado = buscarPorId(id);
        fotovoltaicoEncontrado.setFabricante(fotovoltaicoAtualizado.getFabricante());
        fotovoltaicoEncontrado.setQtdPlacas(fotovoltaicoAtualizado.getQtdPlacas());
        fotovoltaicoEncontrado.setPotPlacas(fotovoltaicoAtualizado.getPotPlacas());
        fotovoltaicoEncontrado.setPotGerador(fotovoltaicoAtualizado.getPotGerador());
        fotovoltaicoEncontrado.setPotInversor(fotovoltaicoAtualizado.getPotInversor());
        fotovoltaicoEncontrado.setTipoTelhado(fotovoltaicoAtualizado.getTipoTelhado());
        fotovoltaicoEncontrado.setConcessionaria(fotovoltaicoAtualizado.getConcessionaria());
        fotovoltaicoRepository.save(fotovoltaicoEncontrado);
        return fotovoltaicoEncontrado;
    }
}
