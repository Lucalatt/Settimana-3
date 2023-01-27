package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "box")
@Getter
@Setter
@ToString
public class BoxSequence {

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "box_seq" )
	@SequenceGenerator( name = "box_seq", sequenceName = "box_sequence" )
	private Long id;
	
	private int width;
	private int height;
	
	public int getArea() {
		return this.width * this.height;
	}
	
}