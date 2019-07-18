import java.util.Scanner;

public class Main {
    
    private static int processCommand(String command, Scanner scan, BirdDatabase db) {
        if (command.equals("Quit")) {
            return 0;
        } else if (command.equals("Add")) {
            System.out.print("Name: ");
            String name = scan.nextLine();
            System.out.print("Latin Name: ");
            String latinName = scan.nextLine();
            Bird bird = new Bird(name, latinName);
            db.addBird(bird);
        } else if (command.equals("Observation")) {
            System.out.print("What was observed:? ");
            String name = scan.nextLine();
            db.addObservation(name);
        } else if (command.equals("Statistics")) {
            db.printBirds();
        } else if (command.equals("Show")) {
            System.out.print("What? ");
            String name = scan.nextLine();
            if (db.containsBird(name)) {
                db.printBird(name);
            } else {
                System.out.println("Is not a bird!");
            }
        } else {
            System.out.println("Not a command.");
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        BirdDatabase db = new BirdDatabase();
        
        while (true) {
            System.out.print("? ");
            String command = scan.nextLine();
            int status = processCommand(command, scan, db);
            if (status == 0) {
                break;
            }
        }
    }

}
