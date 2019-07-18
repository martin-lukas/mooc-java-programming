import java.util.Arrays;

public class Main {
    
    public static void main(String[] Container) {
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }
    
    public static void addSuitcasesFullOfBricks(Container container) {
        for (int i = 1; i <= 100; i++) {
            Suitcase s = new Suitcase(100);
            s.addThing(new Thing("brick", i));
            container.addSuitcase(s);
        }
    }
}
