package com.qualitype.RESTCountries;

import java.util.HashMap;
import java.util.List;

public class Country extends BaseCountry {
	private List<Currency> currencies;
	private List<Language> languages;
	private Translations translations;
	private HashMap<String, String> flags;
	private String flag;
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

	public HashMap<String, String> getFlags() {
		return this.flags;
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

	public String getIndependent() {
		return this.independent;
	}

}
