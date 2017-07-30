package br.com.rhfactor.myburger.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.rhfactor.myburger.model.MenuIngredient;

public class MenuIngredientDao implements IMenuIngredientDao {

	private final EntityManager em;

	@Deprecated
	public MenuIngredientDao() {
		this(null);
	}

	@Inject
	public MenuIngredientDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public MenuIngredient get(Integer menuId, Integer ingredientId) {
		return (MenuIngredient) this.em.createNativeQuery("SELECT mi.* FROM menu_ingredients mi WHERE mi.menu_id = :menuId and mi.ingredient_id = :ingredientId",MenuIngredient.class)
			.setParameter("menuId", menuId)
			.setParameter("ingredientId", ingredientId)
			.getSingleResult();
	}

	@Override
	public void update( Integer menuId, Integer ingredientId , Integer quantity ) {
		this.em.createNativeQuery("UPDATE menu_ingredients mi SET quantity = :quantity WHERE mi.menu_id = :menuId and mi.ingredient_id = :ingredientId")
			.setParameter("menuId", menuId)
			.setParameter("ingredientId", ingredientId)
			.setParameter("quantity", quantity)
			.executeUpdate();
	}

	@Override
	public void delete(Integer menuId, Integer ingredientId) {
		this.em.remove( this.get(menuId, ingredientId) );
	}
	
}
