package it.devstale.resoconto.spese.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.devstale.resoconto.spese.model.Etichetta;
import it.devstale.resoconto.spese.model.Utente;

public interface EtichettaRepository extends PagingAndSortingRepository<Etichetta, Long>{
	
	public List<Etichetta> findByUtenteOrderByNomeAsc(Utente utente);
	public Page<Etichetta> findByUtente(Utente utente, Pageable pageable);

}
