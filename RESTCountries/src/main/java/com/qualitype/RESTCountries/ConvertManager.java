package com.qualitype.RESTCountries;

import java.util.List;

public interface ConvertManager {

	Double convert(String source, String target, double quantity);

	List<String> getAllCurrencies();

}
