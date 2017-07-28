package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SAU")
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
