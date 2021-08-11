package com.qualitype.RESTCountries.javafx.util;

import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FlagCell<S> extends TableCell<S, Image> {

	private final ImageView image;

	public FlagCell() {
		this.image = new ImageView();
		this.image.setFitHeight(50);
		this.image.setFitWidth(75);
		this.image.setPreserveRatio(true);
		setGraphic(this.image);
		setMinHeight(70);
	}

	@Override
	protected void updateItem(Image item, boolean empty) {
		super.updateItem(item, empty);
		if (!empty && item != null) {
			this.image.setImage(item);
			setText(null);
		} else {
			setText(null);
			this.image.setImage(null);
		}
	}

}
