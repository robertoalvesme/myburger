package br.com.rhfactor.myburger.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MenuIngredientPK implements Serializable {

	public MenuIngredientPK() {
	}

	public MenuIngredientPK(Menu menu, Ingredient ingredient) {
		this.menu = menu;
		this.ingredient = ingredient;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4566587926906091592L;

	@JoinColumn(nullable = false, name = "menu_id", updatable = false)
	@ManyToOne(optional = false)
	private Menu menu;

	@JoinColumn(nullable = false, name = "ingredient_id", updatable = false)
	@ManyToOne(optional = false)
	private Ingredient ingredient;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public String toString() {
		return "MenuIngredientId={ ingredient.id = " + this.ingredient.getId() + ", menu.id: " + this.menu.getId() + " }" +  super.toString();
	}

}
