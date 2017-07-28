package br.com.rhfactor.myburger.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.rhfactor.myburger.model.Ingredient;
import br.com.rhfactor.myburger.service.IIngredientService;

@Controller
@Path("admin/ingredient")
public class IngredientController {

	@Inject
	private IIngredientService service;
	@Inject
	private Validator validator;
	@Inject
	private Result result;

	@Get("/")
	public List<Ingredient> list() {
		return this.service.listAll();
	}

	@Get("/add")
	public void form() {
	}

	@Get("/{ingredient.id}")
	public Ingredient form(@NotNull Ingredient ingredient) {
		return this.service.get(ingredient.getId());
	}

	@Post("/")
	public void insert(@NotNull @Valid Ingredient ingredient) {
		this.validator.onErrorRedirectTo(this).form();
		this.service.save(ingredient);
		this.result.include("success", true);
		this.result.redirectTo(this).list();
	}

	@Put("/")
	public void update(@NotNull @Valid Ingredient ingredient) {
		this.validator.onErrorRedirectTo(this).form(ingredient);
		this.service.save(ingredient);
		this.result.include("success", true);
		this.result.redirectTo(this).list();
	}

}