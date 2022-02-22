package D.Service.Impl;

import D.Entities.Prof;
import D.Entities.Student;
import D.Repository.Impl.StudentRepositoryImpl;
import D.Service.StudentService;

import java.util.List;
import java.util.Objects;
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
}
