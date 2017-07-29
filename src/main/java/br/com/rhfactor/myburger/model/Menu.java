package br.com.rhfactor.myburger.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um item de nosso menu, incluindo seus subitens para
 * calcular seu valor, que poderá ser modificado pelo usuário que o está
 * cadastrando.
 * 
 * @author roberto
 *
 */
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2143791560090634919L;

	private Integer id;

	private String name;

	private BigDecimal subtotal = new BigDecimal("0.0");

	private BigDecimal discounts = new BigDecimal("0.0");

	private BigDecimal total = new BigDecimal("0.0");

	private List<Ingredient> ingredients = new ArrayList<Ingredient>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getDiscounts() {
		return discounts;
	}

	public void setDiscounts(BigDecimal discounts) {
		this.discounts = discounts;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

}
