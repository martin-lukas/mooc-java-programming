package dungeon;

import java.util.*;

public class Dungeon {
    private int length;
    private int height;
    private boolean vampiresMove;
    private Player player;
    private List<Vampire> vampires;
    
    private Scanner reader;
    
    public static final char[] DIRECTIONS = new char[]{'w', 'a', 's', 'd'};
    
    public Dungeon(int length,
                   int height,
                   int vampires,
                   int moves,
                   boolean vampiresMove) {
        this.length = length;
        this.height = height;
        
        this.vampires = fillVampires(vampires);
        
        this.player = new Player(moves);
        
        this.vampiresMove = vampiresMove;
        
        reader = new Scanner(System.in);
    }
    
    public void run() {
        while (true) {
            System.out.println(player.getMoves());
            System.out.println();
            printObjects();
            System.out.println();
            printField();
            System.out.println();
            
            String directions = reader.nextLine();
            processDirections(directions);
            
            if (vampires.isEmpty() || player.getMoves() == 0) {
                break;
            }
        }
        if (!vampires.isEmpty() || player.getMoves() == 0) {
            System.out.println("YOU LOSE");
        } else {
            System.out.println("YOU WIN");
            
        }
    }
    
    private void processDirections(String directions) {
        boolean playerMoved = false;
        for (char directionChar : directions.toCharArray()) {
            int direction = getDirectionFromChar(directionChar);
            if (direction != -1) {
                playerMoved = true;
                boolean isMoveSuccessful = player.move(direction, length, height);
                if (isMoveSuccessful) {
                    if (vampiresMove) {
                        moveVampires();
                    }
                    
                    Vampire vampire = getVampireUnderPlayer();
                    if (vampire != null) {
                        vampires.remove(vampire);
                    }
                }
            }
        }
        if (playerMoved) {
            player.useMove();
        }
    }
    
    private Vampire getVampireUnderPlayer() {
        for (Vampire vampire : vampires) {
            if (Arrays.equals((player.getCoordinates()), vampire.getCoordinates())) {
                return vampire;
            }
        }
        return null;
    }
    
    private void moveVampires() {
        for (Vampire vampire : vampires) {
            vampire.move(length, height, getVampiresCoordinates());
        }
    }
    
    private List<List<Integer>> getVampiresCoordinates() {
        List<List<Integer>> vampiresCoordinates = new ArrayList<List<Integer>>();
        for (Vampire vampire : vampires) {
            List<Integer> vampireCoords = new ArrayList<Integer>();
            int[] coords = vampire.getCoordinates();
            vampireCoords.add(coords[0]);
            vampireCoords.add(coords[1]);
            vampiresCoordinates.add(vampireCoords);
        }
        return vampiresCoordinates;
    }
    
    private int getDirectionFromChar(char c) {
        for (int i = 0; i < DIRECTIONS.length; i++) {
            if (DIRECTIONS[i] == c) {
                return i;
            }
        }
        return -1;
    }
    
    private void printField() {
        char[][] field = createField();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
    
    private char[][] createField() {
        char[][] field = new char[height][length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                field[i][j] = '.';
            }
        }
    
        for (Vampire vampire : vampires) {
            int[] coordinates = vampire.getCoordinates();
            field[coordinates[1]][coordinates[0]] = Vampire.MARKER;
        }
        
        int[] playerCoordinates = player.getCoordinates();
        field[playerCoordinates[1]][playerCoordinates[0]] = Player.MARKER;
        
        return field;
    }
    
    private void printObjects() {
        System.out.println(player);
        for (Vampire vampire : vampires) {
            System.out.println(vampire);
        }
    }
    
    private boolean isVampirePresent(int[] coordinates) {
        for (Vampire vampire : vampires) {
            int[] vampireCoordinates = vampire.getCoordinates();
            if (Arrays.equals(coordinates, vampireCoordinates)) {
                return true;
            }
        }
        return false;
    }
    
    private List<Vampire> fillVampires(int count) {
        List<Vampire> filled = new ArrayList<Vampire>();
        for (int i = 0; i < count; i++) {
            filled.add(new Vampire(length, height));
        }
        return filled;
    }
}
