package service;


import exception.CourseNotFoundException;
import model.Course;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


import static repository.CourseRepository.courseList;


public class CourseServiceImp implements CourseService {
    @Override
    public List<Course> addNewCourse() {

        System.out.println("===================================================");
        System.out.print("[+] Insert course ID: ");
        int id = new Scanner(System.in).nextInt();

        System.out.print("[+] Insert course title: ");
        String title = new Scanner(System.in).nextLine();

        System.out.print("[+] Insert instructor name: ");
        String[] instructorNames =new Scanner(System.in).nextLine().split(",");

        System.out.print("[+] Insert course requirements : ");
        String[] requirements = new Scanner(System.in).nextLine().split(",");

        System.out.print("[+] Insert course start date (yyyy-MM-dd): ");
        String dateStr = new Scanner(System.in).nextLine();
        LocalDate startDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println("===========================================");
        Course newcourse=new Course(id,title,instructorNames,requirements,startDate);
        courseList.add(newcourse);
        // Return a list containing the new course
        System.out.println("Add NewCourse Successfully!");
return courseList;

    }

    @Override
    public List<Course> listAllCourses() {
        Table table = new Table(5);
        for (int i = 0; i < 5; i++) {
            table.setColumnWidth(i, 30, 30);
        }
        table.addCell("ID");
        table.addCell("Title");
        table.addCell("instructorNames");
        table.addCell("requirements");
        table.addCell("StartDate");

        for (Course course : courseList) {
            table.addCell(String.valueOf(course.getId()), 1);
            table.addCell(course.getTitle(), 1);
            table.addCell(String.join(", ", course.getInstructorName()), 1);
            table.addCell(String.join(",",course.getRequirement()),1);
            table.addCell(course.getStartDate().toString(), 1);
        }
        System.out.println(table.render());

        return null;
    }

    @Override
    public Course findCourseById(int id) throws CourseNotFoundException {
        Table table = new Table(5);
        for (int i = 0; i < 5; i++) {
            table.setColumnWidth(i, 20, 20);
        }
        table.addCell("ID");
        table.addCell("Title");
        table.addCell("instructorNames");
        table.addCell("requirements");
        table.addCell("StartDate");
        Course course1=null;
        for (Course course: courseList){
            if (course.getId()==(id)) {
                table.addCell(String.valueOf(course.getId()), 1);
                table.addCell(course.getTitle(), 1);
                table.addCell(String.join(", ", course.getInstructorName()), 1);
                table.addCell(String.join(",",course.getRequirement()),1);
                table.addCell(course.getStartDate().toString(), 1);
                course1=course;
            }
        }
        System.out.println(table.render());
        return course1;
        //return courseList.stream()
        //    .filter(e->e.getId()==id).toList()
        //  .getFirst();

    }

    @Override
    public Course fineCourseByTitle(String title) throws CourseNotFoundException {

        Table table = new Table(5);
        for (int i = 0; i < 5; i++) {
            table.setColumnWidth(i, 20, 20);
        }
        table.addCell("ID");
        table.addCell("Title");
        table.addCell("instructorNames");
        table.addCell("requirements");
        table.addCell("StartDate");

        Course course1 = null;

        for (Course course : courseList) {
            if (course.getTitle().toLowerCase().contains(title.toLowerCase())) {
                table.addCell(String.valueOf(course.getId()), 1);
                table.addCell(course.getTitle(), 1);
                table.addCell(String.join(", ", course.getInstructorName()), 1);
                table.addCell(String.join(",", course.getRequirement()), 1);
                table.addCell(course.getStartDate().toString(), 1);
                course1 = course;
                break;
            }
        }
        System.out.println(table.render());
        return course1;
    }

    @Override
    public Course removeCourseById() throws CourseNotFoundException {
        System.out.println("============================================");
        System.out.print("[+] Insert the course ID: ");
        int id=new Scanner(System.in).nextInt();
        Course removedCourse = findCourseById(id);
        courseList.removeIf(course -> course.getId() == id);
        System.out.println("Course id " + id + " has been removed.");
        return removedCourse;
    }


}