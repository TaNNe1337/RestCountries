package com.qualitype.RESTCountries.javafx.util;

import com.qualitype.RESTCountries.javafx.PrimaryController;
import com.qualitype.RESTCountries.rest.RestConvertManager;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.Spinner;

public class ConvertService extends Service<Double> {

	private final PrimaryController pc;
	private final Spinner<Double> spinner;
	private final RestConvertManager convertManager;

	public ConvertService(PrimaryController pc) {
		this.pc = pc;
		this.spinner = this.pc.getSpinner();
		this.convertManager = new RestConvertManager();
	}

	@Override
	protected Task<Double> createTask() {
		return new Task<>() {

			@Override
			protected Double call() throws Exception {
				//TODO Listner wird nur in neuem thread angehangen, rest des codes läuft im normalen thread
				System.out.println("register");

				ConvertService.this.spinner.valueProperty().addListener((observable, oldValue, newValue) -> {
					System.out.println("Test");

					final String sourceCurrency = ConvertService.this.pc.getSourceComboBox().getSelectionModel().getSelectedItem()
							.getCode();
					final String resultCurrency = ConvertService.this.pc.getResultComboBox().getSelectionModel().getSelectedItem()
							.getCode();
					if (sourceCurrency != null && resultCurrency != null) {
						Double conversionRate = Double.valueOf(0);
						try {
							conversionRate = ConvertService.this.convertManager.convert(sourceCurrency, resultCurrency, 1);
						} catch (final Exception e) {
							e.printStackTrace();
						}
						ConvertService.this.pc.getResultField().setText(String.format("%.2f", newValue.doubleValue() * conversionRate));
					}

				});
				return null;
			}

		};
	}

	@Override
	protected void succeeded() {
		super.succeeded();
		getValue();

		// if (Platform.isFxApplicationThread())

		Platform.runLater(() -> {
			// ...
		});
	}
}