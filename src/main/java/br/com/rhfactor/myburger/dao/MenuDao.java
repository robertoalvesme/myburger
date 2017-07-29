package br.com.rhfactor.myburger.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.com.rhfactor.myburger.model.Menu;

public class MenuDao implements IMenuDao {

	@PersistenceContext
	private final EntityManager em;

	public MenuDao(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void insert(Menu menu) throws PersistenceException {
		this.em.persist(menu);
	}

	@Override
	public void update(Menu menu) throws PersistenceException {
		this.em.merge(menu);
	}

	@Override
	public void delete(Menu menu) throws PersistenceException {
		this.em.remove(menu);
	}

	@Override
	public Menu get(Integer id) throws NoResultException {
		return this.em.find(Menu.class, id);
	}

}
