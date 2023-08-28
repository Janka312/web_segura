package modelo.jpa;

import java.util.Date;



import modelo.dao.TransferenciaDAO;
import modelo.entidades.Cuenta;
import modelo.entidades.Transferencia;



public class JPATransferenciaDAO extends JPAGenericDAO<Transferencia, Integer> implements TransferenciaDAO {

	public JPATransferenciaDAO() {
		super(Transferencia.class);
		
	}
	
	@Override
    public Transferencia transferir(Date fecha, Cuenta cuentaOrigen, Cuenta cuentaDestino, float monto, String descripcion) {
	
        Transferencia transferencia = new Transferencia();
        transferencia.setFecha(fecha);
        transferencia.setCuentaOrigen(cuentaOrigen);
        transferencia.setCuentaDestino(cuentaDestino);
        transferencia.setMonto(monto);
        transferencia.setDescripcion(descripcion);

        // Realizar la transferencia: deducir el monto de la cuenta origen y agregarlo a la cuenta destino
        cuentaOrigen.setTotal(cuentaOrigen.getTotal() - monto);
        cuentaDestino.setTotal(cuentaDestino.getTotal() + monto);

        em.getTransaction().begin();
        try {
            em.merge(cuentaOrigen);
            em.merge(cuentaDestino);
            em.persist(transferencia);
            em.getTransaction().commit();
            return transferencia;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }

}
