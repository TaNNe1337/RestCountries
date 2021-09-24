package com.qualitype.RESTCountries;

import java.util.List;

public class BaseCountry {

	protected String name;

	private List<String> topLevelDomain;

	protected String alpha2Code;

	private String alpha3Code;

	private List<String> callingCodes;

	protected String capital;

	private List<String> altSpellings;

	protected String region;

	protected String subregion;

	protected Integer population;

	private List<Double> latlng;

	private String demonym;

	private Double area;

	protected Double gini;

	private List<String> timezones;

	protected List<String> borders;

	protected String nativeName;

	private String numericCode;

	private String continent;

	public String getName() {
		return this.name;
	}

	public List<String> getTopLevelDomain() {
		return this.topLevelDomain;
	}

	public String getAlpha2Code() {
		return this.alpha2Code;
	}

	public String getAlpha3Code() {
		return this.alpha3Code;
	}

	public List<String> getCallingCodes() {
		return this.callingCodes;
	}

	public String getCapital() {
		return this.capital;
	}

	public List<String> getAltSpellings() {
		return this.altSpellings;
	}

	public String getRegion() {
		return this.region;
	}

	public String getSubregion() {
		return this.subregion;
	}

	public Integer getPopulation() {
		return this.population;
	}

	public List<Double> getLatlng() {
		return this.latlng;
	}

	public String getDemonym() {
		return this.demonym;
	}

	public Double getArea() {
		return this.area;
	}

	public Double getGini() {
		return this.gini;
	}

	public List<String> getTimezones() {
		return this.timezones;
	}

	public List<String> getBorders() {
		return this.borders;
	}

	public String getNativeName() {
		return this.nativeName;
	}

	public String getNumericCode() {
		return this.numericCode;
	}

	public String getContinent() {
		return this.continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
}
