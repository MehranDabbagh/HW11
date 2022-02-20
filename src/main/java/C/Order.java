package C;

import java.util.Date;
import java.util.List;

public class Order {
    private Date date;
    private Customer customer;
    private List<Product> products;
    private Double totalPrice;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", customer=" + customer +
                ", products=" + products +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public Order(Date date, Customer customer, List<Product> products) {
        this.date = date;
        this.customer = customer;
        this.products = products;
        this.totalPrice=0.0;
        for (Product product:products
        ) {
            this.totalPrice+=product.getPrice();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
