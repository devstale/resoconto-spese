package it.devstale.resoconto.spese.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.devstale.resoconto.spese.model.Cartella;
import it.devstale.resoconto.spese.model.Utente;

public interface CartellaRepository extends PagingAndSortingRepository<Cartella, Long>{
	
	public List<Cartella> findByUtenteOrderByDataCreazioneDesc(Utente utente);
	
	public Page<Cartella> findByUtente(Utente utente, Pageable pageable);


}
