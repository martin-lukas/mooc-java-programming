package reference.domain;

public class Film {
    private String name;
    
    public Film(String name) {
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
        
        Film f = (Film) o;
        return this.name.equals(f.name);
    }
    
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
