import java.util.Random;

public class Round {
    private static Random random = new Random();
    
    public static int generateJump() {
        return random.nextInt(61) + 60;
    }
    
    public static int[] generatePoints() {
        int[] points = new int[5];
        for (int i =0; i < points.length; i++) {
            points[i] = random.nextInt(11) + 10;
        }
        return points;
    }
}
