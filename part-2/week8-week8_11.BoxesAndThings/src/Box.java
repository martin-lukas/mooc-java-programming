import java.util.ArrayList;

public class Box implements ToBeStored {
    private double maxWeight;
    private ArrayList<ToBeStored> objects;
    
    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        objects = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored object) {
        if (weight() + object.weight() <= maxWeight) {
            objects.add(object);
        }
    }
    
    @Override
    public double weight() {
        double totalWeight = 0;
        for (ToBeStored obj : objects) {
            totalWeight += obj.weight();
        }
        return totalWeight;
    }
    
    @Override
    public String toString() {
        return "Box: " + objects.size() + " things, total weight " + weight() + " kg";
    }
}
