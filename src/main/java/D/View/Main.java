package D.View;



import CustomExceptions.OutOfRangeInput;
import D.Entities.Employee;
import D.Entities.Prof;
import D.Entities.Student;
import D.Service.Impl.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner input=new Scanner(System.in);
    static CourseServiceImpl courseService=new CourseServiceImpl();
    static CourseStudentServiceImpl courseStudentService=new CourseStudentServiceImpl();
    static EmployeeServiceImpl employeeService=new EmployeeServiceImpl();
    static ProfServiceImpl profService=new ProfServiceImpl();
    static StudentServiceImpl studentService=new StudentServiceImpl();
    public static void main(String[] args) {
        boolean flag=true;
   while(flag){
       System.out.println("login as :"+"\n"+"1-admin"+"\n"+"2-profs"+"\n"+"3-student");
       try {
           Integer operator = input.nextInt();
           if(operator>3 || operator<1){
               throw new OutOfRangeInput("please enter something in range!");
           }
           System.out.println("please enter your username:");
           String username=input.next();
           System.out.println("please enter your password:");
           String password=input.next();
           switch (operator){
               case 1:employeeLogin(username,password);break;
               case 2:profLogin(username,password);break;
               case 3:studentLogin(username,password);break;
           }
       }catch (InputMismatchException e){
           System.out.println("please ente a number!");
       }catch (OutOfRangeInput e){
           System.out.println(e.getMessage());
       }

    }
    }
    public static void employeeLogin(String username,String password){
        Integer id=employeeService.login(new Employee(username,password));
        if(id!=0){
            employeeMenu(id);
        }
    }
    public static void profLogin(String username,String password){
        Integer id=profService.login(new Prof(username,password));
        if(id!=0){
            profMenu(id);
        }
    }
    public static void studentLogin(String username,String password){
        Integer id=studentService.login(new Student(username,password));
        if(id!=0){
            studentMenu(id);
        }
    }
    public static void employeeMenu(Integer Id){
        boolean flag=true;
        while(flag){
            System.out.println("1-add , delete and edit employee"+"\n"+"2-add , delete and edit prof"+"\n"+"3-add , delete and edit student"+
                    "\n"+"4-add , delete and edit course"+"\n"+"5-showing payment"+"\n"+"6-exit");
        try {
            Integer operator= input.nextInt();
            if(operator>6 || operator<1){
                throw new OutOfRangeInput("please enter something in range!");
            }
            switch (operator){
                case 1:employeeCUD();break;
                case 2:profCUD();break;
                case 3:studentCUD();break;
                case 4:courseCUD();break;
                case 5:
                    Employee employee=employeeService.findById(Id);
                    System.out.println("firstname:"+employee.getFirstname()+" lastname:"+employee.getLastname()+
                            "payment:150000 T");break;
                case 6:flag=false;break;

            }
        }catch (InputMismatchException e){
            System.out.println("please enter a number!");
        }catch (OutOfRangeInput e){
            System.out.println(e.getMessage());
        }
        }

    }
    public static void profMenu(Integer Id){}
    public static void studentMenu(Integer Id){}
    public static void employeeCUD(){
        boolean flag=true;
        while(flag){
            System.out.println("1-adding"+"\n"+"2-editing"+"\n"+"3-deleting"+"\n"+"4-exit");
            try {
                Integer operator= input.nextInt();
                if(operator>4 || operator<1){
                    throw new OutOfRangeInput("please enter a number!");
                }
                switch (operator){
                    case 1:employeeCreating();break;
                    case 2:employeeEditing();break;
                    case 3:employeeDeleting();break;
                    case 4:flag=false;
                }
            }catch (InputMismatchException e){
                System.out.println("please enter a number!");
            }catch (OutOfRangeInput e){
                System.out.println(e.getMessage());
            }


        }
    }
    public static void profCUD(){}
    public static void studentCUD(){}
    public static void courseCUD(){}
    public static void employeeCreating(){
        System.out.println("please enter firstname:");
        String firstname=input.next();
        System.out.println("please enter lastname:");
        String lastname=input.next();
        System.out.println("please enter username:");
        String username=input.next();
        System.out.println("please enter password:");
        String password=input.next();
     int id=  employeeService.create(new Employee(firstname,lastname,username,password));
if(id>0){
    System.out.println("done!");
}
    }
    public static void employeeDeleting() {
        List<Employee> employeeList = employeeService.findAll();
        for (Employee employee : employeeList
        ) {
            System.out.println("id:" + employee.getId() + " firstname:" + employee.getFirstname() + " lastname:" + employee.getLastname());
        }
        System.out.println("please enter id of the employee you want to delete:");
        try {
            Integer id=input.nextInt();
            Employee employee=employeeService.findById(id);
            if(employee!=null){
                employeeService.Delete(id);

            }else {
                System.out.println("there is no employee with this id!");
            }
        }catch (InputMismatchException e){
            System.out.println("please enter a number!");
        }

    }
    public static void employeeEditing(){}
}
