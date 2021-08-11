package com.qualitype.RESTCountries;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Language {
	private String iso639_1;
	private String iso639_2;
	private final SimpleStringProperty name = new SimpleStringProperty(this, "name");
	private String nativeName;

	public String getIso639_1() {
		return this.iso639_1;
	}

	public void setIso639_1(String code) {
		this.iso639_1 = code;
	}

	public String getIso639_2() {
		return this.iso639_2;
	}

	public void setIso639_2(String iso639_2) {
		this.iso639_2 = iso639_2;
	}
	public StringProperty nameProperty() {
		return this.name;
	}
	public String getName() {
		return this.name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getNativeName() {
		return this.nativeName;
	}

	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}

//	@Override
//	public String toString() {
//		return this.name;
//	}

}
