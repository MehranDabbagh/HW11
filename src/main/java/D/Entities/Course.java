package D.Entities;

import D.Entities.Base.BaseEntity;

public class Course extends BaseEntity {
    private String name;
    private Integer profid;
    private Integer year;
    private Integer term;
    private int unit;

    public Course(Integer id, String name, Integer profid, Integer year, Integer term, int unit) {
        super(id);
        this.name = name;
        this.profid = profid;
        this.year = year;
        this.term = term;
        this.unit = unit;
    }

    public Course(String name, Integer profid, Integer year, Integer term, int unit) {
        this.name = name;
        this.profid = profid;
        this.year = year;
        this.term = term;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProfid() {
        return profid;
    }

    public void setProfid(Integer profid) {
        this.profid = profid;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
