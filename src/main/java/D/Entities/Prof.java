package D.Entities;

public class Prof extends Person{
private String type;

    public Prof(Integer id, String firstname, String lastname, String username, String password, String type) {
        super(id, firstname, lastname, username, password);
        this.type = type;
    }

    public Prof(String username, String password) {
        super(username, password);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
