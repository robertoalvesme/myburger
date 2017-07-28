package br.com.rhfactor.myburger.model;

import java.math.BigDecimal;

public class CommonTest {

	public static class Builder {

		private Common common = new Common();

		public Common build() {
			return this.common;
		}

		public Builder name(String name) {
			this.common.setName(name);
			return this;
		}

		public Builder value(String value) {
			this.common.setValue(new BigDecimal(value));
			return this;
		}

	}

}
