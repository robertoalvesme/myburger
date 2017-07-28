package br.com.rhfactor.myburger.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.rhfactor.myburger.model.Ingredient;

public class IngredientDao extends GenericDao<Ingredient, Integer> implements IIngrentDao {
	
	@Inject
	public IngredientDao(EntityManager em) {
		super(em);
	}

	public List<Ingredient> listByName() {
		return this.em.createQuery("SELECT i FROM Ingredient i ORDER BY i.name",Ingredient.class)
				.getResultList();
	}

}
