public class Reformatory {
    
    private int weightMeasurements = 0;

    public int weight(Person person) {
        weightMeasurements++;
        return person.getWeight();
    }
    
    public void feed(Person person) {
        person.setWeight(person.getWeight() + 1);
    }
    
    public int totalWeightsMeasured() {
        return weightMeasurements;
    }
}
