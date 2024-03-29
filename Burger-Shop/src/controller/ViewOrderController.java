package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.io.IOException;

public class ViewOrderController {
    @FXML
    private Button btnPreparingOrders;
    @FXML
    private Button btnDeliveredOrders;
    @FXML
    private Button btnCancelOrders;
    @FXML
    private Button btnBlack;

    public void PreparingOrdersOnAction(ActionEvent actionEvent) throws IOException {
        Stage thiStage = (Stage) btnPreparingOrders.getScene().getWindow();
        thiStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/ViewPreparingOrders.fxml"))));
        stage.show();
    }

    public void DeliveredOrdersOnAction(ActionEvent actionEvent) {
    }

    public void CancelOrdersOnAction(ActionEvent actionEvent) {
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage thiStage = (Stage) btnBlack.getScene().getWindow();
        thiStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"))));
        stage.show();
    }

}
