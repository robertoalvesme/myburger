package br.com.rhfactor.myburger.service;

import java.util.List;

import br.com.rhfactor.myburger.model.Menu;

public interface IMenuService {

	public Menu get(Integer id);

	public abstract List<Menu> listAll();

	public abstract void save(Menu menu);

	public void delete(Menu menu);

}
