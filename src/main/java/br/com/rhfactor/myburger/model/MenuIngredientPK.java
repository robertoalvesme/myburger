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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuIngredientPK other = (MenuIngredientPK) obj;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		return true;
	}

}
