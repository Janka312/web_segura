package modelo.jpa;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.dao.GenericDAO;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;
	protected EntityManager em;

	public JPAGenericDAO(Class<T> clasePersistente) {
		this.persistentClass = clasePersistente;
		this.em = Persistence.createEntityManagerFactory("juanitojpa").createEntityManager();

	}

	@Override
	public T getById(ID id) {

		return em.find(persistentClass, id);

	}

	@Override
	public List<T> getAll() {
		
		 try {
		        String jpql = "SELECT t FROM " + persistentClass.getSimpleName() + " t";
		        TypedQuery<T> query = em.createQuery(jpql, persistentClass);
		        return query.getResultList();
		    } catch (Exception e) {
		        return new ArrayList<>(); 
		    }
	}

	@Override
	public void create(T entity) {

		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro de insercion");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}

	}

	@Override
	public void update(T entity) {

		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro de actualizacion");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}

	}

	@Override
	public void delete(T entity) {

		em.getTransaction().begin();
		try {
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro de eliminar");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}

	}

	@Override
	public void deleteById(ID id) {

		T entity = this.getById(id);
		if (entity != null) {
			this.delete(entity);
		}
	}

}
