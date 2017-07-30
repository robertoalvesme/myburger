package br.com.rhfactor.myburger.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.rhfactor.myburger.model.Ingredient;
import br.com.rhfactor.myburger.model.Menu;
import br.com.rhfactor.myburger.service.IIngredientService;
import br.com.rhfactor.myburger.service.IMenuIngredientService;

@Controller
@Path("json")
public class APIRest {
	
	private Logger logger = Logger.getLogger(APIRest.class);
	
	@Inject
	private IIngredientService ingredientService;
	
	@Inject
	private IMenuIngredientService menuIngredientService;
	
	@Inject
	private Result result;
	
	@Get("menu/{menu.id}/ingredients")
	public void listIngredients(Menu menu) {
		this.result.use(Results.json())
			.withoutRoot()
			.from(this.ingredientService.listNotIn(menu))
			.exclude("value","type")
			.serialize();
	}
	
	@Put("menu/{menu.id}/ingredient/{ingredient.id}/{quantity}")
	public void changeQuantity( Menu menu , Ingredient ingredient , Integer quantity ) {
		try {
			this.menuIngredientService.update(menu.getId(), ingredient.getId(), quantity);
			this.result.use(Results.json()).from(true,"status").serialize();
		} catch (Exception e) {
			logger.debug(e);
			this.result.use(Results.http()).setStatusCode(500);
		}
	}
	
	@Delete("menu/{menu.id}/ingredient/{ingredient.id}")
	public void delete( Menu menu , Ingredient ingredient ) {
		try {
			this.menuIngredientService.delete(menu.getId(), ingredient.getId());
			this.result.use(Results.json()).from(true,"status").serialize();
		} catch (Exception e) {
			logger.debug(e);
			this.result.use(Results.http()).setStatusCode(500);
		}
	}

}
