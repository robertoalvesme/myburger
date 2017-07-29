package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

public class IngredientTest {

	public static class Builder {

		private Ingredient ingredient = new Ingredient();

		public Ingredient build() {
			return this.ingredient;
		}

		public Builder name(String name) {
			this.ingredient.setName(name);
			return this;
		}

		public Builder value(String value) {
			this.ingredient.setValue(new BigDecimal(value));
			return this;
		}

	}

}
