package controller;

import DB.OrderList;
import Model.Orders;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewCancelOrdersController implements Initializable {
    public Button btnBack;
    public TableView tblCancelOrders;
    public TableColumn colOrderId;
    public TableColumn colCustomerId;
    public TableColumn colCustomerName;
    public TableColumn colQty;
    public TableColumn colValue;

    private final OrderList orderList = OrderList.getInstance();
    private final int CANCEL=2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colValue.setCellValueFactory(new PropertyValueFactory<>("total"));

        ObservableList<Orders> list = orderList.getOrdersByStatus(CANCEL);
        tblCancelOrders.setItems(list);
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage thiStage = (Stage) btnBack.getScene().getWindow();
        thiStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/ViewOrders.fxml"))));
        stage.show();
    }
}
