package br.com.rhfactor.myburger.dao;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.rhfactor.myburger.model.MenuIngredient;
import br.com.rhfactor.myburger.service.IMenuIngredientService;

public class MenuIngredientService implements IMenuIngredientService {
	
	private Logger logger = Logger.getLogger(MenuIngredientService.class);

	@Inject
	private IMenuIngredientDao menuIngredientDao;
	
	@Inject
	private IMenuDao menuDao;
	
	@Inject
	private IIngrentDao ingrentDao;

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

	@Override
	public MenuIngredient save(Integer menuId, Integer ingredientId, Integer quantity) {
		MenuIngredient menuIngredient = new MenuIngredient();
		menuIngredient.getId().setMenu( menuDao.get( menuId) );
		menuIngredient.getId().setIngredient( ingrentDao.get( ingredientId ) );
		menuIngredient.setQuantity(quantity);
		logger.debug(menuIngredient.toString());
		this.menuIngredientDao.insert(menuIngredient);
		return menuIngredient;
	}

}
