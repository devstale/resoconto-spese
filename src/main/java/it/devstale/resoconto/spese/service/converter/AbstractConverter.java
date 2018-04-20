package it.devstale.resoconto.spese.service.converter;

import java.util.ArrayList;
import java.util.List;

import it.devstale.resoconto.spese.exception.ConverterException;

public abstract class AbstractConverter<MODEL, DTO> {
	
	public abstract MODEL toModel(DTO dto) throws ConverterException;
	
	public abstract DTO toDTO(MODEL model) throws ConverterException;
	
	public List<DTO> toDTO(List<MODEL> models) throws ConverterException {
		List<DTO> dtos = null;
		if(models != null && models.size()>0){
			dtos = new ArrayList<DTO>(models.size());
			for (MODEL model : models) {
				dtos.add( this.toDTO(model) );
			}
		}
		return dtos;
	}
	
	public List<MODEL> toModel(List<DTO> dtos) throws ConverterException{
		List<MODEL> models = null;
		if(dtos != null && dtos.size()>0){
			models = new ArrayList<MODEL>(dtos.size());
			for (DTO dto : dtos) {
				models.add( this.toModel(dto) );
			}
		}
		return models;
	}

}
