package D.Service;

import D.Entities.Course;
import D.Entities.Student;

import java.util.List;

public interface CourseStudentService {
    void unitSelecting(Student student, Course course);
    void scoring(Student student, Course course,Integer score);
    List<Integer> courseByTerm( Integer studentId);

}