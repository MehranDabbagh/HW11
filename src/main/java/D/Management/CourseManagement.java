package Management;

import Entities.Course;

import java.util.Objects;

public class CourseManagement {
    public Course register(String coursename,String profname,String term,int unit){
        Course course=new Course(coursename,profname,term,unit);
        return course;
    }
    public Course[] delete(Course[] courses,int courseIndex,String courseName){
        Boolean flag=false;
        for (int i=0;i<courseIndex;i++){
            if(courses[i]!=null){
                if(Objects.equals(courses[i].getName(), courseName)){
                    courses[i]=null;
                    flag=true;
                    System.out.println("done!");
                }
            }}
        if(!flag){
            System.out.println("there is no course with this username!");
        }
        return courses;
    }
    public Course[] editing(Course[] courses,int index,int operator,String newvalue){
        switch (operator){
            case 0:courses[index].setName(newvalue);break;
            case 1:courses[index].setProfname(newvalue);break;
            case 2: courses[index].setTerm(newvalue);break;
            case 3: courses[index].setUnit(Integer.parseInt(newvalue));break;
        }
        return courses;
    }
    public void showingCourses(Course[] courses,int courseIndex){
        for (int i=0;i<courseIndex;i++){
            if(courses[i]!=null){
                System.out.println(i+"."+"course name:"+courses[i].getName()+" profname:"+courses[i].getProfname()+" term:"+courses[i].getTerm()+" unit:"+courses[i].getUnit());
            }
        }
    }
}
