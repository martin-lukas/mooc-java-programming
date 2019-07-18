import people.Person;
import people.Student;
import people.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        Person olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        Student s = (Student) olli;
        s.credits();        // NOT WORKING!
         s.study();              // NOT WORKING!
        System.out.println( olli );   // olli.toString() IT WORKS!
    }
    
    public static void printDepartment(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
