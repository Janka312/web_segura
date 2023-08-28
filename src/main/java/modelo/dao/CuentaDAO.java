package modelo.dao;

import java.util.Date;
import java.util.List;

import modelo.entidades.Cuenta;
import modelo.entidades.Usuario;

public interface CuentaDAO extends GenericDAO<Cuenta, Integer> {
	
	public List<Cuenta> getCuentasByPropietario(Usuario propietario);
	
	public void ajustarSaldo(Cuenta cuenta, float nuevoSaldo, Date fechaAjuste);
	
	public void calcularYActualizarMontoMovido(Cuenta cuenta);

}
