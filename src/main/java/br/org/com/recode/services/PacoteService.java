package br.org.com.recode.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.org.com.recode.model.Pacote;
import br.org.com.recode.repository.PacoteRepository;
import jakarta.transaction.Transactional;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;

    public List<Pacote> getAllPacotes() {
        return pacoteRepository.findAll();
    }

    @Transactional
    public Pacote getPacoteById(Long id) {
        return pacoteRepository.findById(id).orElse(null);
    }

    @Transactional
    public Pacote savePacote(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    public Pacote updatePacote(Long id, Pacote pacoteAtualizado) {
        Pacote pacoteExistente = pacoteRepository.findById(id).orElse(null);
        if (pacoteExistente != null) {
            pacoteExistente.setValor(pacoteAtualizado.getValor());
            pacoteExistente.setDiarias(pacoteAtualizado.getDiarias());
            pacoteExistente.setDestino(pacoteAtualizado.getDestino());
            pacoteExistente.setCliente(pacoteAtualizado.getCliente());
            return pacoteRepository.save(pacoteExistente);
        } else {
            throw new RuntimeException("Pacote com o ID " + id + " não encontrado.");
        }
    }

    public void deletePacote(Long id) {
        pacoteRepository.deleteById(id);
    }
}

