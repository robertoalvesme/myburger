package br.com.rhfactor.myburger.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.rhfactor.myburger.service.IIngredientService;

@Controller
@Path("json")
public class APIRest {
	
	@Inject
	private IIngredientService service;
	
	@Inject
	private Result result;
	
	@Get("ingredients")
	public void listIngredients() {
		this.result.use(Results.json())
			.withoutRoot()
			.from(this.service.listAll())
			.exclude("value","type")
			.serialize();
	}

}
