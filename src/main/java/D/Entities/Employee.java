package D.Entities;

public class Employee extends Person{
    private String payment;

    public Employee(Long id, String firstname, String lastname, String username, String password, String payment) {
        super(id, firstname, lastname, username, password);
        this.payment = payment;
    }

    public String getPayment() {
        return payment;
    }
}
