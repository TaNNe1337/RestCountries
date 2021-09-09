package com.qualitype.RESTCountries.javafx.util;

import com.qualitype.RESTCountries.javafx.PrimaryController;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.Spinner;

public class ConvertService extends Service<Void> {

	private final PrimaryController pc;

	public ConvertService(PrimaryController pc) {
		super();
		this.pc = pc;
	}

	@Override
	protected Task<Void> createTask() {
		return new Task<>() {
			final Spinner<Double> spinner = ConvertService.this.pc.getSpinner();

			@Override
			protected Void call() throws Exception {
				this.spinner.valueProperty().addListener(new ChangeListener<Double>() {

					@Override
					public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
						ConvertService.this.pc.getResultField()
								.setText(String.valueOf(ConvertService.this.pc.getConvertManager().convert(
										ConvertService.this.pc.getSourceComboBox().getSelectionModel().getSelectedItem().getCode(),
										ConvertService.this.pc.getResultComboBox().getSelectionModel().getSelectedItem().getCode(),
										newValue.doubleValue())));

					}
				});
				return null;
			}

		};
	}
}