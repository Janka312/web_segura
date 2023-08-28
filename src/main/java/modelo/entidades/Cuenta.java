package modelo.entidades;

import java.io.Serializable;

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

@Entity
@Table(name="Cuenta")
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombreCuenta")
	private String nombreCuenta;
	
	@ManyToOne
    @JoinColumn(name = "idpropietario")
	private Usuario propietario;
	
	@Column(name="total")
	private float total;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipocuenta")
	private TipoCuenta tipoCuenta;
	
	@Column(name = "monto_movido_ingreso")
    private float montoMovidoIngreso;

    @Column(name = "monto_movido_gasto")
    private float montoMovidoGasto;
	
	public Cuenta() {
		
	}

	public Cuenta(int id, String nombreCuenta, Usuario propietario, float total, TipoCuenta tipoCuenta,
			float montoMovidoIngreso, float montoMovidoGasto) {
		super();
		this.id = id;
		this.nombreCuenta = nombreCuenta;
		this.propietario = propietario;
		this.total = total;
		this.tipoCuenta = tipoCuenta;
		this.montoMovidoIngreso = montoMovidoIngreso;
		this.montoMovidoGasto = montoMovidoGasto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public float getMontoMovidoIngreso() {
		return montoMovidoIngreso;
	}

	public void setMontoMovidoIngreso(float montoMovidoIngreso) {
		this.montoMovidoIngreso = montoMovidoIngreso;
	}

	public float getMontoMovidoGasto() {
		return montoMovidoGasto;
	}

	public void setMontoMovidoGasto(float montoMovidoGasto) {
		this.montoMovidoGasto = montoMovidoGasto;
	}


	
	
	

}
