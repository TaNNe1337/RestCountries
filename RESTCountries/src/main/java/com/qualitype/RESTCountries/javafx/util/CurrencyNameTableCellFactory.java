package com.qualitype.RESTCountries.javafx.util;

import java.util.List;

import com.qualitype.RESTCountries.Currency;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class CurrencyNameTableCellFactory<S> implements Callback<TableColumn<S, List<Currency>>, TableCell<S, List<Currency>>> {

	@Override
	public TableCell<S, List<Currency>> call(TableColumn<S, List<Currency>> param) {
		return new CurrencyNameTableCell<>();
		//teswt
	}
}
