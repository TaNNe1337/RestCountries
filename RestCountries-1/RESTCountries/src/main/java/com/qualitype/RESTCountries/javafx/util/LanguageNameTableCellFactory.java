package com.qualitype.RESTCountries.javafx.util;

import java.util.List;

import com.qualitype.RESTCountries.Language;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class LanguageNameTableCellFactory<S> implements Callback<TableColumn<S, List<Language>>, TableCell<S, List<Language>>> {

	@Override
	public TableCell<S, List<Language>> call(TableColumn<S, List<Language>> param) {
		return new LanguageNameTableCell<>();
	}
}
