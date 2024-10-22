package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Hello World");
        label.setFont(new Font(40));

        Scene scene = new Scene(label);

        stage.setScene(scene);
        stage.setTitle("Welcome to JavaFX!");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}