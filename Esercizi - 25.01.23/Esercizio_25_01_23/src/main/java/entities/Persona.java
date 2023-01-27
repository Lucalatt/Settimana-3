package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "persona")
@Getter
@Setter
@ToString


public class Persona {
	
	@Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String cognome;
	private String email;
	private LocalDate datadinascita;
	@Enumerated(EnumType.STRING)
	private PersonaGenere personaGenere;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "partecipazione_persona",
		joinColumns = @JoinColumn( name = "persona_id" ),
		inverseJoinColumns = @JoinColumn( name = "partecipazione_id" )
	)
	private Set<Partecipazione> listapartecipazione = new HashSet<>();


}
