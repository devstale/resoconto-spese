package it.devstale.resoconto.spese.service.converter;

import org.springframework.stereotype.Component;

import it.devstale.resoconto.spese.exception.ConverterException;
import it.devstale.resoconto.spese.model.Cartella;
import it.devstale.resoconto.spese.service.dto.CartellaDTO;

@Component
public class CartellaConverter extends AbstractConverter<Cartella, CartellaDTO>{

	@Override
	public Cartella toModel(CartellaDTO dto) throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartellaDTO toDTO(Cartella model) throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

}
