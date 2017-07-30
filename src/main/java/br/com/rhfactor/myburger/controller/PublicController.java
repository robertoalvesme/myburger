package br.com.rhfactor.myburger.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.rhfactor.myburger.model.CustomMenu;
import br.com.rhfactor.myburger.model.CustomMenuForm;
import br.com.rhfactor.myburger.model.Ingredient;
import br.com.rhfactor.myburger.service.IIngredientService;
import br.com.rhfactor.myburger.service.IMenuService;

@Controller
public class PublicController {
	
	@Inject
	private IMenuService menuService;
	@Inject
	private IIngredientService ingredientService;
	@Inject
	private Validator validator;
	@Inject
	private Result result;
	
	@Get("/")
	public void index() {
		this.result.include("menuList", this.menuService.listAll());
	}
	
	@Get("/you-choose")
	public void youChoose() {
		this.result.include("ingredientList", this.ingredientService.listAll());
	}
	
	@Post("/you-choose")
	public void youChoose(List<CustomMenuForm> customMenuForm) {
		HashMap<Ingredient, Integer> ingredients = new HashMap<Ingredient, Integer>();
		for( int i = 0;  i < customMenuForm.size(); i++ ) {
			if( customMenuForm.get(i).getQuantity() > 0 ) {
				ingredients.put( this.ingredientService.get(customMenuForm.get(i).getIngredient().getId() ) , customMenuForm.get(i).getQuantity() );
			}
		}
		CustomMenu customMenu = new CustomMenu();
		customMenu.setIngredients(ingredients);
		customMenu.calculate();
		this.result.include("customMenu",customMenu);
		this.result.include("ingredientList", this.ingredientService.listAll());
	}
	
	@Get("/cart")
	public void cart() {
	}

}
