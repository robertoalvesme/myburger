package br.com.rhfactor.myburger.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
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
	
	@Get("/cart")
	public void cart() {
	}

}
