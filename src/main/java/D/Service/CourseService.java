package D.Service;

import D.Entities.Course;

import java.util.List;

public interface CourseService {
    Long create (Course course);
    Course findById(Long id);
    List<Course> findAll();
    void Update(Course course);
    void Delete(Long id);
}
