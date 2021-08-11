package com.qualitype.RESTCountries.javafx.util;

import java.util.List;
import java.util.stream.Collectors;

import com.qualitype.RESTCountries.Language;

import javafx.scene.control.TableCell;

public class LanguageNameTableCell<S> extends TableCell<S, List<Language>> {

	@Override
	protected void updateItem(List<Language> items, boolean empty) {
		super.updateItem(items, empty);
		if (!empty && items != null) {
			setText(items.stream().map(Language::getName).collect(Collectors.joining(", ")));
		} else {
			setText(null);
		}
	}
}
