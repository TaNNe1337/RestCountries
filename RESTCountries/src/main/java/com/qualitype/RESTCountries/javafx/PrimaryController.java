package com.qualitype.RESTCountries.javafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.qualitype.RESTCountries.Country;
import com.qualitype.RESTCountries.Currency;
import com.qualitype.RESTCountries.Language;
import com.qualitype.RESTCountries.javafx.util.ConvertService;
import com.qualitype.RESTCountries.javafx.util.CurrencyNameComboCellFactory;
import com.qualitype.RESTCountries.rest.RestConvertManager;
import com.qualitype.RESTCountries.rest.RestCountryManager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

	@FXML
	private Button searchButton;
	@FXML
	private Button getAll;
	@FXML
	private TextField searchField;
	@FXML
	private TableView<Country> tableView;
	@FXML
	private TableColumn<Country, String> Name;
	@FXML
	private TableColumn<Language, String> Languages;
	@FXML
	private TableColumn<Currency, String> Currencies;
	@FXML
	private Spinner<Double> sourceCurrencySpinner;
	@FXML
	private ComboBox<Currency> sourceCurrencyCombobox;
	@FXML
	private TextField resultField;
	@FXML
	private ComboBox<Currency> resultCurrencyCombobox;
	@FXML
	private Button convertButton;

	private RestCountryManager countryManager;
	private RestConvertManager convertManager;
	private List<Currency> availableCurrencies = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		final CurrencyNameComboCellFactory<Currency> cellFactory = new CurrencyNameComboCellFactory<>();
		this.countryManager = new RestCountryManager();
		this.convertManager = new RestConvertManager();
		try {
			this.availableCurrencies = this.getAvailableCurrencies();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		this.resultCurrencyCombobox.getItems().addAll(this.availableCurrencies);
		this.sourceCurrencyCombobox.getItems().addAll(this.availableCurrencies);
		this.sourceCurrencyCombobox.setButtonCell(cellFactory.call(null));
		this.resultCurrencyCombobox.setButtonCell(cellFactory.call(null));
		this.sourceCurrencyCombobox.getSelectionModel().selectFirst();
		this.resultCurrencyCombobox.getSelectionModel().selectFirst();
		addListener();
		addSelectionListener(this.tableView);
	}

	@FXML
	private void getResult() throws Exception {
		final List<Country> countries = this.countryManager.searchByName(this.searchField.getText());
		this.tableView.getItems().setAll(countries);
	}

	@FXML
	private void getAllCountries() throws Exception {
		final List<Country> countries = this.countryManager.getAllCountries();
		this.tableView.getItems().setAll(countries);
	}

	@FXML
	private void doConversion() throws Exception {
		final String sourceCurrency = this.sourceCurrencyCombobox.getSelectionModel().getSelectedItem().getCode();
		final String resultCurrency = this.resultCurrencyCombobox.getSelectionModel().getSelectedItem().getCode();
		if (sourceCurrency != null && resultCurrency != null) {
			final Double conversionRate = this.convertManager.convert(sourceCurrency, resultCurrency, 1);
			this.resultField.setText(String.format("%.2f", this.sourceCurrencySpinner.getValue() * conversionRate));
		}

	}

	private List<Currency> getAvailableCurrencies() throws Exception {
		final List<Currency> result = new ArrayList<>();
		final List<Currency> fromCountries = this.countryManager.getAllCurrencies();
		final List<String> fromApi = this.convertManager.getAllCurrencies();
		for (final Currency currencyCountry : fromCountries) {
			for (final String currencyApi : fromApi) {
				if (currencyApi.equals(currencyCountry.getCode()) && !result.contains(currencyCountry)) {
					result.add(currencyCountry);
				}
			}
		}
		return result;
	}

	private void addListener() {
		final ConvertService cs = new ConvertService(this);
		cs.start();
	}

	private void addSelectionListener(TableView<Country> tableView1) {
		tableView1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			final var currency = newSelection.getCurrencies().get(0);
			if (currency != null && this.availableCurrencies.contains(currency)) {
				this.sourceCurrencyCombobox.setValue(currency);
			}
		});
	}

	public Spinner<Double> getSpinner() {
		return this.sourceCurrencySpinner;
	}

	public TextField getResultField() {
		return this.resultField;
	}
	public RestConvertManager getConvertManager() {
		return this.convertManager;
	}

	public ComboBox<Currency> getSourceComboBox() {
		return this.sourceCurrencyCombobox;
	}
	public ComboBox<Currency> getResultComboBox() {
		return this.resultCurrencyCombobox;
	}

}
