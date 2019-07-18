package containers;

import java.io.Flushable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ContainerHistory {
    private final List<Double> containerHistory = new ArrayList<Double>();
    
    public double maxValue() {
        if (containerHistory.isEmpty()) {
            return 0;
        }
        return Collections.max(containerHistory);
    }
    
    public double minValue() {
        if (containerHistory.isEmpty()) {
            return 0;
        }
        return Collections.min(containerHistory);
    }
    
    public double average() {
        if (containerHistory.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Double aDouble : containerHistory) {
            sum += aDouble;
        }
        return sum / containerHistory.size();
    }
    
    public double greatestFluctuation() {
        if (containerHistory.size() <= 1) {
            return 0;
        }
        double greatestFluct = 0;
        for (int i = 0; i < containerHistory.size()-1; i++) {
            double fluctuation = Math.abs(containerHistory.get(i) - containerHistory.get(i + 1));
            if (fluctuation > greatestFluct) {
                greatestFluct = fluctuation;
            }
        }
        return greatestFluct;
    }
    
    public double variance() {
        if (containerHistory.size() <= 1) {
            return 0;
        }
        double average = average();
        double sumOfSquares = 0;
        for (Double history : containerHistory) {
            sumOfSquares += Math.pow(history - average, 2);
        }
        return sumOfSquares / (containerHistory.size() - 1);
    }
    
    public void add(double situation) {
        this.containerHistory.add(situation);
    }
    
    public void reset() {
        containerHistory.removeAll(containerHistory);
    }
    
    @Override
    public String toString() {
        return containerHistory.toString();
    }
}
