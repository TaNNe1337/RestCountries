package com.qualitype.RESTCountries.rest.it;

import java.util.Collections;
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
	public void testSearchByName_Germany() throws Exception {
		final List<Country> countries = this.manager.searchByName("Germany");
		Assert.assertEquals("Germany", countries.get(0).getName());
	}

	@Test
	public void testSearchByName_united() throws Exception {
		final List<Country> countries = this.manager.searchByName("united");
		Assert.assertEquals(countries.size(), 6);
	}

	@Test
	public void testSearchByName_WrongName() throws Exception {
		final List<Country> countries = this.manager.searchByName("wrt");
		Assert.assertEquals(Collections.emptyList(), countries);
	}

	@Test
	public void testGetAllCurrencies() throws Exception {
		final List<Currency> currency = this.manager.getAllCurrencies();
		Assert.assertEquals(currency.size(), 284);
	}

}
