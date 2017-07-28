package br.com.rhfactor.myburger.services;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.rhfactor.myburger.model.Cheese;
import br.com.rhfactor.myburger.model.Common;
import br.com.rhfactor.myburger.model.Meat;
import br.com.rhfactor.myburger.model.Menu;
import br.com.rhfactor.myburger.model.MenuTest;
import br.com.rhfactor.myburger.model.Special;

public class MenuServiceTest {

	@Test
	public void testBuilder() {

		Menu xBacon = new MenuTest.Builder().name("X-Bacon").addItem(new Special("Bacon", new BigDecimal("2.0")))
				.addItem(new Meat("Hambúrger de carne", new BigDecimal("4.0")))
				.addItem(new Cheese("Queijo", new BigDecimal("1.0"))).build();
		assertThat(xBacon.getIngredients(), hasSize(3));

		Menu xBurger = new MenuTest.Builder().name("X-Burger")
				.addItem(new Meat("Hambúrger de carne", new BigDecimal("4.0")))
				.addItem(new Cheese("Queijo", new BigDecimal("1.0"))).build();
		assertThat(xBurger.getIngredients(), hasSize(2));

		Menu xEgg = new MenuTest.Builder().name("X-Egg").addItem(new Meat("Hambúrger de carne", new BigDecimal("4.0")))
				.addItem(new Common("Ovo", new BigDecimal("1.0"))).addItem(new Cheese("Queijo", new BigDecimal("1.0")))
				.build();
		assertThat(xEgg.getIngredients(), hasSize(3));

		Menu xEggBacon = new MenuTest.Builder().name("X-Egg Bacon")
				.addItem(new Meat("Hambúrger de carne", new BigDecimal("4.0")))
				.addItem(new Common("Ovo", new BigDecimal("1.0")))
				.addItem(new Cheese("Queijo", new BigDecimal("1.0")))
				.addItem(new Special("Bacon", new BigDecimal("2.0"))).build();
		assertThat(xEggBacon.getIngredients(), hasSize(4));

	}



}
