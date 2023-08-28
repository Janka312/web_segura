package modelo.jpa;

import java.util.Date;

import modelo.dao.IngresoDAO;
import modelo.entidades.Cuenta;
import modelo.entidades.Ingreso;

public class JPAIngresoDAO extends JPAGenericDAO<Ingreso, Integer> implements IngresoDAO{

	public JPAIngresoDAO() {
		super(Ingreso.class);
	}
	
	 @Override
	    public Ingreso ingresar(Date fecha, Cuenta cuentaDestino, float monto, String descripcion) {

	        Ingreso ingreso = new Ingreso();
	        ingreso.setFecha(fecha);
	        ingreso.setCuentaDestino(cuentaDestino);
	        ingreso.setCuentaOrigen(cuentaDestino);
	        ingreso.setMonto(monto);
	        ingreso.setDescripcion(descripcion);

	        // Agregar el monto a la cuenta destino
	        cuentaDestino.setTotal(cuentaDestino.getTotal() + monto);

	        em.getTransaction().begin();
	        try {
	            em.merge(cuentaDestino);
	            em.persist(ingreso);
	            em.getTransaction().commit();
	            return ingreso;
	        } catch (Exception e) {
	            if (em.getTransaction().isActive()) {
	                em.getTransaction().rollback();
	            }
	            // Manejar la excepci�n apropiadamente
	            return null;
	        }
	    }
    }


