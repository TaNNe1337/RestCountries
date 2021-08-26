package com.qualitype.RESTCountries.javafx;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("primary"), 800, 500);
		stage.setScene(scene);
		stage.setTitle("Countries");
		stage.show();
	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		final var bundle = ResourceBundle.getBundle("com.qualitype.RESTCountries.javafx.messages");
		final FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"), bundle);
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		launch();
	}

}