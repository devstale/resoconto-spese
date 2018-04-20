package it.devstale.resoconto.spese.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
		name = "utenti", 
		uniqueConstraints=@UniqueConstraint(
				columnNames={"email"}
				)
		)
public class Utente implements Serializable{

	private static final long serialVersionUID = 3454418077539279544L;

	@Id
	@Column(name = "username", nullable=false, length=50)
	private String username;

	@Column(name = "password", nullable = false, length=100)
	private String password;

	@Column(name = "email", nullable = false, length=100)
	private String email;
	
	@Column(name = "nome", nullable = false, length=50)
	private String nome;
	
	@Column(name = "cognome", nullable = false, length=50)
	private String cognome;
	
	@OneToMany(
	        mappedBy = "utente", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true,
	        fetch=FetchType.LAZY
	    )
    private List<Etichetta> etichette;
	
	@OneToMany(
	        mappedBy = "utente", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true,
	        fetch=FetchType.LAZY
	    )
    private List<Cartella> cartelle;
	
	@OneToMany(
	        mappedBy = "utente", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true,
	        fetch=FetchType.LAZY
	    )
    private List<Spesa> spese;
	
	public Utente() { super(); }
	
	public Utente(String username){
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Etichetta> getEtichette() {
		return etichette;
	}

	public void setEtichette(List<Etichetta> etichette) {
		this.etichette = etichette;
	}
	
	public void aggiungiEtichetta(Etichetta etichetta) {
        etichette.add(etichetta);
        etichetta.setUtente(this);
    }
 
    public void rimuoviEtichetta(Etichetta etichetta) {
        etichette.remove(etichetta);
        etichetta.setUtente(null);
    }

	public List<Cartella> getCartelle() {
		return cartelle;
	}

	public void setCartelle(List<Cartella> cartelle) {
		this.cartelle = cartelle;
	}
	
	public void aggiungiCartella(Cartella cartella) {
        cartelle.add(cartella);
        cartella.setUtente(this);
    }
 
    public void rimuoviCartella(Cartella cartella) {
    	cartelle.remove(cartella);
    	cartella.setUtente(null);
    }

	public List<Spesa> getSpese() {
		return spese;
	}

	public void setSpese(List<Spesa> spese) {
		this.spese = spese;
	}
	
	public void aggiungiSpesa(Spesa spesa) {
        spese.add(spesa);
        spesa.setUtente(this);
    }
 
    public void rimuoviSpesa(Spesa spesa) {
    	spese.remove(spesa);
    	spesa.setUtente(null);
    }

}
