package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
        stage.getIcons().add(new Image("View/image/burgerIcon.png"));
        stage.setTitle("Burger Shop");
        stage.show();
    }

    public void DeliveredOrdersOnAction(ActionEvent actionEvent) throws IOException {
        Stage thiStage = (Stage) btnDeliveredOrders.getScene().getWindow();
        thiStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/ViewDeliveredOrders.fxml"))));
        stage.getIcons().add(new Image("View/image/burgerIcon.png"));
        stage.setTitle("Burger Shop");
        stage.show();
    }

    public void CancelOrdersOnAction(ActionEvent actionEvent) throws IOException {
        Stage thiStage = (Stage) btnCancelOrders.getScene().getWindow();
        thiStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/ViewCancelOrders.fxml"))));
        stage.getIcons().add(new Image("View/image/burgerIcon.png"));
        stage.setTitle("Burger Shop");
        stage.show();
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage thiStage = (Stage) btnBlack.getScene().getWindow();
        thiStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"))));
        stage.getIcons().add(new Image("View/image/burgerIcon.png"));
        stage.setTitle("Burger Shop");
        stage.show();
    }

}
