package com.qualitype.RESTCountries;

import java.util.List;

public class Country extends BaseCountry {
	private List<Currency> currencies;
	private List<Language> languages;
	private Translations translations;
	private List<String> flags;
	private List<RegionalBloc> regionalBlocs;
	private String cioc;
	private String independent;

	public List<Currency> getCurrencies() {
		return this.currencies;
	}

	public List<Language> getLanguages() {
		return this.languages;
	}

	public Translations getTranslations() {
		return this.translations;
	}

	public List<String> getFlags() {
		return this.flags;
	}

	public List<RegionalBloc> getRegionalBlocs() {
		return this.regionalBlocs;
	}

	public String getCioc() {
		return this.cioc;
	}

	public String getIndependent() {
		return this.independent;
	}

}
