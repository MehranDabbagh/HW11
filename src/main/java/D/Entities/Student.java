package Entities;

import java.util.Objects;

public class Student extends Person{
    private Course[] courses;
    private int[] scores;
    private int index;
    public Student(String firstname,String lastname,String username,String password){
       this.setFirstname(firstname);
       this.setLastname(lastname);
       this.setUsername(username);
       this.setPassword(password);
       courses=new Course[20];
       scores=new int[20];
       index=0;
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
        courses[index]=new Course();
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
