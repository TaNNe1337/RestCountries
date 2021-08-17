package com.qualitype.RESTCountries.rest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.qualitype.RESTCountries.ConvertManager;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class RestConvertManager implements ConvertManager {

	Client client;
	WebTarget webTarget;

	public RestConvertManager() {
		this.client = ClientBuilder.newClient();
		this.webTarget = this.client.target("https://currency-exchange.p.rapidapi.com");
	}

	@Override
	public Double convert(String source, String target, double quantity) {
		final WebTarget allTarget = this.webTarget.path("exchange").queryParam("to", target).queryParam("from", source)
				.queryParam("q", Double.valueOf(quantity));
		final Invocation.Builder invocationBuilder = allTarget.request(MediaType.APPLICATION_JSON)
				.header("x-rapidapi-key", "a6e6ce8f06msh1805fd37a9de427p1a0dd9jsn13b67ae656fc")
				.header("x-rapidapi-host", "currency-exchange.p.rapidapi.com");
		try (Response response = invocationBuilder.get()) {
			if (response.getStatus() == 200) {
				final Double output = response.readEntity(Double.class);
				response.close();
				return output;
			}
			return null;
		}
	}

	@Override
	public List<String> getAllCurrencies() {
		final WebTarget allTarget = this.webTarget.path("listquotes");
		final Invocation.Builder invocationBuilder = allTarget.request(MediaType.TEXT_PLAIN)
				.header("x-rapidapi-key", "a6e6ce8f06msh1805fd37a9de427p1a0dd9jsn13b67ae656fc")
				.header("x-rapidapi-host", "currency-exchange.p.rapidapi.com");
		String result = "";
		try (Response response = invocationBuilder.get()) {
			if (response.getStatus() == 200) {
				result = response.readEntity(String.class);
				response.close();
			}
			if (!result.equals("")) {
				final List<String> output = Arrays
						.asList(result.replace("[", "").replace("]", "").replace("\"", "").split(","));
				return output;
			}
			return Collections.emptyList();
		}
	}

}
