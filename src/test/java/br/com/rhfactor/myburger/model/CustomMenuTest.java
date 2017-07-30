package br.com.rhfactor.myburger.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class CustomMenuTest {
	

	/**
	 * Regra: Se tem n hamburgueres paga x - sendo n inteiro impar > 2 multiplo de 3
	 * O número n deve ser a quantidade do desconto  
	 */
	// @Test
	public void calculateTripeDiscount() {
		CustomMenu customMenu = new CustomMenu();
		
		Ingredient ingredient = new IngredientTest.Builder()
				.type("meat")
				.value("10")
				.build();
		
		BigDecimal discount = customMenu.calculateTripeDiscount( ingredient , 3 );
		assertEquals( new BigDecimal("10") , discount );
		
		Ingredient ingredient2 = new IngredientTest.Builder()
				.type("cheese")
				.value("20")
				.build();
		
		BigDecimal discount2 = customMenu.calculateTripeDiscount( ingredient2 , 6 );
		assertEquals( new BigDecimal("40") , discount2 );
	}
	
	// @Test
	public void testarDisconto() {
		CustomMenu customMenu = new CustomMenu();
		Ingredient meat = new IngredientTest.Builder().type("meat").value("10").build();
		BigDecimal discount = customMenu.calculateTripeDiscount( meat , 3 );
		assertEquals( new BigDecimal("10") , discount );
	}
	
	@Test
	public void testCalculateMeatDiscount() {
		CustomMenu customMenu = new CustomMenu();
		
		Ingredient cheese = new IngredientTest.Builder().type("cheese").value("1").build();
		Ingredient meat = new IngredientTest.Builder().type("meat").value("10").build();
		
		customMenu.getIngredients().put(cheese, 2); // 2 - queijo
		customMenu.getIngredients().put(meat, 3); // 30 - 10 de desconto
		customMenu.calculate();
		
		assertEquals( new BigDecimal( 10 ) , customMenu.getDiscounts() );
		assertEquals( new BigDecimal(32) , customMenu.getSubTotal() );
		assertEquals( new BigDecimal( 22 ) , customMenu.getTotal() );
		
	}
	
	@Test
	public void testCalculateSaladDiscount() {
		CustomMenu customMenu = new CustomMenu();
		
		Ingredient cheese = new IngredientTest.Builder().type("cheese").value("1").build();
		Ingredient salad = new IngredientTest.Builder().type("salad").value("5").build();
		
		customMenu.getIngredients().put(cheese, 2); // 2 - queijo
		customMenu.getIngredients().put(salad, 1); // 5
		customMenu.calculate();
		
		assertEquals( new BigDecimal(7) , customMenu.getSubTotal() );
		assertEquals( new BigDecimal(0.7).doubleValue() , customMenu.getDiscounts().doubleValue() , 0.001 );
		assertEquals( new BigDecimal( 6.3 ).doubleValue() , customMenu.getTotal().doubleValue() , 0.001 );
		
	}
	
	

}
