package exception;

public class CourseNotFoundException extends Exception {

    public CourseNotFoundException(){
        super();
    }
    public CourseNotFoundException(String message){
        super(message);
    }
}
