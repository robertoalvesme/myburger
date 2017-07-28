package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("COM")
public class Common extends Ingredient {
	
	public Common() {
		super();
	}

	public Common(String name) {
		super();
		this.name = name;
	}

	public Common(String name, BigDecimal value) {
		super();
		this.name = name;
		this.value = value;
	}
}
