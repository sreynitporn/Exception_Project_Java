package repository;

import model.Course;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
        public static List<Course> courseList =new ArrayList<>(List.of(
                new Course(1,"Java",new String[]{"Nit","Sana"}, new String[]{"C++","C#"}, LocalDate.of(2023,2,12)),
                new Course(2,"Web",new String[]{"koko","kaka"},new String[]{"typing","Research"},LocalDate.of(2024,2,3)))
        );
    public static List<Course> allCourse() {
        return courseList;
    }
}