import java.util.*;

public class Logic {
    private Scanner reader;
    private List<Jumper> jumpers;
    private int numberOfRounds;
    
    public Logic(Scanner reader) {
        this.reader = reader;
        this.jumpers = new ArrayList<Jumper>();
    }
    
    public void start() {
        System.out.println("Kumpula ski jumping week\n" +
                "\n" +
                "Write the names of the participants one at a time; " +
                "an empty string brings you to the jumping phase.");
        System.out.println();
        
        startRegistration();
        startTournament();
        
        printResults();
    }
    
    private void startRegistration() {
        while (true) {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            if (name.isEmpty()) {
                break;
            }
            jumpers.add(new Jumper(name));
        }
        System.out.println();
    }
    
    private void startTournament() {
        System.out.println("The tournament begins!");
    
        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String jump = reader.nextLine();
            System.out.println();
            if (jump.equals("quit")) {
                break;
            } else if (jump.equals("jump")) {
                startRound();
            }
            System.out.println();
        }
        System.out.println("Thanks!");
        System.out.println();
    }
    
    private void startRound() {
        System.out.println("Round " + ++numberOfRounds);
        System.out.println();
        
        printJumpingOrder();
    
        generateResults();
    }
    
    private void printJumpingOrder() {
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        System.out.println("Jumping order:");
        int order = 1;
        for (Jumper jumper : jumpers) {
            System.out.println("  " + order + ". " + jumper);
            order++;
        }
        System.out.println();
    }
    
    private void generateResults() {
        System.out.println("Results of round " + numberOfRounds);
    
        for (Jumper jumper : jumpers) {
            System.out.println("  " + jumper.getName());
            int jumpLength = Round.generateJump();
            System.out.println("    length: " + jumpLength);
            int[] points = Round.generatePoints();
            System.out.println("    judge votes: " + Arrays.toString(points));
            Arrays.sort(points);
            int score = jumpLength + points[1] + points[2] + points[3];
            jumper.newJump(jumpLength, score);
        }
        System.out.println();
    }
    
    private void printResults() {
        Collections.sort(jumpers);
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        int position = 1;
        for (Jumper jumper : jumpers) {
            System.out.println("" + position + "           " + jumper);
            System.out.print("            ");
            jumper.printLengths();
            position++;
        }
    }
}
