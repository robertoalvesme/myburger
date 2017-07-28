package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

public class Cheese extends Ingredient {

	public Cheese() {
		super();
	}

	public Cheese(String name) {
		super();
		this.name = name;
	}

	public Cheese(String name, BigDecimal value) {
		super();
		this.name = name;
		this.value = value;
	}

}
