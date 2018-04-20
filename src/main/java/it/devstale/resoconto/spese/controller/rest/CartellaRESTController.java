package it.devstale.resoconto.spese.controller.rest;

import java.net.URI;
import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import it.devstale.resoconto.spese.model.Cartella;

@RestController
@RequestMapping("/cartelle")
public class CartellaRESTController {
	
	private static final Logger logger = LoggerFactory.getLogger(CartellaRESTController.class.getName());
	

	
	@RequestMapping(
			value="/cartelle", 
			method=RequestMethod.POST)
	public ResponseEntity<Cartella> crea(
			@RequestBody Cartella cartella,
			Principal principal,
			UriComponentsBuilder ucb){
		
//		Cartella cartella = dao.create(classe);
//		
//		HttpHeaders headers = new HttpHeaders();
//		URI locationUri = 
//				ucb.path("/cartelle/")
//				.path(String.valueOf(classeCreata.getId()))
//				.build()
//				.toUri();
//		headers.setLocation(locationUri);
//		
//		return new ResponseEntity<Classe>(classeCreata, headers, HttpStatus.CREATED);
		
		return null;
		
	}

	@RequestMapping(
			value="/cartelle/{id}",
			method=RequestMethod.GET)
	public ResponseEntity<Cartella> findById(
			@PathVariable Long id,
			Principal principal,
			UriComponentsBuilder ucb){
		
		
		
		return null;
		
	}
	
	@RequestMapping(
			value="/cartelle/{id}", 
			method=RequestMethod.PUT)
	public ResponseEntity<Cartella> aggiorna(
			@RequestBody Cartella cartella,
			Principal principal,
			UriComponentsBuilder ucb){
		
		
		return null;
		
	}
	
	@RequestMapping(
			value="/cartelle/{id}", 
			method=RequestMethod.DELETE)
	public ResponseEntity<Cartella> cancella(
			@RequestBody Cartella cartella,
			Principal principal,
			UriComponentsBuilder ucb){
		
		
		return null;
		
	}
		
		

}
