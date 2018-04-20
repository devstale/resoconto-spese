package it.devstale.resoconto.spese.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.devstale.resoconto.spese.model.Utente;

public interface UtenteRepository extends PagingAndSortingRepository<Utente, String>{
	
	public Utente findByUsername(String username);

}
