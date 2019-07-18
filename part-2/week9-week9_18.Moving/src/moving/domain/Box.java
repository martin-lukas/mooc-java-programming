package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing {
    private List<Thing> things;
    private int maximumCapacity;
    
    public Box(int maximumCapacity) {
        this.things = new ArrayList<Thing>();
        this.maximumCapacity = maximumCapacity;
    }
    
    public boolean addThing(Thing thing) {
        if (getVolume() + thing.getVolume() > maximumCapacity) {
            return false;
        }
        things.add(thing);
        return true;
    }
    
    @Override
    public int getVolume() {
        int totalVolume = 0;
        for (Thing t : things) {
            totalVolume += t.getVolume();
        }
        return totalVolume;
    }
}
