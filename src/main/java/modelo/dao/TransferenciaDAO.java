package modelo.dao;

import java.util.Date;

import modelo.entidades.Cuenta;
import modelo.entidades.Transferencia;

public interface TransferenciaDAO extends GenericDAO<Transferencia, Integer> {
	public Transferencia transferir(Date fecha, Cuenta cuentaOrigen, Cuenta cuentaDestino, float monto, String descripcion);
}
