package it.devstale.resoconto.spese.service;

import java.util.List;

import org.springframework.data.domain.Page;

import it.devstale.resoconto.spese.service.dto.CartellaDTO;

public interface CartellaService {
	
	public CartellaDTO crea(CartellaDTO cartella) throws Exception;
	
	public CartellaDTO getById(String id) throws Exception;
	
	public CartellaDTO aggiorna(CartellaDTO cartella) throws Exception;
	
	public CartellaDTO cancella(String id) throws Exception;
	
	public List<CartellaDTO> findAll() throws Exception;
	
	public Page<CartellaDTO> findPaginated(int pagina, int dimensioniPagina) throws Exception;

}
