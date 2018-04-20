package it.devstale.resoconto.spese.service;

import java.util.List;

import it.devstale.resoconto.spese.model.Cartella;
import it.devstale.resoconto.spese.model.Etichetta;
import it.devstale.resoconto.spese.service.dto.SpesaDTO;

public interface SpesaService {

	public SpesaDTO crea(SpesaDTO spesa) throws Exception;

	public SpesaDTO findById(Long id) throws Exception;

	public SpesaDTO aggiorna(SpesaDTO spesa) throws Exception;

	public SpesaDTO cancella(Long id) throws Exception;

	public List<SpesaDTO> find();
	
	public List<SpesaDTO> find(int pagina, int dimensioniPagina);

	public List<SpesaDTO> findByEtichetta(Etichetta etichetta);
	
	public List<SpesaDTO> findByEtichetta(Etichetta etichetta, int pagina, int dimensioniPagina);

	public List<SpesaDTO> findByCartella(Cartella cartella);
	
	public List<SpesaDTO> findByCartella(Cartella cartella, int pagina, int dimensioniPagina);

}
