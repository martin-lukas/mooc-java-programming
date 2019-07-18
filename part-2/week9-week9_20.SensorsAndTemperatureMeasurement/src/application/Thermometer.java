package application;

import java.util.Random;

public class Thermometer implements Sensor {
    private boolean isOn;
    
    public Thermometer() {
        this.isOn = false;
    }
    
    @Override
    public boolean isOn() {
        return isOn;
    }
    
    @Override
    public void on() {
        this.isOn = true;
    }
    
    @Override
    public void off() {
        this.isOn = false;
    }
    
    @Override
    public int measure() {
        if (!isOn) {
            throw new IllegalStateException();
        }
        Random random = new Random();
        return random.nextInt(61) - 30;
    }
}
