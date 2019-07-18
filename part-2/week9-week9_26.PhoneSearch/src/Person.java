import java.util.HashSet;
import java.util.Set;

public class Person implements Comparable<Person> {
    private String name;
    private Set<String> numbers;
    private String address;
    
    public Person(String name) {
        this.name = name;
        this.numbers = new HashSet<String>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public Set<String> getNumbers() {
        return this.numbers;
    }
    
    public void addNumber(String number) {
        this.numbers.add(number);
    }
    
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj != null || obj.getClass() != this.getClass()) {
            return false;
        }
        
        Person p = (Person) obj;
        if (this.name.equals(p.name)) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
    
    public void printInfo() {
        if (address == null) {
            System.out.println("  address unknown");
        } else {
            System.out.println("  address: " + address);
        }
        if (numbers.isEmpty()) {
            System.out.println("  phone number not found");
        } else {
            System.out.println("  phone numbers:");
            for (String number : numbers) {
                System.out.println("   " + number);
            }
        }
    }
}
