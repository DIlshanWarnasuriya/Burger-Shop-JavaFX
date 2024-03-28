package DB;

import Model.Orders;

public class OrderList {

    private Node top;
    private static OrderList instance;


    public void addToList(Orders orders){
        Node n1 = new Node(orders);
        if (top == null){
            top = n1;
        }
        else{
            Node temp = top;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=n1;
        }
    }
    public int size(){
        Node temp = top;
        int count = 0;
        while(temp!=null){
            ++count;
            temp = temp.next;
        }
        return count;
    }
    public String searchCustomer(String id) {
        Node temp = top;
        while(temp!=null){
            if (temp.orders.getCustomerId().equals(id)){
                return temp.orders.getCustomerName();
            }
            temp=temp.next;
        }
        return "null";
    }

    public Orders SearchOrder(String id){
        Node temp = top;
        while(temp!=null){
            if(temp.orders.getOrderId().equals(id)){
                return temp.orders;
            }
            temp = temp.next;
        }
        return null;
    }
















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
