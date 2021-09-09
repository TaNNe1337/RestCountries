package com.qualitype.RESTCountries;

import java.util.List;

public interface CountryManager {
	List<Country> getAllCountries() throws Exception;

	List<Country> searchByName(String name) throws Exception;

	List<Currency> getAllCurrencies() throws Exception;
}
