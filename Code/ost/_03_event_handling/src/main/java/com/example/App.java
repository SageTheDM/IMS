package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    private int counter = 0;

    @Override
    public void start(Stage stage) {
        try {
            Button btn = new Button("Click me");
            StackPane root = new StackPane();
            root.getChildren().add(btn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}