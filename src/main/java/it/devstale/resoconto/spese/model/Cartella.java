package it.devstale.resoconto.spese.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
		name = "cartella",
		uniqueConstraints = @UniqueConstraint(
				columnNames={"nome", "username"}
				)
		)
public class Cartella implements Serializable{
	
	private static final long serialVersionUID = -4061917881854358079L;

	@Id
	@SequenceGenerator(name="cartelle_id_seq", sequenceName="cartelle_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cartelle_id_seq")
	@Column(name = "id", unique = true, nullable = false, updatable=false)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "icona", nullable = false)
	private String icona;
	
	@Column(name = "colore")
	private String colore;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="username", nullable=false, updatable=false)
	private Utente utente;
	
	@Column(name = "data_creazione", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dataCreazione;

	@Column(name = "data_ultima_modifica")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dataUltimaModifica;

	public Cartella() { super(); }
	
	public Cartella(Long id) { 
		super(); 
		this.id = id;
	}
	
	public Cartella(Long id, String nome, String descrizione, String icona, String colore, Utente utente) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.icona = icona;
		this.colore = colore;
		this.utente = utente;
	}

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

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}
	
}
