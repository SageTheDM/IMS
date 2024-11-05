//#region imports
package com.example;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
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
        showMain(); // Change this line to launch a different scene
    }

    // #region main scene
    private void showMain() {
        // Create a VBox to hold the buttons
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.CENTER);

        // Create buttons for each scene
        Button hBoxButton = new Button("Go to HBox Scene");
        Button anchorPaneButton = new Button("Go to AnchorPane Scene");
        Button vBoxButton = new Button("Go to VBox Scene");
        Button stackPaneButton = new Button("Go to StackPane Scene");
        Button borderPaneButton = new Button("Go to BorderPane Scene");
        Button gridPaneButton = new Button("Go to GridPane Scene");

        // Set action for each button to switch scenes
        hBoxButton.setOnAction(e -> showHBoxScene());
        anchorPaneButton.setOnAction(e -> showAnchorPaneScene());
        vBoxButton.setOnAction(e -> showVBoxScene());
        stackPaneButton.setOnAction(e -> showStackPane());
        borderPaneButton.setOnAction(e -> showBorderPane());
        gridPaneButton.setOnAction(e -> showGridPane());

        // Add buttons to the layout
        mainLayout.getChildren().addAll(
                hBoxButton,
                anchorPaneButton,
                vBoxButton,
                stackPaneButton,
                borderPaneButton,
                gridPaneButton);

        // Create the scene with the main layout
        Scene scene = new Scene(mainLayout, 300, 300);
        primaryStage.setTitle("Main Scene");
        primaryStage.setScene(scene);
        primaryStage.show();
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

    // #region borderPane Scene
    private void showBorderPane() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 20, 20, 20));

        // Create buttons
        Button topButton = new Button("Top");
        Button bottomButton = new Button("Bottom");
        Button leftButton = new Button("Left");
        Button rightButton = new Button("Right");

        // Create a TextArea
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);

        // Set the layout of the BorderPane
        borderPane.setTop(topButton);
        borderPane.setBottom(bottomButton);
        borderPane.setLeft(leftButton);
        borderPane.setRight(rightButton);
        borderPane.setCenter(textArea);
        BorderPane.setMargin(textArea, new Insets(10, 10, 10, 10));
        BorderPane.setAlignment(topButton, Pos.CENTER);
        BorderPane.setAlignment(bottomButton, Pos.CENTER);
        BorderPane.setAlignment(leftButton, Pos.CENTER);
        BorderPane.setAlignment(rightButton, Pos.CENTER);

        // Set scene
        Scene scene = new Scene(borderPane, 550, 250);
        primaryStage.setTitle("BorderPane Scene");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // #region GridPane Scene
    private void showGridPane() {
        // Create a GridPane with padding and gaps
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(15);
        gridPane.setVgap(15);

        // Create labels, button, text fields, and text area
        Label nameLabel = new Label("Name:");
        Label emailLabel = new Label("EMAILs:");
        Label commentLabel = new Label("Comment:");
        Button submitButton = new Button("Submit");
        TextField nameTextField = new TextField();
        TextField emailTextField = new TextField();
        TextArea commentTextArea = new TextArea();
        commentTextArea.setWrapText(true);

        // Add controls to the GridPane
        gridPane.add(nameLabel, 0, 0); // Column 0, Row 0
        gridPane.add(emailLabel, 0, 1); // Column 0, Row 1
        gridPane.add(commentLabel, 0, 2); // Column 0, Row 2
        gridPane.add(nameTextField, 1, 0); // Column 1, Row 0
        gridPane.add(emailTextField, 1, 1); // Column 1, Row 1
        gridPane.add(commentTextArea, 1, 2); // Column 1, Row 2
        gridPane.add(submitButton, 1, 3); // Column 1, Row 3

        // Align controls
        GridPane.setValignment(commentLabel, VPos.TOP);
        GridPane.setHalignment(submitButton, HPos.RIGHT);

        // Set column constraints
        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setPercentWidth(33);
        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        columnConstraints2.setPercentWidth(67);
        gridPane.getColumnConstraints().addAll(columnConstraints1, columnConstraints2);

        // Set scene
        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setTitle("GridPane Scene");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
