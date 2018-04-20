package it.devstale.resoconto.spese.service.dto;

import java.io.Serializable;

//@JsonInclude(Include.NON_EMPTY)
public class EtichettaDTO implements Serializable{

	private static final long serialVersionUID = 5276256219456204138L;
	
	private Long id;
	private String nome;
	
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

}
