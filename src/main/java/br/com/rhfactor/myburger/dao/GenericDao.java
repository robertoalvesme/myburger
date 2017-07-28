package br.com.rhfactor.myburger.dao;

import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

public abstract class GenericDao<T, Serializable extends Number> implements IGenericDao<T, Serializable> {

	@PersistenceContext
	protected final EntityManager em;

	private final Class<T> clazz;

	@SuppressWarnings("unchecked")
	@Inject
	public GenericDao(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void insert(T t) throws PersistenceException {
		this.em.persist(t);
	}

	public void update(T t) throws PersistenceException {
		this.em.merge(t);
	}

	public void delete(T t) throws PersistenceException {
		this.em.remove(t);
	}

	public T get(Serializable id) throws NoResultException {
		return this.em.find(this.clazz, id);
	}

}
