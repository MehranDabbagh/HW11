package D.Repository.Impl;

import D.Entities.Student;
import D.Repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentRepositoryImpl implements StudentRepository {
    private List<Student> students;

    public StudentRepositoryImpl() {
        students=new ArrayList<>();
    }

    @Override
    public void create(Student student) {
        try {

            students.add(student);
        }catch (NullPointerException e){

        }
    }

    @Override
    public Student findByUsername(String username) {
        return students.stream().filter(x-> Objects.equals(x.getUsername(), username)).collect(Collectors.toList()).get(0);

    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void Update(Student student) {
        students
                .stream()
                .filter(student1 -> Objects.equals(student1.getUsername(), student.getUsername())).forEach(x->x=student);
    }

    @Override
    public void Delete(Student student) {
        students.remove(student);
    }
}
