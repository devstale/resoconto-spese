package it.devstale.resoconto.spese.service.converter;

import org.springframework.stereotype.Component;

import it.devstale.resoconto.spese.exception.ConverterException;
import it.devstale.resoconto.spese.model.Etichetta;
import it.devstale.resoconto.spese.service.dto.EtichettaDTO;

@Component
public class EtichettaConverter extends AbstractConverter<Etichetta, EtichettaDTO>{

	@Override
	public Etichetta toModel(EtichettaDTO dto) throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EtichettaDTO toDTO(Etichetta model) throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

}
