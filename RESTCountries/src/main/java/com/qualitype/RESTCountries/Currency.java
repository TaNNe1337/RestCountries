package com.qualitype.RESTCountries;

import javafx.beans.property.SimpleStringProperty;

public class Currency {
	private String code;
	private final SimpleStringProperty name = new SimpleStringProperty(this, "name");
	private String symbol;

//	@Override
//	public String toString() {
//		return this.name;
//	}

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
}
