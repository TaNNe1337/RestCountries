package com.qualitype.RESTCountries.rest.it;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.qualitype.RESTCountries.Country;
import com.qualitype.RESTCountries.Currency;
import com.qualitype.RESTCountries.rest.RestCountryManager;

public class RestCountryManagerTest {

	final RestCountryManager manager = new RestCountryManager();

	@Test
	public void testGetAllCountries() throws Exception {
		final List<Country> countries = this.manager.getAllCountries();
		Assert.assertEquals(250, countries.size());
	}

	@Test
	public void testSearchByName() {
		final List<Country> countries = this.manager.searchByName("Germany");
		Assert.assertEquals("Germany", countries.get(0).getName());
	}

	@Test
	public void testGetCurrencyByCountry() {
		final List<Currency> currency = this.manager.getCurrenciesByCountry("Germany");
		Assert.assertEquals("Euro", currency.get(0).getName());
	}

}
