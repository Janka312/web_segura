package modelo.jpa;

import java.util.Date;

import modelo.dao.EgresoDAO;
import modelo.entidades.Cuenta;
import modelo.entidades.Egreso;

public class JPAEgresoDAO extends JPAGenericDAO<Egreso, Integer> implements EgresoDAO {

	public JPAEgresoDAO() {
		super(Egreso.class);
	}
	
	
	@Override
    public Egreso egresar(Date fecha, Cuenta cuentaDestino, float monto, String descripcion) {

        Egreso egreso = new Egreso();
        egreso.setFecha(fecha);
        egreso.setCuentaDestino(cuentaDestino);
        egreso.setCuentaOrigen(cuentaDestino);
        egreso.setMonto(monto);
        egreso.setDescripcion(descripcion);

        // Restar el monto de la cuenta destino
        cuentaDestino.setTotal(cuentaDestino.getTotal() - monto);
        

        em.getTransaction().begin();
        try {
            em.merge(cuentaDestino);
            em.persist(egreso);
            em.getTransaction().commit();
            return egreso;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            // Manejar la excepci�n apropiadamente
            return null;
        }
    }
	

}
