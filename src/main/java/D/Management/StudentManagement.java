package Management;

import Entities.Course;
import Entities.Student;

import java.util.List;
import java.util.Objects;

public class StudentManagement {
    public Student register(String firstName,String lastName,String username,String password){
        Student student=new Student(firstName,lastName,username,password);
        return student;
    }
    public Student[] delete(Student[] students,int studentIndex,String username){
        Boolean flag=false;
        for (int i=0;i<studentIndex;i++){
            if(students[i]!=null){
                if(Objects.equals(students[i].getUsername(), username)){
                    students[i]=null;
                    flag=true;
                    System.out.println("done!");
                }
            }}
       if(!flag){ System.out.println("there is no Student with this username!");}
        return  students;
    }
    public Student[] editing(Student[] students,int index,int operator,String newValue){
        switch (operator){
            case 0:students[index].setFirstname(newValue);
            case 1:students[index].setLastname(newValue);
            case 2: students[index].setUsername(newValue);
            case 3: students[index].setPassword(newValue);
        }
        return students;
    }
    public void showingStudentDetails(Student[] students,int studentIndex,String username){
        for (int i=0;i<studentIndex;i++){
            if(students[i]!=null){
                if(Objects.equals(students[i].getUsername(), username)){
                    System.out.println("firstname:"+students[i].getFirstname()+" lastname:"+students[i].getLastname());
                }
            }
        }
    }
    public Student[]  entekhabvahed(Student[] students, int studentIndex, String username, Course[] courses,int courseIndex,int courseId){
        for(int i=0;i<studentIndex;i++) {
            if (students[i] != null) {
                if (Objects.equals(students[i].getUsername(), username)) {

                    System.out.println("please enter course's id:");

                    if (courseId < courseIndex && courses[courseId] != null) {
                        String[] lastterm = courses[courseId].getTerm().split("/");
                        if (Objects.equals(lastterm[1], "1")) {
                            lastterm[0] = String.valueOf(Integer.parseInt(lastterm[0]) - 1);
                            lastterm[1] = "2";
                        } else if (Objects.equals(lastterm[1], "2")) {
                            lastterm[1] = "1";
                        }
                        String exTerm = lastterm[0] + "/" + lastterm[1];
                        if (students[i].averageScorePerTerm(exTerm) > 18) {
                            if (students[i].unitPerTerm(courses[courseId].getTerm()) < (24 - courses[courseId].getUnit())) {
                                students[i].entekhabvahed(courses[courseId]);
                            } else System.out.println("you can not pick this course it is gonna be more than 24 unit!");
                        } else {
                            if (students[i].unitPerTerm(courses[courseId].getTerm()) < (20 - courses[courseId].getUnit())) {
                                students[i].entekhabvahed(courses[courseId]);
                            } else System.out.println("you can not pick this course it is gonna be more than 20 unit!");
                        }
                    } else System.out.println("this number is invalid please try again!");


                }
            }

        }
        return students;
    }
public void showingStudentCourses(Student[] students,int studentIndex,String username){
    for(int i=0;i<studentIndex;i++){
        if(students[i]!=null){
            if(Objects.equals(students[i].getUsername(), username)){
                students[i].showingCourses();
            }
        }
    }
}
}
