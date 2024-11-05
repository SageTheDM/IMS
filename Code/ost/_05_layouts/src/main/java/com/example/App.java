//#region imports
package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//#region launcher
public class App extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        showStackPane(); // Change this line to launch a different scene
    }

    // #region HBox Scene
    private void showHBoxScene() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 20, 20, 20));
        hbox.setSpacing(15);

        // Create two buttons
        Button leftButton = new Button("Left");
        Button rightButton = new Button("Right");

        // Add buttons to the HBox
        hbox.getChildren().addAll(leftButton, rightButton);
        hbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(hbox, 250, 150);
        primaryStage.setTitle("Hauptfenster - HBox Scene");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // #endregion

    // #region AnchorPane Scene
    private void showAnchorPaneScene() {
        AnchorPane anchorPane = new AnchorPane();

        // Create Control button
        Button mainButton = new Button("Main Button");
        AnchorPane.setTopAnchor(mainButton, 50.0);
        AnchorPane.setLeftAnchor(mainButton, 50.0);
        AnchorPane.setRightAnchor(mainButton, 10.0);
        AnchorPane.setBottomAnchor(mainButton, 10.0);

        // Create Button 1
        Button button1 = new Button("Button 1");
        AnchorPane.setTopAnchor(button1, 10.0);
        AnchorPane.setLeftAnchor(button1, 10.0);

        // Add buttons to the pane
        anchorPane.getChildren().addAll(mainButton, button1);

        Scene scene = new Scene(anchorPane, 640, 480);
        primaryStage.setTitle("Hauptfenster - AnchorPane Scene");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // #endregion

    // #region VBox Scene
    private void showVBoxScene() {
        VBox vbox = new VBox();
        vbox.setSpacing(8);

        // Create the buttons
        Button growButton = new Button("Lass mich wachsen!");
        Button relaxButton = new Button("Lass mich in ruhe!");

        // Set grow priority for the growButton
        VBox.setVgrow(growButton, Priority.ALWAYS);
        growButton.setMaxHeight(500);

        // Add buttons to the VBox
        vbox.getChildren().addAll(growButton, relaxButton);

        Scene scene = new Scene(vbox, 200, 400);
        primaryStage.setTitle("VBox Scene");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // #endregion

    // #region StackPane Scene
    private void showStackPane() {
        StackPane stackPane = new StackPane();

        // Create a circle
        Circle circle = new Circle(100);
        circle.setFill(Color.DARKSLATEBLUE);
        circle.setStroke(Color.BLACK);

        // Create a rectangle
        Rectangle rectangle = new Rectangle(50, 50);

        // Create a text
        Text text = new Text("Hello World");
        text.setFill(Color.CRIMSON);

        // Add the shapes and text to the StackPane
        stackPane.getChildren().addAll(circle, rectangle, text);

        Scene scene = new Scene(stackPane, 300, 300);
        primaryStage.setTitle("StackPane Scene");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // #endregion
}
