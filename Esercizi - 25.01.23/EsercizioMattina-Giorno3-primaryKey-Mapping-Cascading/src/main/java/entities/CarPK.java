package entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CarPK implements Serializable {
	protected String plate;
	protected String country;
}