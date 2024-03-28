package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    public Button btnPlaceOrder;
    public Button btnSearch;
    public Button btnViewOrder;
    public Button btnUpdateOrder;
    public Button btnExit;

    public void PlaceOrderOnAction(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) btnPlaceOrder.getScene().getWindow();
        thisStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/PlaceOrder.fxml"))));
        stage.show();
    }

    public void searchOnAction(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) btnSearch.getScene().getWindow();
        thisStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/Search.fxml"))));
        stage.show();
    }

    public void ViewOrderOnAction(ActionEvent actionEvent) {
    }

    public void updateOrderOnAction(ActionEvent actionEvent) {
    }

    public void exitOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
