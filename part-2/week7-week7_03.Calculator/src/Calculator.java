public class Calculator {
    private Reader reader;
    private int calculations;
    
    public Calculator() {
        reader = new Reader();
    }
    
    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }
            
            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }
        statistics();
    }
    
    private void sum() {
        int[] values = readValues();
        if (values.length == 2) {
            System.out.println("sum of the values " + (values[0] + values[1]));
            calculations++;
        }
    }
    
    private void difference() {
        int[] values = readValues();
        if (values.length == 2) {
            System.out.println("difference of the values " + (values[0] - values[1]));
            calculations++;
        }
    }
    
    private void product() {
        int[] values = readValues();
        if (values.length == 2) {
            System.out.println("product of the values " + (values[0] * values[1]));
            calculations++;
        }
    }
    
    private int[] readValues() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        return new int[]{value1, value2};
    }
    
    private void statistics() {
        System.out.println("Calculations done " + calculations);
    }
}
