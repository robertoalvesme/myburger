package br.com.rhfactor.myburger.dao;

import java.util.List;

import br.com.rhfactor.myburger.model.Ingredient;

public interface IIngrentDao extends IGenericDao<Ingredient, Integer> {

	public abstract List<Ingredient> listByName();

	public abstract List<Ingredient> listNotIn(Integer id);

}
