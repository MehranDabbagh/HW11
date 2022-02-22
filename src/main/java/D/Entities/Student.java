package D.Entities;

import java.util.List;
import java.util.Objects;

public class Student extends Person{


    public Student(Integer id, String firstname, String lastname, String username, String password) {
        super(id, firstname, lastname, username, password);
    }

    public Student(String firstname, String lastname, String username, String password) {
        super(firstname, lastname, username, password);
    }

    public Student(String username, String password) {
        super(username, password);
    }
}
