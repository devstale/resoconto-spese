package it.devstale.resoconto.spese.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.devstale.resoconto.spese.service.EtichettaService;
import it.devstale.resoconto.spese.service.dto.EtichettaDTO;

@Service
public class EtichettaServiceImpl implements EtichettaService {
	
	private static final Logger logger = LoggerFactory.getLogger(EtichettaServiceImpl.class.getName());

	@Override
	public EtichettaDTO crea(EtichettaDTO etichetta) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EtichettaDTO getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EtichettaDTO aggiorna(EtichettaDTO etichetta) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EtichettaDTO cancella(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EtichettaDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
