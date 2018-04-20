package it.devstale.resoconto.spese.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.devstale.resoconto.spese.model.Spesa;
import it.devstale.resoconto.spese.model.Utente;

public interface SpesaRepository extends PagingAndSortingRepository<Spesa, Long>{
	
	public List<Spesa> findByUtenteOrderByDataDesc(Utente utente);
	
	public Page<Spesa> findByUtente(Utente utente, Pageable pageable);

	//@Query("FROM Spesa AS spesa LEFT JOIN spesa.etichette AS etichetta WHERE spesa.utente = :utente AND etichetta =?2 ORDER BY spesa.data")  
	public List<Spesa> findByUtenteAndEtichette_id(Utente utente, Long id);
	
	//@Query("FROM Spesa AS spesa LEFT JOIN spesa.etichette AS etichetta WHERE spesa.utente = ?1 AND etichetta =?2")  
	public Page<Spesa> findByUtenteAndEtichette_id(Utente utente, Long id, Pageable pageable);
	
//	public List<Spesa> findByUtenteAndCartella(Utente utente, Cartella cartella, Sort sort);
	
//	public Page<Spesa> findByUtenteAndCartella(Utente utente, Cartella cartella, Pageable pageable);
	
}
