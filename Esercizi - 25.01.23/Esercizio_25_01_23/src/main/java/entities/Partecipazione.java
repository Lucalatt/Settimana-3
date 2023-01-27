package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "partecipazioni")
@Getter
@Setter
public class Partecipazione {
	
	@Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (
            name = "persona_id", referencedColumnName = "id"
    )
	private Persona persona;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (
            name = "evento_id", referencedColumnName = "id"
    )
	private Evento evento;
	
	private StatoPartecipazione statoPartecipazione;
}
