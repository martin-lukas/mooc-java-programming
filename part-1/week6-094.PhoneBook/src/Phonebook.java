import java.util.ArrayList;

public class Phonebook {
    private ArrayList<Person> people = new ArrayList<Person>();
    
    public String searchNumber(String name) {
        for (Person p : people) {
            if (p.getName().equals(name)) {
                return p.getNumber();
            }
        }
        return "number not known";
    }
    
    public void add(String name, String number) {
        people.add(new Person(name, number));
    }
    
    public void printAll() {
        for (Person p : people) {
            System.out.println(p);
        }
    }
}
