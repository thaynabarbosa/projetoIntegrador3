package com.PIetapa7e8.atividade1.controller;

import com.PIetapa7e8.atividade1.model.Cliente;
import com.PIetapa7e8.atividade1.model.Fotovoltaico;
import com.PIetapa7e8.atividade1.service.ClienteService;
import com.PIetapa7e8.atividade1.service.FotovoltaicoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {
    
    @Autowired
    ClienteService clienteservice;
    
    @Autowired
    FotovoltaicoService fotovoltaicoservice;
    
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
        if (clientes.getId() != null) {
            clienteservice.atualizar(clientes.getId(), clientes);
            model.addAttribute("cliente", clientes);
        } else {
            clienteservice.criar(clientes);
            model.addAttribute("cliente", clientes);
        }
        return "redirect:/lista";
    }
    
    //Lista todos os clientes em uma tabela
    @GetMapping("/lista")
    public String listaClientes(Model model) {
         model.addAttribute("lista", clienteservice.listarTodos());
        return "listaClientes";
    }
    
    @GetMapping("/formularioFv")
    public String cadastroFotovoltaico(Model model, @RequestParam String id){
        Integer idCliente = Integer.parseInt(id);
        Cliente clienteencontrado = clienteservice.buscarPorId(idCliente);
        model.addAttribute("cliente", clienteencontrado);
        model.addAttribute("fotovoltaicos", new Fotovoltaico());
        return "cadastroFotovoltaico";
    }
    
    @PostMapping("/formFV")
    public String gravarFotovoltaico(Model model,@ModelAttribute Fotovoltaico fotovoltaico, @ModelAttribute Cliente cliente) {
        fotovoltaico.setClientes(cliente);
        fotovoltaicoservice.criar(fotovoltaico);
        model.addAttribute("fotovoltaicos", fotovoltaico);
        return "redirect:/lista";
    }
    
    @GetMapping("/exibir")
    public String mostrarDetalhesClientes(Model model, @RequestParam String id) {
       Integer idCliente = Integer.parseInt(id);

        Cliente registroEncontrado = new Cliente();
        registroEncontrado = clienteservice.buscarPorId(idCliente);

        List<Fotovoltaico> fotovoltaicoEncontrada = new ArrayList<>();
        fotovoltaicoEncontrada = fotovoltaicoservice.listarTodos(idCliente);

        model.addAttribute("registroCliente", registroEncontrado);
        model.addAttribute("fotovoltaicos", new Fotovoltaico());
        model.addAttribute("registroFotovoltaico", fotovoltaicoEncontrada);
        return "exibirCadastro";
    }
    
    @GetMapping("/listaFV")
    public String listaFotovoltaico(Model model) {
        model.addAttribute("lista", fotovoltaicoservice.listar());
        return "listaFotovoltaico";
    }
}
