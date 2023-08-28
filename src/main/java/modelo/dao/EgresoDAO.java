package modelo.dao;

import java.util.Date;

import modelo.entidades.Cuenta;
import modelo.entidades.Egreso;

public interface EgresoDAO extends GenericDAO<Egreso, Integer> {

	public Egreso egresar(Date fecha, Cuenta cuentaDestino, float monto, String descripcion);

}
