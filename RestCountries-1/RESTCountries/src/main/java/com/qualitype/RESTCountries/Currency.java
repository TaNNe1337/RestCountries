package com.qualitype.RESTCountries;

import java.util.Objects;

import javafx.beans.property.SimpleStringProperty;

public class Currency {
	private String code;
	private final SimpleStringProperty name = new SimpleStringProperty(this, "name");
	private String symbol;

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "Currency [code=" + this.code + ", name=" + this.name.get() + ", symbol=" + this.symbol + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.code, this.symbol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Currency other = (Currency) obj;
		return Objects.equals(this.code, other.code) && Objects.equals(this.symbol, other.symbol);
	}
}
