package boxes;

public class OneThingBox extends Box {
    private Thing thing;
    
    @Override
    public void add(Thing newThing) {
        if (thing == null) {
            thing = newThing;
        }
    }
    
    @Override
    public boolean isInTheBox(Thing thing) {
        if (this.thing != null) {
            return this.thing.equals(thing);
            
        }
        return false;
    }
}
