package br.com.rhfactor.myburger.service;

import java.util.List;

import javax.inject.Inject;

import br.com.rhfactor.myburger.dao.IIngrentDao;
import br.com.rhfactor.myburger.model.Ingredient;
import br.com.rhfactor.myburger.model.Menu;

public class IngredientService extends GenericService<Ingredient, Integer> implements IIngredientService {

	@Inject
	public IngredientService(IIngrentDao dao) {
		super(dao);
	}

	public List<Ingredient> listAll() {
		return ((IIngrentDao) this.dao).listByName();
	}

	public void save(Ingredient ingredient) {
		if (ingredient.getId()==null) {
			this.dao.insert(ingredient);
		} else {
			this.dao.update(ingredient);
		}
	}

	@Override
	public List<Ingredient> listNotIn(Menu menu) {
		return ((IIngrentDao) this.dao).listNotIn(menu.getId());
	}

}
