package br.com.rhfactor.myburger.service;

import java.util.List;

import br.com.rhfactor.myburger.model.Ingredient;
import br.com.rhfactor.myburger.model.Menu;

public interface IIngredientService extends IGenericService<Ingredient, Integer> {

	public abstract List<Ingredient> listAll();

	public abstract void save(Ingredient ingredient);

	public abstract List<Ingredient> listNotIn(Menu menu);


}
