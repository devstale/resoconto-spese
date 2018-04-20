package it.devstale.resoconto.spese.service.impl;

import configuration.security.util.SecurityUtils;
import it.devstale.resoconto.spese.model.Utente;

public abstract class AbstractServiceImpl {
	
	protected Utente getUtente(){
		return new Utente(SecurityUtils.getCurrentUsername());
	}

}
