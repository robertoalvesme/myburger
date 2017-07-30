package br.com.rhfactor.myburger.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.rhfactor.myburger.controller.MenuController;
import br.com.rhfactor.myburger.dao.IMenuDao;
import br.com.rhfactor.myburger.model.Menu;
import br.com.rhfactor.myburger.model.MenuIngredient;

public class MenuService implements IMenuService {
	
	private Logger logger = Logger.getLogger(MenuService.class);

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
		
		for( MenuIngredient item : menu.getIngredients() ) {
			item.getId().setMenu(menu);
			if( item.getQuantity() <= 0 ) {
				menu.getIngredients().remove(item);
			}
		}
		
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
