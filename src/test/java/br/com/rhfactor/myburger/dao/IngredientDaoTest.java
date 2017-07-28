package br.com.rhfactor.myburger.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IngredientDaoTest extends DaoTest {

	@Test
	public void testConnection() {
		assertTrue(this.getEntityManager().isOpen());
	}

}
