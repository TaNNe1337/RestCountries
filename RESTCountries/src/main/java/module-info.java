module com.qualitype.RESTCountries.javafx {
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	requires jakarta.ws.rs;
	requires com.fasterxml.jackson.annotation;
	requires java.logging;

	opens com.qualitype.RESTCountries.javafx to javafx.fxml;
	opens com.qualitype.RESTCountries;
	exports com.qualitype.RESTCountries.javafx;
	exports com.qualitype.RESTCountries;
	exports com.qualitype.RESTCountries.javafx.util;
}
