package it.devstale.dao;

import java.util.ArrayList;
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
import configuration.security.WebSecurityConfiguration;
import it.devstale.resoconto.spese.model.Cartella;
import it.devstale.resoconto.spese.model.Etichetta;
import it.devstale.resoconto.spese.model.Spesa;
import it.devstale.resoconto.spese.model.Utente;
import it.devstale.resoconto.spese.repository.EtichettaRepository;
import it.devstale.resoconto.spese.repository.SpesaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DataConfiguration.class, WebSecurityConfiguration.class})
@WebAppConfiguration
@Transactional
public class SpesaRepositoryTest {
	
	@Autowired
	SpesaRepository repository;
	
	@Autowired
	EtichettaRepository etichettaRepository;

	@Test
	@Rollback(false)
	public void crea(){

		try{

			Utente utente = new Utente();
			utente.setUsername("devstale");
			Sort sort = Sort.by(Order.asc("id"));
			Pageable pageable = PageRequest.of(0, 5, sort);
			List<Etichetta> etichette = etichettaRepository.findByUtente(utente, pageable).getContent();
			
			for(int i=0; i<5; i++){
				
				Spesa spesa = new Spesa();
				spesa.setColore("orange");
				Cartella cartella = new Cartella();
				cartella.setId(1L);
				spesa.setCartella(cartella);
				spesa.setData(new Date());
				spesa.setDescrizione("Descrizione "+i);
				spesa.setEtichette(etichette);
				spesa.setNome("spesa"+i);
				spesa.setTotale(new Double(i));
				spesa.setUtente(utente);
				
				//associazione bidirezionale
				for (Etichetta etichetta : etichette) {
					etichetta.setSpese(new ArrayList<>());
					etichetta.getSpese().add(spesa);
				}
				
				spesa = repository.save(spesa);

				Assert.assertNotNull(spesa.getId());

				System.out.println("ID: " + spesa.getId());
				
			}

		}catch(Exception e){

			Assert.assertTrue(false);
			e.printStackTrace();

		}

	}
	
	@Test
	@Rollback(false)
	public void findByUtente(){
		
		try{
			
			Utente utente = new Utente("devstale");
			List<Spesa> spese = repository.findByUtenteOrderByDataDesc(utente);
			
			Assert.assertNotNull(spese);
			Assert.assertTrue(spese.size()>0);
			
			Pageable pageable = PageRequest.of(0, 10, Sort.by(Order.desc("data")));
			spese = repository.findByUtente(utente, pageable).getContent();

			Assert.assertNotNull(spese);
			Assert.assertTrue(spese.size()>0);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Rollback(false)
	public void findByUtenteAndEtichetta(){
		try{
			
			List<Spesa> spese = repository.findByUtenteAndEtichette_id(new Utente("devstale"), 1L);

			Assert.assertNotNull(spese);
			Assert.assertTrue(spese.size()>0);
			
			Pageable pageable = PageRequest.of(0, 5, Sort.by(Order.desc("data")));
			spese = repository.findByUtenteAndEtichette_id(new Utente("devstale"), 1L, pageable).getContent();

			Assert.assertNotNull(spese);
			Assert.assertTrue(spese.size()>0);
			
			for (Spesa spesa : spese) {
				System.out.println(spesa.getId());
				System.out.println(spesa.getEtichette().get(0).getId());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
