package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private Scene scene1, scene2;

    @Override
    public void start(Stage stage) {
        // First scene with distinct text
        Label label1 = new Label("Welcome to Scene 1!");
        Button switchToScene2 = new Button("Switch to Scene 2");
        VBox layout1 = new VBox(20, label1, switchToScene2); // VBox with spacing between elements
        layout1.setStyle("-fx-alignment: center;"); // Center-align VBox contents
        scene1 = new Scene(layout1, 640, 480);

        // Second scene with distinct text
        Label label2 = new Label("You are now in Scene 2!");
        Button switchToScene1 = new Button("Switch to Scene 1");
        VBox layout2 = new VBox(20, label2, switchToScene1); // VBox with spacing between elements
        layout2.setStyle("-fx-alignment: center;"); // Center-align VBox contents
        scene2 = new Scene(layout2, 640, 480);

        // Button actions to switch scenes
        switchToScene2.setOnAction(e -> stage.setScene(scene2));
        switchToScene1.setOnAction(e -> stage.setScene(scene1));

        // Set initial scene and show the stage
        stage.setScene(scene1);
        stage.setTitle("Scene Switcher");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
