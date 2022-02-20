package D.Management;


import D.Entities.Course;
import D.Entities.Employee;
import D.Entities.Prof;
import D.Entities.Student;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Management {
    private Student[] students;
    private Employee[] employees;
    private Prof[] profs;
    private Course[] courses;
    private int studentIndex;
    private int profIndex;
    private int employeeIndex;
    private int courseIndex;
    private StudentManagement studentManagement=new StudentManagement();
    private ProfManagement profManagement=new ProfManagement();
    private  EmployeeManagement employeeManagement=new EmployeeManagement();
   private CourseManagement courseManagement=new CourseManagement();
    Scanner input=new Scanner(System.in);
    public Management() {
        students=new Student[20];
        employees=new Employee[20];
        profs=new Prof[20];
        courses=new Course[20];
        employees[0]=new Employee("ali","ahmadi","admin","admin");
        studentIndex=0;
        profIndex=0;
        courseIndex=0;
        employeeIndex=1;

    }
    public void registerStudent() {
        System.out.println("please enter firstname:");
        String firstname=input.next();
        System.out.println("please enter lastname:");
        String lastname=input.next();
        System.out.println("please enter username:");
        String username=input.next();
        System.out.println("please enter password:");
       String password=input.next();
        students[studentIndex]= studentManagement.register(firstname,lastname,username,password);
        studentIndex++;
    }
    public void deletingStudent(){
        System.out.println("please enter student's username:");
       String username=input.next();
     students= studentManagement.delete(students,studentIndex,username);
    }
    public void editingStudent(){
        System.out.println("please enter student's username:");
        String username=input.next();
        try{
        for (int i=0;i<studentIndex;i++){
            if(students[i]!=null){
            if(Objects.equals(students[i].getUsername(), username)){
                System.out.println("please enter 0 for editing firstname,1 for last name,2 for username,3 for password");
               int operator=input.nextInt();
               if(operator>3 || operator<0 ){
                   throw new CustomExceptions.OutOfRangeInput("please enter something in range!");
               }
                System.out.println("enter the new value:");
               String newvalue=input.next();
         students=studentManagement.editing(students,i,operator,newvalue);
            }}
        }
        System.out.println("there is no student with this username!");}
        catch (CustomExceptions.OutOfRangeInput e){
            System.out.println(e.getMessage());
        }
        catch (NullPointerException e){

        }catch (InputMismatchException e){
            System.out.println("please enter a number!");
        }
    }
    public void registerProf(){
        System.out.println("please enter firstname:");
        String firstname=input.next();
        System.out.println("please enter lastname:");
        String lastname=input.next();
        System.out.println("please enter username:");
        String username=input.next();
        System.out.println("please enter password:");
        String password=input.next();
        System.out.println("please enter type(hagholtadris/heyatelmi):");
        String type=input.next();
        profs[profIndex]= profManagement.register(firstname,lastname,username,password,type);
        profIndex++;
        System.out.println("done!");
    }
    public void deletingProf(){
        System.out.println("please enter prof's username:");
        String username=input.next();
        for (int i=0;i<profIndex;i++){
            if(profs[i]!=null){
            if(Objects.equals(profs[i].getUsername(), username)){
               profs= profManagement.delete(profs,profIndex,username);
                return;
            }
        }}
        System.out.println("there is no prof with this username!");
    }
    public void editingProf(){
        System.out.println("please enter prof's username:");
        String username=input.next();
        try {
            for (int i = 0; i < profIndex; i++) {
                if (profs[i] != null) {
                    if (Objects.equals(profs[i].getUsername(), username)) {
                        System.out.println("please enter 0 for editing firstname,1 for last name,2 for username,3 for password,4 for type");
                        int operator = input.nextInt();
                        if(operator>4 || operator<0){
                            throw new CustomExceptions.OutOfRangeInput("please enter something in range!");
                        }
                        System.out.println("enter the new value:");
                        String newvalue = input.next();
                        switch (operator) {
                            case 0:
                                profs[i].setFirstname(newvalue);return;
                            case 1:
                                profs[i].setLastname(newvalue);return;
                            case 2:
                                profs[i].setUsername(newvalue);return;
                            case 3:
                                profs[i].setPassword(newvalue);return;
                            case 4:
                                profs[i].setType(newvalue);return;
                        }
                    }
                }
            }
            System.out.println("there is no prof with this username!");
        }catch (InputMismatchException e){
            System.out.println("please enter a number!");
        }catch (CustomExceptions.OutOfRangeInput e){
            System.out.println(e.getMessage());
        }
    }
    public void registerEmployee(){
        System.out.println("please enter firstname:");
        String firstname=input.next();
        System.out.println("please enter lastname:");
        String lastname=input.next();
        System.out.println("please enter username:");
        String username=input.next();
        System.out.println("please enter password:");
        String password=input.next();
        employees[employeeIndex]= employeeManagement.register(firstname,lastname,username,password);
employeeIndex++;
    }
    public void deletingEmployee(){
        System.out.println("please enter employee's username:");
        String username=input.next();
        for (int i=0;i<employeeIndex;i++){
            if(employees[i]!=null){
            if(Objects.equals(employees[i].getUsername(), username)){
                employees[i]=null;
                return;
            }
        }}
        System.out.println("there is no employee with this username!");
    }
    public void editingEmployee(){
        System.out.println("please enter employee's username:");
        String username=input.next();
        for (int i=0;i<employeeIndex;i++){
            if(employees[i]!=null){
            if(Objects.equals(employees[i].getUsername(), username)){
                System.out.println("please enter 0 for editing firstname,1 for last name,2 for username,3 for password");
                try {
                    int operator=input.nextInt();
                    if(operator>3 || operator<0){
                        throw new CustomExceptions.OutOfRangeInput("please enter something in range!");
                    }
                    System.out.println("enter new value:");
                    String newvalue=input.next();
                    employees=employeeManagement.editing(employees,i,operator,newvalue);
                    return;
                }catch (InputMismatchException e){
                    System.out.println("please enter a number!");
                }catch (CustomExceptions.OutOfRangeInput e){
                    System.out.println(e.getMessage());
                }

            }
        }}
        System.out.println("there is no employee with this username!");
    }
    public void registerCourse(){
        System.out.println("please enter coursename:");
        String coursename=input.next();
        System.out.println("please enter profname:");
        String profname=input.next();
        System.out.println("please enter term(like 1395/1):");
        String term=input.next();
        System.out.println("please enter unit:");
        int unit=input.nextInt();
        courses[courseIndex]= courseManagement.register(coursename,profname,term,unit);
        courseIndex++;
        System.out.println("done!");
    }
    public void deleteCourse(){
        System.out.println("enter the course's name:");
        String name=input.next();
       courses=courseManagement.delete(courses,courseIndex,name);

    }
    public void editingCourse(){
        System.out.println("enter the course's name:");
        String name=input.next();
        for (int i=0;i<courseIndex;i++){
            if(courses[i]!=null){
                if(Objects.equals(courses[i].getName(), name)){
                    System.out.println("please enter 0 for editing coursename,1 for  profname,2 for term(like 1395-1),3 for unit");
                   try {
                       int operator=input.nextInt();
                       if(operator>3 || operator<0 ){
                           throw new CustomExceptions.OutOfRangeInput("please enter something in range!");
                       }
                       System.out.println("enter new value:");
                       String newvalue=input.next();
                       courseManagement.editing(courses,i,operator,newvalue);
                       return;
                   }catch (InputMismatchException e){
                       System.out.println("please enter a number!");
                   }catch (CustomExceptions.OutOfRangeInput e){
                       System.out.println(e.getMessage());
                   }

                }
            }
        }
        System.out.println("there is no course with this name!");
    }
    public void showingEmployeePayment(String username){
       employeeManagement.showingEmployeePayment(employees,employeeIndex,username);
    }
    public void showingStudentDetail(String username){
     studentManagement.showingStudentDetails(students,studentIndex,username);
    }
    public void showingCourses(){
courseManagement.showingCourses(courses,courseIndex);
    }
    public void entekhabvahed(String username){
try{
    int courseId= input.nextInt();
students=studentManagement.entekhabvahed(students,studentIndex,username,courses,courseIndex,courseId);}
catch (InputMismatchException e){
    System.out.println("please enter a number!");
}
    }
    public void showingProfDetail(String username){
        profManagement.showingProfDetails(profs,profIndex,username);
    }
    public void submittingScores(String username){
        System.out.println("please enter the student's username:");
        String student=input.next();
        System.out.println("please enter the course's username:");
        String course=input.next();
        System.out.println("please enter th score (0-20)");
        try {
            int score=input.nextInt();
            if(score>20 || score<0){
                throw new CustomExceptions.OutOfRangeInput( "please enter something in range!");
            }
            students=profManagement.submittingScore(students,studentIndex,course,score,student,username);
        }catch (InputMismatchException e){
            System.out.println("please enter a number!");
        }catch (CustomExceptions.OutOfRangeInput e){
            System.out.println(e.getMessage());
        }

    }
    public void showingProfPayment(String  username,String term){
profManagement.showingProfPayment(profs,profIndex,courses,courseIndex,username,term);
    }
    public String login(String username,String password){
        for(int i=0;i<profIndex;i++){
            if(profs[i]!=null){
            if(Objects.equals(profs[i].getUsername(), username) && Objects.equals(profs[i].getPassword(), password)){
                return "prof";
            }
        }}
        for(int i=0;i<employeeIndex;i++){
            if(employees[i]!=null){
            if(Objects.equals(employees[i].getUsername(), username) && Objects.equals(employees[i].getPassword(), password)){
                return "employee";
            }
        }}
        for(int i=0;i<studentIndex;i++){
            if(students[i]!=null){
            if(Objects.equals(students[i].getUsername(), username) && Objects.equals(students[i].getPassword(), password)){
                return "student";
            }
        }}
        return "undefined";
    }
    public void showingStudentCourses(String username){
       studentManagement.showingStudentCourses(students,studentIndex,username);
    }
}

