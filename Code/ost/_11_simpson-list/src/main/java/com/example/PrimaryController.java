package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController {

    // Observable list to store names
    private final ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    private Button add;

    @FXML
    private TextField input;

    @FXML
    private ListView<String> list; // ListView configured to display Strings

    @FXML
    private Button rm;

    @FXML
    public void initialize() {
        items.add("Homer");
        items.add("Bart");
        items.add("Lisa");
        items.add("Maggi");
        items.add("Marge");
        list.setItems(items);
    }

    @FXML
    void add(ActionEvent event) {
        String temp = input.getText().trim();
        if (!temp.isEmpty() && !items.contains(temp)) { // Avoid duplicates
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to add " + temp + " from the list?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                items.add(temp);
                input.clear(); // Clear the input field after adding
            }
        }
    }

    @FXML
    void remove(ActionEvent event) {
        String selected = list.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to remove " + selected + " from the list?");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                items.remove(selected);
            }
        }
    }
}
