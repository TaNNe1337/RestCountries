package com.qualitype.RESTCountries.javafx.util;

import java.util.List;
import java.util.stream.Collectors;

import com.qualitype.RESTCountries.Currency;

import javafx.scene.control.TableCell;

public class CurrencyNameTableCell<S> extends TableCell<S, List<Currency>> {

	@Override
	protected void updateItem(List<Currency> items, boolean empty) {
		super.updateItem(items, empty);
		if (!empty && items != null) {
			setText(items.stream().map(Currency::getName).collect(Collectors.joining(", ")));
		} else {
			setText(null);
		}
	}
}
