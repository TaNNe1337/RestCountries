package com.qualitype.RESTCountries;

import java.time.LocalDate;

public class ConvertCurrency {

	private LocalDate updated;

	private String source;

	private String target;

	private double value;

	private double quantity;

	private double amount;

	public LocalDate getUpdated() {
		return this.updated;
	}

	public void setUpdated(LocalDate updated) {
		this.updated = updated;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
