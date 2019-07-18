package moving.logic;

import moving.domain.Box;
import moving.domain.Thing;

import java.util.ArrayList;
import java.util.List;

public class Packer {
    private int boxesVolume;
    
    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();
        if (things.isEmpty()) {
            return boxes;
        }
        boxes.add(new Box(boxesVolume));
        int index = 0;
        Box boxUsed = boxes.get(index);
        for (Thing t : things) {
            boolean success = boxUsed.addThing(t);
            if (!success) {
                boxes.add(new Box(boxesVolume));
                boxUsed = boxes.get(++index);
                boxUsed.addThing(t);
            }
        }
        return boxes;
    }
}
