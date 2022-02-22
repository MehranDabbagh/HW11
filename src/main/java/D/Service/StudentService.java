package D.Service;

import D.Entities.Course;
import D.Entities.Student;

public interface StudentService extends BaseService<Student,Long> {
    boolean selectingUnit(Course course, Long id);
}
