package controller;

import DB.OrderList;
import Model.Orders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateOrderDetailsController {

    @FXML
    private TextField txtOrderId;
    @FXML
    private Label lblOrderId;
    @FXML
    private Label lblTotal;
    @FXML
    private Label lblCustomerId;
    @FXML
    private Label lblCustomerName;
    @FXML
    private Button btnSearch;
    @FXML
    private Rectangle hidePanel;
    @FXML
    private TextField txtQty;
    @FXML
    private SplitMenuButton spnStatus;
    @FXML
    private Rectangle successMessagePanel;
    @FXML
    private Rectangle ErrorMessagePanel;
    @FXML
    private Label lblWarningMessage;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnCalculate;
    @FXML
    private Button btnUpdate;

    private final int PREPARING=0;
    private final int DELIVERED=1;
    private  final int CANCEL=2;
    private final double BURGERPRICE = 500;

    private  final OrderList orderList = OrderList.getInstance();
    private Orders order;

    public void searchOnAction(ActionEvent actionEvent) {
        if(txtOrderId.getText().isEmpty()){
            WarningMessage("Error", "Please Insert order Id");
            hidePanel.setVisible(true);
        }
        else{
            order = orderList.SearchOrder(txtOrderId.getText());

            if (order==null){
                WarningMessage("Error", "Order Not Found Please Insert Valid order Id");
                hidePanel.setVisible(true);
            }
            else{
                WarningMessage("Success", "Order Found");
                hidePanel.setVisible(false);
                lblOrderId.setText(order.getOrderId());
                lblCustomerId.setText(order.getCustomerId());
                lblCustomerName.setText(order.getCustomerName());
                lblTotal.setText("" + order.getTotal());
                txtQty.setText("" + order.getQty());
                spnStatus.setText(getStatus(order.getStatus()));
            }
        }
    }

    public void calculateOnAction(ActionEvent actionEvent) {
        try{
            int qty = Integer.parseInt(txtQty.getText());

            if (qty==0){
                WarningMessage("Error", "Please Enter only Number more than zero");
            }
            else if(qty == order.getQty()){
                WarningMessage("Error", "Not change quantity");
            }
            else{
                ClearWarningMessage();
                double total = qty * BURGERPRICE;
                lblTotal.setText("" + total);
            }
        }catch (RuntimeException ex){
            WarningMessage("Error", "Please Enter only Number more than zero");
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {

    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) btnBack.getScene().getWindow();
        thisStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"))));
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
