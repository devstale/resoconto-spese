package it.devstale.resoconto.spese.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import it.devstale.resoconto.spese.repository.CartellaRepository;
import it.devstale.resoconto.spese.service.CartellaService;
import it.devstale.resoconto.spese.service.converter.CartellaConverter;
import it.devstale.resoconto.spese.service.dto.CartellaDTO;

@Service
public class CartellaServiceImpl 
		extends AbstractServiceImpl
			implements CartellaService {
	
	private static final Logger logger = LoggerFactory.getLogger(CartellaServiceImpl.class.getName());
	
	@Autowired
	private CartellaRepository dao;
	
	@Autowired
	private CartellaConverter converter;

	@Override
	public CartellaDTO crea(CartellaDTO cartella) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartellaDTO getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartellaDTO aggiorna(CartellaDTO cartella) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartellaDTO cancella(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartellaDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CartellaDTO> findPaginated(int pagina, int dimensioniPagina) throws Exception {
		
		try{
			
//			List<Cartella> cartelle = dao.findByUtente(getUtente(), pagina, dimensioniPagina);
//			Page<CartellaDTO> pagina = 
			
		// TODO Auto-generated method stub
		}catch(Exception e){
			logger.error("Si è verificato un errore in findPaginated.");
		}
		return null;
	}

	

}
