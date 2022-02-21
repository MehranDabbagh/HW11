package D.Entities;

public class Prof extends Person{
private String type;

    public Prof(Long id, String type) {
        super(id);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
