import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingingCentre {
    private final Map<Bird, List<String>> observations = new HashMap<Bird, List<String>>();
    
    public void observe(Bird bird, String place) {
        if (observations.containsKey(bird)) {
            observations.get(bird).add(place);
        } else {
            List<String> places = new ArrayList<String>();
            places.add(place);
            observations.put(bird,places);
        }
    }
    
    public void observations(Bird bird) {
        if (observations.containsKey(bird)) {
            List<String> places = observations.get(bird);
            printBirdAndObservations(bird);
            for (String place : places) {
                System.out.println(place);
            }
        } else {
            printBirdAndObservations(bird);
        }
    }
    
    private void printBirdAndObservations(Bird bird) {
        if (observations.containsKey(bird)) {
            System.out.println(bird + " observations: " + observations.get(bird).size());
        } else {
            System.out.println(bird + " observations: 0");
        }
    }
}
