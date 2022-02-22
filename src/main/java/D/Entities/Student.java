package D.Entities;

import java.util.List;
import java.util.Objects;

public class Student extends Person{
    private List<Course> courses;
    private int[] scores;
    private int index;

    public Student(Long id, String firstname, String lastname, String username, String password, List<Course> courses, int[] scores, int index) {
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

    public int unitPerTerm(String term){
        int sum=0;
        for(int i=0;i<index;i++){
            if(Objects.equals(courses[i].getTerm(), term)){
                sum=sum+courses[i].getUnit();
            }
        }
        return sum;
    }
    public void entekhabvahed(Course course){
      //  courses[index]=new Course();
        courses[index]=course;
        scores[index]=0;
        index++;
    }
    public int averageScorePerTerm(String term){
        int sum=0;
        int count=0;
        for(int i=0;i<index;i++){
            if(Objects.equals(courses[i].getTerm(), term)){
                sum=sum+courses[i].getUnit();
                count++;
            }
        }
        if(count!=0) return (sum/count);
        else return 0;
    }
    public boolean checkCourse(String coursename){
        for (int i=0;i<index;i++){
            if(courses[i]!=null){
                if(Objects.equals(courses[i].getName(), coursename)&& scores[i]>10){
                    return true;
                }
            }
        }
        return false;
    }
    public void showingCourses(){
        for (int i=0;i<index;i++){
            if(courses[i]!=null){
                System.out.println("the course is :"+courses[i].getName()+" term:"+courses[i].getTerm()+" by prof:"+courses[i].getProfname()+" unit:"+courses[i].getUnit()+" score:"+scores[i]);
            }
        }
    }
    public Boolean submitingScore(String coursename,String profname,int score){
        for(int i=0;i<index;i++){
            if(Objects.equals(courses[i].getName(), coursename) && Objects.equals(courses[i].getProfname(), profname)){
                scores[i]=score;return true;
            }
        }
        return false;
    }

}
