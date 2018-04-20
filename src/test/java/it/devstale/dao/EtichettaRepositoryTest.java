package it.devstale.dao;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import configuration.DataConfiguration;
import it.devstale.resoconto.spese.model.Etichetta;
import it.devstale.resoconto.spese.model.Utente;
import it.devstale.resoconto.spese.repository.EtichettaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DataConfiguration.class})
@WebAppConfiguration
@Transactional
public class EtichettaRepositoryTest {

	@Autowired
	EtichettaRepository repository;

	@Test
	@Rollback(false)
	public void crea(){

		try{

			for(int i=100; i<120; i++){
				
				Etichetta etichetta = new Etichetta();
				etichetta.setNome("Etichetta " + i);
				Utente utente = new Utente();
				utente.setUsername("devstale");
				etichetta.setUtente(utente);
				etichetta = repository.save(etichetta);

				Assert.assertNotNull(etichetta.getId());

				System.out.println("ID: " + etichetta.getId());
			}

		}catch(Exception e){

			Assert.assertTrue(false);
			e.printStackTrace();

		}

	}

	@Test
	@Rollback(false)
	public void aggiorna(){

		try{

			Optional<Etichetta> optional = repository.findById(1L);
			if(optional.isPresent()){
				Etichetta etichetta = optional.get();
				etichetta.setNome(etichetta.getNome()+"-aggiornato");
				repository.save(etichetta);
			}
			
		}catch(Exception e){

			e.printStackTrace();

		}

	}


	@Test
	@Rollback(false)
	public void cancella(){

		try{

			if(repository.existsById(1L))
				repository.deleteById(1L);

		}catch(Exception e){

			e.printStackTrace();

		}

	}


	@Test
	@Rollback(false)
	public void findAllByUtente(){

		try{
			
			Utente utente = new Utente();
			utente.setUsername("devstale");
			List<Etichetta> etichette = repository.findByUtenteOrderByNomeAsc(utente);

			Assert.assertNotNull(etichette);
			Assert.assertTrue(etichette.size() > 0);

			for (Etichetta etichetta : etichette) {
				System.out.println(etichetta.getId());
			}
			
			Sort sort = Sort.by(Order.asc("id"));
			Pageable pageable = PageRequest.of(0, 5, sort);
			etichette = repository.findByUtente(utente, pageable).getContent();
			
			for (Etichetta etichetta : etichette) {
				System.out.println(etichetta.getId());
			}
			
			pageable = PageRequest.of(1, 5, sort);
			etichette = repository.findByUtente(utente, pageable).getContent();
			
			for (Etichetta etichetta : etichette) {
				System.out.println(etichetta.getId());
			}
			
			pageable = PageRequest.of(2, 5, sort);
			etichette = repository.findByUtente(utente, pageable).getContent();
			
			for (Etichetta etichetta : etichette) {
				System.out.println(etichetta.getId());
			}
			
			pageable = PageRequest.of(3, 5, sort);
			etichette = repository.findByUtente(utente, pageable).getContent();
			
			for (Etichetta etichetta : etichette) {
				System.out.println(etichetta.getId());
			}

		}catch(Exception e){

			e.printStackTrace();

		}

	}


}
