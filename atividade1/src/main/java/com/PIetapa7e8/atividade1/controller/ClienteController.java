package com.PIetapa7e8.atividade1.controller;

import com.PIetapa7e8.atividade1.model.Cliente;
import com.PIetapa7e8.atividade1.model.Fotovoltaico;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {
    
    private List<Cliente> listaclientes = new ArrayList<>();
    private List<Fotovoltaico> listafotovoltaico = new ArrayList<>();
    
    //página inicial,ccom os menus, localhost:8080/index
    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }
    
    //pagina  para cadastro de cliente
    @GetMapping("/cadastroCliente")
    public String inicio(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastroCliente";
    }
    
    //Salva na lista os clientes do formulario cadastro clientes
    @PostMapping("/cadastro")
    public String cadastrarClientes(@ModelAttribute Cliente clientes, Model model) {
        clientes.setId(listaclientes.size() + 1);
        listaclientes.add(clientes);
        model.addAttribute("cliente", clientes);
        return "redirect:/lista";
    }
    
    @GetMapping("/lista")
    public String listaClientes(Model model) {
        model.addAttribute("lista", listaclientes);
        return "listaClientes";
    }
    
    @GetMapping("/formularioFv")
    public String cadastroFotovoltaico(Model model){
        model.addAttribute("fotovoltaicos", new Fotovoltaico());
        return "cadastroFotovoltaico";
    }
    
    @PostMapping("/formFV")
    public String gravarFotovoltaico(Model model,@ModelAttribute Fotovoltaico fotovoltaico) {
        fotovoltaico.setId(listafotovoltaico.size()+1);
        listafotovoltaico.add(fotovoltaico);
        model.addAttribute("fotovoltaicos", listafotovoltaico);
        return "redirect:/lista";
    }
    
    @GetMapping("/exibir")
    public String mostrarDetalhesFilme(Model model, @RequestParam String id) {
        Integer idCliente = Integer.parseInt(id);
        Cliente registroEncontrado = new Cliente();
        for (Cliente c : listaclientes) {
            if (c.getId() == idCliente) {
                registroEncontrado = c;
                break;
            }
        }
        Fotovoltaico fotovoltaicoEncontrado = new Fotovoltaico();
        
        for (Fotovoltaico f : listafotovoltaico) {
            if (f.getId() == idCliente) {
                fotovoltaicoEncontrado = f;
                break;
            }
        }
        model.addAttribute("registroCliente", registroEncontrado);
        model.addAttribute("registroFotovoltaico", fotovoltaicoEncontrado);
        return "exibirCadastro";
    }
    
    @GetMapping("/listaFV")
    public String listaFotovoltaico(Model model) {
        model.addAttribute("listaFV", listafotovoltaico);
        return "listaFotovoltaico";
    }
}
