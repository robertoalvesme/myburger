package br.com.rhfactor.myburger.dao;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.rhfactor.myburger.model.Ingredient;
import br.com.rhfactor.myburger.model.IngredientTest;
import br.com.rhfactor.myburger.model.Menu;
import br.com.rhfactor.myburger.model.MenuTest;

public class MenuDaoTest extends DaoTest {

	private IIngrentDao ingredientDao = new IngredientDao(this.getEntityManager());
	private IMenuDao menuDao = new MenuDao(this.getEntityManager());

	@Test
	public void testInsert() {

		// Criando item
		Ingredient egg = new IngredientTest.Builder().name("Ovo").value("1").build();
		Ingredient chickenMeat = new IngredientTest.Builder().name("Hamburger de Frango").value("2").build();
		Ingredient biffMeat = new IngredientTest.Builder().name("Hamburger de Carne").value("3").build();

		this.ingredientDao.insert(egg);
		this.ingredientDao.insert(chickenMeat);
		this.ingredientDao.insert(biffMeat);

		this.flush();
		
		Menu xBacon = new MenuTest.Builder().name("X-Bacon")
				.addItem(egg).addItem(chickenMeat).addItem(biffMeat)
				.build();

		assertThat(xBacon.getIngredients(), hasSize(3));
		this.menuDao.insert(xBacon);
		this.flush();
	}

}
