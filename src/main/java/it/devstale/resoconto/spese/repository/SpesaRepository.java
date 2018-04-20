package it.devstale.resoconto.spese.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.devstale.resoconto.spese.model.Cartella;
import it.devstale.resoconto.spese.model.Spesa;
import it.devstale.resoconto.spese.model.Utente;

public interface SpesaRepository extends PagingAndSortingRepository<Spesa, Long>{
	
	public List<Spesa> findByUtenteOrderByDataDesc(Utente utente);
	
	public Page<Spesa> findByUtente(Utente utente, Pageable pageable);

	public List<Spesa> findByUtenteAndEtichette_id(Utente utente, Long id);
	
	public Page<Spesa> findByUtenteAndEtichette_id(Utente utente, Long id, Pageable pageable);
	
	public List<Spesa> findByUtenteAndCartellaOrderByDataDesc(Utente utente, Cartella cartella);
	
	public Page<Spesa> findByUtenteAndCartella(Utente utente, Cartella cartella, Pageable pageable);
	
}
