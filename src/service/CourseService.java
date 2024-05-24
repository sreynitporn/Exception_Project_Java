package service;

import exception.CourseNotFoundException;
import model.Course;

import java.util.List;

public interface CourseService {
    List<Course> addNewCourse();
    List<Course> listAllCourses();
    Course findCourseById(int id) throws CourseNotFoundException;
    Course fineCourseByTitle(String title) throws CourseNotFoundException ;
    Course  removeCourseById() throws CourseNotFoundException;

}
