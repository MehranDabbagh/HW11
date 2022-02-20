package Entities;

public class Employee extends Person{
    private String payment;
    public Employee(String firstname,String lastname,String username,String password){
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setUsername(username);
        this.setPassword(password);
        payment="1500000 TOMAN";
    }

    public String getPayment() {
        return payment;
    }
}
