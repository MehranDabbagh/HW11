package D.Entities;

public class Employee extends Person{
    private String payment;

    public Employee(Long id, String payment) {
        super(id);
        this.payment = payment;
    }

    public String getPayment() {
        return payment;
    }
}
