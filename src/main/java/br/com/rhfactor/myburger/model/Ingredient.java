package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, columnDefinition = "VARCHAR(3) NOT NULL", length = 3, name = "type")
@DiscriminatorValue(value = "ING")
public abstract class Ingredient implements IIngredient {

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

	protected BigDecimal value;

	@Column(insertable = false, updatable = false)
	private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
