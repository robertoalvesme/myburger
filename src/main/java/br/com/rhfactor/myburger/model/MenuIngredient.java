package br.com.rhfactor.myburger.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "menu_ingredients")
public class MenuIngredient implements Serializable {
	
	public MenuIngredient() {
		this.id = new MenuIngredientPK();
	}
	
	public MenuIngredient(Ingredient ingredient, Menu menu) {
		this.id = new MenuIngredientPK(menu,ingredient);
		this.quantity = 1;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8742520722003872296L;

	@EmbeddedId
	private MenuIngredientPK id;

	@Min(1)
	@Max(10)
	private Integer quantity = 0;

	public MenuIngredientPK getId() {
		return id;
	}

	public void setId(MenuIngredientPK id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		MenuIngredient other = (MenuIngredient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return " { id [ id : " + this.id.toString() + " , quantity : " + quantity+ " ] } " + super.toString();
	}

}
