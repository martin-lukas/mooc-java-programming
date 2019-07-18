import java.util.*;

public class Logic {
    private Map<String, Person> people;
    
    private Scanner reader;
    
    public Logic() {
        this.people = new HashMap<String, Person>();
        this.reader = new Scanner(System.in);
    }
    
    public void start() {
        System.out.println("phone search\n" +
                "available operations:\n" +
                " 1 add a number\n" +
                " 2 search for a number\n" +
                " 3 search for a person by phone number\n" +
                " 4 add an address\n" +
                " 5 search for personal information\n" +
                " 6 delete personal information\n" +
                " 7 filtered listing\n" +
                " x quit\n\n");
        
        while (true) {
            System.out.print("command: ");
            String command = reader.nextLine();
            if (command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                addNumber();
            } else if (command.equals("2")) {
                searchNumber();
            } else if (command.equals("3")) {
                searchPersonByNumber();
            } else if (command.equals("4")) {
                addAddress();
            } else if (command.equals("5")) {
                searchInfo();
            } else if (command.equals("6")) {
                removePerson();
            } else if (command.equals("7")) {
                filteredSearch();
            }
            System.out.println();
        }
    }
    
    private void addNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();
        
        if (people.containsKey(name)) {
            people.get(name).addNumber(number);
        } else {
            Person newPerson = new Person(name);
            newPerson.addNumber(number);
            people.put(name, newPerson);
            
        }
    }
    
    private void searchNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        if (people.containsKey(name)) {
            Set<String> numbers = people.get(name).getNumbers();
            if (numbers.isEmpty()) {
                System.out.println(" not found");
            } else {
                for (String number : numbers) {
                    System.out.println(" " + number);
                }
            }
        } else {
            System.out.println("person not found");
        }
    }
    
    private void searchPersonByNumber() {
        Set<Person> found = new HashSet<Person>();
        System.out.print("number: ");
        String searchedNumber = reader.nextLine();
        for (Person p : people.values()) {
            if (p.getNumbers().contains(searchedNumber)) {
                found.add(p);
            }
        }
        if (found.isEmpty()) {
            System.out.println(" not found");
        } else {
            for (Person person : found) {
                System.out.println(" " + person.getName());
            }
        }
    }
    
    private void addAddress() {
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();
        Person p;
        if (people.containsKey(name)) {
            p = people.get(name);
        } else {
            p = new Person(name);
            people.put(name, p);
        }
        p.setAddress(street + " " + city);
    }
    
    private void searchInfo() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        
        if (people.containsKey(name)) {
            Person p = people.get(name);
            p.printInfo();
        } else {
            System.out.println("  not found");
        }
    }
    
    private void removePerson() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        people.remove(name);
    }
    
    private void filteredSearch() {
        List<Person> found = new ArrayList<Person>();
        System.out.print("keyword (if empty, all listed): ");
        String query = reader.nextLine();
    
        if (query.isEmpty()) {
            found.addAll(people.values());
        } else {
    
            for (Person p : people.values()) {
                if (p.getName().contains(query)) {
                    found.add(p);
                }
                if (p.getAddress() != null && p.getAddress().contains(query)) {
                    found.add(p);
                }
            }
        }
        if (found.isEmpty()) {
            System.out.println(" keyword not found");
        } else {
            Collections.sort(found);
            for (Person person : found) {
                System.out.println(" " + person.getName());
                person.printInfo();
            }
        }
        
    }
}
