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
    public void create(Course course) {
        try {
            course.setId(courses.size()+1L);
            courses.add(course);
        }catch (NullPointerException e){

        }
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
        .filter(course1 -> Objects.equals(course1.getId(), course.getId())).forEach(x->x=course);
    }

    @Override
    public void Delete(Course course) {
        courses.remove(course);
    }
}
