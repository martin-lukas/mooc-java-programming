
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
    
        ArrayList<Student> students = new ArrayList<Student>();
        
        while (true) {
            System.out.print("name: ");
            String name = reader.nextLine();
            if (name.isEmpty()) {
                break;
            }
            System.out.print("studentnumber: ");
            String studentNumber = reader.nextLine();
            students.add(new Student(name, studentNumber));
        }
        System.out.println();
        for (Student s : students) {
            System.out.println(s);
        }
    
        System.out.print("Give search term: ");
        String query = reader.nextLine();
        System.out.println("Result:");
        for (Student s : students) {
            if (s.getName().contains(query)) {
                System.out.println(s);
            }
        }
    }
}
