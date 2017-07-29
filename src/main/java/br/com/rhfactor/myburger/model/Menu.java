package br.com.rhfactor.myburger.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Classe que representa um item de nosso menu, incluindo seus subitens para
 * calcular seu valor, que poderá ser modificado pelo usuário que o está
 * cadastrando.
 * 
 * @author roberto
 *
 */
@Entity
@Table(name = "menu")
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2143791560090634919L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@NotEmpty
	@Column(length = 100, nullable = false, unique = true)
	private String name;

	private BigDecimal subtotal = new BigDecimal("0.0"); // Exibir o valor real dos itens

	private BigDecimal total = new BigDecimal("0.0"); // Permitir que o usuário possa cadastrar o valor

	private List<MenuIngredient> ingredients = new ArrayList<MenuIngredient>();

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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<MenuIngredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<MenuIngredient> ingredients) {
		this.ingredients = ingredients;
	}

}
