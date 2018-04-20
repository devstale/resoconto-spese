package it.devstale.resoconto.spese.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "spese")
public class Spesa {
	
	@Id 
	@SequenceGenerator(name="spese_id_seq", sequenceName="spese_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="spese_id_seq")
	@Column(name = "id", unique = true, nullable = false, updatable=false)
	private Long id;
	
	@Column(name = "nome", nullable = false, length=50)
	private String nome;
	
	@Column(name = "descrizione", length=200)
	private String descrizione;
	
	@Column(name = "data", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date data;
	
	@Column(name="totale", nullable=false)
	private Double totale;
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch=FetchType.LAZY)
    @JoinTable(
        name = "spese_etichette", 
        joinColumns = { @JoinColumn(name = "spesa_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "etichetta_id") }
    )
	private List<Etichetta> etichette;
	
	@Column(name = "colore", length=50)
	private String colore;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cartella_id", nullable=false)
	private Cartella cartella;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="username", nullable=false)
	private Utente utente;

	public Spesa() { }
	
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getTotale() {
		return totale;
	}

	public void setTotale(Double totale) {
		this.totale = totale;
	}

	public List<Etichetta> getEtichette() {
		return etichette;
	}

	public void setEtichette(List<Etichetta> etichette) {
		this.etichette = etichette;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public Cartella getCartella() {
		return cartella;
	}

	public void setCartella(Cartella cartella) {
		this.cartella = cartella;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}
