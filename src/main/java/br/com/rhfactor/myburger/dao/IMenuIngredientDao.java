package br.com.rhfactor.myburger.dao;

import br.com.rhfactor.myburger.model.MenuIngredient;

public interface IMenuIngredientDao {

	public abstract void update(Integer menuId, Integer ingredientId, Integer quantity);

	public abstract void delete(Integer menuId, Integer ingredientId);

	public abstract MenuIngredient get(Integer menuId, Integer ingredientId);

}
