package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SPE")
public class Special extends Ingredient {

	public Special() {
		super();
	}

	public Special(String name) {
		super();
		this.name = name;
	}

	public Special(String name, BigDecimal value) {
		super();
		this.name = name;
		this.value = value;
	}

}
