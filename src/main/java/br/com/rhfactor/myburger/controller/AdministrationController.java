package br.com.rhfactor.myburger.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
@Path("admin")
public class AdministrationController {

	private Logger logger = Logger.getLogger(AdministrationController.class);

	@Inject
	private Validator validator;
	@Inject
	private Result result;

	@Get("")
	public void dashboard() {
	}

}
