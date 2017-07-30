package br.com.rhfactor.myburger.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;

public class CustomMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 674093560418543637L;

	private HashMap<Ingredient, Integer> ingredients = new HashMap<Ingredient, Integer>();

	private BigDecimal total = new BigDecimal("0");
	private BigDecimal subTotal = new BigDecimal("0");
	private BigDecimal discounts = new BigDecimal("0");

	private Integer cheeses = 0;
	private Integer meats = 0;
	private boolean specialItens = false;
	private boolean saladItens = false;
	private boolean otherDiscounts = false;

	// Specific Functions

	public void calculate() {
		Iterator<Ingredient> keySetIterator = ingredients.keySet().iterator();
		while (keySetIterator.hasNext()) {
			Ingredient key = keySetIterator.next();
			Integer quantity = ingredients.get(key);
			this.subTotal = this.getSubTotal().add( key.getValue().multiply( new BigDecimal( quantity ) ) );
			if( key.isSpecial() ) {
				this.specialItens = true;
			}
			if( key.isSalad() ) {
				this.saladItens = true;
			}
			if( key.hasDiscount() && quantity % 3 == 0 ) {
				BigDecimal discount = calculateTripeDiscount( key , quantity );
				this.discounts = this.getDiscounts().add(discount);
			}
		}
		
		// Aplicar disconto de salada sem bacon quando não tiver disconto de carnes
		if( ( this.saladItens && !this.specialItens ) && !this.otherDiscounts ) {
			this.discounts = this.getDiscounts().add( this.getSubTotal().multiply(new BigDecimal( "0.10" )) );
		}
		
		this.setTotal(  this.getSubTotal().subtract( this.getDiscounts() ) );
	}
	
	/**
	 * Deve retornar a quantidade de desconto sob este produto 
	 * 
	 * @param ingredient
	 * @param integer
	 * @return discount
	 */
	BigDecimal calculateTripeDiscount(Ingredient ingredient, Integer integer) {
		Integer t = ((Double) Math.ceil( integer * 0.3333)).intValue();
		return ingredient.getValue().multiply( new BigDecimal(t) );
	}
	
	// Getters and Setters

	public HashMap<Ingredient, Integer> getIngredients() {
		return ingredients;
	}

	public void setIngredients(HashMap<Ingredient, Integer> ingredients) {
		this.ingredients = ingredients;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getDiscounts() {
		return discounts;
	}

	public void setDiscounts(BigDecimal discounts) {
		this.discounts = discounts;
	}

	public Integer getCheeses() {
		return cheeses;
	}

	public void setCheeses(Integer cheeses) {
		this.cheeses = cheeses;
	}

	public Integer getMeats() {
		return meats;
	}

	public void setMeats(Integer meats) {
		this.meats = meats;
	}

	public boolean isSpecialItens() {
		return specialItens;
	}

	public void setSpecialItens(boolean specialItens) {
		this.specialItens = specialItens;
	}

	public boolean isSaladItens() {
		return saladItens;
	}

	public void setSaladItens(boolean saladItens) {
		this.saladItens = saladItens;
	}

	public boolean isOtherDiscounts() {
		return otherDiscounts;
	}

	public void setOtherDiscounts(boolean otherDiscounts) {
		this.otherDiscounts = otherDiscounts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

}
