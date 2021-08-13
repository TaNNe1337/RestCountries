package com.qualitype.RESTCountries.javafx;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.qualitype.RESTCountries.Country;
import com.qualitype.RESTCountries.Currency;
import com.qualitype.RESTCountries.Language;
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

	private RestCountryManager manager;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.manager = new RestCountryManager();
	}
	@FXML
	private void getResult() {
		final List<Country> countries = this.manager.searchByName(this.searchField.getText());
		this.tableView.getItems().setAll(countries);
	}
	@FXML
	private void getAllCountries() {
		final List<Country> countries = this.manager.getAllCountries();
		this.tableView.getItems().setAll(countries);
	}
}
