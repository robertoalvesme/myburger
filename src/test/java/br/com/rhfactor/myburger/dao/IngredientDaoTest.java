package br.com.rhfactor.myburger.dao;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.rhfactor.myburger.model.Common;
import br.com.rhfactor.myburger.model.CommonTest;
import br.com.rhfactor.myburger.model.Ingredient;

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
	
	@Test
	public void testListByName() {
		
		// Criando item
		Common egg = new CommonTest.Builder()
				.name("Ovo")
				.value("1")
				.build();
		
		Common chickenMeat = new CommonTest.Builder()
				.name("Hamburger de Frango")
				.value("2")
				.build();
		
		Common biffMeat = new CommonTest.Builder()
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
