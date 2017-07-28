package br.com.rhfactor.myburger.service;

import java.util.List;

import javax.inject.Inject;

import br.com.rhfactor.myburger.dao.IIngrentDao;
import br.com.rhfactor.myburger.model.Ingredient;

public class IngredientService extends GenericService<Ingredient, Integer> implements IIngredientService {

	@Inject
	public IngredientService(IIngrentDao dao) {
		super(dao);
	}

	public List<Ingredient> listAll() {
		return ((IIngrentDao) this.dao).listByName();
	}

	public void save(Ingredient ingredient) {
		if (ingredient.getId() > 0) {
			this.dao.insert(ingredient);
		} else {
			this.dao.update(ingredient);
		}
	}

}
