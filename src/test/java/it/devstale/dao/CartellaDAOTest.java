package it.devstale.dao;

import java.util.Date;
import java.util.List;

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
import it.devstale.resoconto.spese.model.Cartella;
import it.devstale.resoconto.spese.model.Utente;
import it.devstale.resoconto.spese.repository.CartellaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DataConfiguration.class})
@WebAppConfiguration
@Transactional
public class CartellaDAOTest {
	
	@Autowired
	CartellaRepository dao;

	@Test
	@Rollback(false)
	public void crea(){

		try{
			
			for(int i=0; i<42; i++){
				
				Cartella cartella = new Cartella();
				cartella.setNome("Cartella " + i);
				cartella.setColore("blue-grey");
				cartella.setDescrizione("Descrizione " + i);
				cartella.setIcona("fa-shopping-cart");
				Utente utente = new Utente();
				utente.setUsername("devstale");			
				cartella.setUtente(utente);
				cartella.setDataCreazione(new Date());

				cartella = dao.save(cartella);

				Assert.assertNotNull(cartella.getId());

				System.out.println("ID: " + cartella.getId());
			}

		}catch(Exception e){
			
			Assert.assertTrue(false);
			e.printStackTrace();
			
		}

	}

	
	@Test
	@Rollback(false)
	public void cancella(){

		try{
			
			Long id = 1L;
			if(dao.existsById(id));
				dao.deleteById(id);

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
			
			List<Cartella> cartelle = dao.findByUtenteOrderByDataCreazioneDesc(utente);
			
			Assert.assertNotNull(cartelle);
			Assert.assertTrue(cartelle.size() > 0);
			
			for (Cartella cartella : cartelle) {
				System.out.println(cartella.getNome());
			}
			
			Sort sort = Sort.by(Order.asc("id"));
			Pageable pageable = PageRequest.of(0, 5, sort);
			cartelle = dao.findByUtente(utente, pageable).getContent();
			for (Cartella cartella : cartelle) {
				System.out.println(cartella.getNome());
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}

	}
	

}
