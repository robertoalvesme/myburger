package br.com.rhfactor.myburger.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.rhfactor.myburger.service.IIngredientService;

@Controller
public class PublicController {
	
	@Inject
	private IIngredientService service;
	@Inject
	private Validator validator;
	@Inject
	private Result result;
	
	@Get("/")
	public void index() {
	}

}
