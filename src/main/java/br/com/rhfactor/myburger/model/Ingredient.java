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
import javax.persistence.Transient;
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

	public Ingredient(String name, BigDecimal value, IngredientTypes type) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
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

	@Transient
	private Boolean used = false;

	@Enumerated
	@Column(updatable = false, length = 4)
	private IngredientTypes type;
	
	// 
	
	public boolean isSalad() {
		return type.equals(IngredientTypes.SALA);
	}
	
	public boolean isSpecial() {
		return type.equals(IngredientTypes.SPEC);
	}
	
	public boolean hasDiscount() {
		return type.equals(IngredientTypes.MEAT) || type.equals(IngredientTypes.CHEE);
	}
	
	// Getters and Setters

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Ingredient other = (Ingredient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	public void setType(IngredientTypes type) {
		this.type = type;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

	

}
