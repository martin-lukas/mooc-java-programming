package reference.domain;

public class Person {
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        
        Person p = (Person) o;
        return p.name.equals(this.name);
    }
    
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
