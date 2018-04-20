package it.devstale.resoconto.spese.service.dto;

import java.io.Serializable;

public class Errore implements Serializable{
	
	private static final long serialVersionUID = -479468641038933245L;
	
	private int codice;
	private String messaggio;
	
	public Errore() { }
	
	public Errore(int codice, String messaggio){
		this.codice = codice;
		this.messaggio = messaggio;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

}