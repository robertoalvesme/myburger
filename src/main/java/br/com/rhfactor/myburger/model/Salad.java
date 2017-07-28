package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

public class Salad extends Ingredient {

	public Salad() {
		super();
	}

	public Salad(String name) {
		super();
		this.name = name;
	}

	public Salad(String name, BigDecimal value) {
		super();
		this.name = name;
		this.value = value;
	}
}
