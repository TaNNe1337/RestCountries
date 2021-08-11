package com.qualitype.RESTCountries.rest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.qualitype.RESTCountries.Country;
import com.qualitype.RESTCountries.CountryManager;
import com.qualitype.RESTCountries.Currency;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javafx.scene.image.Image;

public class RestCountryManager implements CountryManager {

	//"https://restcountries.eu/rest/v2"
	Client client;
	WebTarget webTarget;

	public RestCountryManager() {
		this.client = ClientBuilder.newClient();
		this.webTarget = this.client.target("https://restcountries.eu/rest/v2");
	}
	@Override
	public List<Country> getAllCountries() {
		final WebTarget allTarget = this.webTarget.path("/all");
		final Invocation.Builder invocationBuilder = allTarget.request(MediaType.APPLICATION_JSON);
		try (Response response = invocationBuilder.get()) {
			if (response.getStatus() == 200) {
				final List<Country> output = Arrays.asList(response.readEntity(Country[].class));
				output.stream().forEach(c -> c.setFlagImage(new Image(c.getFlag(), true)));
				response.close();
				return output;
			}
			return Collections.emptyList();
		}
	}

	@Override
	public List<Country> searchByName(String name) {
		final WebTarget nameTarget = this.webTarget.path("/name").path(name);
		final Invocation.Builder invocationBuilder = nameTarget.request(MediaType.APPLICATION_JSON);
		try (Response response = invocationBuilder.get()) {
			if (response.getStatus() == 200) {
				final List<Country> output = Arrays.asList(response.readEntity(Country[].class));
				response.close();
				return output;
			}
			return Collections.emptyList();
		}

	}

	@Override
	public List<Currency> getCurrenciesByCountry(String fullName) {
		final WebTarget nameTarget = this.webTarget.path("/name").path(fullName).queryParam("fullText", "true");
		final Invocation.Builder invocationBuilder = nameTarget.request(MediaType.APPLICATION_JSON);
		try (Response response = invocationBuilder.get()) {
			if (response.getStatus() == 200) {
				final List<Country> countries = Arrays.asList(response.readEntity(Country[].class));
				final List<Currency> currencies = countries.get(0).getCurrencies();
				response.close();
				return currencies;
			}
			return Collections.emptyList();
		}
	}

}
