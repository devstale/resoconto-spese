package it.devstale.resoconto.spese.service.converter;

import org.springframework.stereotype.Component;

import it.devstale.resoconto.spese.exception.ConverterException;
import it.devstale.resoconto.spese.model.Spesa;
import it.devstale.resoconto.spese.service.dto.SpesaDTO;

@Component
public class SpesaConverter extends AbstractConverter<Spesa, SpesaDTO>{

	@Override
	public Spesa toModel(SpesaDTO dto) throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpesaDTO toDTO(Spesa model) throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

}
