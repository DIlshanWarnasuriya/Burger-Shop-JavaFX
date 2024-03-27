package DB;

import Model.Orders;

public class OrderList {

    private Node top;
    private static OrderList instance;


    class Node{
        private Orders orders;
        private Node next;
        public Node(Orders orders) {
            this.orders = orders;
        }
    }

    public static OrderList getInstance(){
        if (instance == null){
            instance = new OrderList();
        }
        return instance;
    }
}
