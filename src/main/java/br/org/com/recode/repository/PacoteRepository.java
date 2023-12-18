package br.org.com.recode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.org.com.recode.model.Pacote;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long> {

}
