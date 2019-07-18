package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }
    
    public List<Integer> readings() {
        return readings;
    }
    
    public void addSensor(Sensor additional) {
        sensors.add(additional);
    }
    
    @Override
    public boolean isOn() {
        for (Sensor s : sensors) {
            if (!s.isOn()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void on() {
        for (Sensor s : sensors) {
            s.on();
        }
    }
    
    @Override
    public void off() {
        for (Sensor s : sensors) {
            s.off();
        }
    }
    
    @Override
    public int measure() {
        if (!isOn()) {
            throw new IllegalStateException();
        }
        int sumOfMeasures = 0;
        for (Sensor s : sensors) {
            sumOfMeasures += s.measure();
        }
        int averageMeasurement = sumOfMeasures / sensors.size();
        readings.add(averageMeasurement);
        return averageMeasurement;
    }
}
