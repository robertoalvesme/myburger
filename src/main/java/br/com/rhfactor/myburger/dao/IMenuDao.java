package br.com.rhfactor.myburger.dao;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import br.com.rhfactor.myburger.model.Menu;

public interface IMenuDao {

	public abstract Menu get(Integer id) throws NoResultException;

	public abstract void delete(Menu menu) throws PersistenceException;

	public abstract void update(Menu menu) throws PersistenceException;

	public abstract void insert(Menu menu) throws PersistenceException;

}
