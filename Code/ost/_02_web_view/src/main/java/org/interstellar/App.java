package org.interstellar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        WebView browser = new WebView();
        browser.getEngine().load("https://interstellardevelopment.org/");

        StackPane root = new StackPane(browser);

        Scene scene = new Scene(root, 1080, 720);

        stage.setTitle("Test Webseite");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}