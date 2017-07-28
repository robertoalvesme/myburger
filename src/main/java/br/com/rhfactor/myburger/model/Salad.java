package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SAL")
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
