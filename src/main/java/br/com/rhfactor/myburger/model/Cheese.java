package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHE")
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
