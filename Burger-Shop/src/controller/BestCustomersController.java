package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BestCustomersController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TableView tblBestCustomers;
    @FXML
    private TableColumn colCustomerId;
    @FXML
    private TableColumn colCustomerName;
    @FXML
    private TableColumn colValue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        loadTable();
    }

    private void loadTable(){

    }



    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) btnBack.getScene().getWindow();
        thisStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/Search.fxml"))));
        stage.show();
    }



}
