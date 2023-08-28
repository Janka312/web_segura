package modelo.entidades;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EGRESO")
public class Egreso extends Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Egreso() {
		
	}

}
