package modelo.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import modelo.dao.CuentaDAO;
import modelo.entidades.Cuenta;
import modelo.entidades.Movimiento;
import modelo.entidades.TipoCuenta;
import modelo.entidades.Usuario;
import modelo.dao.IngresoDAO;
import modelo.dao.EgresoDAO;
import modelo.dao.MovimientoDAO;


public class JPACuentaDAO extends JPAGenericDAO<Cuenta, Integer> implements CuentaDAO {

	public JPACuentaDAO() {
		super(Cuenta.class);
	}
	
	
	public List<Cuenta> getCuentasByPropietario(Usuario propietario) {
        try {
            String jpql = "SELECT c FROM Cuenta c WHERE c.propietario = :propietario";
            TypedQuery<Cuenta> query = em.createQuery(jpql, Cuenta.class);
            query.setParameter("propietario", propietario);
            return query.getResultList();
        } catch (Exception e) {
            // Manejar la excepción apropiadamente (lanzarla, registrarla, etc.)
            return new ArrayList<>(); // O una respuesta más significativa en caso de error
        }
    }
	
	public void calcularYActualizarMontoMovido(Cuenta cuenta) {
		JPAMovimientoDAO movimientoDAO = new JPAMovimientoDAO();
	    List<Movimiento> movimientos = movimientoDAO.getMovimientosByCuenta(cuenta);

	    float montoMovidoIngreso = 0;
	    float montoMovidoGasto = 0;
	    
	    for (Movimiento movimiento : movimientos) {
	        if (movimiento.getCuentaOrigen().getTipoCuenta() == TipoCuenta.SOLO_INGRESO) {
	            montoMovidoIngreso += movimiento.getMonto();
	        } else if (movimiento.getCuentaDestino().getTipoCuenta() == TipoCuenta.SOLO_GASTO) {
	            montoMovidoGasto += movimiento.getMonto();
	        }
	    }

	    cuenta.setMontoMovidoIngreso(montoMovidoIngreso);
	    cuenta.setMontoMovidoGasto(montoMovidoGasto);

	    em.getTransaction().begin();
	    try {
	        em.merge(cuenta);
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        // Manejar la excepción apropiadamente
	    }
	}
	
	
	
	public void ajustarSaldo(Cuenta cuenta, float nuevoSaldo, Date fechaAjuste) {
		
		 float saldoAnterior = cuenta.getTotal();
		    float diferencia = nuevoSaldo - saldoAnterior;

		    if (diferencia != 0) {
		        if (diferencia > 0) {
		            // Registrar ingreso con la diferencia
		            IngresoDAO ingresoDAO = new JPAIngresoDAO();
		            String descripcion = "Ajuste de saldo: ingreso de " + diferencia;
		            ingresoDAO.ingresar(fechaAjuste, cuenta, diferencia, descripcion);
		        } else {
		            // Registrar egreso con la diferencia positiva
		            EgresoDAO egresoDAO = new JPAEgresoDAO();
		            String descripcion = "Ajuste de saldo: egreso de " + (-diferencia);
		            egresoDAO.egresar(fechaAjuste, cuenta, -diferencia, descripcion);
		        }
		        
		        cuenta.setTotal(nuevoSaldo);
		        em.getTransaction().begin();
		        try {
		            em.merge(cuenta);
		            em.getTransaction().commit();
		        } catch (Exception e) {
		            if (em.getTransaction().isActive()) {
		                em.getTransaction().rollback();
		            }
		            // Manejar la excepción apropiadamente
		        }
		    }

	}
}
