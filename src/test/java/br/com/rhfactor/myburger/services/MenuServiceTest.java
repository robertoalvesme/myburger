package br.com.rhfactor.myburger.services;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.rhfactor.myburger.model.Ingredient;
import br.com.rhfactor.myburger.model.IngredientTypes;
import br.com.rhfactor.myburger.model.Menu;
import br.com.rhfactor.myburger.model.MenuTest;

public class MenuServiceTest {

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
