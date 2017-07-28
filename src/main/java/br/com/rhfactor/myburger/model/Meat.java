package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MEA")
public class Meat extends Ingredient {

	public Meat() {
		super();
	}

	public Meat(String name) {
		super();
		this.name = name;
	}

	public Meat(String name, BigDecimal value) {
		super();
		this.name = name;
		this.value = value;
	}
}
