package com.qualitype.RESTCountries.rest;

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
	static private final String KEY = "9582|MZNdLeMjJjgbrBu8XUBQ17eRGXFkz6rA";
	// https://fixer.io/product

	public RestConvertManager() {
		this.client = ClientBuilder.newClient();
		this.webTarget = this.client.target("http://api.valuta.money/v1/quotes");
	}

	@Override
	public double convert(String source, String target, double quantity) {
		final WebTarget allTarget = this.webTarget.path(source).path(target).path("json").queryParam("qty", quantity)
				.queryParam("k", KEY);
		final Invocation.Builder invocationBuilder = allTarget.request(MediaType.APPLICATION_JSON);
		try (Response response = invocationBuilder.get()) {
			if (response.getStatus() == 200) {
				final double output = response.readEntity(Double.class);
				response.close();
				return output;
			}
			return 0;
		}
	}

}
