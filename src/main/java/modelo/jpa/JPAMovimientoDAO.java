package modelo.jpa;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import modelo.dao.MovimientoDAO;
import modelo.entidades.Cuenta;
import modelo.entidades.Movimiento;
import modelo.entidades.Usuario;

public class JPAMovimientoDAO extends JPAGenericDAO<Movimiento, Integer> implements MovimientoDAO {

	public JPAMovimientoDAO() {
		super(Movimiento.class);
		
	}
	
	
	@Override
	public List<Movimiento> getMovimientosByUsuario(Usuario usuario) {
	    try {
	        String jpql = "SELECT m FROM Movimiento m " +
	                      "WHERE m.cuentaOrigen.propietario = :propietario OR m.cuentaDestino.propietario = :propietario";
	        TypedQuery<Movimiento> query = em.createQuery(jpql, Movimiento.class);
	        query.setParameter("propietario", usuario);
	        return query.getResultList();
	    } catch (Exception e) {
	    
	        return new ArrayList<>(); 
	    }
	}
	
	
	public List<Movimiento> getMovimientosByUsuarioAndMonth(Usuario usuario, int mesSeleccionado) {
        try {
            String jpql = "SELECT m FROM Movimiento m WHERE " +
                          "(m.cuentaOrigen.propietario = :propietario OR m.cuentaDestino.propietario = :propietario) " +
                          "AND FUNCTION('MONTH', m.fecha) = :mes";
            TypedQuery<Movimiento> query = em.createQuery(jpql, Movimiento.class);
            query.setParameter("propietario", usuario);
            query.setParameter("mes", mesSeleccionado);
            return query.getResultList();
        } catch (Exception e) {
           
            return new ArrayList<>(); 
        }
    }
	
	public List<Movimiento> getMovimientosByCuenta(Cuenta cuenta) {
        try {
            String jpql = "SELECT m FROM Movimiento m WHERE m.cuentaOrigen = :cuenta OR m.cuentaDestino = :cuenta";
            TypedQuery<Movimiento> query = em.createQuery(jpql, Movimiento.class);
            query.setParameter("cuenta", cuenta);
            return query.getResultList();
        } catch (Exception e) {
           
            return new ArrayList<>();
        }
    }
	
	public List<Movimiento> getMovimientosByCuentaAndMonth(Cuenta cuenta, int mesSeleccionado) {
	    try {
	        String jpql = "SELECT m FROM Movimiento m WHERE " +
	                      "(m.cuentaOrigen = :cuenta OR m.cuentaDestino = :cuenta) " +
	                      "AND FUNCTION('MONTH', m.fecha) = :mes";
	        TypedQuery<Movimiento> query = em.createQuery(jpql, Movimiento.class);
	        query.setParameter("cuenta", cuenta);
	        query.setParameter("mes", mesSeleccionado);
	        return query.getResultList();
	    } catch (Exception e) {
	        
	        return new ArrayList<>(); 
	    }
	}


}
