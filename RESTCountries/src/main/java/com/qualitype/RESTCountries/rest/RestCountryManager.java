package com.qualitype.RESTCountries.rest;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.qualitype.RESTCountries.Country;
import com.qualitype.RESTCountries.CountryManager;
import com.qualitype.RESTCountries.Currency;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class RestCountryManager implements CountryManager {

	// "https://restcountries.eu/rest/v2"
	Client client;
	WebTarget webTarget;

	public RestCountryManager() {
		this.client = ClientBuilder.newClient();
		this.webTarget = this.client.target("https://restcountries.com/v2");
	}

	@Override
	public List<Country> getAllCountries() throws Exception {
		final WebTarget allTarget = this.webTarget.path("/all");
		final Invocation.Builder invocationBuilder = allTarget.request(MediaType.APPLICATION_JSON);
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
	public List<Country> searchByName(String name) throws Exception {
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
	public List<Currency> getAllCurrencies() throws Exception {
		final List<Country> allCountries = new LinkedList<>(getAllCountries());

		for (int i = 0; i < allCountries.size(); i++) {
			if (allCountries.get(i).getCurrencies() == null) {
				allCountries.remove(i);
			}
		}
		return allCountries.stream().map(Country::getCurrencies).flatMap(List::stream).collect(Collectors.toList());
	}

}
