package br.com.rhfactor.myburger.model;

public class MenuTest {

	public static class Builder {

		private Menu menu = new Menu();

		public Menu build() {
			return this.menu;
		}

		public Builder name(String name) {
			this.menu.setName(name);
			return this;
		}

		public Builder addItem(Ingredient ingredient) {
			this.menu.getIngredients().add(new MenuIngredient(ingredient, this.menu));
			return this;
		}

	}

}
