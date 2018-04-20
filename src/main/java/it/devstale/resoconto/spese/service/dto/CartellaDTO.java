package it.devstale.resoconto.spese.service.dto;

import java.io.Serializable;

//@JsonInclude(Include.NON_EMPTY)
public class CartellaDTO implements Serializable{

	private static final long serialVersionUID = 5978476770794266084L;
	
	private Long id;
	private String nome;
	private String descrizione;
	private String icona;
	private String colore;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIcona() {
		return icona;
	}

	public void setIcona(String icona) {
		this.icona = icona;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

}
