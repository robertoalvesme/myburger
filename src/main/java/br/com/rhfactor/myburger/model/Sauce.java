package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

public class Sauce extends Ingredient {
	
	public Sauce() {
		super();
	}

	public Sauce(String name) {
		super();
		this.name = name;
	}

	public Sauce(String name, BigDecimal value) {
		super();
		this.name = name;
		this.value = value;
	}
}
