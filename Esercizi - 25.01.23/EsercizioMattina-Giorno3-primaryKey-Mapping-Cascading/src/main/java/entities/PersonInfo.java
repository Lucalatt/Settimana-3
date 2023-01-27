package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class PersonInfo {

	private double height;
	private double weight;
	@Column(unique = true)
	private String cf;
	
	
}
