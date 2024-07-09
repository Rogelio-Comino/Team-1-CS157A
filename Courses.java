import java.util.HashSet;
import java.util.Scanner;
public class Courses {
    protected HashSet<String> courseList;

    public Courses() {
        courseList = new HashSet<>();
    }
    public void setCourses(String course) {
        courseList.add(course);
    }
    public void numOfCourses(int numclasses) {
        Scanner scnr = new Scanner(System.in);

        for (int i = 1; i <= numclasses; ++i) {
            System.out.print("Name of course #" + i + ": ");
            String className = scnr.nextLine();
            setCourses(className);
        }
    }
    public void displayCourseList(){
        int count = 1;
        for (String item : courseList) {
            System.out.println(count + ") " + item);
        }
    }
}
