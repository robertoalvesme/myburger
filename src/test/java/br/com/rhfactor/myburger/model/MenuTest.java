package br.com.rhfactor.myburger.model;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class MenuTest {

	public static class Builder {

		private Menu menu = new Menu();

		public Menu build() {
			return this.menu;
		}

		public Builder name(String name) {
			this.menu.setName(name);
			return this;
		}

		public Builder addItem(Ingredient ingredient) {
			this.menu.getIngredients().add(new MenuIngredient(ingredient, this.menu));
			return this;
		}

	}
	
	@Test
	public void testBuilder() {

		Menu xBacon = new MenuTest.Builder().name("X-Bacon")
				.addItem(new Ingredient("Bacon", new BigDecimal("2.0"), IngredientTypes.SPEC))
				.addItem(new Ingredient("Hambúrger de carne", new BigDecimal("4.0"), IngredientTypes.MEAT ))
				.addItem(new Ingredient("Queijo", new BigDecimal("1.0"), IngredientTypes.CHEE)).build();
		assertThat(xBacon.getIngredients(), hasSize(3));

		Menu xBurger = new MenuTest.Builder().name("X-Burger")
				.addItem(new Ingredient("Hambúrger de carne", new BigDecimal("4.0"), IngredientTypes.MEAT ))
				.addItem(new Ingredient("Queijo", new BigDecimal("1.0"), IngredientTypes.CHEE)).build();
		assertThat(xBurger.getIngredients(), hasSize(2));

		Menu xEgg = new MenuTest.Builder().name("X-Egg")
				.addItem(new Ingredient("Hambúrger de carne", new BigDecimal("4.0"), IngredientTypes.MEAT ))
				.addItem(new Ingredient("Ovo", new BigDecimal("1.0"), IngredientTypes.COMM ))
				.addItem(new Ingredient("Queijo", new BigDecimal("1.0"), IngredientTypes.CHEE)).build();
		assertThat(xEgg.getIngredients(), hasSize(3));

		Menu xEggBacon = new MenuTest.Builder().name("X-Egg Bacon")
				.addItem(new Ingredient("Hambúrger de carne", new BigDecimal("4.0"), IngredientTypes.MEAT ))
				.addItem(new Ingredient("Ovo", new BigDecimal("1.0"), IngredientTypes.COMM ))
				.addItem(new Ingredient("Queijo", new BigDecimal("1.0"), IngredientTypes.CHEE))
				.addItem(new Ingredient("Bacon", new BigDecimal("2.0"), IngredientTypes.SPEC )).build();
		assertThat(xEggBacon.getIngredients(), hasSize(4));

	}

}
