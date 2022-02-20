package D.View;

import D.Management.Management;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Management management=new Management();
    static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {


        while(true){
            String userName="";
            String password="";
            try {
                System.out.println("please enter your username");
                userName = input.next();
                System.out.println("please enter your password");
                password = input.next();
            }
            catch (InputMismatchException e){
                System.out.println("wrong types!");

            }
            catch (NullPointerException n){
                System.out.println("please type something!");
            }
            switch (management.login(userName,password)){
                case "prof":profMenu(userName,password);break;
                case "employee":employeeMenu(userName,password);break;
                case "student":studentMenu(userName,password);break;
                case "undefined":
                    if(!Objects.equals(userName, "") && !Objects.equals(password, ""))
                    { System.out.println("there is no acc with this username and password please try again!");}
            }
        }}
    public static void employeeMenu(String username,String password)  {
        boolean condition=true;
        while(condition){
            try{
            System.out.println("please enter 1 for adding student 2 for deleting student 3 for editing student");
            System.out.println("please enter 4 for adding prof 5 for deleting prof 6 for editing prof");
            System.out.println("please enter 7 for adding employee 8 for deleting employee 9 for editing employee");
            System.out.println("please enter 10 for adding course 11 for deleting course 12 for editing course");
            System.out.println("please enter 13 for showing your payment");
            System.out.println("please enter 14 for exit");
            int operator;
                 input.nextLine();
                operator=input.nextInt();
                if(operator>14 || operator <1){
                    throw new CustomExceptions.OutOfRangeInput("please enter something in range!");
                }

            switch (operator){
                case 1: management.registerStudent();break;
                case 2: management.deletingStudent();break;
                case 3:management.editingStudent();break;
                case 4:management.registerProf();break;
                case 5:management.deletingProf();break;
                case 6:management.editingProf();break;
                case 7:management.registerEmployee();break;
                case 8:management.deletingEmployee();break;
                case 9:management.editingEmployee();break;
                case 10:management.registerCourse();break;
                case 11:management.deleteCourse();break;
                case 12:management.editingCourse();break;
                case 13:management.showingEmployeePayment(username);break;
                case 14:condition=false;break;
            }}
              catch (CustomExceptions.OutOfRangeInput e){
        System.out.println(e.getMessage());
            }
            catch (InputMismatchException e){
                System.out.println("please enter a number!");
            }
        }
}
    public static void studentMenu(String username,String password) throws CustomExceptions.OutOfRangeInput {
       boolean condition=true;
        while(condition){
            try {
                System.out.println("enter 1 for showing you details");
                System.out.println("enter 2 for showing courses");
                System.out.println("enter 3 for showing unit selection");
                System.out.println("enter 4 for showing your courses");
                System.out.println("enter 5 for exit");
                int operator=input.nextInt();
                if(operator>5 || operator<1){
                    throw new CustomExceptions.OutOfRangeInput("please enter something in range!");
                }
                switch (operator){
                    case 1:management.showingStudentDetail(username);break;
                    case 2:management.showingCourses();break;
                    case 3:management.entekhabvahed(username);break;
                    case 4:management.showingStudentCourses(username);break;
                    case 5:condition=false;
                }
            }catch (InputMismatchException e){
                System.out.println("please enter a number!");
            }
         catch (CustomExceptions.OutOfRangeInput e){
             System.out.println(e.getMessage());
          }
        }
}
    public static void profMenu(String username,String password){
    boolean condition=true;
    while(condition){
        try {
            System.out.println("enter 1 for showing you details");
            System.out.println("enter 2 for submitting scores");
            System.out.println("enter 3 for showing your payment");
            System.out.println("enter 4 for exit");
            input.nextLine();
            int operator=input.nextInt();
            if(operator>4 || operator<0){
                throw new CustomExceptions.OutOfRangeInput("please enter something in range!");
            }
            switch (operator){
                case 1:management.showingProfDetail(username);break;
                case 2:management.submittingScores(username);break;
                case 3:
                    System.out.println("enter your term for seeing your payment(like 1395/1)");
                   try{
                       String input1=input.next();
                       if(input1.length()!=6 || input1.charAt(5)!='/'){
                           throw new CustomExceptions.TermFormat("wrong term format!");
                       }
                    String[] a=input1.split("/");
                    if(Integer.valueOf(a[0])<1390 || Integer.valueOf(a[1])>2 || Integer.valueOf(a[1])<1 || Integer.valueOf(a[0])>1400 )
                    {
                        throw new CustomExceptions.OutOfRangeTerm("there is no term with this details!");
                    }
                    management.showingProfPayment(username,input1);
                   }
                   catch (InputMismatchException e){
                       System.out.println("please enter a string!");
                   }
                   catch (CustomExceptions.OutOfRangeTerm e){
                       System.out.println(e.getMessage());
                   }
                   catch (NullPointerException e){
                       System.out.println("please enter something!");
                   }
                   catch (CustomExceptions.TermFormat e){
                       System.out.println(e.getMessage());
                   }
                   finally {
                       break;

                   }

                case 4:condition=false;
            }
        }
        catch (InputMismatchException e){
            System.out.println("please enter a number!");
        }
        catch (CustomExceptions.OutOfRangeInput e){
            System.out.println(e.getMessage());
        }


    }
}
}
