package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * JavaFX App with AnchorPane layout
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Create AnchorPane
        AnchorPane anchorPane = new AnchorPane();

        // Create Controll button
        Button controlButton = new Button("Button");
        AnchorPane.setTopAnchor(controlButton, 50.0);
        AnchorPane.setLeftAnchor(controlButton, 50.0);
        AnchorPane.setRightAnchor(controlButton, 10.0);
        AnchorPane.setBottomAnchor(controlButton, 10.0);

        // Create Button 1
        Button button1 = new Button("Button 1");
        AnchorPane.setTopAnchor(button1, 10.0);
        AnchorPane.setLeftAnchor(button1, 10.0);

        // Add buttons to the pane
        anchorPane.getChildren().addAll(controlButton, button1);

        // Set up the Scene with AnchorPane
        Scene scene = new Scene(anchorPane, 640, 480);
        stage.setTitle("Hauptfenster with AnchorPane");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
