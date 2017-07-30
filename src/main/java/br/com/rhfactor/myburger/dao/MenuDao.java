package br.com.rhfactor.myburger.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.rhfactor.myburger.model.Menu;

public class MenuDao extends GenericDao<Menu, Integer> implements IMenuDao {

	@Inject
	public MenuDao(EntityManager em) {
		super(em);
	}

	@Override
	public List<Menu> listByName() {
		return this.em.createQuery("SELECT m FROM Menu m ORDER BY m.name",Menu.class)
				.getResultList();
	}

}
