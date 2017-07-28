package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

public class MeatTest {

	public static class Builder {

		private Meat meat = new Meat();

		public Meat build() {
			return this.meat;
		}

		public Builder name(String name) {
			this.meat.setName(name);
			return this;
		}

		public Builder value(String value) {
			this.meat.setValue(new BigDecimal(value));
			return this;
		}

	}
}
