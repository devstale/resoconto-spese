package it.devstale.resoconto.spese.controller.rest;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import it.devstale.resoconto.spese.service.dto.Errore;

/**
 * Classe che intercetta le eccezioni lanciate durante l'esecuzione dei rest controller e gestisce 
 * la costruzione della response. In questo modo i metodi dei controller rest si dovranno preoccupare esclusivamente
 * del flusso normale di esecuzione.
 */
@ControllerAdvice
public class ExceptionsHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionsHandler.class.getName());
	
	@ExceptionHandler(HibernateException.class)
	public ResponseEntity<Errore> hibernateException(HibernateException e){
		
		logger.debug("Intercettata una HibernateException dall'handler.");
		Errore errore = new Errore(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getLocalizedMessage());
		return new ResponseEntity<Errore>(errore, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
