package br.com.rhfactor.myburger.dao;

import javax.inject.Inject;

import br.com.rhfactor.myburger.model.MenuIngredient;
import br.com.rhfactor.myburger.service.IMenuIngredientService;

public class MenuIngredientService implements IMenuIngredientService {

	@Inject
	private IMenuIngredientDao menuIngredientDao;

	@Override
	public void update(Integer menuId, Integer ingredientId, Integer quantity) {
		this.menuIngredientDao.update(menuId, ingredientId, quantity);
	}

	@Override
	public void delete(Integer menuId, Integer ingredientId) {
		this.menuIngredientDao.delete(menuId, ingredientId);
	}

	@Override
	public MenuIngredient get(Integer menuId, Integer ingredientId) {
		return this.menuIngredientDao.get(menuId, ingredientId);
	}

}
