package com.qualitype.RESTCountries.javafx.util;

import com.qualitype.RESTCountries.Currency;
import com.qualitype.RESTCountries.rest.RestConvertManager;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ConvertService extends Service<Double> {

	private final RestConvertManager convertManager;
	private final ComboBox<Currency> sourceComboBox;
	private final ComboBox<Currency> resultComboBox;
	private final Double value;
	private final TextField resultField;

	public ConvertService(ComboBox<Currency> sourceCombo, ComboBox<Currency> resultCombo, Double value, TextField resultField) {
		this.convertManager = new RestConvertManager();
		this.sourceComboBox = sourceCombo;
		this.resultComboBox = resultCombo;
		this.value = value;
		this.resultField = resultField;
	}

	@Override
	protected Task<Double> createTask() {
		return new Task<>() {

			@Override
			protected Double call() throws Exception {
				final String sourceCurrency = ConvertService.this.sourceComboBox.getSelectionModel().getSelectedItem().getCode();
				final String resultCurrency = ConvertService.this.resultComboBox.getSelectionModel().getSelectedItem().getCode();
				if (sourceCurrency != null && resultCurrency != null) {
					Double conversionRate = Double.valueOf(0);
					try {
						conversionRate = ConvertService.this.convertManager.convert(sourceCurrency, resultCurrency, 1);
					} catch (final Exception e) {
						e.printStackTrace();
					}
					return Double.valueOf(ConvertService.this.value.doubleValue() * conversionRate.doubleValue());
				}

				return null;
			}

		};
	}

	@Override
	protected void succeeded() {
		super.succeeded();
		if (Platform.isFxApplicationThread()) {

			Platform.runLater(() -> {
				this.resultField.setText(String.format("%.2f", getValue()));
			});
		}
	}
}