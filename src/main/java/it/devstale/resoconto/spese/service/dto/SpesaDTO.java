package it.devstale.resoconto.spese.service.dto;

import java.io.Serializable;
import java.util.List;


//@JsonInclude(Include.NON_EMPTY)
public class SpesaDTO implements Serializable{

	private static final long serialVersionUID = -6605577325748425257L;
	
	private Long id;
	private String nome;
	private String descrizione;
	private String data;
	private String totale;
	private List<String> etichette;
	private String colore;
	private String idCartella;

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTotale() {
		return totale;
	}

	public void setTotale(String totale) {
		this.totale = totale;
	}

	public List<String> getEtichette() {
		return etichette;
	}

	public void setEtichette(List<String> etichette) {
		this.etichette = etichette;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getIdCartella() {
		return idCartella;
	}

	public void setIdCartella(String idCartella) {
		this.idCartella = idCartella;
	}

}
