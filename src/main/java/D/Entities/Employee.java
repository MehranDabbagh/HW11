package D.Entities;

public class Employee extends Person{


    public Employee(Integer id, String firstname, String lastname, String username, String password) {
        super(id, firstname, lastname, username, password);
    }

    public Employee(String firstname, String lastname, String username, String password) {
        super(firstname, lastname, username, password);
    }

    public Employee(String username, String password) {
        super(username, password);
    }
}
