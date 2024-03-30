package controller;

import DB.OrderList;
import Model.Orders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateOrderDetailsController implements Initializable {

    @FXML
    private MenuButton statusMenu;
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



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        MenuItem m1 = new MenuItem("Preparing");
        MenuItem m2 = new MenuItem("Delivered");
        MenuItem m3 = new MenuItem("Cancel");

        statusMenu.getItems().remove(0,2);
        statusMenu.getItems().add(m1);
        statusMenu.getItems().add(m2);
        statusMenu.getItems().add(m3);

        m1.setOnAction(evt -> {
            statusMenu.setText("Preparing");
        });

        m2.setOnAction(evt -> {
            statusMenu.setText("Delivered");
        });

        m3.setOnAction(evt -> {
            statusMenu.setText("Cancel");
        });
    }



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
                if (order.getStatus() == DELIVERED){
                    WarningMessage("Error", "The Order is already Delivered");
                    hidePanel.setVisible(true);
                }
                else if(order.getStatus() == CANCEL){
                    WarningMessage("Error", "The Order is Cancel");
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
                    statusMenu.setText(getStatusName(order.getStatus()));
                }
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
        try{
            if(txtQty.getText().equals(Integer.toString(order.getQty())) && statusMenu.getText().equals(getStatusName(order.getStatus()))){
                WarningMessage("Error", "No any changes");
                hidePanel.setVisible(true);
            }
            else if (txtQty.getText().equals("0") || txtQty.getText().isEmpty()){
                WarningMessage("Error", "Please Enter only Number more than zero for Quantity");
                hidePanel.setVisible(true);
            }
            else{
                if (0==getStatusNumber(statusMenu.getText())){
                    order.setQty(Integer.parseInt(txtQty.getText()));
                }
                else if(1==getStatusNumber(statusMenu.getText())){
                    order.setQty(Integer.parseInt(txtQty.getText()));
                    order.setStatus(getStatusNumber(statusMenu.getText()));
                }
                else{
                    order.setQty(Integer.parseInt(txtQty.getText()));
                    order.setStatus(getStatusNumber(statusMenu.getText()));
                    order.setTotal(0);
                }
                hidePanel.setVisible(false);
                WarningMessage("Success", "Update Successful");
            }
        }catch (RuntimeException ex){
            WarningMessage("Error", "Please Enter only Number more than zero for Quantity");
            hidePanel.setVisible(true);
        }
        System.out.print(statusMenu.getText());
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) btnBack.getScene().getWindow();
        thisStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/HomePage.fxml"))));
        stage.show();
    }

    private String getStatusName(int num){
        if (num == PREPARING){
            return "Preparing";
        }
        else if(num == DELIVERED){
            return "Delivered";
        }
        else{
            return "Cancel";
        }
    }

    private int getStatusNumber(String name){
        if(name.equals("Preparing")){
            return 0;
        }
        else if(name.equals("Delivered")){
            return 1;
        }
        else{
            return 2;
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
