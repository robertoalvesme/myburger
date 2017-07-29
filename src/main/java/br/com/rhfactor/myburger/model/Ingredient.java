package br.com.rhfactor.myburger.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ingredient")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Ingredient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6434414983943374698L;

	public Ingredient() {
		super();
	}

	public Ingredient(String name) {
		super();
		this.name = name;
	}

	public Ingredient(String name, BigDecimal value) {
		super();
		this.name = name;
		this.value = value;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	@NotNull
	@NotEmpty
	@Column(length = 100, nullable = false, unique = true)
	protected String name;

	// @Digits(integer=5, fraction=2)
	// @Column(nullable= false, precision=5, scale=2)
	protected BigDecimal value;

	@Enumerated
	@Column(updatable = false, length = 5)
	private IngredientTypes type;

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

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public IngredientTypes getType() {
		return type;
	}

	public void setType(IngredientTypes type) {
		this.type = type;
	}

}
