package controller;

import DB.OrderList;
import Model.Orders;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observable;

public class SearchCustomerController {
    @FXML
    private TextField txtCustomerId;
    @FXML
    private Rectangle successMessagePanel;
    @FXML
    private Rectangle ErrorMessagePanel;
    @FXML
    private Label lblWarningMessage;
    @FXML
    private Label lblCustomerName;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnSearch;
    @FXML
    private TableView tblOrders;
    @FXML
    private TableColumn colOrderId;
    @FXML
    private TableColumn colQty;
    @FXML
    private TableColumn colTotal;
    @FXML
    private Rectangle hidePanel;

    private final OrderList orderList = OrderList.getInstance();

    public void searchOnAction(ActionEvent actionEvent) {
        if (txtCustomerId.getText().isEmpty() || txtCustomerId.getText().length() != 10){
            WarningMessage("Error", "Please Enter Valid Phone No");
            hidePanel.setVisible(true);
            txtCustomerId.setText("");
        }
        else{
            colOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
            colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
            colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

            ObservableList<Orders> ob = orderList.SearchCustomerOrderDetails(txtCustomerId.getText());

            if (ob==null){
                WarningMessage("Error", "Customer Not found");
                hidePanel.setVisible(true);
                txtCustomerId.setText("");
            }
            else{
                tblOrders.setItems(ob);
                lblCustomerName.setText(ob.get(0).getCustomerName());
                WarningMessage("Success", "Customer Found");
                hidePanel.setVisible(false);
                txtCustomerId.setText("");
            }
        }
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) btnBack.getScene().getWindow();
        thisStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/Search.fxml"))));
        stage.show();
    }

    private void WarningMessage(String status, String message){
        if (status.equals("Success")){
            ClearWarningMessage();
            successMessagePanel.setVisible(true);
        }
        else{
            ClearWarningMessage();
            ErrorMessagePanel.setVisible(true);
        }
        lblWarningMessage.setVisible(true);
        lblWarningMessage.setText(message);
    }
    private void ClearWarningMessage(){
        ErrorMessagePanel.setVisible(false);
        successMessagePanel.setVisible(false);
        lblWarningMessage.setVisible(false);
    }
}
