package com.qualitype.RESTCountries.javafx.util;

import com.qualitype.RESTCountries.Currency;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class CurrencyNameComboCellFactory<S> implements Callback<ListView<Currency>, ListCell<Currency>> {

	@Override
	public ListCell<Currency> call(ListView<Currency> param) {
		return new CurrencyNameComboCell<>();
	}

}
