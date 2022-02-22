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
    public Long create(Student student) {
        try {
student.setId(students.size()+1l);
            students.add(student);
        }catch (NullPointerException e){

        }
        return student.getId();
    }

    @Override
    public Student findById(Long id) {
        return students.stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);

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
    public void Delete(Long id) {
        students.remove(id);
        students
                .stream()
                .filter(student1 -> Objects.equals(student1.getId(),id) && student1.getId()>id).forEach(x->x.setId(x.getId()-1));
    }
}
