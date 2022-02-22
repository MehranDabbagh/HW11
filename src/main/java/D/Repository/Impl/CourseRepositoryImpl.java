package D.Repository.Impl;

import D.Entities.Course;
import D.Repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CourseRepositoryImpl implements CourseRepository {
    private List<Course> courses;
    public CourseRepositoryImpl() {
        courses=new ArrayList<>();
    }

    @Override
    public Long create(Course course) {
        try {
            course.setId(courses.size()+1L);
            courses.add(course);
        }catch (NullPointerException e){

        }
        return course.getId();
    }

    @Override
    public Course findById(Long id) {
       return courses.stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);

    }

    @Override
    public List<Course> findAll() {

        return courses;
    }

    @Override
    public void Update(Course course) {
        courses
        .stream()
        .filter(course1 -> Objects.equals(course1.getName(), course.getName())).forEach(x->x=course);
    }

    @Override
    public void Delete(Long id) {
        courses.remove(id);
        courses
                .stream()
                .filter(student1 -> Objects.equals(student1.getId(),id) && student1.getId()>id).forEach(x->x.setId(x.getId()-1));
    }
}
