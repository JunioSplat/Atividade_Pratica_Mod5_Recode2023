package br.org.com.recode.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.org.com.recode.model.ReservaViagem;
import br.org.com.recode.repository.ReservaViagemRepository;
import jakarta.transaction.Transactional;

@Service
public class ReservaViagemService {

    @Autowired
    private ReservaViagemRepository reservaViagemRepository;

    public List<ReservaViagem> getAllReservasViagem() {
        return reservaViagemRepository.findAll();
    }

    @Transactional
    public ReservaViagem getReservaViagemById(Long id) {
        return reservaViagemRepository.findById(id).orElse(null);
    }

    @Transactional
    public ReservaViagem saveReservaViagem(ReservaViagem reservaViagem) {
        return reservaViagemRepository.save(reservaViagem);
    }

    public ReservaViagem updateReservaViagem(Long id, ReservaViagem reservaViagemAtualizada) {
        ReservaViagem reservaViagemExistente = reservaViagemRepository.findById(id).orElse(null);
        if (reservaViagemExistente != null) {
            reservaViagemExistente.setDataIda(reservaViagemAtualizada.getDataIda());
            reservaViagemExistente.setCliente(reservaViagemAtualizada.getCliente());
            reservaViagemExistente.setPacote(reservaViagemAtualizada.getPacote());
            return reservaViagemRepository.save(reservaViagemExistente);
        } else {
            throw new RuntimeException("ReservaViagem com o ID " + id + " não encontrado.");
        }
    }

    public void deleteReservaViagem(Long id) {
        reservaViagemRepository.deleteById(id);
    }
}
