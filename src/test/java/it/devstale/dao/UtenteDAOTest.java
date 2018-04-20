//package it.devstale.dao;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import configuration.DataConfiguration;
//import configuration.security.WebSecurityConfiguration;
//import it.devstale.resoconto.spese.model.Utente;
//import it.devstale.resoconto.spese.repository.UtenteRepository;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes={DataConfiguration.class, WebSecurityConfiguration.class})
//@WebAppConfiguration
//@Transactional
//public class UtenteDAOTest {
//
//	@Autowired
//	UtenteRepository dao;
//
//	@Test
//	@Rollback(false)
//	public void crea(){
//
//		try{
//			
//			Utente utente = new Utente();
//			utente.setNome("Francesco");
//			utente.setCognome("Esposito");
//			utente.setUsername("devstale");
//			utente.setEmail("devstale@alice.it");
//			dao.crea(utente);
//			
//			System.out.println(utente);
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
//	}
//
//}
