import exception.CourseNotFoundException;
import model.Course;
import service.CourseService;
import service.CourseServiceImp;

import java.util.List;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws CourseNotFoundException {
        CourseService courseService=new CourseServiceImp();
        int choice=0;
        do{
            System.out.println("=============================================================");
            System.out.println("1. Add a new course");
            System.out.println("2. List all courses");
            System.out.println("3. Find a course by ID");
            System.out.println("4. Fine a course by title");
            System.out.println("5. Remove a course by ID");
            System.out.println("6. Exit");
            System.out.print("[+] Insert option:");
            choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1:
                    courseService.addNewCourse();
                    break;
                case 2:
                    courseService.listAllCourses();
                    break;
                case 3:
                    System.out.println("=======================================");
                    System.out.print("[+] Insert course ID: ");
                        int Id = new Scanner(System.in).nextInt();
                        try {
                            Course foundCourse = courseService.findCourseById(Id);
                        } catch (CourseNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    break;
                case 4:
                    System.out.println("=================================================");
                    System.out.print("[+] Insert course title: ");
                    String title = new Scanner(System.in).nextLine();
                    try {
                        Course foundCourse = courseService.fineCourseByTitle(title);
                    } catch (CourseNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    courseService.removeCourseById();
                    break;
                case 6:
                    System.out.println("Exit....");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (choice!=6);
    }
}