package C;

import java.util.Date;
import java.util.List;

public class Order {
    private Date date;
    private Customer customer;
    private List<Product> products;

    public Order(Date date, Customer customer, List<Product> products) {
        this.date = date;
        this.customer = customer;
        this.products = products;
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
