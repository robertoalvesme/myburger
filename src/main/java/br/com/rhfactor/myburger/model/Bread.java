package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

public class Bread extends Ingredient {
	
	public Bread() {
		super();
	}

	public Bread(String name) {
		super();
		this.name = name;
	}

	public Bread(String name, BigDecimal value) {
		super();
		this.name = name;
		this.value = value;
	}

}
