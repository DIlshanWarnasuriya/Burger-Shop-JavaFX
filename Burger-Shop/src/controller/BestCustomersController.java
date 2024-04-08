package controller;

import DB.OrderList;
import Model.Orders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
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

    private final OrderList orderList = OrderList.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        colValue.setCellValueFactory(new PropertyValueFactory<>("total"));

        loadTable();
    }

    private void loadTable(){
        ObservableList<Orders> list = orderList.getToArray();
        list = removeDuplicate(list);
        list = SortList(list);
        tblBestCustomers.setItems(list);
    }
    private ObservableList<Orders> removeDuplicate(ObservableList<Orders> list){
        ObservableList<Orders> tempList = FXCollections.observableArrayList();

        for (int i=0; i<list.toArray().length; i++){
            int index = isDuplicate(tempList, list.get(i).getCustomerId());

            if(index==-1){
                tempList.add(list.get(i));
            }
            else{
                double total1 = tempList.get(index).getTotal();
                double total2 = list.get(i).getTotal();
                Orders or = tempList.get(index);
                or.setTotal(total1+total2);
                tempList.set(index, or);
            }
        }
        return tempList;
    }
    private int isDuplicate(ObservableList<Orders> list, String id){
        for (int i=0; i<list.toArray().length; i++){
            if (list.get(i).getCustomerId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    private ObservableList<Orders> SortList(ObservableList<Orders> list){
        for (int j=0; j<list.toArray().length -1; ++j){
            for(int i=list.toArray().length-1; i>j; i--){
                if (list.get(i).getTotal() > list.get(i-1).getTotal()){
                    Orders t1 = list.get(i);
                    Orders t2 = list.get(i-1);
                    list.set(i, t2);
                    list.set(i-1, t1);
                }
            }
        }
        return list;
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) btnBack.getScene().getWindow();
        thisStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/Search.fxml"))));
        stage.getIcons().add(new Image("View/image/burgerIcon.png"));
        stage.setTitle("Burger Shop");
        stage.show();
    }
}
