package com.qualitype.RESTCountries.rest.it;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qualitype.RESTCountries.rest.RestConvertManager;

public class RestConvertManagerTest {

	final RestConvertManager manager = new RestConvertManager();
	List<String> listOfCurrencies = new ArrayList<>();

	// ["SGD","MYR","EUR","USD","AUD","JPY","CNH","HKD","CAD","INR","DKK","GBP","RUB","NZD","MXN","IDR","TWD","THB","VND"]
	@Before
	public void setUp() {
		final String[] arrayOfCurrencies = {"SGD", "MYR", "EUR", "USD", "AUD", "JPY", "CNH", "HKD", "CAD", "INR", "DKK", "GBP", "RUB",
				"NZD", "MXN", "IDR", "TWD", "THB", "VND"};
		this.listOfCurrencies = Arrays.asList(arrayOfCurrencies);
	}

	@Test
	public void testConvertSGDtoMYR() throws Exception {
		final Double result = this.manager.convert("SGD", "MYR", 20);
		Assert.assertEquals(Double.valueOf(3.116902), result);
	}

	@Test
	public void testGetAllCurrencies() throws Exception {
		final List<String> result = this.manager.getAllCurrencies();
		result.forEach(System.out::println);
		Assert.assertEquals(this.listOfCurrencies, result);
	}

}
