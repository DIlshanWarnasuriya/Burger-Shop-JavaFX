package Model;

public class Orders {
    private String OrderId;
    private String CustomerId;
    private String CustomerName;
    private int qty;
    private double total;

    public Orders() {
    }

    public Orders(String orderId, String customeId, String customerName, int qty, double total) {
        OrderId = orderId;
        CustomerId = customeId;
        CustomerName = customerName;
        this.qty = qty;
        this.total = total;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "OrderId='" + OrderId + '\'' +
                ", CustomerId='" + CustomerId + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", qty=" + qty +
                ", total=" + total +
                '}';
    }
}
