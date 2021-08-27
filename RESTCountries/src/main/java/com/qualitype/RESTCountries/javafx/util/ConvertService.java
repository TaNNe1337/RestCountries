package com.qualitype.RESTCountries.javafx.util;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.Spinner;

public class ConvertService extends Service<Double> {

	private final Spinner<Double> spinner;

	public ConvertService(Spinner<Double> spinner) {
		super();
		this.spinner = spinner;
	}

	@Override
	protected Task<Double> createTask() {
		return new Task<>() {

			@Override
			protected Double call() throws Exception {
				ConvertService.this.spinner.valueProperty().addListener(new ChangeListener<Double>() {

					@Override
					public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
//						PrimaryController.this.resultField.setText(String.valueOf(PrimaryController.this.convertManager.convert(
//								PrimaryController.this.sourceCurrencyCombobox.getSelectionModel().getSelectedItem().getCode(),
//								PrimaryController.this.resultCurrencyCombobox.getSelectionModel().getSelectedItem().getCode(),
//								oldValue.doubleValue())));

						//teaisudgaskjgdakjhg
					}
				});
				return null;
			}
		};
	}

//	private void addListener(Spinner<Double> spinner) {
//		spinner.valueProperty().addListener(new ChangeListener<Double>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
//				PrimaryController.this.resultField.setText(String.valueOf(PrimaryController.this.convertManager.convert(
//						PrimaryController.this.sourceCurrencyCombobox.getSelectionModel().getSelectedItem().getCode(),
//						PrimaryController.this.resultCurrencyCombobox.getSelectionModel().getSelectedItem().getCode(),
//						oldValue.doubleValue())));
//			}
//		});
//	}
}