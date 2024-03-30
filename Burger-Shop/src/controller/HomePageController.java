package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    @FXML
    private Button btnPlaceOrder;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnViewOrder;
    @FXML
    private Button btnUpdateOrder;
    @FXML
    private Button btnExit;

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

    public void ViewOrderOnAction(ActionEvent actionEvent) throws IOException {
        Stage thiStage = (Stage) btnViewOrder.getScene().getWindow();
        thiStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/ViewOrders.fxml"))));
        stage.show();
    }

    public void updateOrderOnAction(ActionEvent actionEvent) throws IOException {
        Stage thiStage = (Stage) btnUpdateOrder.getScene().getWindow();
        thiStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/UpdateOrderDetails.fxml"))));
        stage.show();
    }

    public void exitOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
