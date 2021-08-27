package com.qualitype.RESTCountries.javafx.util;

import com.qualitype.RESTCountries.Currency;

import javafx.scene.control.ListCell;

public class CurrencyNameComboCell<S> extends ListCell<Currency> {

	@Override
	public void updateItem(Currency items, boolean empty) {
		super.updateItem(items, empty);
		if (!empty && items != null) {
			setText(items.getName());
		} else {
			setText(null);
		}
	}
}
