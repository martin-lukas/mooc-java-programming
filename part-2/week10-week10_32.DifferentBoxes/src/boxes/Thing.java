package boxes;

public class Thing {
    
    private String name;
    private int weight;
    
    public Thing(String name, int weight) {
        
        this.name = name;
        if (weight < 0) {
            throw new IllegalArgumentException("Weight was negative");
        } else {
            this.weight = weight;
        }
    }
    
    public Thing(String name) {
        this(name, 0);
    }
    
    public String getName() {
        return name;
    }
    
    public int getWeight() {
        return weight;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Thing t = (Thing) obj;
        return this.name.equals(t.name);
    }
    
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
