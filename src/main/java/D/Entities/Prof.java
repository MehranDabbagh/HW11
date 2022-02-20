package Entities;

public class Prof extends Person{
private String type;
    public Prof(String firstname,String lastname,String username,String password,String type){
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setUsername(username);
        this.setPassword(password);
        this.type=type;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
