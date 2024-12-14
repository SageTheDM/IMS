package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class PrimaryController {

    @FXML
    private ListView<Item> cartList;

    @FXML
    public void initialize() {
        // Sample data
        ObservableList<Item> items = FXCollections.observableArrayList(
                new Item("Book 1", "Fantasy adventure novel", 3, 19.99),
                new Item("Book 2", "Science fiction thriller", 1, 25.50));

        cartList.setItems(items);

        // Custom cell factory to display items
        cartList.setCellFactory(param -> new ListCell<Item>() {
            @Override
            protected void updateItem(Item item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    // Create a custom layout for each item
                    HBox hbox = new HBox();
                    Text titleText = new Text(item.getTitle());
                    Text descText = new Text(item.getDescription());
                    Text quantityText = new Text("Quantity: " + item.getQuantity());
                    Text priceText = new Text("Price: $" + item.getPrice());

                    hbox.getChildren().addAll(titleText, descText, quantityText, priceText);
                    setGraphic(hbox);
                }
            }
        });
    }

    // Item class to hold data
    public static class Item {
        private String title;
        private String description;
        private int quantity;
        private double price;

        public Item(String title, String description, int quantity, double price) {
            this.title = title;
            this.description = description;
            this.quantity = quantity;
            this.price = price;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }
    }
}
