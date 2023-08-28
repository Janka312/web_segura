package modelo.jpa;

import modelo.dao.CuentaDAO;
import modelo.dao.DAOFactory;
import modelo.dao.EgresoDAO;
import modelo.dao.IngresoDAO;
import modelo.dao.MovimientoDAO;
import modelo.dao.TransferenciaDAO;
import modelo.dao.UsuarioDAO;

public class JPADAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
	
		return new JPAUsuarioDAO();
	}

	@Override
	public CuentaDAO getCuentaDAO() {
		
		return new JPACuentaDAO();
	}

	@Override
	public TransferenciaDAO getTransferenciaDAO() {
		return new JPATransferenciaDAO();
	}

	@Override
	public MovimientoDAO getMovimientoDAO() {
		return new JPAMovimientoDAO();
	}

	@Override
	public IngresoDAO getIngresoDAO() {
		return new JPAIngresoDAO();
	}

	@Override
	public EgresoDAO getEgresoDAO() {
		return new JPAEgresoDAO();
	}

}
