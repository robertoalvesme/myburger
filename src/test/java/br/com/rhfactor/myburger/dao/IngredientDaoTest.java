package br.com.rhfactor.myburger.dao;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.rhfactor.myburger.model.Ingredient;
import br.com.rhfactor.myburger.model.IngredientTest;

/**
 * Teste de integração com camada de persistência
 * 
 * @author roberto
 *
 */
public class IngredientDaoTest extends DaoTest {
	
	private IIngrentDao dao = new IngredientDao(this.getEntityManager());

	@Test
	public void testConnection() {
		assertTrue(this.getEntityManager().isOpen());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testListByName() {
		
		// Criando item
		Ingredient egg = new IngredientTest.Builder()
				.name("Ovo")
				.value("1")
				.build();
		
		Ingredient chickenMeat = new IngredientTest.Builder()
				.name("Hamburger de Frango")
				.value("2")
				.build();
		
		Ingredient biffMeat = new IngredientTest.Builder()
				.name("Hamburger de Carne")
				.value("3")
				.build();
		
		this.dao.insert(egg);
		this.dao.insert(chickenMeat);
		this.dao.insert(biffMeat);
		
		this.flush();
		
		List<Ingredient> listByName = this.dao.listByName();
		
		assertThat(listByName, hasSize(3));
		assertThat(listByName, contains( 
				hasProperty("name",is("Hamburger de Carne"))
				, hasProperty("name",is("Hamburger de Frango"))
				, hasProperty("name",is("Ovo"))
			)
		);
		
		
	}

}
