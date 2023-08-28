package modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.DiscriminatorType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "movimiento")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipomovimiento", discriminatorType = DiscriminatorType.STRING)
public abstract class Movimiento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fecha")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "idcuentaorigen")
	private Cuenta cuentaOrigen;
	
	@ManyToOne
	@JoinColumn(name = "idcuentadestino")
	private Cuenta cuentaDestino;
	
	@Column(name = "monto")
	private float monto;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	public Movimiento() {
		
	}



	public Movimiento(int id, Date fecha, Cuenta cuentaOrigen, Cuenta cuentaDestino, float monto, String descripcion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cuentaOrigen = cuentaOrigen;
		this.cuentaDestino = cuentaDestino;
		this.monto = monto;
		this.descripcion = descripcion;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Cuenta getCuentaOrigen() {
		return cuentaOrigen;
	}



	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}



	public Cuenta getCuentaDestino() {
		return cuentaDestino;
	}



	public void setCuentaDestino(Cuenta cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	
	
	

}
