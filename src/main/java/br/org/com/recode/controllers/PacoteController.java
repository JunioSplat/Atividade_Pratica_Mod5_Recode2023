package br.org.com.recode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.com.recode.model.Cliente;
import br.org.com.recode.model.Pacote;
import br.org.com.recode.services.ClienteService;
import br.org.com.recode.services.PacoteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/pacotes")
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;
    
    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public String listPacotes(Model model) {
        List<Pacote> pacotes = pacoteService.getAllPacotes();
        model.addAttribute("pacotes", pacotes);
        return "ListarPacotes";
    }

    @GetMapping("/novo")
    public String showFormForAdd(Model model) {
        Pacote pacote = new Pacote();
        List<Cliente> clientes = clienteService.getAllClientes();
        model.addAttribute("pacote", pacote);
        model.addAttribute("clientes", clientes);
        return "pacoteForm";
    }

    @PostMapping("/save")
    public String savePacote(@ModelAttribute("pacote") @Valid Pacote pacote, BindingResult result) {
        if (result.hasErrors()) {
            return "pacoteForm";
        }
        pacote.setCliente(clienteService.getClienteById(pacote.getCliente().getId()));

        pacoteService.savePacote(pacote);
        return "redirect:/pacotes";
    }

    @GetMapping("/editar/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        Pacote pacote = pacoteService.getPacoteById(id);
        model.addAttribute("pacote", pacote);
        return "editarPacote";
    }

    @PostMapping("/editar/{id}")
    public String updatePacotes(@PathVariable Long id, @ModelAttribute("pacote") Pacote pacote) {
        pacoteService.updatePacote(id, pacote);
        return "redirect:/pacotes";
    }
//
//    @GetMapping("/deletar/{id}")
//    public String deletePacote(@PathVariable Long id) {
//        pacoteService.deletePacote(id);
//        return "redirect:/pacotes";
//    }

    @GetMapping("/deletar/{id}")
    public ResponseEntity<String> deletePacote(@PathVariable Long id) {
        try {
            pacoteService.deletePacote(id);
            return ResponseEntity.ok("Pacote excluído com sucesso");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O pacote não pode ser excluído pois está associado a uma Reserva");
        }
    }
}
