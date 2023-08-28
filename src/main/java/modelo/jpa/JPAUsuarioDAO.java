package modelo.jpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.dao.UsuarioDAO;
import modelo.entidades.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO{


	public JPAUsuarioDAO() {
		
		super(Usuario.class);
	
	}

	@Override
	public Usuario autorizar(String nombre, String password) {
		String sentenciaJPQL = "SELECT p FROM Usuario p WHERE p.nombre = :nombre AND p.password = :password ";
		Query query = em.createQuery(sentenciaJPQL);
		//Parametros
		query.setParameter("nombre", nombre);
		query.setParameter("password", password);
		
		
		try {
	        Usuario usuarioAutorizado = (Usuario) query.getSingleResult();
	        return usuarioAutorizado;
	    } catch (NoResultException e) {
	        return  null; 
	    }
	}

}
