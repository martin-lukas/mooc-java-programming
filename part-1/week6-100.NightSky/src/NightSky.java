import java.util.Random;

public class NightSky {
    private double density;
    private int width;
    private int height;
    private int starsInLastPrint;
    
    public NightSky(double density) {
        this.density = density;
        width = 20;
        height = 10;
    }
    
    public NightSky(int width, int height) {
        density = 0.1;
        this.width = width;
        this.height = height;
    }
    
    public NightSky(double density, int width, int height) {
        this.density = density;
        this.width = width;
        this.height = height;
    }
    
    public int starsInLastPrint() {
        return starsInLastPrint;
    }
    
    public void printLine() {
        Random rand = new Random();
        int countStars = 0;
        for (int i = 0; i < width; i++) {
            double d = rand.nextDouble();
            if (d <= density) {
                System.out.print("*");
                countStars++;
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
        starsInLastPrint = countStars;
    }
    
    public void print() {
        int totalStars = 0;
        for (int i = 0; i < height; i++) {
            printLine();
            totalStars += starsInLastPrint;
        }
        starsInLastPrint = totalStars;
    }
}
