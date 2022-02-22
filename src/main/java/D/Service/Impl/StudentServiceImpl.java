package D.Service.Impl;

import D.Entities.Course;
import D.Entities.Student;
import D.Repository.Impl.StudentRepositoryImpl;
import D.Service.StudentService;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    private StudentRepositoryImpl studentRepository;

    public StudentServiceImpl() {
        studentRepository=new StudentRepositoryImpl();
    }

    @Override
    public Long login(Student student) {
        List<Student> students =  studentRepository.findAll();
        List<Student> students1=      students.stream().filter(x-> Objects.equals(x.getUsername(), student.getUsername()) && Objects.equals(x.getPassword(), student.getPassword())).collect(Collectors.toList());
        if(students1.size()>0){
            return students1.get(0).getId();
        }
        return 0l;
    }

    @Override
    public Long create(Student student) {
        return studentRepository.create(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void Update(Student student) {
studentRepository.Update(student);
    }

    @Override
    public void Delete(Long id) {
studentRepository.Delete(id);
    }

    @Override
    public boolean selectingUnit(Course course, Long id) {
        AtomicInteger count= new AtomicInteger();
        Student student= studentRepository.findById(id);
        List<Course> courses=    student.getCourses().stream().filter(x-> Objects.equals(x.getName(), course.getName()) && Objects.equals(x.getTerm(), course.getTerm())
         ).collect(Collectors.toList());
        if(courses.size()>0){
            System.out.println("you already picked up this unit!");
         return false;
        }
       student.getCourses().stream().filter(x-> Objects.equals(x.getTerm(), course.getTerm())).collect(Collectors.toList())
                .forEach( x-> count.addAndGet(x.getUnit()));
        String[] lastterm = course.getTerm().split("/");
        if (Objects.equals(lastterm[1], "1")) {
            lastterm[0] = String.valueOf(Integer.parseInt(lastterm[0]) - 1);
            lastterm[1] = "2";
        } else if (Objects.equals(lastterm[1], "2")) {
            lastterm[1] = "1";
        }
        String exTerm = lastterm[0] + "/" + lastterm[1];
        Integer avg=student.averageScorePerTerm(exTerm);
        if(count.get()+course.getUnit()>20 && avg<18){
            System.out.println("you cannot pick  more than 20 unit in this term");
            return false;
        }else if(avg>=18 && count.get()+course.getUnit()>24){
            System.out.println("you cannot pick more than 24 unit in this term!");
            return false;
        }
            student.getCourses().add(course);
            System.out.println("done!");
            return true;


    }
}
