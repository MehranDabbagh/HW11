package Management;

import Entities.Course;
import Entities.Prof;
import Entities.Student;

import java.util.Objects;

public class ProfManagement {
    public Prof register(String firstName,String lastName,String username,String password,String type){
        Prof prof=new Prof(firstName,lastName,username,password,type);
        return prof;
    }
    public Prof[] delete(Prof[] profs,int profIndex,String userName){
        Boolean flag=false;
        for (int i=0;i<profIndex;i++){
            if(profs[i]!=null){
                if(Objects.equals(profs[i].getUsername(), userName)){
                    profs[i]=null;
                    flag=true;
                    System.out.println("done!");
                }
            }}
        if(!flag){
            System.out.println("there is no prof with this username!");
        }
        return profs;
    }
    public Prof[] editing(Prof[] profs, int index, int operator, String newValue){
        switch (operator){
            case 0:profs[index].setFirstname(newValue);
            case 1:profs[index].setLastname(newValue);
            case 2: profs[index].setUsername(newValue);
            case 3: profs[index].setPassword(newValue);
        }
        return profs;
    }
    public void showingProfDetails(Prof[] profs,int profIndex,String username){
        for(int i=0;i<profIndex;i++){
            if(profs[i]!=null){
                if(Objects.equals(profs[i].getUsername(), username)){
                    System.out.println("firstname:"+profs[i].getFirstname()+" lastname:"+profs[i].getLastname()+" type:"+profs[i].getType());
                }
            }
        }
    }
    public Student[] submittingScore(Student[] students,int studentIndex,String course,int score,String student,String profUserName){
        if(score<0 || score >20){
            System.out.println("undefined!");
         return  students;
        }
        for(int i=0;i<studentIndex;i++){
            if(students[i]!=null){
                if(Objects.equals(students[i].getUsername(), student)){
                    if(students[i].submitingScore(course,profUserName,score)){
                        System.out.println("done");
                    }else System.out.println("undefined!");
                }
            }

        }
        return students;
    }
public void showingProfPayment(Prof[] profs, int profIndex, Course[] courses,int courseIndex, String username,String term){
    for(int i=0;i<profIndex;i++){
        if(profs[i]!=null){
            if(Objects.equals(profs[i].getUsername(), username)){
                int sum=0;
                for(int j=0;j<courseIndex;j++){
                    if(Objects.equals(courses[j].getProfname(), profs[i].getLastname()) && Objects.equals(courses[j].getTerm(), term)){
                        sum+=courses[j].getUnit();
                    }
                }
                if(Objects.equals(profs[i].getType(), "hagholtadris")){
                    System.out.println("MR/MS"+profs[i].getFirstname()+" "+profs[i].getLastname()+" your salary is:"+(sum*1000000)+"TOOMAN");
                } else if(Objects.equals(profs[i].getType(), "heyatelmi")){
                    System.out.println("MR/MS"+profs[i].getFirstname()+" "+profs[i].getLastname()+" your salary is:"+((sum*1000000)+5000000)+"TOOMAN");

                }
            }
        }
    }
}
}
