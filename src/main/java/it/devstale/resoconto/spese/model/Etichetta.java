package it.devstale.resoconto.spese.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
		name = "etichette",
		uniqueConstraints=@UniqueConstraint(
				columnNames={"nome", "username"}
				)
		)
public class Etichetta implements Serializable{
	
	private static final long serialVersionUID = 9086396040587438355L;

	@Id
	@SequenceGenerator(name="etichette_id_seq", sequenceName="etichette_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="etichette_id_seq")
	@Column(name = "id", unique = true, nullable = false, updatable=false)
	private Long id;
	
	@Column(name = "nome", nullable=false)
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="username", nullable=false, updatable=false)
	private Utente utente;
	
	@ManyToMany(mappedBy = "etichette", fetch=FetchType.LAZY)
	private List<Spesa> spese;

	public Etichetta() { super(); }
	
	public Etichetta(Long id) {
		super();
		this.id = id;
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

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Spesa> getSpese() {
		return spese;
	}

	public void setSpese(List<Spesa> spese) {
		this.spese = spese;
	}

}
