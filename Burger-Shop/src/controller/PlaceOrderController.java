package controller;

import DB.OrderList;
import Model.Orders;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlaceOrderController implements Initializable {
    public Label lblOrderId;
    public TextField txtCustomerID;
    public TextField txtCustomerName;
    public TextField txtQty;
    public Label lblTotal;
    public Button btnPlaceOrder;
    public Button btnBackToHome;
    public Button btnCalculate;
    public Button btnSearch;
    public Rectangle successMessagePanel;
    public Rectangle ErrorMessagePanel;
    public Label lblWarningMessage;
    public Button btnCancel;


    final double BURGERPRICE = 500;
    private double total;
    private OrderList orderList = OrderList.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateId();
    }

    public void searchOnAction(ActionEvent actionEvent) {
        try{
            if (txtCustomerID.getText().length() == 10 && txtCustomerID.getText().charAt(0) == '0'){
                String CustomerName = orderList.searchCustomer(txtCustomerID.getText());
                if (CustomerName != "null"){
                    txtCustomerName.setText(CustomerName);
                    WarningMessage("Success", "Customer is Hear");
                    txtCustomerName.setEditable(false);
                }
                else{
                    txtCustomerName.setEditable(true);
                }
                txtQty.setEditable(true);
                ClearWarningMessage();
            }
            else {
                WarningMessage("Error", "Please Enter Valid Phone Number");
                txtCustomerID.setText("");
            }
        }catch(RuntimeException ex){
            WarningMessage("Error", "Please Enter Valid Phone Number");
            txtCustomerID.setText("");
        }
    }

    public void calculateOnAction(ActionEvent actionEvent) {

        try{
            int qty = Integer.parseInt(txtQty.getText());

            if (qty <= 0){
                WarningMessage("Error", "Please Enter only Number more than zero");
                txtQty.setText("");
            }
            else{
                double total = BURGERPRICE * qty;
                lblTotal.setText(""+total);
                ClearWarningMessage();
            }
        }catch(RuntimeException ex){
            WarningMessage("Error", "Please Enter only Number more than zero");
            txtQty.setText("");
        }
    }

    public void placeOrderOnAction(ActionEvent actionEvent) {
        if(txtCustomerID.getText().equals("") || txtCustomerName.getText().equals("") || txtQty.getText().equals("")){
            WarningMessage("Error", "Please Fill Details");
        }
        else{
            String id = lblOrderId.getText();
            String CId = txtCustomerID.getText();
            String cName = txtCustomerName.getText();
            int qty = Integer.parseInt(txtQty.getText());

            orderList.addToList(new Orders(id,CId,cName,qty, total));

            WarningMessage("Success", "Order Place Successful");
            generateId();
            txtCustomerID.setText("");
            txtCustomerName.setText("");
            txtQty.setText("");
            lblTotal.setText("0.00");
        }
    }

    public void BackToHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) btnBackToHome.getScene().getWindow();
        thisStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"))));
        stage.show();
    }

    public void CancelOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void generateId(){
        int nextNumber = orderList.size()+1;
        lblOrderId.setText(String.format("B%04d", nextNumber));
    }


    private void WarningMessage(String status, String message){
        if (status.equals("Success")){
            successMessagePanel.setVisible(true);
        }
        else{
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
