package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class PrimaryController {
    double progress = 0;

    @FXML
    private Button buttonSend;

    @FXML
    private TextField emailInput;

    @FXML
    private TextField nachnameInput;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private TextField vornameInput;

    @FXML
    void onTextChanged(KeyEvent event) {
        if (event.getSource() == vornameInput || event.getSource() == nachnameInput
                || event.getSource() == emailInput) {
            progress = 0;
            if (!vornameInput.getText().trim().isEmpty()) {
                progress += 1.0 / 3.0;
            }
            if (!nachnameInput.getText().trim().isEmpty()) {
                progress += 1.0 / 3.0;
            }
            if (!emailInput.getText().trim().isEmpty()) {
                progress += 1.0 / 3.0;
            }
            progressBar.setProgress(progress);
        }
    }

    @FXML
    void sendForm(ActionEvent event) {
        if ((int) progress == 1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to send?");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                vornameInput.clear();
                nachnameInput.clear();
                emailInput.clear();
                progressBar.setProgress(0);
            }
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Incomplete Data Warning");
            alert.setHeaderText("Incomplete Data");
            alert.setContentText("Please fill in all required fields before proceeding.");
            alert.showAndWait();
        }
    }

}