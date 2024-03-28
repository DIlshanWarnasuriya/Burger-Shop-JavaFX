package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchController {
    public Button btnBestCustomers;
    public Button btnSearchCustomers;
    public Button btnSearchOrders;
    public Button btnBlack;

    public void BestCustomersOnAction(ActionEvent actionEvent) {
    }

    public void SearchCustomersOnAction(ActionEvent actionEvent) {
    }

    public void SearchOrdersOnAction(ActionEvent actionEvent) {
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) btnBlack.getScene().getWindow();
        thisStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"))));
        stage.show();
    }
}
