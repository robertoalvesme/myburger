package br.com.rhfactor.myburger.model;

public enum IngredientTypes {

	MT("meat"), CS("chesse"), BD("bread"), CM("common"), SC("sauce"), SD("salad"), SP("special");

	IngredientTypes(String description) {
		this.description = description;
	}

	private final String description;

	public String getDescription() {
		return description;
	}

	public static IngredientTypes get(String typed) {
		for (IngredientTypes type : IngredientTypes.values()) {
			if (type.getDescription().equals(typed)) {
				return type;
			}
		}
		throw new RuntimeException("no.type.defined");
	}

}
