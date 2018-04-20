package it.devstale.resoconto.spese.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.devstale.resoconto.spese.model.Cartella;
import it.devstale.resoconto.spese.model.Etichetta;
import it.devstale.resoconto.spese.repository.SpesaRepository;
import it.devstale.resoconto.spese.service.SpesaService;
import it.devstale.resoconto.spese.service.dto.SpesaDTO;

@Service
public class SpesaServiceImpl implements SpesaService {
	
	private static final Logger logger = LoggerFactory.getLogger(SpesaServiceImpl.class.getName());
	
	@Autowired
	private SpesaRepository dao;

	@Override
	public SpesaDTO crea(SpesaDTO spesa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpesaDTO findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpesaDTO aggiorna(SpesaDTO spesa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpesaDTO cancella(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpesaDTO> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpesaDTO> find(int pagina, int dimensioniPagina) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpesaDTO> findByEtichetta(Etichetta etichetta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpesaDTO> findByEtichetta(Etichetta etichetta, int pagina, int dimensioniPagina) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpesaDTO> findByCartella(Cartella cartella) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpesaDTO> findByCartella(Cartella cartella, int pagina, int dimensioniPagina) {
		// TODO Auto-generated method stub
		return null;
	}

}
