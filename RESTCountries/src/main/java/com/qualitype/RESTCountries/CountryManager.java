package com.qualitype.RESTCountries;

import java.util.List;

public interface CountryManager {
	List<Country> getAllCountries();

	List<Country> searchByName(String name);

	List<Currency> getCurrenciesByCountry(String fullName);
}
