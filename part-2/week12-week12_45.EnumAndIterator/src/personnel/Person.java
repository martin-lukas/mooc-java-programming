package personnel;

public class Person {
    private String name;
    private Education ed;
    
    public Person(String name, Education ed) {
        this.name = name;
        this.ed = ed;
    }
    
    public Education getEducation() {
        return ed;
    }
    
    @Override
    public String toString() {
        return name + ", " + ed;
    }
}
