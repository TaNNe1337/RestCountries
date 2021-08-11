package com.qualitype.RESTCountries;

import java.util.ArrayList;
import java.util.List;

public class RegionalBloc {
	private String acronym;
	private String name;
	private List<String> otherAcronyms;
	private List<String> otherNames;

	public String getAcronym() {
		return this.acronym;
	}

	public String getName() {
		return this.name;
	}

	public List<String> getOtherAcronyms() {
		if (this.otherAcronyms == null) {
			this.otherAcronyms = new ArrayList<>();
		}
		return this.otherAcronyms;
	}

	public List<String> getOtherNames() {
		if (this.otherNames == null) {
			this.otherNames = new ArrayList<>();
		}
		return this.otherNames;
	}
}
