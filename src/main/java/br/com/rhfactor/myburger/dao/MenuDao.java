package br.com.rhfactor.myburger.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.com.rhfactor.myburger.model.Menu;

public class MenuDao implements IMenuDao {

	@PersistenceContext
	private final EntityManager em;

	@Inject
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

	@Override
	public List<Menu> listByName() {
		return this.em.createQuery("SELECT m FROM Menu m ORDER BY m.name",Menu.class)
				.getResultList();
	}

}
