package modelo.dao;

import java.util.Date;

import modelo.entidades.Cuenta;
import modelo.entidades.Ingreso;


public interface IngresoDAO extends GenericDAO<Ingreso, Integer>{

	public Ingreso ingresar(Date fecha, Cuenta cuentaDestino, float monto, String descripcion);

}
