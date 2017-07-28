package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

public class Ingredient implements IIngredient {

	public Ingredient() {
		super();
	}

	public Ingredient(String name) {
		super();
		this.name = name;
	}

	public Ingredient(String name, BigDecimal value) {
		super();
		this.name = name;
		this.value = value;
	}

	protected Integer id;

	protected String name;

	protected BigDecimal value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
