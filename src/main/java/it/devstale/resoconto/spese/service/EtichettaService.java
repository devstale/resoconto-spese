package it.devstale.resoconto.spese.service;

import java.util.List;

import it.devstale.resoconto.spese.service.dto.EtichettaDTO;

public interface EtichettaService {
	
	public EtichettaDTO crea(EtichettaDTO etichetta) throws Exception;
	
	public EtichettaDTO getById(String id) throws Exception;
	
	public EtichettaDTO aggiorna(EtichettaDTO etichetta) throws Exception;
	
	public EtichettaDTO cancella(String id) throws Exception;
	
	public List<EtichettaDTO> findAll() throws Exception;

}
