package br.com.rhfactor.myburger.dao;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public interface IGenericDao<T, Serializable extends Number> {

	public abstract void insert(T t) throws PersistenceException;

	public abstract void update(T t) throws javax.persistence.PersistenceException;

	public abstract void delete(T t) throws javax.persistence.PersistenceException;

	public abstract T get(Serializable id) throws NoResultException;

}
