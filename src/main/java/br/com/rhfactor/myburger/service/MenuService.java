package br.com.rhfactor.myburger.service;

import java.util.List;

import javax.inject.Inject;

import br.com.rhfactor.myburger.dao.IMenuDao;
import br.com.rhfactor.myburger.model.Menu;

public class MenuService implements IMenuService {

	@Deprecated
	public MenuService() {
		this(null);
	}

	@Inject
	public MenuService(IMenuDao menuDao) {
		super();
		this.dao = menuDao;
	}

	private final IMenuDao dao;

	@Override
	public Menu get(Integer id) {
		return this.dao.get(id);
	}

	@Override
	public List<Menu> listAll() {
		return this.dao.listByName();
	}

	@Override
	public void save(Menu menu) {
		if (menu.getId() == null) {
			this.dao.insert(menu);
		} else {
			this.dao.update(menu);
		}
	}

	@Override
	public void delete(Menu menu) {
		this.dao.delete(menu);
	}

}
