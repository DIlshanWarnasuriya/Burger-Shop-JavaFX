package controller;

import DB.OrderList;
import Model.Orders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchOrderController {

    @FXML
    private Label lblOrderId;
    @FXML
    private Label lblCustomerId;
    @FXML
    private Label lblCustomerName;
    @FXML
    private Label lblQty;
    @FXML
    private Label lblStatus;
    @FXML
    private Label lblTotal;
    @FXML
    private TextField txtOrderId;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnBack;
    @FXML
    private Rectangle hidePanel;
    @FXML
    private Rectangle successMessagePanel;
    @FXML
    private Rectangle ErrorMessagePanel;
    @FXML
    private Label lblWarningMessage;

    private final OrderList orderList = OrderList.getInstance();
    private final int PREPARING=0;
    private final int DELIVERED=1;
    private  final int CANCEL=2;

    public void searchOnAction(ActionEvent actionEvent) {
        if (txtOrderId.getText().isEmpty()){
            WarningMessage("Error", "Please Enter Order Id");
            hidePanel.setVisible(true);
        }
        else{
            Orders orders = orderList.SearchOrder(txtOrderId.getText());

            if(orders == null){
                WarningMessage("Error", "Order Not Found");
                hidePanel.setVisible(true);
                txtOrderId.setText("");
            }
            else{
                WarningMessage("Success", "Order Found");
                hidePanel.setVisible(false);
                txtOrderId.setText("");

                lblOrderId.setText(orders.getOrderId());
                lblCustomerId.setText(orders.getCustomerId());
                lblCustomerName.setText(orders.getCustomerName());
                lblQty.setText("" + orders.getQty());
                lblStatus.setText(getStatus(orders.getStatus()));
                lblTotal.setText("" + orders.getTotal());
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

    private String getStatus(int num){
        if (num == PREPARING){
            return "Preparing....";
        }
        else if(num == DELIVERED){
            return "Delivered....";
        }
        else{
            return "Cancel....";
        }
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
