package Entities;

public class Course {
    private String name;
    private String profname;
    private String term;
    private int unit;
public Course(){

}
    public Course(String name, String profname, String term, int unit) {
        this.name = name;
        this.profname = profname;
        this.term = term;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public String getProfname() {
        return profname;
    }

    public String getTerm() {
        return term;
    }

    public int getUnit() {
        return unit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfname(String profname) {
        this.profname = profname;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
