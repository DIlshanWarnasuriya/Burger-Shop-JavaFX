package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchController {
    @FXML
    private Button btnBestCustomers;
    @FXML
    private Button btnSearchCustomers;
    @FXML
    private Button btnSearchOrders;
    @FXML
    private Button btnBlack;

    public void BestCustomersOnAction(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) btnBestCustomers.getScene().getWindow();
        thisStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/BestCustomers.fxml"))));
        stage.getIcons().add(new Image("View/image/burgerIcon.png"));
        stage.setTitle("Burger Shop");
        stage.show();
    }

    public void SearchCustomersOnAction(ActionEvent actionEvent) throws IOException{
        Stage thisStage = (Stage) btnSearchCustomers.getScene().getWindow();
        thisStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/SearchCustomers.fxml"))));
        stage.getIcons().add(new Image("View/image/burgerIcon.png"));
        stage.setTitle("Burger Shop");
        stage.show();
    }

    public void SearchOrdersOnAction(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) btnBlack.getScene().getWindow();
        thisStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/SearchOrders.fxml"))));
        stage.getIcons().add(new Image("View/image/burgerIcon.png"));
        stage.setTitle("Burger Shop");
        stage.show();
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) btnBlack.getScene().getWindow();
        thisStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"))));
        stage.getIcons().add(new Image("View/image/burgerIcon.png"));
        stage.setTitle("Burger Shop");
        stage.show();
    }
}
