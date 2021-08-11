package com.qualitype.RESTCountries.javafx.util;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.util.Callback;

public class FlagCellFactory<S> implements Callback<TableColumn<S, Image>, TableCell<S, Image>> {

	@Override
	public TableCell<S, Image> call(TableColumn<S, Image> param) {
		return new FlagCell<>();
	}
}
