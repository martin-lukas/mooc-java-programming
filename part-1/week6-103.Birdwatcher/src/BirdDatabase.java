import java.util.HashMap;

public class BirdDatabase {
    private HashMap<Bird, Integer> birds;
    
    public BirdDatabase() {
        birds = new HashMap<Bird, Integer>();
    }
    
    
    
    public void addObservation(String birdName) {
        if (containsBird(birdName)) {
            Bird bird = getBird(birdName);
            int observations = birds.get(bird);
            birds.replace(bird,++observations);
        } else {
            System.out.println("Is not a bird!");
        }
    }
    
    public void addBird(Bird bird) {
        if (!containsBird(bird.getName())) {
            birds.put(bird, 0);
        } else {
            System.out.println("This bird is already in the database.");
        }
    }
    
    public void printBirds() {
        for (Bird bird : birds.keySet()) {
            printBird(bird.getName());
        }
    }
    
    public void printBird(String birdName) {
        Bird bird = getBird(birdName);
        if (bird != null) {
            System.out.println(bird.getName() +
                    " (" + bird.getLatinName() + "): "
                    + birds.get(bird) + " observations");
        }
    }
    
    private Bird getBird(String birdName) {
        for (Bird b : birds.keySet()) {
            if (b.getName().equals(birdName)) {
                return b;
            }
        }
        return null;
    }
    
    public boolean containsBird(String birdName) {
        for (Bird b : birds.keySet()) {
            if (b.getName().equals(birdName)) {
                return true;
            }
        }
        return false;
    }
}
