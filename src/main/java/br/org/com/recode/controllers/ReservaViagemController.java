package br.org.com.recode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.com.recode.model.Cliente;
import br.org.com.recode.model.Pacote;
import br.org.com.recode.model.ReservaViagem;
import br.org.com.recode.services.ClienteService;
import br.org.com.recode.services.PacoteService;
import br.org.com.recode.services.ReservaViagemService;

@Controller
@RequestMapping("/reservas")
public class ReservaViagemController {

    private final ReservaViagemService reservaViagemService;
    private final ClienteService clienteService;
    private final PacoteService pacoteService;

    @Autowired
    public ReservaViagemController(ReservaViagemService reservaViagemService, ClienteService clienteService,
            PacoteService pacoteService) {
        this.reservaViagemService = reservaViagemService;
        this.clienteService = clienteService;
        this.pacoteService = pacoteService;
    }

    @GetMapping
    public String listReservasViagem(Model model) {
        List<ReservaViagem> reservasViagem = reservaViagemService.getAllReservasViagem();
        model.addAttribute("reservasViagem", reservasViagem);
        return "ListarReservasViagem";
    }

    @GetMapping("/nova")
    public String showFormForAdd(Model model) {
        ReservaViagem reservaViagem = new ReservaViagem();
        model.addAttribute("reservaViagem", reservaViagem);
        model.addAttribute("clientes", clienteService.getAllClientes());
        model.addAttribute("pacotes", pacoteService.getAllPacotes());
        return "reservaViagemForm";
    }

    @PostMapping("/save")
    public String saveReservaViagem(@ModelAttribute("reservaViagem") ReservaViagem reservaViagem) {
        reservaViagemService.saveReservaViagem(reservaViagem);
        return "redirect:/reservas";
    }

    @GetMapping("/editar/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        ReservaViagem reservaViagem = reservaViagemService.getReservaViagemById(id);
        model.addAttribute("reservaViagem", reservaViagem);
        model.addAttribute("clientes", clienteService.getAllClientes());
        model.addAttribute("pacotes", pacoteService.getAllPacotes());
        return "editarReservaViagem";
    }

    @PostMapping("/editar/{id}")
    public String updateReservasViagem(@PathVariable Long id,
            @ModelAttribute("reservaViagem") ReservaViagem reservaViagem) {
        reservaViagemService.updateReservaViagem(id, reservaViagem);
        return "redirect:/reservas";
    }

    @GetMapping("/deletar/{id}")
    public String deleteReservaViagem(@PathVariable Long id) {
        reservaViagemService.deleteReservaViagem(id);
        return "redirect:/reservas";
    }

}