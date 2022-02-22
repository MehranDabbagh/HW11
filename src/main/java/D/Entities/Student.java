package D.Entities;

import java.util.List;
import java.util.Objects;

public class Student extends Person{
    private List<Course> courses;
    private int[] scores;
    private int index;

    public Student(Integer id, String firstname, String lastname, String username, String password, List<Course> courses, int[] scores, int index) {
        super(id, firstname, lastname, username, password);
        this.courses = courses;
        this.scores = scores;
        this.index = index;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }



}
