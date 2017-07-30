package br.com.rhfactor.myburger.service;

import br.com.rhfactor.myburger.model.MenuIngredient;

public interface IMenuIngredientService {

	public abstract void update(Integer menuId, Integer ingredientId, Integer quantity);

	public abstract void delete(Integer menuId, Integer ingredientId);

	public abstract MenuIngredient get(Integer menuId, Integer ingredientId);

	public abstract MenuIngredient save(Integer menuId, Integer ingredientId, Integer quantity);

}
