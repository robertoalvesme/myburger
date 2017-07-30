package br.com.rhfactor.myburger.dao;

import java.util.List;

import br.com.rhfactor.myburger.model.Menu;

public interface IMenuDao extends IGenericDao<Menu, Integer> {

	public abstract List<Menu> listByName();

}
