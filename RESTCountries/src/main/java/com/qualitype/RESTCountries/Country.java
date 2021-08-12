package com.qualitype.RESTCountries;

import java.util.List;

public class Country extends BaseCountry {
	private List<Currency> currencies;
	private List<Language> languages;
	private Translations translations;
	private String flag;
	private List<RegionalBloc> regionalBlocs;
	private String cioc;

	public List<Currency> getCurrencies() {
		return this.currencies;
	}

	public List<Language> getLanguages() {
		return this.languages;
	}

	public Translations getTranslations() {
		return this.translations;
	}

	public String getFlag() {
		return this.flag;
	}

	public List<RegionalBloc> getRegionalBlocs() {
		return this.regionalBlocs;
	}

	public String getCioc() {
		return this.cioc;
	}

}
