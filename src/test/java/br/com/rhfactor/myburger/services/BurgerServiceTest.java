package br.com.rhfactor.myburger.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class BurgerServiceTest {

	/**
	 * Regra: Se o lanche tem alfase e não tem Bacon ganha 10% de desconto
	 */
	public void testHasBacon() {

	}

	/**
	 * Regra: Se tem n hamburgueres paga x - sendo n inteiro impar > 2 multiplo de 3
	 * O número n deve ser a quantidade do desconto  
	 */
	@Test
	public void hasMeatPromotion() {
		
		/*
		n = 3 => 2
		n = 6 => 4
		n = 9 => 6
		n = 12 => 8
		*/

		Integer n = 9;
		if( n % 3 != 0 ) {
			throw new RuntimeException("Não divisivel por 3");
		}
		// Qual é a razão do desconto? Razão é 33% da quantidade.
		Integer t = ((Double) Math.ceil( n * 0.3333)).intValue();
		assertTrue( n-t == 6);
	}

	public void hasCheesePromotion() {

	}

}
