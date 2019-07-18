public class Counter {
    private boolean check = false;
    private int value = 0;
    
    public Counter() {}
    
    public Counter(int startingValue, boolean check) {
        value = startingValue;
        this.check = check;
    }
    
    public Counter(int startingValue) {
        value = startingValue;
    }
    
    public Counter(boolean check) {
        this.check = check;
    }
    
    public int value() {
        return value;
    }
    
    public void increase(int increaseAmount) {
        if (increaseAmount >= 0) {
            value += increaseAmount;
        }
    }
    
    public void decrease(int decreaseAmount) {
        if (decreaseAmount >= 0) {
            if (check) {
                if ((value - decreaseAmount) >= 0) {
                    value -= decreaseAmount;
                } else {
                    value = 0;
                }
            } else {
                value -= decreaseAmount;
            }
        }
    }
    
    public void increase() {
        value++;
    }
    
    public void decrease() {
        if (check) {
            if ((value - 1) >= 0) {
                value--;
            }
        } else {
            value--;
        }
    }
}
