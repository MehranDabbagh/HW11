package Management;

import Entities.Employee;
import Entities.Prof;

import java.util.Objects;

public class EmployeeManagement {
    public Employee register(String firstName,String lastName,String username,String password){
        Employee employee=new Employee(firstName,lastName,username,password);
        return employee;
    }
    public Employee[] delete(Employee[] employees, int profIndex, String userName){
        Boolean flag=false;
        for (int i=0;i<profIndex;i++){
            if(employees[i]!=null){
                if(Objects.equals(employees[i].getUsername(), userName)){
                    employees[i]=null;
                    flag=true;
                    System.out.println("done!");
                }
            }}
        if(!flag){
            System.out.println("there is no prof with this username!");
        }
        return employees;
    }
    public Employee[] editing(Employee[] employees, int index, int operator, String newValue){
        switch (operator){
            case 0:employees[index].setFirstname(newValue);
            case 1:employees[index].setLastname(newValue);
            case 2: employees[index].setUsername(newValue);
            case 3: employees[index].setPassword(newValue);
        }
        return employees;
    }
    public void showingEmployeePayment(Employee[] employees,int employeeIndex,String userNAME){
        for (int i=0;i<employeeIndex;i++){
            if(employees[i]!=null){
                if(Objects.equals(employees[i].getUsername(), userNAME)){
                    System.out.println("firstname:"+employees[i].getFirstname()+" lastname:"+employees[i].getLastname()+" payment:"+employees[i].getPayment());
                    return;
                }
            }}
    }
}
