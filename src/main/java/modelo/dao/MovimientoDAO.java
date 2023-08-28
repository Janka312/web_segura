package modelo.dao;



import java.util.List;

import modelo.entidades.Cuenta;
import modelo.entidades.Movimiento;
import modelo.entidades.Usuario;

public interface MovimientoDAO extends GenericDAO<Movimiento, Integer> {
	

	public List<Movimiento> getMovimientosByUsuario(Usuario propietario);
	public List<Movimiento> getMovimientosByUsuarioAndMonth(Usuario propietario, int mesSelecionado);
	public List<Movimiento> getMovimientosByCuenta(Cuenta cuenta);
	public List<Movimiento> getMovimientosByCuentaAndMonth(Cuenta cuenta, int mesSeleccionado);
}
